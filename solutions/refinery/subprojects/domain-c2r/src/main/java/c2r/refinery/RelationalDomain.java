package c2r.refinery;

import atl.research.relational_.Relational_Factory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import tools.refinery.store.model.Interpretation;
import tools.refinery.store.model.Model;
import tools.refinery.store.model.ModelStoreBuilder;
import tools.refinery.store.query.dnf.Query;
import tools.refinery.store.query.resultset.ResultSetListener;
import tools.refinery.store.query.view.AnySymbolView;
import tools.refinery.store.query.view.FunctionView;
import tools.refinery.store.query.view.KeyOnlyView;
import tools.refinery.store.representation.Symbol;
import tools.refinery.store.tuple.Tuple;

import java.util.*;

public class RelationalDomain {
	public static final Symbol<Boolean> relational_Named;
	public static final AnySymbolView relational_NamedView;
	public final Interpretation<Boolean> Named;
	public static final Symbol<String> relational_name;
	public static final FunctionView<String> relational_nameView;
	public final Interpretation<String> name;
	public static final Symbol<Boolean> relational_Table;
	public static final AnySymbolView relational_TableView;
	public final Interpretation<Boolean> Table;
	public static final Symbol<Boolean> relational_Column;
	public static final AnySymbolView relational_ColumnView;
	public final Interpretation<Boolean> Column;
	public static final Symbol<Boolean> relational_Type;
	public static final AnySymbolView relational_TypeView;
	public final Interpretation<Boolean> Type;
	public static final Symbol<Boolean> relational_col;
	public static final AnySymbolView relational_colView;
	public final Interpretation<Boolean> col;
	public static final Symbol<Boolean> relational_key;
	public static final AnySymbolView relational_keyView;
	public final Interpretation<Boolean> key;
	public static final Symbol<Boolean> relational_type;
	public static final AnySymbolView relational_typeView;
	public final Interpretation<Boolean> type;
	static {
		relational_Named = Symbol.of("relational.Named",1);
		relational_NamedView = new KeyOnlyView<>(relational_Named);

		 relational_name = Symbol.of("name:String@relational.Named",1, String.class,null);
		 relational_nameView =  new FunctionView<>(relational_name);

		 relational_Table = Symbol.of("relational.Table",1);
		 relational_TableView = new KeyOnlyView<>(relational_Table);

		 relational_Column = Symbol.of("relational.Column",1);
		 relational_ColumnView = new KeyOnlyView<>(relational_Column);

		 relational_Type = Symbol.of("relational.Type",1);
		 relational_TypeView = new KeyOnlyView<>(relational_Type);

		 relational_col = Symbol.of("col:Column@relational.Table",2);
		 relational_colView = new KeyOnlyView<>(relational_col);

		 relational_key = Symbol.of("key:Column@relational.Table",2);
		 relational_keyView = new KeyOnlyView<>(relational_key);

		 relational_type = Symbol.of("type:Type@relational.Column",2);
		 relational_typeView = new KeyOnlyView<>(relational_type);
	}
	public static void build(ModelStoreBuilder builder){
		builder.symbols(relational_Named, relational_name, relational_Table, relational_Column, relational_Type, relational_col, relational_key, relational_type);
	}


	public RelationalDomain(Model model){
		Named = model.getInterpretation(relational_Named);
		name = model.getInterpretation(relational_name);
		Table = model.getInterpretation(relational_Table);
		Column = model.getInterpretation(relational_Column);
		Type = model.getInterpretation(relational_Type);
		col = model.getInterpretation(relational_col);
		key = model.getInterpretation(relational_key);
		type = model.getInterpretation(relational_type);
	}

	public void toResource(Resource resource){
		var trace = new HashMap<Tuple, EObject>();
		var factory = Relational_Factory.eINSTANCE;

		var typeCursor = Type.getAll();
		while (typeCursor.move()){
			var type = factory.createType();
			var typeName = name.get(typeCursor.getKey());
			type.setName(typeName);
			trace.put(typeCursor.getKey(),type);
			resource.getContents().add(type);
		}

		var tableCursor = Table.getAll();
		while(tableCursor.move()){
			var table = factory.createTable();

			String tableName = name.get(tableCursor.getKey());
			table.setName(tableName);
			resource.getContents().add(table);

			var colCursor = col.getAll();
			while(colCursor.move()){
				if (colCursor.getKey().get(0)==tableCursor.getKey().get(0)){
					var colTuple = Tuple.of(colCursor.getKey().get(1));
					var column = factory.createColumn();

					String colName = name.get(colTuple);
					column.setName(colName);

					column.setOwner(table);
					table.getCol().add(column);

					if(key.get(colCursor.getKey())){
						column.setKeyOf(table);
						table.getKey().add(column);
					}

					var types = type.getAll();
					while(types.move()){
						var tc = types.getKey();
						if(colTuple.get(0)==tc.get(0)){
							var type = trace.get(Tuple.of(tc.get(1)));
							column.setType((atl.research.relational_.Type) type);
						}
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		var b = new StringBuilder();
		b.append("Relational Domain\n");


		var dtypes = Type.getAll();
		while(dtypes.move()){
			b.append("\tDataType").append(dtypes.getKey())
					.append(", name=\"").append(name.get(dtypes.getKey()))
					.append("\"\n");
		}

		var tables = Table.getAll();
		while(tables.move()) {
			b.append("\tTable").append(tables.getKey())
					.append(", name=\"").append(name.get(tables.getKey()))
					.append("\"\n");//TODO keys
			var colCursor = col.getAll();
			while(colCursor.move()){
				if(colCursor.getKey().get(0)==tables.getKey().get(0)){
					var colTuple = Tuple.of(colCursor.getKey().get(1));
					b.append("\t\tColumn").append(colTuple)
							.append(", name=\"").append(name.get(colTuple));
					var types = type.getAll();
					while(types.move()){
						if(types.getKey().get(0)==colTuple.get(0)){
							b.append(", type=").append(name.get(Tuple.of(types.getKey().get(1))));
						}
					}
				}
			}
		}
		return b.toString();
	}
	public ResultSetListener<String> makeNameListener(){
		return new ResultSetListener<>() {
			private final Queue<Triple<Tuple,String,String>> queue = new LinkedList<>();
			@Override
			public void put(Tuple key, String fromValue, String toValue) {
				var params = Tuples.create(key,fromValue,toValue);
				var result = execute(params);
				if(result)
					queue.removeIf(this::execute);
				else
					queue.add(params);

			}
			private boolean execute(Triple<Tuple,String,String> tuple){
				if(Objects.equals(name.get(tuple.getFirst()),tuple.getSecond())){
					name.put(tuple.getFirst(),tuple.getThird());
					return true;
				}
				return false;
			}
		};
	}
}
