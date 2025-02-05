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

// Setup
public class Class2Relational {
	private static final Relational_Factory RELATIONALFACTORY = Relational_Factory.eINSTANCE;
	// Tracing
	private static final Tracer TRACER = new Tracer();
	// Helper
	private static final List<DataType> allDataTypes = new LinkedList<>();

	private static Type objectIdType;

	private static Type objectIdType() {
		if (objectIdType == null) {
			objectIdType = allDataTypes.stream().filter($ -> $.getName().equals("Integer")).findFirst().map($ -> {var t = RELATIONALFACTORY.createType();t.setName($.getName()); return t;}).get();
		}
		return objectIdType;
	}

    // Traversal
	public static List<Named> transform(List<EObject> input) {

		for (EObject namedElt : input) {
			if (namedElt instanceof DataType) {
				allDataTypes.add((DataType) namedElt);
			}
		}

		preTransform(input);
		return actualTransform(input);
	}

	// Traversal
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

    // Traversal
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

    // Transformation
    private static List<Named> Classes2List(List<EObject> input) {
    	var nameds = new LinkedList<Named>();

    	for (EObject eObject : input) {
            // Transformation 4
            // Tracing 10
			nameds.addAll(TRACER.resolveAll(eObject).stream().map($ -> (Named) $).collect(Collectors.toList()));
		}
		// Transformation
    	nameds.add(objectIdType());

    	return nameds;
    }

    // Tracing
    public static void Class2TablePre(Class c) {
    	TRACER.addTrace(c, RELATIONALFACTORY.createTable());
    	TRACER.addTrace(c, "key", RELATIONALFACTORY.createColumn());
    }

    // Transformation
    public static void Class2Table(Class c) {
        // Tracing
    	var out = TRACER.resolve(c, RELATIONALFACTORY.createTable());
    	var key = TRACER.resolve(c, "key", RELATIONALFACTORY.createColumn());

    	// Transformation
    	out.setName(c.getName());
    	out.getCol().clear();
    	out.getCol().add(key);
    	// Transformation 12
    	// Tracing 16
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));
    	// Transformation 12
    	// Tracing 17
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, "key" ,RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));
        // Transformation 12
    	// Tracing 17
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, "id", RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));
        // Transformation 12
    	// Tracing 17
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, "value", RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));
    	// Transformation 12
    	// Tracing 17
    	out.getCol().addAll(c.getAttr().stream().filter(e -> !e.getMultiValued()).map($ -> TRACER.resolve($, "foreignKey", RELATIONALFACTORY.createColumn())).filter($ -> $ != null).collect(Collectors.toList()));

    	// Transformation
    	out.getKey().clear();
    	out.getKey().add(key);

    	key.setName("objectId");
    	key.setType(objectIdType());
    }

    // Tracing
    public static void DataType2TypePre(DataType dt) {
    	TRACER.addTrace(dt, RELATIONALFACTORY.createType());
    }

    // Transformation
    public static void DataType2Type(DataType dt) {
        // Tracing
    	var out = TRACER.resolve(dt, RELATIONALFACTORY.createType());
    	// Transformation
    	out.setName(dt.getName());
    }

    // Tracing
    public static void DataTypeAttribute2ColumnPre(Attribute a) {
    	if(DataType.class.isAssignableFrom(a.getClass())) {
    		TRACER.addTrace(a, RELATIONALFACTORY.createColumn());
    	}
    }

    // Transformation
    public static void DataTypeAttribute2Column(Attribute a) {
        // Tracing
    	var out = TRACER.resolve(a, RELATIONALFACTORY.createColumn());

    	// Transformation
    	out.setName(a.getName());
    	// Transformation 3
    	// Tracing 6
    	out.setType(TRACER.resolve(a.getType(), RELATIONALFACTORY.createType()));
    }

    // Tracing
    public static void MultiValuedDataTypeAttribute2ColumnPre(Attribute a) {
    	if(DataType.class.isAssignableFrom(a.getClass()) && a.getMultiValued()) {
    		TRACER.addTrace(a, RELATIONALFACTORY.createTable());
    		TRACER.addTrace(a, "id", RELATIONALFACTORY.createColumn());
    		TRACER.addTrace(a, "value", RELATIONALFACTORY.createColumn());
    	}
    }

    // Transformation
    public static void MultiValuedDataTypeAttribute2Column(Attribute a) {
        // Tracing
    	var out = TRACER.resolve(a, RELATIONALFACTORY.createTable());
    	var id = TRACER.resolve(a, "id", RELATIONALFACTORY.createColumn());
    	var value = TRACER.resolve(a, "value", RELATIONALFACTORY.createColumn());

    	// Transformation
    	out.setName(a.getOwner().getName() + "_" + a.getName());
    	out.getCol().clear();
    	out.getCol().add(id);
    	out.getCol().add(value);

    	var ownerName= a.getOwner().getName();
    	var name = Character.toLowerCase(ownerName.charAt(0)) + ownerName.substring(1);
    	id.setName(name + "Id");
    	id.setType(objectIdType());

    	value.setName(a.getName());
    	// Transformation 3
    	// Tracing 6
    	value.setType(TRACER.resolve(a.getType(), RELATIONALFACTORY.createType()));
    }

    // Tracing
    public static void ClassAttribute2ColumnPre(Attribute a) {
    	if(DataType.class.isAssignableFrom(a.getClass()) && !a.getMultiValued()) {
    		TRACER.addTrace(a, RELATIONALFACTORY.createColumn());
    	}
    }

    // Transformation
    public static void ClassAttribute2Column(Attribute a) {
        // Tracing
    	var foreignKey = TRACER.resolve(a, RELATIONALFACTORY.createColumn());
    	// Transformation
    	foreignKey.setName(a.getName() + "Id");
    	foreignKey.setType(objectIdType());
    }

    // Tracing
    public static void MultiValuedClassAttribute2ColumnPre(Attribute a) {
    	if(Class.class.isAssignableFrom(a.getClass()) && a.getMultiValued()) {
    		TRACER.addTrace(a, RELATIONALFACTORY.createTable());
    		TRACER.addTrace(a, "id", RELATIONALFACTORY.createColumn());
    		TRACER.addTrace(a, "foreignKey", RELATIONALFACTORY.createColumn());
    	}
    }

    // Transformation
    public static void MultiValuedClassAttribute2Column(Attribute a) {
        // Tracing
    	var t = TRACER.resolve(a, RELATIONALFACTORY.createTable());
    	var id = TRACER.resolve(a, "id", RELATIONALFACTORY.createColumn());
    	var foreignKey = TRACER.resolve(a, "foreignKey", RELATIONALFACTORY.createColumn());

    	// Transformation
    	t.setName(a.getOwner().getName() + "_" + a.getName());
    	t.getCol().clear();
    	t.getCol().add(id);
    	t.getCol().add(foreignKey);

    	var ownerName= a.getOwner().getName();
    	var name = Character.toLowerCase(ownerName.charAt(0)) + ownerName.substring(1);
    	id.setName(name + "Id");
    	id.setType(objectIdType());

    	foreignKey.setName(a.getName() + "Id");
    	// Transformation 3
    	// Tracing 6
    	foreignKey.setType(TRACER.resolve(a.getType(), RELATIONALFACTORY.createType()));
    }

}
