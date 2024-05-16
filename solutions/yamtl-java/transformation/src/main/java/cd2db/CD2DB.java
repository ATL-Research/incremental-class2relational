package cd2db;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import Changes.ChangesPackage;
import Changes.ModelChange;
import Changes.ModelChangeSet;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import static yamtl.dsl.Helper.*;
import static yamtl.dsl.Rule.*;

import atl.research.class_.Attribute;
import atl.research.class_.Class;
import atl.research.class_.Class_Package;
import atl.research.class_.DataType;
import atl.research.relational_.Column;
import atl.research.relational_.Relational_Package;
import atl.research.relational_.Table;
import atl.research.relational_.Type;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import yamtl.core.YAMTLModule;

// transformation
public class CD2DB extends YAMTLModule {

    static String inputModelPath = "C:\\Users\\ab373\\Documents\\git-repos\\git-yamtl\\incremental-class2relational\\models\\correctness5\\class.xmi";
    static String changePath = "C:\\Users\\ab373\\Documents\\git-repos\\git-yamtl\\incremental-class2relational\\models\\correctness5\\change.xmi";

    // setup
    public static void main(String[] args) {
    	// setup
        ResourceSet resourceSet = new ResourceSetImpl();
        // setup
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());

        // setup
        EPackage e = Class_Package.eINSTANCE;
        // setup
        e = Relational_Package.eINSTANCE;
        // setup
        e = ChangesPackage.eINSTANCE;

        // setup
        var source = resourceSet.getResource(URI.createFileURI(inputModelPath), true);
        // setup
        var changes = resourceSet.getResource(URI.createFileURI(changePath), true);
        // setup
        EcoreUtil.resolveAll(resourceSet);

        // setup
        CD2DB xform = new CD2DB();
        // incremental change recognition
        xform.adviseWithinThisNamespaceExpressions(List.of("atl.research.class_..*"));
        // setup
        xform.setExecutionMode(YAMTLModule.ExecutionMode.INCREMENTAL);
        // setup
        xform.loadInputResources(Map.of("cd", source));
        // setup
        xform.execute();

        // setup
        xform.saveOutputModels(Map.of("db", "transformation/src/main/java/cd2db/java/out_after_batch.xmi"), List.of("Table", "Type"));
        // incremental change recognition
        xform.adaptInputModel("cd");

