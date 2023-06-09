using HSRM.TTC2023.ClassToRelational.Class_;
using HSRM.TTC2023.ClassToRelational.Relational_;
using NMF.Models;
using NMF.Synchronizations;
using NMF.Expressions.Linq;
using Type = HSRM.TTC2023.ClassToRelational.Relational_.Type;
using NMF.Utilities;
using NMF.Expressions;

namespace HSRM.TTC2023.ClassToRelational
{
    public class ClassToRelational : ReflectiveSynchronization
    {
        public class MainRule : SynchronizationRule<Model, Model>
        {
            protected override Model CreateRightOutput(Model input, IEnumerable<Model> candidates, ISynchronizationContext context, out bool existing)
            {
                var integerType = new Type { Name = "Integer" };
                context.Data["Integer"] = integerType;
                var model = base.CreateRightOutput(input, candidates, context, out existing);
                model.RootElements.Add(integerType);
                return model;
            }

            public override void DeclareSynchronization()
            {
                SynchronizeManyLeftToRightOnly(SyncRule<DataTypeToType>(), m => m.RootElements.OfType<IDataType>(), rels => rels.RootElements.OfType<IModelElement, IType>());
                SynchronizeManyLeftToRightOnly(SyncRule<ClassToTable>(), m => m.RootElements.OfType<IClass>(), rels => rels.RootElements.OfType<IModelElement, ITable>());
                SynchronizeManyLeftToRightOnly(SyncRule<AttributeToTable>(),
                    m => from c in m.RootElements.OfType<IClass>()
                         from a in c.Attr
                         where a.MultiValued
                         select a, 
                    rels => rels.RootElements.OfType<IModelElement, ITable>());
            }
        }

        public class ClassToTable : SynchronizationRule<IClass, ITable>
        {
            protected override ITable CreateRightOutput(IClass input, IEnumerable<ITable> candidates, ISynchronizationContext context, out bool existing)
            {
                existing = false;
                var primaryKey = new Column
                {
                    Name = "objectId",
                    Type = (IType)context.Data["Integer"]
                };
                return new Table
                {
                    Col = { primaryKey },
                    Key = { primaryKey }
                };
            }

            public override void DeclareSynchronization()
            {
                Synchronize(c => c.Name, t => t.Name);
                SynchronizeMany(SyncRule<AttributeToColumn>(), c => c.Attr.Where(a => !a.MultiValued), t => t.Col);
            }
        }

        public class DataTypeToType : SynchronizationRule<IDataType, IType>
        {
            public override void DeclareSynchronization()
            {
                Synchronize(dt => dt.Name, t => t.Name);
            }

            protected override IType CreateRightOutput(IDataType input, IEnumerable<IType> candidates, ISynchronizationContext context, out bool existing)
            {
                existing = false;
                if (input.Name == "Integer")
                {
                    return (IType)context.Data["Integer"];
                }
                return new Type();
            }
        }

        public class AttributeToColumn : SynchronizationRule<IAttribute, IColumn>
        {
            public override void DeclareSynchronization()
            {
                SynchronizeLeftToRightOnly(a => a.Type is IDataType ? a.Name : a.Name + "Id", c => c.Name);
                Synchronize(SyncRule<DataTypeToType>(),
                    a => (IDataType)a.Type,
                    c => c.Type,
                    (a, c) => a.Type is IDataType);
            }

            protected override IColumn CreateRightOutput(IAttribute input, IEnumerable<IColumn> candidates, ISynchronizationContext context, out bool existing)
            {
                existing = false;
                var column = new Column();
                if (input.Type is IClass)
                {
                    column.Type = (IType)context.Data["Integer"];
                }
                return column;
            }
        }

        public class AttributeToTable : SynchronizationRule<IAttribute, ITable>
        {
            protected override ITable CreateRightOutput(IAttribute input, IEnumerable<ITable> candidates, ISynchronizationContext context, out bool existing)
            {
                existing = false;
                return new Table
                {
                    Col = { new Column { Type = (IType)context.Data["Integer"] } }
                };
            }

            public override void DeclareSynchronization()
            {
                SynchronizeLeftToRightOnly(a => a.Owner.Name + "_" + a.Name, t => t.Name);
                SynchronizeLeftToRightOnly(a => a.Owner.Name.ToCamelCase() + "Id", t => t.Col[0].Name);
                SynchronizeLeftToRightOnly(SyncRule<AttributeToColumn>(),
                    a => a,
                    t => t.Col.FirstOrDefault(col => IsNotTheFirst(col)));
            }

            private static bool IsNotTheFirst(IColumn column)
            {
                return column?.Owner.Col.IndexOf(column) != 0;
            }
        }
    }
}
