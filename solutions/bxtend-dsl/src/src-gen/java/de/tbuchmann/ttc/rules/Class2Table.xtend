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

abstract class Class2Table extends Elem2Elem {
	new(Class2Relational trafo) {
		super("Class2Table", trafo)
	}
	
	override CorrModelDelta sourceToTarget(Set<EObject> _detachedCorrElems) {
		this.createdElems = new ArrayList<EObject>()
		this.spareElems = new ArrayList<EObject>()
		this.detachedCorrElems = _detachedCorrElems
				
		val _matches = new ArrayList<Source>()
		for (clz : sourceModel.allContents.filter(typeof(atl.research.class_.Class)).toIterable()) {
			_matches += new Source(clz)
		}
		
		for (_match : _matches) {
			val clz = _match.clz
			
			val _corr = wrap(clz).updateOrCreateCorrSrc()
			val _tblType = new CorrElemType("Table", false)
			val _trg = _corr.getOrCreateTrg(_tblType)
			val tbl = unwrap(_trg.get(0) as SingleElem) as atl.research.relational_.Table
			
			tbl.setName(clz.getName())
			
			//clz.getAttr().forEach[corr.assertRuleId("SingleAttribute2Column", "SingleClassAttribute2Column", "MultiAttribute2Table")]
			val _attSinCol = clz.getAttr()
					.filter[corr.ruleId == "SingleAttribute2Column"]
					.map[unwrap(corr.target.get(0) as SingleElem) as atl.research.relational_.Column]
					.toList()
			val _attSinCol_2 = clz.getAttr()
					.filter[corr.ruleId == "SingleClassAttribute2Column"]
					.map[unwrap(corr.target.get(0) as SingleElem) as atl.research.relational_.Column]
					.toList()
			val _attMulTbl = clz.getAttr()
					.filter[corr.ruleId == "MultiAttribute2Table"]
					.map[unwrap(corr.target.get(0) as SingleElem) as atl.research.relational_.Table]
					.toList()
			val _col = colFrom(_attSinCol, _attSinCol_2, _attMulTbl, tbl)
			tbl.getCol().clear()
			tbl.getCol().addAll(_col.col)
		}
		
		return new CorrModelDelta(this.createdElems, this.spareElems, this.detachedCorrElems)
	}
	
	override void onTrgElemCreation(EObject trgElem) {
		switch (trgElem.corrElemPosition) {
			case 0: onTblCreation(trgElem as atl.research.relational_.Table)
		}
	}
	def protected abstract void onTblCreation(atl.research.relational_.Table tbl);
	
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
			val _clzType = new CorrElemType("Class", false)
			_corr.getOrCreateSrc(_clzType)
		}
		
		return new CorrModelDelta(this.createdElems, this.spareElems, this.detachedCorrElems)
	}
	
	@Data protected static class Type4col {
		List<atl.research.relational_.Column> col
	}
	def protected abstract Type4col colFrom(List<atl.research.relational_.Column> attSinCol, List<atl.research.relational_.Column> attSinCol_2, List<atl.research.relational_.Table> attMulTbl, atl.research.relational_.Table parent);
	
	@Data protected static class Source {
		atl.research.class_.Class clz
	}
	def protected static Source source(Corr _corr) {
		_corr.assertRuleId("Class2Table")
		val clz = unwrap(_corr.source.get(0)) as atl.research.class_.Class
		return new Source(clz)
	}
	@Data protected static class Target {
		atl.research.relational_.Table tbl
	}
	def protected static Target target(Corr _corr) {
		_corr.assertRuleId("Class2Table")
		val tbl = unwrap(_corr.target.get(0)) as atl.research.relational_.Table
		return new Target(tbl)
	}
}
