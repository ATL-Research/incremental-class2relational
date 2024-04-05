package de.tbuchmann.ttc.rules;

import de.tbuchmann.ttc.corrmodel.Corr
import de.tbuchmann.ttc.corrmodel.SingleElem
import de.tbuchmann.ttc.rules.Elem2Elem
import de.tbuchmann.ttc.trafo.Class2Relational
import java.util.ArrayList
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Data

class DataType2Type extends Elem2Elem {
	new(Class2Relational trafo) {
		super("DataType2Type", trafo)
	}
	
	override CorrModelDelta sourceToTarget(Set<EObject> _detachedCorrElems) {
		this.createdElems = new ArrayList<EObject>()
		this.spareElems = new ArrayList<EObject>()
		this.detachedCorrElems = _detachedCorrElems
				
		val _matches = new ArrayList<Source>()
		for (dt : sourceModel.allContents.filter(typeof(atl.research.class_.DataType)).toIterable()) {
			_matches += new Source(dt)
		}
		
		for (_match : _matches) {
			val dt = _match.dt
			
			val _corr = wrap(dt).updateOrCreateCorrSrc()
			val _tType = new CorrElemType("Type", false)
			val _trg = _corr.getOrCreateTrg(_tType)
			val t = unwrap(_trg.get(0) as SingleElem) as atl.research.relational_.Type
			
			t.setName(dt.getName())
		}
		
		return new CorrModelDelta(this.createdElems, this.spareElems, this.detachedCorrElems)
	}
	
	override CorrModelDelta targetToSource(Set<EObject> _detachedCorrElems) {
		this.createdElems = new ArrayList<EObject>()
		this.spareElems = new ArrayList<EObject>()
		this.detachedCorrElems = _detachedCorrElems
				
		val _matches = new ArrayList<Target>()
		for (t : targetModel.allContents.filter(typeof(atl.research.relational_.Type)).toIterable()) {
			_matches += new Target(t)
		}
		
		for (_match : _matches) {
			val t = _match.t
			
			val _corr = wrap(t).updateOrCreateCorrTrg()
			val _dtType = new CorrElemType("DataType", false)
			_corr.getOrCreateSrc(_dtType)
		}
		
		return new CorrModelDelta(this.createdElems, this.spareElems, this.detachedCorrElems)
	}
	
	@Data protected static class Source {
		atl.research.class_.DataType dt
	}
	def protected static Source source(Corr _corr) {
		_corr.assertRuleId("DataType2Type")
		val dt = unwrap(_corr.source.get(0)) as atl.research.class_.DataType
		return new Source(dt)
	}
	@Data protected static class Target {
		atl.research.relational_.Type t
	}
	def protected static Target target(Corr _corr) {
		_corr.assertRuleId("DataType2Type")
		val t = unwrap(_corr.target.get(0)) as atl.research.relational_.Type
		return new Target(t)
	}
}
