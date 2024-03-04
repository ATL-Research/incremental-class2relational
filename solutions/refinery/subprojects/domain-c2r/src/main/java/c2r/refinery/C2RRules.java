package c2r.refinery;

import c2r.refinery.rules.PrintActionLiteral;
import c2r.refinery.terms.StringTerm;
import c2r.refinery.terms.StringToFirstLowerTerm;
import tools.refinery.store.dse.modification.DanglingEdges;
import tools.refinery.store.dse.transition.Rule;
import tools.refinery.store.dse.transition.actions.ActionLiteral;
import tools.refinery.store.query.dnf.FunctionalQuery;
import tools.refinery.store.query.dnf.Query;
import tools.refinery.store.query.dnf.RelationalQuery;
import tools.refinery.store.query.term.*;
import tools.refinery.store.query.term.int_.IntTerms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static c2r.refinery.ClassDomain.*;
import static c2r.refinery.RelationalDomain.*;
import static c2r.refinery.Trace2Domain.*;
import static c2r.refinery.terms.StringTerms.*;
import static c2r.refinery.terms.StringTerms.constant;
import static tools.refinery.store.dse.modification.DanglingEdges.DELETE;
import static tools.refinery.store.dse.modification.actions.ModificationActionLiterals.create;
import static tools.refinery.store.dse.modification.actions.ModificationActionLiterals.delete;
import static tools.refinery.store.dse.transition.actions.ActionLiterals.put;
import static tools.refinery.store.query.literal.CallPolarity.NEGATIVE;
import static tools.refinery.store.query.literal.Literals.check;

public class C2RRules extends C2RRefineryMain{
	public static final FunctionalQuery<String> postfix = Query.of("postfix", String.class,
			(builder, att, postfix) -> builder
					.clause((type) -> List.of(
									class_typeView.call(att,type),
									class_ClassView.call(type),
									postfix.assign(constant("Id"))
							)

					)
					.clause((type) -> List.of(
									class_typeView.call(att,type),
									class_DataTypeView.call(type),
									postfix.assign(constant(""))
							)

					)
	);
	public static final RelationalQuery needInteger = Query.of("needInt", builder -> builder
			.clause((type) ->{
				var name = Variable.of("name", String.class);
				return List.of(
						class_DataTypeView.call(type),
						class_nameView.call(type,name),
						check(eq(name, constant("Integer")))
				);
			})
			.clause(
					class_ClassView.call(ignore())
			)
	);
	public static final RelationalQuery hasInteger = Query.of("hasInt", (builder, p1) -> builder
			.clause(() ->{
				var name = Variable.of("name", String.class);
				return List.of(
						relational_TypeView.call(p1),
						relational_nameView.call(p1,name),
						check(eq(name, constant( "Integer")))
				);
			})
	);

	public static final Rule addInt = Rule.of("addInt", builder -> builder
			.clause(
					needInteger.call(),
					hasInteger.call(NEGATIVE, ignore())
			)
			.action((trg) -> List.of(
					new PrintActionLiteral("Add integer action called."),
					create(trg),
					put(relational_Type,true,trg),
					put(relational_name,"Integer",trg)
			))
	);

	public static final Rule removeInt = Rule.of("removeInt", (builder, p1) -> builder
					.clause(
							needInteger.call(NEGATIVE),
							hasInteger.call(p1)
					)
					.action(
							new PrintActionLiteral("Remove integer action called."),
							delete(p1, DELETE)
					)
	);

	public static final RelationalQuery needDataType = Query.of("needDataType", (build, src) -> build
			.clause(() -> {
				var name = Variable.of("name", String.class);
				return List.of(
						class_DataTypeView.call(src),
						class_nameView.call(src,name),
						check(notEq(name, constant("Integer")))
				);
			})
	);