        // setup
        if (changes.getContents().size() > 0) {
            // setup
            ModelChangeSet change = (ModelChangeSet) changes.getContents().get(0);
            // setup
            for (ModelChange c : change.getChanges()) {
            	// System.out.println("Applying change " + c);
                // setup
                c.apply();
            }
        }
        //  incremental change propagation
        xform.propagateDelta("cd");
        // setup
        xform.saveOutputModels(Map.of("db", "transformation/src/main/java/cd2db/java/out_after_prop.xmi"), List.of("Table", "Type"));
    }

    // transformation
    public CD2DB() {
        // transformation
        header().in("cd", CD).out("db", DB);
        // transformation
        ruleStore(List.of(
        		// transformation	
        		rule("ClassToTable")
        				// model navigation
        				.in("c", cd_Class())
        				// transformation	
                        .out("t", db_Table(), () -> {
                        	// model navigation
                        	Class c = c();
                        	// model navigation
                            Table t = t();
                            // transformation
                            t.setName(c.getName());
                            // transformation	
                            t.getCol().add(key());
                            // transformation	
                            t.getKey().add(key());
                            // model navigation
                            List<Attribute> list = c.getAttr()
                            		// model navigation
                            		.stream()
                            		// model navigation
                            		.filter(a -> !a.getMultiValued())
                            		// model navigation
                            		.collect(Collectors.toList());
                            // transformation 
                            t.getCol().addAll(
                            		// trace
                            		(List<Column>)fetch(list, "col" )
                            );
                        })
                        // transformation	
                        .out("key", db_Column(), () -> {
                        	// transformation	
                            key().setName("objectId");
                            // transformation
                            key().setType(
                        		// trace
                        		(Type)fetch(fetch("objectIdType"))
                            );
                        }),

                // transformation	
                rule("DataType2Type")
                		// model navigation
                        .in("dt", cd_DataType())
                        // transformation	
                        .out("type", db_Type(), () -> {
                        	// transformation
                            type().setName(dt().getName());
                        }),
                // transformation			
                rule("DataTypeAttribute2Column")
		                // model navigation
                        .in("att", cd_Attribute()).filter(() -> {
                        	// model navigation
                            return att().getType() instanceof DataType &&
                            		// model navigation
                                    !att().getMultiValued();
                        })
                        // transformation
                        .out("col", db_Column(), () -> {
                        	// transformation
                            col().setName(att().getName());
                            // transformation
                            col().setType(
                            		// trace 
                            		(Type)fetch(att().getType())
                            );
                        }),
                // transformation			
                rule("MultiValuedDataTypeAttribute2Column")
                // model navigation
                        .in("att", cd_Attribute()).filter(() -> {
                        	// model navigation
                            return att().getType() instanceof DataType &&
                            		// model navigation
                                    att().getMultiValued();
                        })
                        // transformation
                        .out("t", db_Table(), () -> {
                        	// transformation
                            if (att().getOwner() != null && att().getOwner().getName() != null)
                            	// transformation
                                t().setName(att().getOwner().getName() + "_" + att().getName());
                            // transformation
                            t().getCol().add(id());
                            // transformation
                            t().getCol().add(col());
                        })
                        // transformation
                        .out("id", db_Column(), () -> {
                        	// transformation
                            if (att().getOwner() != null && att().getOwner().getName() != null)
                            	// transformation
                                id().setName(firstToLower(att().getOwner().getName()) + "Id");
                            // transformation
                            var intDataType = fetch("objectIdType");
                            // transformation
                            if (intDataType != null)
                            	// transformation
                                id().setType(
                                		//trace
                                		(Type)fetch(intDataType)
                                );
                        })
                        // transformation
                        .out("col", db_Column(), () -> {
                        	// transformation
                            col().setName(att().getName());
                            // transformation
                            col().setType(
                            		// trace
                            		(Type)fetch(att().getType())
                            );
                        }),

                // transformation
                rule("ClassAttribute2Column")
                		// model navigation
                        .in("att", cd_Attribute()).filter(() -> {
                        	// model navigation
                            return att().getType() instanceof Class &&
                            		// model navigation
                                    !att().getMultiValued();
                        })
                        // transformation
                        .out("col", db_Column(), () -> {
                        	// transformation
                            col().setName(att().getName() + "Id");
                            // transformation
                            var intDataType = fetch("objectIdType");
                            // transformation
                            if (intDataType != null)
                            	// transformation
                                col().setType(
                                		// trace 
                                		(Type)fetch(intDataType)
                                );
                        }),

                // transformation
                rule("MultiValuedClassAttribute2Column")
                		// model navigation
                        .in("att", cd_Attribute()).filter(() -> {
                        	// model navigation
                            return att().getType() instanceof Class &&
                            		// model navigation
                                    att().getMultiValued();
                        })
                        // transformation
                        .out("t", db_Table(), () -> {
                        	// transformation
                            if (att().getOwner() != null  && att().getOwner().getName() != null)
                            	// transformation
                                t().setName(att().getOwner().getName() + "_" + att().getName());
                            // transformation
                            t().getCol().add(id());
                            // transformation
                            t().getCol().add(col());
                        })
                        // transformation
                        .out("id", db_Column(), () -> {
                        	// transformation
                            if (att().getOwner() != null && att().getOwner().getName() != null)
                            	// transformation
                                id().setName(firstToLower(att().getOwner().getName()) + "Id");
                            // transformation
                            var intDataType = fetch("objectIdType");
                            // transformation
                            if (intDataType != null)
                            	// transformation
                                id().setType(
                                		// trace 
                                		(Type)fetch(intDataType)
                                );
                        })
                        .out("col", db_Column(), () -> {
                        	// transformation
                            col().setName(att().getName() + "Id");
                            // transformation
                            var intDataType = fetch("objectIdType");
                            // transformation
                            if (intDataType != null)
                            	// transformation, 
                                col().setType(
                                		// trace
                                		(Type)fetch(intDataType)
                                );
                        })

        ));

        // helper
        helperStore( List.of(
        		// helper
                staticAttribute("objectIdType", () -> {
                	// helper
                	return allInstances(cd_DataType())
                			// helper
                            .stream()
                            // helper
                            .filter(it -> it instanceof DataType && "Integer".equals(((DataType)it).getName()))
                            // helper
                            .findFirst().orElse(null);
                })

        ));
    }


    // helper
    public List<Attribute> incomingReferences(Class c) {
    	// helper
        return allInstances(cd_Attribute()).stream()
        		// helper
                .map(instance -> (Attribute) instance) // casting to Attribute
                // helper
                .filter(attribute -> attribute.getType().equals(c) && attribute.getMultiValued())
                // helper
                .collect(Collectors.toList());
    }


    // helper
    public static String firstToLower(String input) {
    	// helper
        return input.isEmpty() ? input : Character.toLowerCase(input.charAt(0)) + input.substring(1);
    }


    // helper
    private EPackage CD = Class_Package.eINSTANCE;
    // helper
    private EPackage DB = Relational_Package.eINSTANCE;

    // helper
    public EClass cd_Class() {
    	// helper
        return (EClass) CD.getEClassifier("Class");
    }
    // helper
    public EClass cd_Attribute() {
    	// helper
        return (EClass) CD.getEClassifier("Attribute");
    }
    // helper
    public EClass cd_DataType() {
    	// helper
        return (EClass) CD.getEClassifier("DataType");
    }
    // helper
    public EClass db_Table() {
    	// helper
        return (EClass) DB.getEClassifier("Table");
    }
    // helper
    public EClass db_Column() {
    	// helper
        return (EClass) DB.getEClassifier("Column");
    }
    // helper
    public EClass db_Type() {
    	// helper
        return (EClass) DB.getEClassifier("Type");
    }

    // helper
    public DataType dt() {
    	// helper
        Object _fetch = this.fetch("dt");
        // helper
        return ((DataType) _fetch);
    }

    // helper
    public Class c() {
    	// helper
        Object _fetch = this.fetch("c");
        // helper
        return ((Class) _fetch);
    }

    // helper
    public Table t() {
    	// helper
        Object _fetch = this.fetch("t");
        // helper
        return ((Table) _fetch);
    }

    // helper
    public Column key() {
    	// helper
        Object _fetch = this.fetch("key");
        return ((Column) _fetch);
    }

    // helper
    public Attribute att() {
    	// helper
        Object _fetch = this.fetch("att");
        // helper
        return ((Attribute) _fetch);
    }

    // helper
    public Column col() {
    	// helper
        Object _fetch = this.fetch("col");
        // helper
        return ((Column) _fetch);
    }
    // helper
    public Column id() {
    	// helper
        Object _fetch = this.fetch("id");
        // helper
        return ((Column) _fetch);
    }
    // helper
    public Column value() {
    	// helper
        Object _fetch = this.fetch("value");
        // helper
        return ((Column) _fetch);
    }

    // helper
    public Type type() {
    	// helper
        Object _fetch = this.fetch("type");
        // helper
        return ((Type) _fetch);
    }

}
