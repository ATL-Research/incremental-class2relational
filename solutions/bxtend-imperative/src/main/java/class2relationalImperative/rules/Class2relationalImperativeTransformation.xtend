package class2relationalImperative.rules;

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EObject
import class2relationalImperative.correspondence.class2relationalImperative.Corr
import java.util.ArrayList
import java.util.List

import de.ubt.ai1.m2m.bidir.imperative.xtend.BXtendTransformation

public class Class2relationalImperativeTransformation implements BXtendTransformation {
	
	private Resource sourceModel
	private Resource targetModel
	private Resource corrModel
	
	private List<Elem2Elem> rules = new ArrayList<Elem2Elem>();
	
	new(URI source, URI target, URI correspondence) {
		val ResourceSet set = new ResourceSetImpl();
		sourceModel = set.getResource(source, true)
		targetModel = set.getResource(target, true)
		corrModel = set.getResource(correspondence, true)
		
		if (corrModel.contents.size == 0) {
			corrModel.contents.add(class2relationalImperative.correspondence.class2relationalImperative.Class2relationalImperativeFactory.eINSTANCE.createTransformation)	
		}

		// TODO: add your rules in the proper order to the 'rules' List	
					
	}
	
	new(Resource source, Resource target, Resource correspondence) {
		val ResourceSet set = new ResourceSetImpl();
		sourceModel = source
		targetModel = target
		corrModel = correspondence
		
		if (corrModel.contents.size == 0) {
			corrModel.contents.add(class2relationalImperative.correspondence.class2relationalImperative.Class2relationalImperativeFactory.eINSTANCE.createTransformation)	
		}
		
		// TODO: add your rules in the proper order to the 'rules' List
		rules.addAll(#[new DataType2Type(source, target, correspondence), new SingleAttribute2Column(source, target, correspondence),
			new MultiAttribute2Table(source, target, correspondence), new Class2Table(source, target, correspondence)])
	}
	
	override void sourceToTarget() {
		if (sourceModel.contents.size != 0)
		for (Elem2Elem e : rules) {
			e.sourceToTarget()
		}
		
		// handle deletions
		deleteUnreferencedTargetElements
	}
	
	override void targetToSource() {		
		if (targetModel.contents.size != 0)
		for (Elem2Elem e: rules) {
			e.targetToSource()
		}
		
		// handle deletions
		deleteUnreferencedSourceElements
	}
	
	def boolean checkCorrespondences() {
		true
	}
	
	def detectSourceDeletions() {
		corrModel.allContents.filter(typeof(Corr)).filter[ c |
			c.sourceElement == null
		]
	}
		
	def detectTargetDeletions() {
		corrModel.allContents.filter(typeof(Corr)).filter[ c |
			c.targetElement == null 
		]
	}
	
	def deleteUnreferencedTargetElements(){
		val List<EObject> deletionList = newArrayList; 
		
		detectSourceDeletions().forEach[c |
			// TODO: add handling of contained and referenced Elements here if appropriate			
			// end
			deletionList += c.targetElement
			deletionList += c
		]
		deletionList.forEach[e | EcoreUtil.delete(e, true)]
	}
	
	def deleteUnreferencedSourceElements(){
		val List<EObject> deletionList = newArrayList; 
		
		detectTargetDeletions().forEach[c |
			// TODO: add handling of contained and referenced Elements here if appropriate
			
			// end
			deletionList += c.sourceElement
			deletionList += c
		]
		deletionList.forEach[e | EcoreUtil.delete(e, true)]
	}
}