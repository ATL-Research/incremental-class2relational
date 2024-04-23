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

        // Tracing 7
        private Dictionary<IAttribute, ITable> _attributeTables = new();
        
        // Tracing 6
        private Model _result = new Model();

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

        // Incremental Change Propagation 8
        private void Remove<T>(object original, ICollection<T> targetCollection)
        {
            // Incremental Change Propagation 16
            if (original != null && _trace.TryGetValue(original, out var transformed) && transformed is T target)
            {
                // Change Propagation 3
                targetCollection.Remove(target);
            }
        }

        // Transformation 9
        private Type _integerType = new Type { Name = "Integer" };

        // Transformation 5
        public Model Transform(Model classModel)
        {
            // Transformation 4
            _result = new Model();
            // Model Navigation 6
            foreach (var item in classModel.RootElements)
            {
                // Transformation 2
                AddElement(item);
            }
            // Incremental Change Recognition 8
            classModel.RootElements.AsNotifiable().CollectionChanged += (o, e) =>
            {
                // Incremental Change Propagation 6
                if (e.Action == NotifyCollectionChangedAction.Reset)
                {
                    // Incremental Change Propagation 3
                    _result.RootElements.Clear();
                    // Incremental Change Propagation 1
                    return;
                }
                // Incremental Change Propagation 5
                if (e.OldItems != null)
                {
                    // Incremental Change Propagation 6
                    foreach (IModelElement item in e.OldItems)
                    {
                        // Incremental Change Propagation 4
                        Remove(item, _result.RootElements);
                    }
                }
                // Incremental Change Propagation 5
                if (e.NewItems != null)
                {
                    // Incremental Change Propagation 6
                    foreach (IModelElement item in e.NewItems)
                    {
                        // Incremental Change Propagation 2
                        AddElement(item);
                    }
                }
            };
            // Transformation 2
            return _result;
        }

        // Helper 5
        private void AddElement(IModelElement rootElement)
        {
            // Transformation 6
            _result.RootElements.Add((IModelElement)TraceOrTransform(rootElement)!);

            // Transformation 5
            if (rootElement is IClass @class)
            {
                // Model Navigation 6
                foreach (var att in @class.Attr)
                {
                    // Transformation 2
                    AddAttribute(att);
                }

                // Incremental Change Recognition 8
                @class.Attr.AsNotifiable().CollectionChanged += (o, e) =>
                {
                    // Incremental Change Propagation 6
                    if (e.Action == NotifyCollectionChangedAction.Reset)
                    {
                        // Incremental Change Propagation 5
                        foreach (var att in _attributeTables)
                        {
                            // Incremental Change Propagation 6
                            if (att.Key.Owner == @class)
                            {
                                // Incremental Change Propagation 5
                                _result.RootElements.Remove(att.Value);
                            }
                        }
                    }
                    // Incremental Change Propagation 5
                    if (e.OldItems != null)
                    {
                        // Incremental Change Propagation 6
                        foreach (IAttribute att in e.OldItems)
                        {
                            // Incremental Change Propagation 3
                            if (att.MultiValued)
                            {
                                // Incremental Change Propagation 5
                                _result.RootElements.Remove(_attributeTables[att]);
                            }
                            // Incremental Change Recognition 4
                            att.MultiValuedChanged -= AttMultiValuedChanged;
                        }
                    }
                    // Incremental Change Propagation 5
                    if (e.NewItems != null)
                    {
                        // Incremental Change Propagation 6
                        foreach (IAttribute att in e.NewItems)
                        {
                            // Incremental Change Propagation 2
                            AddAttribute(att);
                        }
                    }
                };
            }
        }

        // Helper 5
        private void AddAttribute(IAttribute att)
        {
            // Model Navigation 3
            if (att.MultiValued)
            {
                // Transformation 5
                _result.RootElements.Add(CreateAttributeTable(att));
            }

            // Incremental Change Recognition 4
            att.MultiValuedChanged += AttMultiValuedChanged;
        }

        // Incremental Change Propagation 7
        private void AttMultiValuedChanged(object? sender, ValueChangedEventArgs e)
        {
            // Incremental Change Propagation 6
            var att = sender as IAttribute;
            // Incremental Change Propagation 3
            if (att!.MultiValued)
            {
                // Incremental Change Propagation 5
                _result.RootElements.Add(CreateAttributeTable(att));
            }
            // Incremental Change Propagation 1
            else
            {
                // Incremental Change Propagation 5
                _result.RootElements.Remove(_attributeTables[att]);
            }
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
            // Incremental Change Propagation 6
            void OnMultiValuedChanged(object? sender, ValueChangedEventArgs e)
            {
                // Incremental Change Propagation 5
                var att = sender as IAttribute;
                // Incremental Change Propagation 3
                if (att!.MultiValued)
                {
                    // Incremental Change Propagation 6
                    table!.Col.Add((IColumn)TraceOrTransform(att)!);
                }
                // Incremental Change Propagation 1
                else
                {
                    // Incremental Change Propagation 6
                    table!.Col.Remove((IColumn)_trace[att]);
                }
            }
            // Model Traversal 6
            foreach (var attr in @class.Attr)
            {
                // Model Traversal 3
                if (attr.MultiValued)
                {
                    //  Transformation 6
                    table.Col.Add((IColumn)TraceOrTransform(attr)!);
                }
                // Incremental Change Recognition 4
                attr.MultiValuedChanged += OnMultiValuedChanged;
            }
            // Incremental Change Propagation 8
            ((INotifyCollectionChanged)@class.Attr).CollectionChanged += (o, e) =>
            {
                // Incremental Change Propagation 4
                if (e.Action == NotifyCollectionChangedAction.Reset)
                {
                    // Incremental Change Propagation 3
                    table.Col.Clear();
                    // Incremental Change Propagation 4
                    table.Col.Add(primaryKey);
                    // Incremental Change Propagation 1
                    return;
                }
                // Incremental Change Propagation 5
                if (e.OldItems != null)
                {
                    // Incremental Change Propagation 6
                    foreach (IAttribute item in e.OldItems)
                    {
                        // Incremental Change Propagation 3
                        if (!item.MultiValued)
                        {
                            // Incremental Change Recognition 6
                            table.Col.Remove((IColumn)_trace[item]);
                        }
                        // Incremental Change Recognition 4
                        item.MultiValuedChanged -= OnMultiValuedChanged;
                    }
                }
                // Incremental Change Propagation 5
                if (e.NewItems != null)
                {
                    // Incremental Change Propagation 6
                    foreach (IAttribute item in e.NewItems)
                    {
                        // Incremental Change Propagation 3
                        if (!item.MultiValued)
                        {
                            // Incremental Change Propagation 6
                            table.Col.Add((IColumn)TraceOrTransform(item)!);
                        }
                        // Incremental Change Recognition 4
                        item.MultiValuedChanged += OnMultiValuedChanged;
                    }
                }
            };
            // Incremental Change Propagation 11
            @class.NameChanged += (s, e) => { table.Name = @class.Name; };
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
            // Incremental Change Propagation 11
            dataType.NameChanged += (o, e) => type.Name = dataType.Name;
            // Transformation 2
            return type;
        }

        // Transformation 5
        private IColumn Transform(IAttribute attribute)
        {
            // Transformation 5
            var column = new Column();
            // Helper 6
            void UpdateNameAndType(object? sender, ValueChangedEventArgs? e)
            {
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
                    // Transformation 7
                    column!.Type = (IType)TraceOrTransform(attribute.Type)!;
                    // Transformation 5
                    column.Name = attribute.Name;
                }
            }
            // Helper 3
            UpdateNameAndType(null, null);
            // Incremental Change Recognition 4
            attribute.TypeChanged += UpdateNameAndType;
            // Incremental Change Recognition 4
            attribute.NameChanged += UpdateNameAndType;
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
            // Helper 6
            void OnNameChanged(object? sender, ValueChangedEventArgs? e)
            {
                // Transformation 8
                table.Name = attribute.Owner.Name + "_" + attribute.Name;
                // Transformation 8
                key.Name = attribute.Owner.Name.ToCamelCase() + "Id";
            }
            // Helper 3
            OnNameChanged(null, null);
            // Incremental Change Recognition 5
            attribute.Owner.NameChanged += OnNameChanged;
            // Incremental Change Propagation 6
            attribute.OwnerChanged += (o, e) =>
            {
                // Incremental Change Recognition 11
                if (e.OldValue != null) ((IClass)e.OldValue).NameChanged -= OnNameChanged;
                // Incremental Change Propagation 3
                OnNameChanged(o, e);
                // Incremental Change Recognition 11
                if (e.NewValue != null) ((IClass)e.NewValue).NameChanged += OnNameChanged;
            };

            // Tracing 4
            _attributeTables[attribute] = table;
            // Transformation 2
            return table;
        }
    }
}
