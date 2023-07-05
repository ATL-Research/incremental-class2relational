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
    internal class CSharpClassToRelational
    {
        // Tracing 6
        private Dictionary<object, IModelElement> _trace = new();

        // Tracing 5
        private object? TraceOrTransform(object item)
        {
            // Tracing 5
            if (item == null) return null;
            // Tracing 7
            if (!_trace.TryGetValue(item, out var transformed))
            {
                // Tracing 4
                transformed = Transform((dynamic)item);
                // Tracing 4
                _trace.Add(item, transformed);
            }
            // Tracing 2
            return transformed;
        }

        // Transformation 7
        private Type _integerType = new Type { Name = "Integer" };

        // Transformation 5
        public Model Transform(Model classModel)
        {
            // Transformation 4
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
            // Transformation 4
            var primaryKey = new Column
            {
                // Transformation 2
                Name = "objectId",
                // Transformation 2
                Type = _integerType
            };
            //  Transformation 4
            var table = new Table
            {
                //  Transformation 3
                Name = @class.Name,
                //  Transformation 1
                Col =
                {
                    //  Transformation 1
                    primaryKey
                }
            };
            // Model Traversal 10
            foreach (var attr in @class.Attr.Where(att => !att.MultiValued))
            {
                //  Transformation 6
                table.Col.Add((IColumn)TraceOrTransform(attr));
            }
            // Change Propagation 6
            ((INotifyCollectionChanged)@class.Attr).CollectionChanged += (o, e) =>
            {
                // Change Propagation 4
                if (e.Action == NotifyCollectionChangedAction.Reset)
                {
                    // Change Propagation 3
                    table.Col.Clear();
                    // Change Propagation 4
                    table.Col.Add(primaryKey);
                    // Change Propagation 1
                    return;
                }
                // Change Propagation 4
                if (e.OldItems != null)
                {
                    // Change Propagation 6
                    foreach (var item in e.OldItems)
                    {
                        // Change Propagation 6
                        table.Col.Remove((IColumn)_trace[item]);
                    }
                }
                // Change Propagation 4
                if (e.NewItems != null)
                {
                    // Change Propagation 6
                    foreach (var item in e.NewItems)
                    {
                        // Change Propagation 6
                        table.Col.Add((IColumn)TraceOrTransform(item));
                    }
                }
            };
            // Change Propagation 8
            @class.NameChanged += (s, e) => { table.Name = @class.Name; };
            // Transformation 1
            return table;
        }

        // Transformation 5
        private IType Transform(IDataType dataType)
        {
            // Tracing 4
            if (dataType.Name == "Integer")
            {
                // Tracing 2
                return _integerType;
            }
            // Transformation 4
            var type = new Type
            {
                // Transformation 3
                Name = dataType.Name
            };
            // Change Propagation 8
            dataType.NameChanged += (o, e) => type.Name = dataType.Name;
            // Transformation 2
            return type;
        }

        // Transformation 5
        private IColumn Transform(IAttribute attribute)
        {
            // Transformation 4
            var column = new Column();
            // Helper 6
            void UpdateNameAndType(object? sender, ValueChangedEventArgs? e)
            {
                // Transformation 5
                if (attribute.Type is IClass)
                {
                    // Transformation 3
                    column!.Type = _integerType;
                    // Transformation 5
                    column.Name = attribute.Name + "Id";
                }
                else
                {
                    // Transformation 6
                    column!.Type = (IType)TraceOrTransform(attribute.Type)!;
                    // Transformation 4
                    column.Name = attribute.Name;
                }
            }
            // Helper 3
            UpdateNameAndType(null, null);
            // Change Propagation 3
            attribute.TypeChanged += UpdateNameAndType;
            // Change Propagation 3
            attribute.NameChanged += UpdateNameAndType;
            // Transformation 2
            return column;
        }

        // Transformation 5
        private ITable CreateAttributeTable(IAttribute attribute)
        {
            // Transformation 6
            var key = new Column { Type = _integerType };
            // Transformation 4
            var table = new Table
            {
                // Transformation 1
                Col =
                {
                    // Transformation 1
                    key,
                    // Transformation 3
                    (IColumn)TraceOrTransform(attribute)!
                }
            };
            // Helper 6
            void OnNameChanged(object? sender, ValueChangedEventArgs? e)
            {
                // Transformation 7
                table.Name = attribute.Owner.Name + "_" + attribute.Name;
                // Transformation 7
                key.Name = attribute.Owner.Name.ToCamelCase() + "Id";
            }
            // Helper 3
            OnNameChanged(null, null);
            // Change Propagation 4
            attribute.Owner.NameChanged += OnNameChanged;
            // Change Propagation 4
            attribute.OwnerChanged += (o, e) =>
            {
                // Change Propagation 9
                if (e.OldValue != null) ((IClass)e.OldValue).NameChanged -= OnNameChanged;
                // Change Propagation 3
                OnNameChanged(o, e);
                // Change Propagation 9
                if (e.NewValue != null) ((IClass)e.NewValue).NameChanged += OnNameChanged;
            };
            // Transformation 2
            return table;
        }
    }
}