	public static final RelationalQuery hasDataType = Query.of("hasDataType", (build, src, trg) -> build
			.clause(
					class_DataTypeView.call(src),
					traceKeyView.call(src,trg),
					relational_TypeView.call(trg)
			)
	);
	public static final Rule addType = Rule.of("addType", (builder, src) -> builder
			.clause(
					needDataType.call(src),
					hasDataType.call(NEGATIVE,src, ignore())
			)
			.action(() -> {
				var trg = Variable.of();
				return List.of(
						new PrintActionLiteral("Add type action called."),
						create(trg),
						put(relational_Type, true, trg),
						put(Trace2Domain.trace_trace,0,src,trg)
				);
			})
	);
	public static final Rule removeType = Rule.of("removeType", (builder, src,trg) -> builder
			.clause(
					needDataType.call(NEGATIVE,src),
					hasDataType.call(src,trg),
					traceKeyView.call(src,trg)
			)
			.action(
					new PrintActionLiteral("Remove type action called."),
					delete(trg, DELETE)
			)
	);

	public static final RelationalQuery needClass = Query.of("needClass", (builder, src) -> builder
			.clause(
					class_ClassView.call(src)
			)
	);
	public static final RelationalQuery hasClass = Query.of("hasClass", (builder, src, tbl, id) -> builder
			.clause(
					class_ClassView.call(src),
					traceKeyView.call(src,tbl),
					traceKeyView.call(src,id),
					relational_TableView.call(tbl),
					relational_ColumnView.call(id)
			)
	);
	public static final Rule addClass = Rule.of("addClass", (builder, src, itype) -> builder
			.clause(() -> {
				var name = Variable.of("name",String.class);
				return List.of(
						needClass.call(src),
						hasClass.call(NEGATIVE,src,ignore(),ignore()),
						relational_TypeView.call(itype),
						relational_nameView.call(itype, name),
						check(eq(name,constant("Integer")))
				);
			})
			.action(() -> {
				var tbl = Variable.of();
				var id = Variable.of();
				return List.of(
						new PrintActionLiteral("Add class action called."),
						create(tbl),
						create(id),
						put(relational_Table,true,tbl),
						put(relational_Column,true,id),
						put(relational_col,true,tbl,id),
						put(relational_key,true,tbl,id),
						put(relational_type, true, id, itype),
						put(trace_trace,0,src,tbl),
						put(trace_trace,1,src,id)
				);
			})
	);
	public static final Rule removeClass = Rule.of("removeClass", (builder, src, tbl, id) -> builder
			.clause(
					needClass.call(NEGATIVE,src),
					hasClass.call(src, tbl,id)
			)
			.action(
					new PrintActionLiteral("Remove class action called."),
					delete(tbl, DELETE),
					delete(id, DELETE)
			)
	);

	public static final RelationalQuery needAttribute2Table = Query.of("needAttribute2Table",
			(builder,src) -> builder
					.clause(
							class_AttributeView.call(src),
							class_multivaluedView.call(src),
							class_attView.call(Variable.of(),src),
							class_typeView.call(src,Variable.of())
					)
	);
	public static final RelationalQuery hasAttribute2Table = Query.of("hasAttribute2Table", (builder, src, tbl, c1,
																							  c2) -> builder
			.clause(
					//FIXME Multiple match (c1, c2 is interchangeable)
					class_AttributeView.call(src),
					traceKeyView.call(src,tbl),
					relational_TableView.call(tbl),
					traceKeyView.call(src,c1),
					relational_ColumnView.call(c1),
					traceKeyView.call(src,c2),
					relational_ColumnView.call(c2),
					c1.notEquivalent(c2)
			)
	);
	public static final Rule addAttribute2Table = Rule.of("addAttribute2Table", (builder, src) -> builder
			.clause(
					needAttribute2Table.call(src),
					hasAttribute2Table.call(NEGATIVE,src,Variable.of(),Variable.of(),Variable.of())
			)
			.action(() -> {
				var tbl = Variable.of();
				var c1 = Variable.of();
				var c2 = Variable.of();
				return List.of(
						new PrintActionLiteral("Add attribute to table action called."),
						create(tbl),
						create(c1),
						create(c2),
						put(relational_Table,true,tbl),
						put(relational_Column, true, c1),
						put(relational_Column,true, c2),
						put(relational_col,true,tbl,c1),
						put(relational_col,true,tbl,c2),
						put(trace_trace,0,src,tbl),
						put(trace_trace,1,src,c1),
						put(trace_trace,2,src,c2)

				);
			})
	);
	public static final Rule removeAttribute2Table = Rule.of("removeAttribute2Table",
			(builder, src,tbl,c1,c2) -> builder
					.clause(
							needAttribute2Table.call(NEGATIVE,src),
							hasAttribute2Table.call(src,tbl,c1,c2)
					)
					.action(
							new PrintActionLiteral("Remove attribute to table action called."),
							delete(tbl, DELETE),
							delete(c1, DELETE),
							delete(c2, DELETE)
					)
	);

