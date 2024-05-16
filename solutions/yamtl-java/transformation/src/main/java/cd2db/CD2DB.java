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

    public CD2DB() {
        header().in("cd", CD).out("db", DB);
        ruleStore(List.of(
        		rule("ClassToTable")
        				// model navigation
        				.in("c", cd_Class())
        				// transformation	
                        .out("t", db_Table(), () -> {
                        	// model navigation
                        	Class c = c();
                            Table t = t();
                            // transformation
                            t.setName(c.getName());
                            t.getCol().add(key());
                            t.getKey().add(key());
                            // model navigation
                            List<Attribute> list = c.getAttr()
                            		.stream()
                            		.filter(a -> !a.getMultiValued())
                            		.collect(Collectors.toList());
                            // transformation 
                            t.getCol().addAll(
                            		// trace
                            		(List<Column>)fetch(list, "col" )
                            );
                        })
                        // transformation	
                        .out("key", db_Column(), () -> {
                            key().setName("objectId");
                            key().setType(
                        		// trace
                        		(Type)fetch(
                                    // model navigation
                                    fetch("objectIdType")
                                )
                            );
                        }),

                // transformation	
                rule("DataType2Type")
                		// model navigation
                        .in("dt", cd_DataType())
                        // transformation	
                        .out("type", db_Type(), () -> {
                            type().setName(dt().getName());
                        }),
                // transformation			
                rule("DataTypeAttribute2Column")
		                // model navigation
                        .in("att", cd_Attribute()).filter(() -> {
                            return att().getType() instanceof DataType &&
                                    !att().getMultiValued();
                        })
                        // transformation
                        .out("col", db_Column(), () -> {
                            col().setName(att().getName());
                            col().setType(
                            		// trace 
                            		(Type)fetch(att().getType())
                            );
                        }),
                // transformation			
                rule("MultiValuedDataTypeAttribute2Column")
                // model navigation
                        .in("att", cd_Attribute()).filter(() -> {
                            return att().getType() instanceof DataType &&
                                    att().getMultiValued();
                        })
                        // transformation
                        .out("t", db_Table(), () -> {
                            if (att().getOwner() != null && att().getOwner().getName() != null)
                                t().setName(att().getOwner().getName() + "_" + att().getName());
                            t().getCol().add(id());
                            t().getCol().add(col());
                        })
                        // transformation
                        .out("id", db_Column(), () -> {
                            if (att().getOwner() != null && att().getOwner().getName() != null)
                                id().setName(firstToLower(att().getOwner().getName()) + "Id");
                            // model navigation
                            var intDataType = fetch("objectIdType");
                            // transformation
                            if (intDataType != null)
                                id().setType(
                                		//trace
                                		(Type)fetch(intDataType)
                                );
                        })
                        // transformation
                        .out("col", db_Column(), () -> {
                            col().setName(att().getName());
                            col().setType(
                            		// trace
                            		(Type)fetch(att().getType())
                            );
                        }),

                // transformation
                rule("ClassAttribute2Column")
                		// model navigation
                        .in("att", cd_Attribute()).filter(() -> {
                            return att().getType() instanceof Class &&
                                    !att().getMultiValued();
                        })
                        // transformation
                        .out("col", db_Column(), () -> {
                            col().setName(att().getName() + "Id");
                            var intDataType = fetch("objectIdType");
                            if (intDataType != null)
                                col().setType(
                                		// trace 
                                		(Type)fetch(intDataType)
                                );
                        }),

                // transformation
                rule("MultiValuedClassAttribute2Column")
                		// model navigation
                        .in("att", cd_Attribute()).filter(() -> {
                            return att().getType() instanceof Class &&
                                    att().getMultiValued();
                        })
                        // transformation
                        .out("t", db_Table(), () -> {
                            if (att().getOwner() != null  && att().getOwner().getName() != null)
                                t().setName(att().getOwner().getName() + "_" + att().getName());
                            else
                                t().setName("Table_" + att().getName());
                            t().getCol().add(id());
                            t().getCol().add(col());
                        })
                        // transformation
                        .out("id", db_Column(), () -> {
                            if (att().getOwner() != null && att().getOwner().getName() != null)
                                id().setName(firstToLower(att().getOwner().getName()) + "Id");
                            else 
                                id().setName("tableId");
                            // model navigation
                            var intDataType = fetch("objectIdType");
                            // transformation
                            if (intDataType != null)
                                id().setType(
                                		// trace 
                                		(Type)fetch(intDataType)
                                );
                        })
                        // transformation
                        .out("col", db_Column(), () -> {
                            col().setName(att().getName() + "Id");
                            // model navigation
                            var intDataType = fetch("objectIdType");
                            // transformation
                            if (intDataType != null)
                                col().setType(
                                		// trace
                                		(Type)fetch(intDataType)
                                );
                        })

        ));
        // helper
        helperStore( List.of(
            staticAttribute("objectIdType", () -> {
                return allInstances(cd_DataType())
                        .stream()
                        .filter(it -> it instanceof DataType && "Integer".equals(((DataType)it).getName()))
                        .findFirst().orElse(null);
            })
        ));
    }

    // helper
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
