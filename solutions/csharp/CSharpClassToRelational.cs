using HSRM.TTC2023.ClassToRelational.Class_;
using HSRM.TTC2023.ClassToRelational.Relational_;
using NMF.Models;
using NMF.Utilities;
using Type = HSRM.TTC2023.ClassToRelational.Relational_.Type;

namespace HSRM.TTC2023.ClassToRelational
{
    // Setup
    internal class CSharpClassToRelational
    {
        // Tracing
        private Dictionary<object, IModelElement> _trace = new();

        // Tracing
        private object? TraceOrTransform(object item)
        {
            // Tracing
            if (item == null) return null;
            // Tracing
            if (!_trace.TryGetValue(item, out var transformed))
            {
                // Tracing
                transformed = Transform((dynamic)item);
                // Tracing
                _trace.Add(item, transformed);
            }
            // Tracing
            return transformed;
        }

        // Transformation
        private Type _integerType = new Type { Name = "Integer" };

        // Transformation
        public Model Transform(Model classModel)
        {
            // Transformation
            var result = new Model();
            // Model_Navigation
            foreach (var item in classModel.RootElements)
            {
                // Transformation
                result.RootElements.Add((IModelElement)TraceOrTransform(item));
            }
            // Model_Navigation
            foreach (var tableValuedAttribute in from cl in classModel.RootElements.OfType<IClass>()
                                                 from att in cl.Attr
                                                 where att.MultiValued
                                                 select att)
            {
                // Transformation
                result.RootElements.Add(CreateAttributeTable(tableValuedAttribute));
            }
            // Transformation
            return result;
        }

        // Transformation
        private ITable Transform(IClass @class)
        {
            // Transformation
            var primaryKey = new Column
            {
                // Transformation
                Name = "objectId",
                // Transformation
                Type = _integerType
            };
            // Transformation
            var table = new Table
            {
                // Transformation
                Name = @class.Name,
                // Transformation
                Col =
                {
                    // Transformation
                    primaryKey
                }
            };
            // Model Traversal
            foreach (var attr in @class.Attr.Where(att => !att.MultiValued))
            {
                //  Transformation
                table.Col.Add((IColumn)TraceOrTransform(attr));
            }
            // Transformation
            return table;
        }

        // Transformation
        private IType Transform(IDataType dataType)
        {
            // Tracing
            if (dataType.Name == "Integer")
            {
                // Tracing
                return _integerType;
            }
            // Transformation
            var type = new Type
            {
                // Transformation
                Name = dataType.Name
            };
            // Transformation
            return type;
        }

        // Transformation
        private IColumn Transform(IAttribute attribute)
        {
            // Transformation
            var column = new Column();
            // Transformation
            if (attribute.Type is IClass)
            {
                // Transformation
                column!.Type = _integerType;
                // Transformation
                column.Name = attribute.Name + "Id";
            }
            else
            {
                // Transformation
                column!.Type = (IType)TraceOrTransform(attribute.Type)!;
                // Transformation
                column.Name = attribute.Name;
            }
            // Transformation
            return column;
        }

        // Transformation
        private ITable CreateAttributeTable(IAttribute attribute)
        {
            // Transformation
            var key = new Column { Type = _integerType };
            // Transformation
            var table = new Table
            {
                // Transformation
                Col =
                {
                    // Transformation
                    key,
                    // Transformation
                    (IColumn)TraceOrTransform(attribute)!
                }
            };

            // Transformation
            table.Name = attribute.Owner.Name + "_" + attribute.Name;
            // Transformation
            key.Name = attribute.Owner.Name.ToCamelCase() + "Id";
            // Transformation
            return table;
        }
    }
}
