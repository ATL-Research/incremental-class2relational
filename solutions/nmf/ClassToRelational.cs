using HSRM.TTC2023.ClassToRelational.Class_;
using HSRM.TTC2023.ClassToRelational.Relational_;
using NMF.Models;
using NMF.Synchronizations;
using NMF.Expressions.Linq;
using Type = HSRM.TTC2023.ClassToRelational.Relational_.Type;
using NMF.Utilities;

namespace HSRM.TTC2023.ClassToRelational
{
    // Transformation
    public class ClassToRelational : ReflectiveSynchronization
    {
        // Transformation
        public class MainRule : SynchronizationRule<Model, Model>
        {
            // Transformation
            protected override Model CreateRightOutput(Model input, IEnumerable<Model> candidates, ISynchronizationContext context, out bool existing)
            {
                // Tracing
                var integerType = new Type { Name = "Integer" };
                context.Data["Integer"] = integerType;
                var model = base.CreateRightOutput(input, candidates, context, out existing);
                model.RootElements.Add(integerType);
                return model;
            }

            // Transformation
            public override void DeclareSynchronization()
            {
                // Transformation 3
                // Model_Navigation 11
                SynchronizeManyLeftToRightOnly(SyncRule<DataTypeToType>(), m => m.RootElements.OfType<IDataType>(), rels => rels.RootElements.OfType<IModelElement, IType>());
                // Transformation 3
                // Model_Navigation 11
                SynchronizeManyLeftToRightOnly(SyncRule<ClassToTable>(), m => m.RootElements.OfType<IClass>(), rels => rels.RootElements.OfType<IModelElement, ITable>());
                // Transformation
                SynchronizeManyLeftToRightOnly(SyncRule<AttributeToTable>(),
                // Model_Navigation
                    m => from c in m.RootElements.OfType<IClass>()
                         from a in c.Attr
                         where a.MultiValued
                         select a, 
                    // Tranformation
                    rels => rels.RootElements.OfType<IModelElement, ITable>());
            }
        }

        // Transformation
        public class ClassToTable : SynchronizationRule<IClass, ITable>
        {
            // Transformation
            protected override ITable CreateRightOutput(IClass input, IEnumerable<ITable> candidates, ISynchronizationContext context, out bool existing)
            {
                // Transformation
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

            // Transformation
            public override void DeclareSynchronization()
            {
                // Transformation
                Synchronize(c => c.Name, t => t.Name);
                // Transformation
                SynchronizeMany(SyncRule<AttributeToColumn>(), c => c.Attr.Where(a => !a.MultiValued), t => t.Col);
            }
        }

        // Transformation
        public class DataTypeToType : SynchronizationRule<IDataType, IType>
        {
            // Transformation
            public override void DeclareSynchronization()
            {
                // Transformation
                Synchronize(dt => dt.Name, t => t.Name);
            }

            // Transformation
            protected override IType CreateRightOutput(IDataType input, IEnumerable<IType> candidates, ISynchronizationContext context, out bool existing)
            {
                // Transformation
                existing = false;
                if (input.Name == "Integer")
                {
                    return (IType)context.Data["Integer"];
                }
                return new Type();
            }
        }

        // Transformation
        public class AttributeToColumn : SynchronizationRule<IAttribute, IColumn>
        {
            // Transformation
            public override void DeclareSynchronization()
            {
                // Transformation
                SynchronizeLeftToRightOnly(a => a.Type is IDataType ? a.Name : a.Name + "Id", c => c.Name);
                // Transformation
                Synchronize(SyncRule<DataTypeToType>(),
                    a => (IDataType)a.Type,
                    c => c.Type,
                    (a, c) => a.Type is IDataType);
            }

            // Transformation 14
            protected override IColumn CreateRightOutput(IAttribute input, IEnumerable<IColumn> candidates, ISynchronizationContext context, out bool existing)
            {
                // Transformation
                existing = false;
                var column = new Column();
                if (input.Type is IClass)
                {
                    column.Type = (IType)context.Data["Integer"];
                }
                return column;
            }
        }

        // Transformation
        public class AttributeToTable : SynchronizationRule<IAttribute, ITable>
        {
            // Transformation
            protected override ITable CreateRightOutput(IAttribute input, IEnumerable<ITable> candidates, ISynchronizationContext context, out bool existing)
            {
                // Transformation
                existing = false;
                return new Table
                {
                    Col = { new Column { Type = (IType)context.Data["Integer"] } }
                };
            }

            // Transformation
            public override void DeclareSynchronization()
            {
                // Transformation
                SynchronizeLeftToRightOnly(a => a.Owner.Name + "_" + a.Name, t => t.Name);
                // Transformation
                SynchronizeLeftToRightOnly(a => a.Owner.Name.ToCamelCase() + "Id", t => t.Col[0].Name);
                // Transformation
                SynchronizeLeftToRightOnly(SyncRule<AttributeToColumn>(),
                    a => a,
                    t => t.Col.FirstOrDefault(col => IsNotTheFirst(col)));
            }

            // Helper
            private static bool IsNotTheFirst(IColumn column)
            {
                //  Helper
                return column?.Owner.Col.IndexOf(column) != 0;
            }
        }
    }
}
