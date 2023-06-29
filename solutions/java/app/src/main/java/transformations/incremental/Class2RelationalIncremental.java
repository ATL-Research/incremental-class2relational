package transformations.incremental;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentAdapter;

import atl.research.relational_.Relational_Factory;
import atl.research.relational_.Named;
import atl.research.relational_.Type;
import atl.research.class_.Class;
import atl.research.class_.DataType;
import atl.research.class_.NamedElt;
import atl.research.class_.impl.AttributeImpl;
import atl.research.class_.impl.ClassImpl;
import atl.research.class_.impl.DataTypeImpl;
import atl.research.class_.Attribute;
import transformations.util.trace.Tracer;
import transformations.util.traverse.Traverser;
import util.CONSTANTS;
import util.IO;

public class Class2RelationalIncremental {
	private static final Relational_Factory RELATIONALFACTORY = Relational_Factory.eINSTANCE;
	private static final Tracer TRACER = new Tracer();
	private static final List<DataType> allDataTypes = new LinkedList<>();
	private static Traverser PRETRAVERSER;
	private static Traverser TRAVERSER;
	
	private static Type objectIdType;
	
	private static Type objectIdType() {
		if (objectIdType == null) {
			objectIdType = allDataTypes.stream().filter($ -> $.getName().equals("Integer")).findFirst().map($ -> {var t = RELATIONALFACTORY.createType();t.setName($.getName()); return t;}).get();
		}
		return objectIdType;
	}
	
	public static Resource start(Resource class2relationalIN, Resource class2relationalOUT) {
		class2relationalOUT.getContents().addAll(Class2RelationalIncremental.transform(class2relationalIN.getContents().stream().map($ -> (EObject) $).collect(Collectors.toList())));
		IO.persist(class2relationalOUT);
		
		
		// setup continuous incrementality on topLevel
		/**
		 * Adapter to listen for changes on topLevel of model
		 * We use AdapterImpl to only listen to insert/delete events and ignore any changes within elements.
		 * Changes within elements trigger Notification on these elements as defined in C2RInc
		 */
		Adapter adapterIn = new AdapterImpl() {
			public void notifyChanged(Notification notification) {
				var notificationType = notification.getEventType();
				switch (notificationType) {
					//handle adding by triggering the pre and actual transforms?
					//updates on those that contain/reference it should automatically happen when their contents change
					case Notification.ADD -> {
						System.out.println("New Object added: " + notification.getNewValue());
						var iterable = Stream.of((EObject) notification.getNewValue()).collect(Collectors.toList());
						PRETRAVERSER.traverseAndAcceptPre(iterable.iterator());
						TRAVERSER.traverseAndAccept(iterable.iterator());
						// add the newly created elements to the resource because everything is stored top level in the C2R transformation
						var allTargets = TRACER.resolveAll((EObject) notification.getNewValue());
						for (EObject target : allTargets) {
							class2relationalOUT.getContents().add(target);
						}
					}
					//handle removal of element by removing all elements that are resolveable through source from the resource
					case Notification.REMOVE -> {
						System.out.println("Object removed: " + notification.getOldValue());
						var allTargets = TRACER.resolveAll((EObject) notification.getOldValue());
						for (EObject target : allTargets) {
							class2relationalOUT.getContents().remove(target);
						}
					}
				}
            }
		};
		class2relationalIN.eAdapters().add(adapterIn);
		
		// adapter to persist output if changes occur
		Adapter adapterOut = new EContentAdapter() {
			public void notifyChanged(Notification notification) {
				System.out.println("Notfication received from the data model. OUTPUT Data model has changed!!!" + notification.getEventType());
//				notification.getNotifier() == class2relationalOUT
				
				//turn of notifications for duration of writing resource to file. Otherwise we get a infinite loop
				class2relationalOUT.eSetDeliver(false);
				IO.persist(class2relationalOUT);
				class2relationalOUT.eSetDeliver(true);
            }
		};
		class2relationalOUT.eAdapters().add(adapterOut);
		
		return class2relationalIN;
	}
	
	public static Resource start(String inPath, String outPath) {
		var class2relationalIN = IO.getResource(inPath);
		var class2relationalOUT = IO.createResource(outPath);
		
		return start(class2relationalIN, class2relationalOUT);
	}
	
