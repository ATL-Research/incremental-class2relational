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

import yamtl.core.YAMTLModule
import yamtl.groovy.YAMTLGroovyExtensions
import yamtl.groovy.YAMTLGroovyExtensions_dynamicEMF

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
	// setup
	public EPackage CD = Class_Package.eINSTANCE;
    public EPackage DB = Relational_Package.eINSTANCE;

    // transformation
    CD2DB() {
		// setup
        YAMTLGroovyExtensions_dynamicEMF.init(this)

		// transformation
        header().in('cd', CD).out('db', DB)

		ruleStore([
			rule('ClassToTable')
				// model_navigation
				.in('c', CD.Class)
				// transformation
				.out('t', DB.Table, {
					t.name = c.name
					t.col.add(key)
					t.key.add(key)
					// model_navigation
					def list = c.attr.findAll{ !it.multiValued }
					// transformation
					t.col.addAll(
						// tracing
						fetch(list, 'col')
					)
				})
				// transformation
				.out('key', DB.Column, {
					key.name = 'objectId'
					key.type = 
						// tracing
						fetch(objectIdType)
				}),
			// transformation
			rule('DataType2Type')
				// model_navigation
				.in('dt', CD.DataType)
				// transformation
				.out('type', DB.Type, {
					type.name = dt.name
				}),
			// transformation
			rule('DataTypeAttribute2Column')
				// model_navigation
				.in('att', CD.Attribute).filter({
					att.type instanceof DataType && !att.multiValued
				})
				// transformation
				.out('col', DB.Column, {
					col.name = att.name
					col.type = 
						// tracing
						fetch(att.type)
				}),
			// transformation
			rule('MultiValuedDataTypeAttribute2Column')
				// model_navigation
				.in('att', CD.Attribute).filter({
					att.type instanceof DataType && att.multiValued
				})
				// transformation
				.out('t', DB.Table, {
					if (att.owner != null && att.owner.name != null)
						t.name = "${att.owner.name}_${att.name}"
					t.col.add(id)
					t.col.add(col)
				})
				.out('id', DB.Column, {
					if (att.owner != null && att.owner.name != null)
						id.name = "${att.owner.name.toLowerCase()}Id"
					id.type = 
						// tracing
						fetch(objectIdType)
				})
				.out('col', DB.Column, {
					col.name = att.name
					col.type = 
						// tracing
						fetch(att.type)
				}),
			// transformation
			rule('ClassAttribute2Column')
				// model_navigation
				.in('att', CD.Attribute).filter({
					att.type instanceof Class && !att.multiValued
				})
				// transformation
				.out('col', DB.Column, {
					col.name = "${att.name}Id"
					col.type = 
						// tracing
						fetch(objectIdType)
				}),
			// transformation
			rule('MultiValuedClassAttribute2Column')
				// model_navigation
				.in('att', CD.Attribute).filter({
					att.type instanceof Class && att.multiValued
				})
				// transformation
				.out('t', DB.Table, {
					if (att.owner != null && att.owner.name != null)
						t.name = "${att.owner.name}_${att.name}"
					t.col.add(id)
					t.col.add(col)
				})
				.out('id', DB.Column, {
					if (att.owner != null && att.owner.name != null)
						id.name = "${att.owner.name.toLowerCase()}Id"
					id.type = 
						// tracing
						fetch(objectIdType)
				})
				.out('col', DB.Column, {
					col.name = "${att.name}Id"
					col.type = 
						// tracing 
						fetch(objectIdType)
				})
		])
		// helper
        helperStore([
            staticAttribute('objectIdType', {
                allInstances(CD.DataType).find{ it instanceof DataType && it.name == 'Integer' }
            })
        ])
    }

}
