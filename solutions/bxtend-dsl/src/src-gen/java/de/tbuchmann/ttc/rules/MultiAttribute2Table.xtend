package de.tbuchmann.ttc.rules;

import de.tbuchmann.ttc.corrmodel.Corr
import de.tbuchmann.ttc.corrmodel.SingleElem
import de.tbuchmann.ttc.rules.Elem2Elem
import de.tbuchmann.ttc.trafo.Class2Relational
import java.util.ArrayList
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Data

abstract class MultiAttribute2Table extends Elem2Elem {
	new(Class2Relational trafo) {
		super("MultiAttribute2Table", trafo)
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
			val _tblType = new CorrElemType("Table", false)
			val _trg = _corr.getOrCreateTrg(_tblType)
			val tbl = unwrap(_trg.get(0) as SingleElem) as atl.research.relational_.Table
			
			val _tblName = tblNameFrom(att.getName(), att.getOwner())
			tbl.setName(_tblName.tblName)
			
			val _col = colFrom(att.getName(), att.getType(), att.getOwner())
			tbl.getCol().clear()
			tbl.getCol().addAll(_col.col)
		}
		
		return new CorrModelDelta(this.createdElems, this.spareElems, this.detachedCorrElems)
	}
	
	override CorrModelDelta targetToSource(Set<EObject> _detachedCorrElems) {
		this.createdElems = new ArrayList<EObject>()
		this.spareElems = new ArrayList<EObject>()
		this.detachedCorrElems = _detachedCorrElems
				
		val _matches = new ArrayList<Target>()
		for (tbl : targetModel.allContents.filter(typeof(atl.research.relational_.Table)).toIterable()) {
			_matches += new Target(tbl)
		}
		
		for (_match : _matches) {
			val tbl = _match.tbl
			
			val _corr = wrap(tbl).updateOrCreateCorrTrg()
			val _attType = new CorrElemType("Attribute", false)
			_corr.getOrCreateSrc(_attType)
		}
		
		return new CorrModelDelta(this.createdElems, this.spareElems, this.detachedCorrElems)
	}
	
	def protected abstract boolean filterAtt(atl.research.class_.Attribute att);
	
	@Data protected static class Type4tblName {
		String tblName
	}
	def protected abstract Type4tblName tblNameFrom(String attName, atl.research.class_.Class owner);
	
	@Data protected static class Type4col {
		List<atl.research.relational_.Column> col
	}
	def protected abstract Type4col colFrom(String attName, atl.research.class_.Classifier type, atl.research.class_.Class owner);
	
	@Data protected static class Source {
		atl.research.class_.Attribute att
	}
	def protected static Source source(Corr _corr) {
		_corr.assertRuleId("MultiAttribute2Table")
		val att = unwrap(_corr.source.get(0)) as atl.research.class_.Attribute
		return new Source(att)
	}
	@Data protected static class Target {
		atl.research.relational_.Table tbl
	}
	def protected static Target target(Corr _corr) {
		_corr.assertRuleId("MultiAttribute2Table")
		val tbl = unwrap(_corr.target.get(0)) as atl.research.relational_.Table
		return new Target(tbl)
	}
}
