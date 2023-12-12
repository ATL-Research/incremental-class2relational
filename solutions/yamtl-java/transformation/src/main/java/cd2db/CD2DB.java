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

public class CD2DB extends YAMTLModule {

    static String inputModelPath = "C:\\Users\\ab373\\Documents\\git-repos\\git-yamtl\\incremental-class2relational\\models\\correctness5\\class.xmi";
    static String changePath = "C:\\Users\\ab373\\Documents\\git-repos\\git-yamtl\\incremental-class2relational\\models\\correctness5\\change.xmi";

    public static void main(String[] args) {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
                "xmi",
                new XMIResourceFactoryImpl()
        );

        // Register source, change and target metamodels in global registry
        EPackage e;
        e = Class_Package.eINSTANCE;
        e = Relational_Package.eINSTANCE;
        e = ChangesPackage.eINSTANCE;

        var source = resourceSet.getResource(URI.createFileURI(inputModelPath), true);
        var changes = resourceSet.getResource(URI.createFileURI(changePath), true);
        EcoreUtil.resolveAll(resourceSet);


        CD2DB xform = new CD2DB();
        xform.adviseWithinThisNamespaceExpressions(List.of("atl.research.class_..*"));
        xform.setExecutionMode(YAMTLModule.ExecutionMode.INCREMENTAL);

        xform.loadInputResources(Map.of("cd", source));
        xform.execute();


        xform.saveOutputModels(Map.of("db", "transformation/src/main/java/cd2db/java/out_after_batch.xmi"), List.of("Table", "Type"));

        xform.adaptInputModel("cd");



        if (changes.getContents().size() > 0) {
            ModelChangeSet change = (ModelChangeSet) changes.getContents().get(0);
            for (ModelChange c : change.getChanges()) {
                System.out.println("Applying change " + c);
                c.apply();
            }
        }

        xform.propagateDelta("cd");