	public static final RelationalQuery needAttribute2Column = Query.of("needAttribute2Column",
			(builder,src) -> builder
					.clause(
							class_AttributeView.call(src),
							class_multivaluedView.call(NEGATIVE,src),
							class_attView.call(Variable.of(),src),
							class_typeView.call(src,Variable.of())
					)
	);
	public static final RelationalQuery hasAttribute2Column = Query.of("hasAttribute2Column",
			(builder, src, col) -> builder
					.clause(()-> {
						var idx = Variable.of("idx", Integer.class);
						return List.of(
								traceFunctionView.call(src,col,idx),
								relational_ColumnView.call(col),
								check(IntTerms.eq(idx, IntTerms.constant(0)))
						);
					})
	);
	public static final Rule addAttribute2Column = Rule.of("addAttribute2Column", (builder, src,tbl) -> builder
			.clause((cls) -> List.of(
					needAttribute2Column.call(src),
					hasAttribute2Column.call(NEGATIVE,src,Variable.of()),
					class_attView.call(cls,src),
					traceKeyView.call(cls,tbl),
					relational_TableView.call(tbl)
			))
			.action(() -> {
				var col = Variable.of();
				return List.of(
						new PrintActionLiteral("Add attribute to column action called."),
						create(col),
						put(relational_Column, true, col),
						put(relational_col,true,tbl,col),
						put(trace_trace,0,src,col)
				);
			})
	);
	public static final Rule removeAttribute2Column = Rule.of("removeAttribute2Column",
			(builder, src,col) -> builder
					.clause(
							needAttribute2Column.call(NEGATIVE,src),
							hasAttribute2Column.call(src,col)
					)
					.action(
							new PrintActionLiteral("Remove attribute to column action called."),
							delete(col, DELETE)
					)
	);