	private static List<Named> transform(List<EObject> input) {
		
		for (EObject namedElt : input) {
			if (namedElt instanceof DataType) {
				allDataTypes.add((DataType) namedElt);
			}
		}
		
		preTransform(input);
		return actualTransform(input);
	}
	
    private static void preTransform(List<EObject> input) {
    	var iterator = input.iterator();
        PRETRAVERSER = new Traverser(TRACER);
        PRETRAVERSER.addFunction(ClassImpl.class, x -> Class2TablePre((Class)x ));
        PRETRAVERSER.addFunction(DataTypeImpl.class, x -> DataType2TypePre((DataType) x));
        PRETRAVERSER.addFunction(AttributeImpl.class, x -> {DataTypeAttribute2ColumnPre((Attribute) x);
        											MultiValuedDataTypeAttribute2ColumnPre((Attribute) x);
        											ClassAttribute2ColumnPre((Attribute) x);
        											MultiValuedClassAttribute2ColumnPre((Attribute) x);
        											});
        											
        PRETRAVERSER.traverseAndAcceptPre(iterator);
    }
    
    private static List<Named> actualTransform(List<EObject> input) {
    	var newRoot = Classes2List(input);
    	
    	var iterator = input.iterator();
        TRAVERSER = new Traverser(TRACER);
        TRAVERSER.addFunction(ClassImpl.class, x -> {
        	Class2Table((Class)x );
        	var adapter = new EContentAdapter() {
    			public void notifyChanged(Notification notification) {
    				System.out.println("Notfication received from the data model. Data model of Class has changed!!!" + notification.getEventType());
    				Class2Table((Class) notification.getNotifier());
    			}
    		};
    		x.eAdapters().add(adapter);
        });
        TRAVERSER.addFunction(DataTypeImpl.class, x -> {
        	DataType2Type((DataType) x);
        	var adapter = new EContentAdapter() {
    			public void notifyChanged(Notification notification) {
    				System.out.println("Notfication received from the data model. Data model of Class has changed!!!" + notification.getEventType());
    				DataType2Type((DataType) notification.getNotifier());
    			}
    		};
    		x.eAdapters().add(adapter);
        });
        TRAVERSER.addFunction(AttributeImpl.class, x -> {
        	DataTypeAttribute2Column((Attribute) x);
			MultiValuedDataTypeAttribute2Column((Attribute) x);
			ClassAttribute2Column((Attribute) x);
			MultiValuedClassAttribute2Column((Attribute) x);
			var adapter = new EContentAdapter() {
    			public void notifyChanged(Notification notification) {
    				System.out.println("Notfication received from the data model. Data model of Class has changed!!!" + notification.getEventType());
    				DataTypeAttribute2Column((Attribute) notification.getNotifier());
    				MultiValuedDataTypeAttribute2Column((Attribute) notification.getNotifier());
    				ClassAttribute2Column((Attribute) notification.getNotifier());
    				MultiValuedClassAttribute2Column((Attribute) notification.getNotifier());
    			}
    		};
    		x.eAdapters().add(adapter);
		});
        
        TRAVERSER.traverseAndAccept(iterator);
        
        return newRoot;
    }
    
    private static List<Named> Classes2List(List<EObject> input) {
    	var nameds = new LinkedList<Named>();
    	
    	for (EObject eObject : input) {
			nameds.addAll(TRACER.resolveAll(eObject).stream().map($ -> (Named) $).collect(Collectors.toList()));
		}
    	nameds.add(objectIdType());
    	
    	return nameds;
    }
    
    public static void Class2TablePre(Class c) {
    	TRACER.addTrace(c, RELATIONALFACTORY.createTable());
    	TRACER.addTrace(c, "key", RELATIONALFACTORY.createColumn());
    }
    
