using HSRM.TTC2023.ClassToRelational.Class_;
using HSRM.TTC2023.ClassToRelational.Relational_;
using NMF.Expressions;
using NMF.Models;
using NMF.Utilities;
using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Schema;
using Type = HSRM.TTC2023.ClassToRelational.Relational_.Type;

namespace HSRM.TTC2023.ClassToRelational
{
    // Setup 3
    internal class CSharpClassToRelational
    {
        // Tracing 7
        private Dictionary<object, IModelElement> _trace = new();

        // Tracing 5
        private object? TraceOrTransform(object item)
        {
            // Tracing 6
            if (item == null) return null;
            // Tracing 7
            if (!_trace.TryGetValue(item, out var transformed))
            {
                // Tracing 5
                transformed = Transform((dynamic)item);
                // Tracing 4
                _trace.Add(item, transformed);
            }
            // Tracing 2
            return transformed;
        }

        // Transformation 9
        private Type _integerType = new Type { Name = "Integer" };

        // Transformation 5
        public Model Transform(Model classModel)
        {
            // Transformation 5
            var result = new Model();
            // Model Navigation 6
            foreach (var item in classModel.RootElements)
            {
                // Transformation 6
                result.RootElements.Add((IModelElement)TraceOrTransform(item));
            }
            // Model Navigation 21
            foreach (var tableValuedAttribute in from cl in classModel.RootElements.OfType<IClass>()
                                                 from att in cl.Attr
                                                 where att.MultiValued
                                                 select att)
            {
                // Transformation 5
                result.RootElements.Add(CreateAttributeTable(tableValuedAttribute));
            }
            // Transformation 2
            return result;
        }

        // Transformation 5
        private ITable Transform(IClass @class)
        {
            // Transformation 5
            var primaryKey = new Column
            {
                // Transformation 3
                Name = "objectId",
                // Transformation 3
                Type = _integerType
            };
            //  Transformation 5
            var table = new Table
            {
                //  Transformation 4
                Name = @class.Name,
                //  Transformation 2
                Col =
                {
                    //  Transformation 1
                    primaryKey
                }
            };
            // Model Traversal 11
            foreach (var attr in @class.Attr.Where(att => !att.MultiValued))
            {
                //  Transformation 6
                table.Col.Add((IColumn)TraceOrTransform(attr));
            }
            // Transformation 2
            return table;
        }

        // Transformation 5
        private IType Transform(IDataType dataType)
        {
            // Tracing 5
            if (dataType.Name == "Integer")
            {
                // Tracing 2
                return _integerType;
            }
            // Transformation 5
            var type = new Type
            {
                // Transformation 4
                Name = dataType.Name
            };
            // Transformation 2
            return type;
        }

        // Transformation 5
        private IColumn Transform(IAttribute attribute)
        {
            // Transformation 5
            var column = new Column();
            // Transformation 5
            if (attribute.Type is IClass)
            {
                // Transformation 4
                column!.Type = _integerType;
                // Transformation 6
                column.Name = attribute.Name + "Id";
            }
            else
            {
                // Transformation 6
                column!.Type = (IType)TraceOrTransform(attribute.Type)!;
                // Transformation 5
                column.Name = attribute.Name;
            }
            // Transformation 2
            return column;
        }

        // Transformation 5
        private ITable CreateAttributeTable(IAttribute attribute)
        {
            // Transformation 8
            var key = new Column { Type = _integerType };
            // Transformation 5
            var table = new Table
            {
                // Transformation 2
                Col =
                {
                    // Transformation 1
                    key,
                    // Transformation 3
                    (IColumn)TraceOrTransform(attribute)!
                }
            };

            // Transformation 9
            table.Name = attribute.Owner.Name + "_" + attribute.Name;
            // Transformation 8
            key.Name = attribute.Owner.Name.ToCamelCase() + "Id";
            // Transformation 2
            return table;
        }
    }
}
