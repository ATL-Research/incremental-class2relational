package class2relationalImperative.rules;

import atl.research.class_.Class_Factory
import atl.research.class_.Class_Package
import class2relationalImperative.correspondence.class2relationalImperative.Class2relationalImperativeFactory
import class2relationalImperative.correspondence.class2relationalImperative.Corr
import class2relationalImperative.correspondence.class2relationalImperative.Transformation
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource

abstract class Elem2Elem {
	
	protected Resource sourceModel
	protected Resource targetModel
	protected Resource corrModel
	
	protected val sourceFactory = Class_Factory::eINSTANCE
	protected val targetFactory = atl.research.relational_.Relational_Factory::eINSTANCE
	protected val corrFactory = Class2relationalImperativeFactory::eINSTANCE
	protected val sourcePackage = Class_Package::eINSTANCE
	protected val targetPackage = atl.research.relational_.Relational_Package::eINSTANCE
	
	protected var String ruleID
	
	protected static Map<EObject, Corr> elementsToCorr = newHashMap
	
	new(Resource src, Resource trgt, Resource corr) {
		sourceModel = src
		targetModel = trgt
		corrModel = corr	
		ruleID = "base"
		(corrModel.contents.get(0) as Transformation).correspondences.forEach[c | 
			elementsToCorr.put(c.sourceElement, c)
			elementsToCorr.put(c.targetElement, c)
		]
	}
	
	def void sourceToTarget() {
	}
	
	def void targetToSource() {
	}
	
	def getCorrModelElem(EObject obj) {
		elementsToCorr.get(obj)
	}

	def getOrCreateCorrModelElement(EObject obj, String description) {
		var Corr corr = obj.getCorrModelElem
		if (corr == null) {
			corr = corrFactory.createBasicElem => [
				if (obj.eClass.EPackage instanceof Class_Package)
					sourceElement = obj
				if (obj.eClass.EPackage instanceof atl.research.relational_.Relational_Package)
					targetElement = obj
				desc = description
			]
			(corrModel.contents.get(0) as Transformation).correspondences += corr
			elementsToCorr.put(corr.sourceElement, corr)
			elementsToCorr.put(corr.targetElement, corr)
		}
		return corr
	}
		

	def createSourceElement(EClass clazz) {
		sourceFactory.create(clazz)
	}
	
	def createTargetElement(EClass clazz) {
		targetFactory.create(clazz)
	}
	
	def getOrCreateSourceElem(Corr corr, EClass clazz) {
		
		var EObject source  = corr.sourceElement
		if (corr.sourceElement == null){
			source = createSourceElement(clazz)
			corr.sourceElement = source
			elementsToCorr.put(corr.sourceElement, corr)
		}
		return source
	}

	def getOrCreateTargetElem(Corr corr, EClass clazz) {
		var EObject target = corr.targetElement 
		if (target == null) {
			target = createTargetElement(clazz)
			corr.targetElement = target
			elementsToCorr.put(corr.targetElement, corr)
		}
		return target
	}
	
	
}