    public static void Class2Table(Class c) {
    	var out = TRACER.resolve(c, RELATIONALFACTORY.createTable());
    	var key = TRACER.resolve(c, "key", RELATIONALFACTORY.createColumn());
    	
    	out.setName(c.getName());
    	out.getCol().clear();
    	out.getCol().add(key);
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, "key" ,RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, "id", RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, "value", RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, "foreignKey", RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));
    	
    	out.getKey().clear();
    	out.getKey().add(key);
    	
    	key.setName("objectId");
    	key.setType(objectIdType());
    }
    
    public static void DataType2TypePre(DataType dt) {
    	TRACER.addTrace(dt, RELATIONALFACTORY.createType());
    }
    
    public static void DataType2Type(DataType dt) {
    	var out = TRACER.resolve(dt, RELATIONALFACTORY.createType());
    	out.setName(dt.getName());
    }
    
    public static void DataTypeAttribute2ColumnPre(Attribute a) {
    	if(DataType.class.isAssignableFrom(a.getClass())) {
    		TRACER.addTrace(a, RELATIONALFACTORY.createColumn());
    	}
    }
    
    public static void DataTypeAttribute2Column(Attribute a) {
    	var out = TRACER.resolve(a, RELATIONALFACTORY.createColumn());
    	
    	out.setName(a.getName());
    	out.setType(TRACER.resolve(a.getType(), RELATIONALFACTORY.createType()));
    }
    
    public static void MultiValuedDataTypeAttribute2ColumnPre(Attribute a) {
    	if(DataType.class.isAssignableFrom(a.getClass()) && a.getMultiValued()) {
    		TRACER.addTrace(a, RELATIONALFACTORY.createTable());
    		TRACER.addTrace(a, "id", RELATIONALFACTORY.createColumn());
    		TRACER.addTrace(a, "value", RELATIONALFACTORY.createColumn());
    	}
    }
    
    public static void MultiValuedDataTypeAttribute2Column(Attribute a) {
    	var out = TRACER.resolve(a, RELATIONALFACTORY.createTable());
    	var id = TRACER.resolve(a, "id", RELATIONALFACTORY.createColumn());
    	var value = TRACER.resolve(a, "value", RELATIONALFACTORY.createColumn());
    	
    	out.setName(a.getOwner().getName() + "_" + a.getName());
    	out.getCol().clear();
    	out.getCol().add(id);
    	out.getCol().add(value);
    	
    	var ownerName= a.getOwner().getName();
    	var name = Character.toLowerCase(ownerName.charAt(0)) + ownerName.substring(1);
    	id.setName(name + "Id");
    	id.setType(objectIdType());
    	
    	value.setName(a.getName());
    	value.setType(TRACER.resolve(a.getType(), RELATIONALFACTORY.createType()));
    }
    
    public static void ClassAttribute2ColumnPre(Attribute a) {
    	if(DataType.class.isAssignableFrom(a.getClass()) && !a.getMultiValued()) {
    		TRACER.addTrace(a, RELATIONALFACTORY.createColumn());
    	}
    }
    
    public static void ClassAttribute2Column(Attribute a) {
    	var foreignKey = TRACER.resolve(a, RELATIONALFACTORY.createColumn());
    	foreignKey.setName(a.getName() + "Id");
    	foreignKey.setType(objectIdType());
    }
    
    public static void MultiValuedClassAttribute2ColumnPre(Attribute a) {
    	if(Class.class.isAssignableFrom(a.getClass()) && a.getMultiValued()) {
    		TRACER.addTrace(a, RELATIONALFACTORY.createTable());
    		TRACER.addTrace(a, "id", RELATIONALFACTORY.createColumn());
    		TRACER.addTrace(a, "foreignKey", RELATIONALFACTORY.createColumn());
    	}
    }
    
    public static void MultiValuedClassAttribute2Column(Attribute a) {
    	var t = TRACER.resolve(a, RELATIONALFACTORY.createTable());
    	var id = TRACER.resolve(a, "id", RELATIONALFACTORY.createColumn());
    	var foreignKey = TRACER.resolve(a, "foreignKey", RELATIONALFACTORY.createColumn());
    	
    	t.setName(a.getOwner().getName() + "_" + a.getName());
    	t.getCol().clear();
    	t.getCol().add(id);
    	t.getCol().add(foreignKey);
    	
    	var ownerName= a.getOwner().getName();
    	var name = Character.toLowerCase(ownerName.charAt(0)) + ownerName.substring(1);
    	id.setName(name + "Id");
    	id.setType(objectIdType());
    	
    	foreignKey.setName(a.getName() + "Id");
    	foreignKey.setType(TRACER.resolve(a.getType(), RELATIONALFACTORY.createType()));
    }

}