	public static final FunctionalQuery nameQuery = Query.of("nameQuery", String.class,
			(builder, trg, name) -> builder
					.clause((src) -> List.of(//DataType -> Type
							relational_TypeView.call(trg),
							traceKeyView.call(src,trg),
							class_nameView.call(src,name)
					))
					.clause((src) -> List.of(//Class -> Table (Table name)
							relational_TableView.call(trg),
							traceKeyView.call(src,trg),
							class_ClassView.call(src),
							class_nameView.call(src,name)
					))
					.clause((src) -> List.of(//Class -> Table (ID column name)
							relational_ColumnView.call(trg),
							traceKeyView.call(src,trg),
							class_ClassView.call(src),
							name.assign(constant("objectId"))
					))
					.clause((src,cls) -> {//Attribute -> Table (Table name)
						var classname = Variable.of("classname", String.class);
						var attname = Variable.of("attname", String.class);
						return List.of(
								relational_TableView.call(trg),
								traceKeyView.call(src,trg),
								class_AttributeView.call(src),
								class_attView.call(cls,src),
								class_nameView.call(cls, classname),
								class_nameView.call(src, attname),
								name.assign(format("%s_%s",classname,attname))
						);
					})
					.clause((src,cls) -> {//Attribute -> Table (Host column name)
						var classname = Variable.of("classname", String.class);
						var idx = Variable.of("idx", Integer.class);
						return List.of(//Attribute -> Table (Table name)
								relational_ColumnView.call(trg),
								traceFunctionView.call(src,trg,idx),

								check(IntTerms.eq(idx, IntTerms.constant(1))),

								class_AttributeView.call(src),
								class_attView.call(cls,src),
								class_nameView.call(cls, classname),
								name.assign(toFirstLower(format("%sId",classname)))//
						);
					})
					.clause((src) -> {//Attribute -> Table (Target column name)
						var attname = Variable.of("classname", String.class);
						var idx = Variable.of("idx", Integer.class);
						var end = Variable.of("end", String.class);
						return List.of(//Attribute -> Table (Table name)
								relational_ColumnView.call(trg),
								traceFunctionView.call(src,trg,idx),

								check(IntTerms.eq(idx, IntTerms.constant(2))),

								class_AttributeView.call(src),
								class_nameView.call(src, attname),
								postfix.call(src).toLiteral(end),
								name.assign(toFirstLower(format("%s%s",attname,end)))
						);
					})
					.clause((src) -> {//Attribute -> Column
						var attname = Variable.of("classname", String.class);
						var end = Variable.of("end", String.class);
						return List.of(//Attribute -> Table (Table name)
								relational_ColumnView.call(trg),
								traceKeyView.call(src,trg),
								class_AttributeView.call(src),
								class_multivaluedView.call(NEGATIVE,src),
								class_nameView.call(src, attname),
								postfix.call(src).toLiteral(end),
								name.assign(format("%s%s",attname,end))
						);
					})
	);
	public static final RelationalQuery specifiedType = Query.of("specifiedType", (builder, col,type) -> builder
			.clause((att, stype) -> { // Typing for non-id columns
				var sname = Variable.of("sname", String.class);
				var idx = Variable.of("ixd", Integer.class);
				return List.of(
						traceFunctionView.call(att,col,idx),
						relational_ColumnView.call(col),
						class_AttributeView.call(att),
						check(IntTerms.notEq(idx, IntTerms.constant(1))),

						class_typeView.call(att,stype),
						class_nameView.call(stype,sname),

						relational_TypeView.call(type),
						relational_nameView.call(type,sname)//,
				);
			})

	);
	public static final RelationalQuery typeMapping = Query.of("expectedType",
			(builder, trg, type) -> builder
					.clause(specifiedType.call(trg,type))
					.clause(() -> {// Default type is Integer
						var name = Variable.of("name",String.class);
						return List.of(
								relational_ColumnView.call(trg),
								specifiedType.call(NEGATIVE,trg,ignore()),
								relational_TypeView.call(type),
								relational_nameView.call(type,name),
								check(eq(name, constant("Integer")))
						);
					})
	);
	public static final Rule setType = Rule.of("setType",
			(builder, trg,type) -> builder
					.clause(
							typeMapping.call(trg,type),
							relational_typeView.call(NEGATIVE,trg,type)
					)
					.action(
							new PrintActionLiteral("Set type action called."),
							put(relational_type,true,trg,type)
					)
	);
	public static final Rule unsetType = Rule.of("unsetType",
			(builder, trg,type) -> builder
					.clause((newtype) -> List.of(
							relational_typeView.call(trg,type),
							typeMapping.call(trg,newtype),
							type.notEquivalent(newtype)
					))
					.clause(
							relational_typeView.call(trg,type),
							typeMapping.call(NEGATIVE,trg,ignore()))
					.action(
							new PrintActionLiteral("Unset type action called.", trg, type),
							put(relational_type,false,trg,type)
					)
	);
	public static final Rule clean = Rule.of("cleanRule", (builder, obj) -> builder
			.clause(
					relational_ColumnView.call(obj),
					traceKeyView.call(NEGATIVE,ignore(),obj)
			)
			.clause(
					relational_TableView.call(obj),
					traceKeyView.call(NEGATIVE,ignore(),obj)
			)
			.action(
					new PrintActionLiteral("Clean rule called."),
					delete(obj,DELETE)
			)
	);
	public static NodeVariable ignore(){
		return NodeVariable.of();
	}
}