        xform.saveOutputModels(Map.of("db", "transformation/src/main/java/cd2db/java/out_after_prop.xmi"), List.of("Table", "Type"));
    }
    
    
    public CD2DB() {
        header().in("cd", CD).out("db", DB);

        ruleStore(List.of(
                rule("ClassToTable")
                        .in("c", cd_Class())
                        .out("t", db_Table(), () -> {
                            Class c = c();
                            Table t = t();
                            t.setName(c.getName());

                            List<Attribute> list = c.getAttr().stream()
                                    .filter(a -> !a.getMultiValued())
                                    .collect(Collectors.toList());
                            t.getCol().addAll((List<Column>)fetch(list, "col" ));

                            t.getCol().add(key());
                            t.getKey().add(key());
                        })
                        .out("key", db_Column(), () -> {
                            key().setName("objectId");
                            key().setType((Type)fetch(fetch("objectIdType")));
                        }),

                rule("DataType2Type")
                        .in("dt", cd_DataType())
                        .out("type", db_Type(), () -> {
                            type().setName(dt().getName());
                        }),

                rule("DataTypeAttribute2Column")
                        .in("att", cd_Attribute()).filter(() -> {
                            return att().getType() instanceof DataType &&
                                    !att().getMultiValued();
                        })
                        .out("col", db_Column(), () -> {
                            col().setName(att().getName());
                            col().setType((Type)fetch(att().getType()));
                        }),

                rule("MultiValuedDataTypeAttribute2Column")
                        .in("att", cd_Attribute()).filter(() -> {
                            return att().getType() instanceof DataType &&
                                    att().getMultiValued();
                        })
                        .out("t", db_Table(), () -> {
                            if (att().getOwner() != null && att().getOwner().getName() != null)
                                t().setName(att().getOwner().getName() + "_" + att().getName());
                            t().getCol().add(id());
                            t().getCol().add(col());
                        })
                        .out("id", db_Column(), () -> {
                            if (att().getOwner() != null && att().getOwner().getName() != null)
                                id().setName(firstToLower(att().getOwner().getName()) + "Id");
                            var intDataType = fetch("objectIdType");
                            if (intDataType != null)
                                id().setType((Type)fetch(intDataType));
                        })
                        .out("col", db_Column(), () -> {
                            col().setName(att().getName());
                            col().setType((Type)fetch(att().getType()));
                        }),


                rule("ClassAttribute2Column")
                        .in("att", cd_Attribute()).filter(() -> {
                            return att().getType() instanceof Class &&
                                    !att().getMultiValued();
                        })
                        .out("col", db_Column(), () -> {
                            col().setName(att().getName() + "Id");
                            var intDataType = fetch("objectIdType");
                            if (intDataType != null)
                                col().setType((Type)fetch(intDataType));
                        }),

                rule("MultiValuedClassAttribute2Column")
                        .in("att", cd_Attribute()).filter(() -> {
                            return att().getType() instanceof Class &&
                                    att().getMultiValued();
                        })
                        .out("t", db_Table(), () -> {
                            if (att().getOwner() != null  && att().getOwner().getName() != null)
                                t().setName(att().getOwner().getName() + "_" + att().getName());
                            t().getCol().add(id());
                            t().getCol().add(col());
                        })
                        .out("id", db_Column(), () -> {
                            if (att().getOwner() != null && att().getOwner().getName() != null)
                                id().setName(firstToLower(att().getOwner().getName()) + "Id");
                            var intDataType = fetch("objectIdType");
                            if (intDataType != null)
                                id().setType((Type)fetch(intDataType));
                        })
                        .out("col", db_Column(), () -> {
                            col().setName(att().getName() + "Id");
                            var intDataType = fetch("objectIdType");
                            if (intDataType != null)
                                col().setType((Type)fetch(intDataType));
                        })


        ));

        helperStore( List.of(

                staticAttribute("objectIdType", () -> {
                    return allInstances(cd_DataType())
                            .stream()
                            .filter(it -> it instanceof DataType && "Integer".equals(((DataType)it).getName()))
                            .findFirst().orElse(null);
                })

        ));
    }



    public List<Attribute> incomingReferences(Class c) {
        return allInstances(cd_Attribute()).stream()
                .map(instance -> (Attribute) instance) // casting to Attribute
                .filter(attribute -> attribute.getType().equals(c) && attribute.getMultiValued())
                .collect(Collectors.toList());
    }


    public static String firstToLower(String input) {
        return input.isEmpty() ? input : Character.toLowerCase(input.charAt(0)) + input.substring(1);
    }


    private EPackage CD = Class_Package.eINSTANCE;
    private EPackage DB = Relational_Package.eINSTANCE;

    public EClass cd_Class() {
        return (EClass) CD.getEClassifier("Class");
    }
    public EClass cd_Attribute() {
        return (EClass) CD.getEClassifier("Attribute");
    }
    public EClass cd_DataType() {
        return (EClass) CD.getEClassifier("DataType");
    }
    public EClass db_Table() {
        return (EClass) DB.getEClassifier("Table");
    }
    public EClass db_Column() {
        return (EClass) DB.getEClassifier("Column");
    }
    public EClass db_Type() {
        return (EClass) DB.getEClassifier("Type");
    }

    public DataType dt() {
        Object _fetch = this.fetch("dt");
        return ((DataType) _fetch);
    }

    public Class c() {
        Object _fetch = this.fetch("c");
        return ((Class) _fetch);
    }

    public Table t() {
        Object _fetch = this.fetch("t");
        return ((Table) _fetch);
    }

    public Column key() {
        Object _fetch = this.fetch("key");
        return ((Column) _fetch);
    }

    public Attribute att() {
        Object _fetch = this.fetch("att");
        return ((Attribute) _fetch);
    }

    public Column col() {
        Object _fetch = this.fetch("col");
        return ((Column) _fetch);
    }
    public Column id() {
        Object _fetch = this.fetch("id");
        return ((Column) _fetch);
    }
    public Column value() {
        Object _fetch = this.fetch("value");
        return ((Column) _fetch);
    }

    public Type type() {
        Object _fetch = this.fetch("type");
        return ((Type) _fetch);
    }

}
