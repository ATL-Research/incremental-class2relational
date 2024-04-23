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
    // Transformation 4
    public class ClassToRelational : ReflectiveSynchronization
    {
        // Transformation 6
        public class MainRule : SynchronizationRule<Model, Model>
        {
            // Transformation 14
            protected override Model CreateRightOutput(Model input, IEnumerable<Model> candidates, ISynchronizationContext context, out bool existing)
            {
                // Tracing 29
                var integerType = new Type { Name = "Integer" };
                context.Data["Integer"] = integerType;
                var model = base.CreateRightOutput(input, candidates, context, out existing);
                model.RootElements.Add(integerType);
                return model;
            }

            // Transformation 4
            public override void DeclareSynchronization()
            {
                // Transformation 3
                // Model Traversal 13
                SynchronizeManyLeftToRightOnly(SyncRule<DataTypeToType>(), m => m.RootElements.OfType<IDataType>(), rels => rels.RootElements.OfType<IModelElement, IType>());
                // Transformation 3
                // Model Traversal 13
                SynchronizeManyLeftToRightOnly(SyncRule<ClassToTable>(), m => m.RootElements.OfType<IClass>(), rels => rels.RootElements.OfType<IModelElement, ITable>());
                // Transformation 3
                SynchronizeManyLeftToRightOnly(SyncRule<AttributeToTable>(),
                // Model Traversal 19
                    m => from c in m.RootElements.OfType<IClass>()
                         from a in c.Attr
                         where a.MultiValued
                         select a, 
                    // Model Traversal 7
                    rels => rels.RootElements.OfType<IModelElement, ITable>());
            }
        }

        // Transformation 6
        public class ClassToTable : SynchronizationRule<IClass, ITable>
        {
            // Transformation 14
            protected override ITable CreateRightOutput(IClass input, IEnumerable<ITable> candidates, ISynchronizationContext context, out bool existing)
            {
                // Transformation 26
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

            // Transformation 4
            public override void DeclareSynchronization()
            {
                // Transformation 1
                // Model Traversal 8
                Synchronize(c => c.Name, t => t.Name);
                // Transformation 3
                // Model Traversal 13
                SynchronizeMany(SyncRule<AttributeToColumn>(), c => c.Attr.Where(a => !a.MultiValued), t => t.Col);
            }
        }

        // Transformation 6
        public class DataTypeToType : SynchronizationRule<IDataType, IType>
        {
            // Transformation 4
            public override void DeclareSynchronization()
            {
                // Transformation 9
                Synchronize(dt => dt.Name, t => t.Name);
            }

            // Transformation 14
            protected override IType CreateRightOutput(IDataType input, IEnumerable<IType> candidates, ISynchronizationContext context, out bool existing)
            {
                // Transformation 16
                existing = false;
                if (input.Name == "Integer")
                {
                    return (IType)context.Data["Integer"];
                }
                return new Type();
            }
        }

        // Transformation 6
        public class AttributeToColumn : SynchronizationRule<IAttribute, IColumn>
        {
            // Transformation 4
            public override void DeclareSynchronization()
            {
                // Transformation 16
                SynchronizeLeftToRightOnly(a => a.Type is IDataType ? a.Name : a.Name + "Id", c => c.Name);
                // Transformation 3
                Synchronize(SyncRule<DataTypeToType>(),
                    // Model Traversal 5
                    a => (IDataType)a.Type,
                    // Transformation 3
                    c => c.Type,
                    // Model Traversal 7
                    (a, c) => a.Type is IDataType);
            }

            // Transformation 14
            protected override IColumn CreateRightOutput(IAttribute input, IEnumerable<IColumn> candidates, ISynchronizationContext context, out bool existing)
            {
                // Transformation 22
                existing = false;
                var column = new Column();
                if (input.Type is IClass)
                {
                    column.Type = (IType)context.Data["Integer"];
                }
                return column;
            }
        }

        // Transformation 6
        public class AttributeToTable : SynchronizationRule<IAttribute, ITable>
        {
            // Transformation 14
            protected override ITable CreateRightOutput(IAttribute input, IEnumerable<ITable> candidates, ISynchronizationContext context, out bool existing)
            {
                // Transformation 16
                existing = false;
                return new Table
                {
                    Col = { new Column { Type = (IType)context.Data["Integer"] } }
                };
            }

            // Transformation 4
            public override void DeclareSynchronization()
            {
                // Transformation 13
                SynchronizeLeftToRightOnly(a => a.Owner.Name + "_" + a.Name, t => t.Name);
                // Transformation 13
                SynchronizeLeftToRightOnly(a => a.Owner.Name.ToCamelCase() + "Id", t => t.Col[0].Name);
                // Transformation 3
                SynchronizeLeftToRightOnly(SyncRule<AttributeToColumn>(),
                    // Model Traversal 3
                    a => a,
                    // Transformation 9
                    t => t.Col.FirstOrDefault(col => IsNotTheFirst(col)));
            }

            // Helper 6
            private static bool IsNotTheFirst(IColumn column)
            {
                //  Helper 7
                return column?.Owner.Col.IndexOf(column) != 0;
            }
        }
    }
}
