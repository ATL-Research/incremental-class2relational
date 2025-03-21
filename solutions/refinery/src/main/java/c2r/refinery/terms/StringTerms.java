package c2r.refinery.terms;

import tools.refinery.logic.term.ConstantTerm;
import tools.refinery.logic.term.DataVariable;
import tools.refinery.logic.term.Term;
import tools.refinery.logic.term.comparable.EqTerm;
import tools.refinery.logic.term.comparable.NotEqTerm;

public class StringTerms {
	public static Term<String> constant(String value){ return new ConstantTerm<>(String.class, value);}

	public static Term<Boolean> eq(Term<String> left, Term<String> right){
		return new EqTerm<>(String.class,left,right);
	}
	public static Term<Boolean> notEq(Term<String> left, Term<String> right){
		return new NotEqTerm<>(String.class, left, right);
	}
	public static Term<String> toFirstLower(Term<String> arg){ return new StringToFirstLowerTerm(arg);}
	public static Term<String> format(String template, DataVariable<?>... data){
		return new StringTerm(template,data);
	}
}
