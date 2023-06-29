package transformations.batch;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;

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

public class Class2Relational {
	private static final Relational_Factory RELATIONALFACTORY = Relational_Factory.eINSTANCE;
	private static final Tracer TRACER = new Tracer();
	private static final List<DataType> allDataTypes = new LinkedList<>();
	
	private static Type objectIdType;
	
	private static Type objectIdType() {
		if (objectIdType == null) {
			objectIdType = allDataTypes.stream().filter($ -> $.getName().equals("Integer")).findFirst().map($ -> {var t = RELATIONALFACTORY.createType();t.setName($.getName()); return t;}).get();
		}
		return objectIdType;
	}
	
	
	public static List<Named> transform(List<EObject> input) {
		
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
        var traverser = new Traverser(TRACER);
        traverser.addFunction(ClassImpl.class, x -> Class2TablePre((Class)x ));
        traverser.addFunction(DataTypeImpl.class, x -> DataType2TypePre((DataType) x));
        traverser.addFunction(AttributeImpl.class, x -> {DataTypeAttribute2ColumnPre((Attribute) x);
        											MultiValuedDataTypeAttribute2ColumnPre((Attribute) x);
        											ClassAttribute2ColumnPre((Attribute) x);
        											MultiValuedClassAttribute2ColumnPre((Attribute) x);
        											});
        											
        traverser.traverseAndAcceptPre(iterator);
    }
    
    private static List<Named> actualTransform(List<EObject> input) {
    	var newRoot = Classes2List(input);
    	
    	var iterator = input.iterator();
        var traverser = new Traverser(TRACER);
        traverser.addFunction(ClassImpl.class, x -> Class2Table((Class)x ));
        traverser.addFunction(DataTypeImpl.class, x -> DataType2Type((DataType) x));
        traverser.addFunction(AttributeImpl.class, x -> {DataTypeAttribute2Column((Attribute) x);
													MultiValuedDataTypeAttribute2Column((Attribute) x);
													ClassAttribute2Column((Attribute) x);
													MultiValuedClassAttribute2Column((Attribute) x);
		});
        
        traverser.traverseAndAccept(iterator);
        
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