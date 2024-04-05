package de.tbuchmann.ttc.rules;

import de.tbuchmann.ttc.corrmodel.Corr
import de.tbuchmann.ttc.corrmodel.SingleElem
import de.tbuchmann.ttc.rules.Elem2Elem
import de.tbuchmann.ttc.trafo.Class2Relational
import java.util.ArrayList
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Data

abstract class SingleClassAttribute2Column extends Elem2Elem {
	new(Class2Relational trafo) {
		super("SingleClassAttribute2Column", trafo)
	}
	
	override CorrModelDelta sourceToTarget(Set<EObject> _detachedCorrElems) {
		this.createdElems = new ArrayList<EObject>()
		this.spareElems = new ArrayList<EObject>()
		this.detachedCorrElems = _detachedCorrElems
				
		val _matches = new ArrayList<Source>()
		for (att : sourceModel.allContents.filter(typeof(atl.research.class_.Attribute)).filter[filterAtt(it)].toIterable()) {
			_matches += new Source(att)
		}
		
		for (_match : _matches) {
			val att = _match.att
			
			val _corr = wrap(att).updateOrCreateCorrSrc()
			val _colType = new CorrElemType("Column", false)
			val _trg = _corr.getOrCreateTrg(_colType)
			val col = unwrap(_trg.get(0) as SingleElem) as atl.research.relational_.Column
			
			val _colName = colNameFrom(att.getName(), att.getType())
			col.setName(_colName.colName)
			
			val _colType_2 = colTypeFrom(att.getName(), att.getType())
			col.setType(_colType_2.colType)
		}
		
		return new CorrModelDelta(this.createdElems, this.spareElems, this.detachedCorrElems)
	}
	
	override CorrModelDelta targetToSource(Set<EObject> _detachedCorrElems) {
		this.createdElems = new ArrayList<EObject>()
		this.spareElems = new ArrayList<EObject>()
		this.detachedCorrElems = _detachedCorrElems
				
		val _matches = new ArrayList<Target>()
		for (col : targetModel.allContents.filter(typeof(atl.research.relational_.Column)).toIterable()) {
			_matches += new Target(col)
		}
		
		for (_match : _matches) {
			val col = _match.col
			
			val _corr = wrap(col).updateOrCreateCorrTrg()
			val _attType = new CorrElemType("Attribute", false)
			_corr.getOrCreateSrc(_attType)
		}
		
		return new CorrModelDelta(this.createdElems, this.spareElems, this.detachedCorrElems)
	}
	
	def protected abstract boolean filterAtt(atl.research.class_.Attribute att);
	
	@Data protected static class Type4colName {
		String colName
	}
	def protected abstract Type4colName colNameFrom(String attName, atl.research.class_.Classifier attType);
	
	@Data protected static class Type4colType {
		atl.research.relational_.Type colType
	}
	def protected abstract Type4colType colTypeFrom(String attName, atl.research.class_.Classifier attType);
	
	@Data protected static class Source {
		atl.research.class_.Attribute att
	}
	def protected static Source source(Corr _corr) {
		_corr.assertRuleId("SingleClassAttribute2Column")
		val att = unwrap(_corr.source.get(0)) as atl.research.class_.Attribute
		return new Source(att)
	}
	@Data protected static class Target {
		atl.research.relational_.Column col
	}
	def protected static Target target(Corr _corr) {
		_corr.assertRuleId("SingleClassAttribute2Column")
		val col = unwrap(_corr.target.get(0)) as atl.research.relational_.Column
		return new Target(col)
	}
}
