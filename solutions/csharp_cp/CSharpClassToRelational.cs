
using HSRM.TTC2023.ClassToRelational.Class_;
using HSRM.TTC2023.ClassToRelational.Relational_;
using NMF.Expressions;
using NMF.Models;
using NMF.Utilities;
using System.Collections.Specialized;
using Type = HSRM.TTC2023.ClassToRelational.Relational_.Type;

// Setup 
namespace HSRM.TTC2023.ClassToRelational
{
    internal class CSharpClassToRelational
    {
        // Tracing 
        private Dictionary <object, IModelElement> _trace = new();

        // Tracing 
        private Dictionary <IAttribute, ITable> _attributeTables = new();

        // Tracing 
        private Model _result = new Model();

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

        // Change_Propagation 
        private void Remove <T>(object original, ICollection <T> targetCollection)
        {
            // Change_Propagation 
            if (original != null && _trace.TryGetValue(original, out var transformed) && transformed is T target)
            {
                // Change_Propagation 
                targetCollection.Remove(target);
            }
            if (original is IClass cl)
            {
                foreach (var att in cl.Attr.Where(a => a.MultiValued))
                {
                    targetCollection.Remove((T)_attributeTables[att]);
                }
            }
        }

        // Transformation 
        private Type _integerType = new Type { Name = "Integer" };

        // Transformation 
        public Model Transform(Model classModel)
        {
            // Transformation 
            _result = new Model();
            // Model_Navigation  
            foreach (var item in classModel.RootElements)
            {
                // Transformation 
                AddElement(item);
            }
            // Change_Identification 
            classModel.RootElements.AsNotifiable().CollectionChanged += (o, e) =>
            {
                // Change_Propagation 
                if (e.Action == NotifyCollectionChangedAction.Reset)
                {
                    // Change_Propagation 
                    _result.RootElements.Clear();
                    // Change_Propagation 
                    return;
                }
                // Change_Propagation 
                if (e.OldItems != null)
                {
                    // Change_Propagation 
                    foreach (IModelElement item in e.OldItems)
                    {
                        // Change_Propagation 
                        Remove(item, _result.RootElements);
                    }
                }
                // Change_Propagation 
                if (e.NewItems != null)
                {
                    // Change_Propagation 
                    foreach (IModelElement item in e.NewItems)
                    {
                        // Change_Propagation 
                        AddElement(item);
                    }
                }
            };
            // Transformation 
            return _result;
        }

        // Helper 
        private void AddElement(IModelElement rootElement)
        {
            // Transformation 
            _result.RootElements.Add((IModelElement)TraceOrTransform(rootElement)!);

            // Transformation 
            if (rootElement is IClass @class)
            {
                // Model_Navigation  
                foreach (var att in @class.Attr)
                {
                    // Transformation 
                    AddAttribute(att);
                }

                // Change_Identification 
                @class.Attr.AsNotifiable().CollectionChanged += (o, e) =>
                {
                    // Change_Propagation 
                    if (e.Action == NotifyCollectionChangedAction.Reset)
                    {
                        // Change_Propagation 
                        foreach (var att in _attributeTables)
                        {
                            // Change_Propagation 
                            if (att.Key.Owner == @class)
                            {
                                // Change_Propagation 
                                _result.RootElements.Remove(att.Value);
                            }
                        }
                    }
                    // Change_Propagation 
                    if (e.OldItems != null)
                    {
                        // Change_Propagation 
                        foreach (IAttribute att in e.OldItems)
                        {
                            // Change_Propagation 
                            if (att.MultiValued)
                            {
                                // Change_Propagation 
                                _result.RootElements.Remove(_attributeTables[att]);
                            }
                            // Change_Identification 
                            att.MultiValuedChanged -= AttMultiValuedChanged;
                        }
                    }
                    // Change_Propagation 
                    if (e.NewItems != null)
                    {
                        // Change_Propagation 
                        foreach (IAttribute att in e.NewItems)
                        {
                            // Change_Propagation 
                            AddAttribute(att);
                        }
                    }
                };
            }
        }

        // Helper 
        private void AddAttribute(IAttribute att)
        {
            // Model_Navigation  
            if (att.MultiValued)
            {
                // Transformation 
                _result.RootElements.Add(CreateAttributeTable(att));
            }

            // Change_Identification 
            att.MultiValuedChanged += AttMultiValuedChanged;
        }

        // Change_Propagation 
        private void AttMultiValuedChanged(object? sender, ValueChangedEventArgs e)
        {
            // Change_Propagation 
            var att = sender as IAttribute;
            // Change_Propagation 
            if (att!.MultiValued)
            {
                // Change_Propagation 
                _result.RootElements.Add(CreateAttributeTable(att));
            }
            // Change_Propagation 
            else
            {
                // Change_Propagation 
                _result.RootElements.Remove(_attributeTables[att]);
            }
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
            //  Transformation 
            var table = new Table
            {
                //  Transformation 
                Name = @class.Name,
                //  Transformation 
                Col =
                {
                    //  Transformation 
                    primaryKey
                }
            };
            // Change_Propagation 
            void OnMultiValuedChanged(object? sender, ValueChangedEventArgs e)
            {
                // Change_Propagation 
                var att = sender as IAttribute;
                // Change_Propagation 
                if (!att!.MultiValued)
                {
                    // Change_Propagation 
                    table!.Col.Add((IColumn)TraceOrTransform(att)!);
                }
                // Change_Propagation 
                else
                {
                    // Change_Propagation 
                    table!.Col.Remove((IColumn)_trace[att]);
                }
            }
            // Model_Traversal 
            foreach (var attr in @class.Attr)
            {
                // Model_Traversal 
                if (!attr.MultiValued)
                {
                    //  Transformation 
                    table.Col.Add((IColumn)TraceOrTransform(attr)!);
                }
                // Change_Identification 
                attr.MultiValuedChanged += OnMultiValuedChanged;
            }
            // Change_Propagation 
            ((INotifyCollectionChanged)@class.Attr).CollectionChanged += (o, e) =>
            {
                // Change_Propagation 
                if (e.Action == NotifyCollectionChangedAction.Reset)
                {
                    // Change_Propagation 
                    table.Col.Clear();
                    // Change_Propagation 
                    table.Col.Add(primaryKey);
                    // Change_Propagation 
                    return;
                }
                // Change_Propagation 
                if (e.OldItems != null)
                {
                    // Change_Propagation 
                    foreach (IAttribute item in e.OldItems)
                    {
                        // Change_Propagation 
                        if (!item.MultiValued)
                        {
                            // Change_Identification 
                            table.Col.Remove((IColumn)_trace[item]);
                        }
                        // Change_Identification 
                        item.MultiValuedChanged -= OnMultiValuedChanged;
                    }
                }
                // Change_Propagation 
                if (e.NewItems != null)
                {
                    // Change_Propagation 
                    foreach (IAttribute item in e.NewItems)
                    {
                        // Change_Propagation 
                        if (!item.MultiValued)
                        {
                            // Change_Propagation 
                            table.Col.Add((IColumn)TraceOrTransform(item)!);
                        }
                        // Change_Identification 
                        item.MultiValuedChanged += OnMultiValuedChanged;
                    }
                }
            };
            // Change_Propagation 
            @class.NameChanged += (s, e) => { table.Name = @class.Name; };
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
            // Change_Propagation 
            dataType.NameChanged += (o, e) => type.Name = dataType.Name;
            // Transformation 
            return type;
        }

        // Transformation 
        private IColumn Transform(IAttribute attribute)
        {
            // Transformation 
            var column = new Column();
            // Helper 
            void UpdateNameAndType(object? sender, ValueChangedEventArgs? e)
            {
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
            }
            // Helper 
            UpdateNameAndType(null, null);
            // Change_Identification 
            attribute.TypeChanged += UpdateNameAndType;
            // Change_Identification 
            attribute.NameChanged += UpdateNameAndType;
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
            // Helper 
            void OnNameChanged(object? sender, ValueChangedEventArgs? e)
            {
                // Transformation 
                table.Name = attribute.Owner?.Name + "_" + attribute.Name;
                // Transformation 
                key.Name = attribute.Owner?.Name.ToCamelCase() + "Id";
            }
            // Helper 
            OnNameChanged(null, null);
            // Change_Identification 
            attribute.Owner.NameChanged += OnNameChanged;
            // Change_Propagation 
            attribute.OwnerChanged += (o, e) =>
            {
                // Change_Identification 
                if (e.OldValue != null) ((IClass)e.OldValue).NameChanged -= OnNameChanged;
                // Change_Propagation 
                OnNameChanged(o, e);
                // Change_Identification 
                if (e.NewValue != null) ((IClass)e.NewValue).NameChanged += OnNameChanged;
            };

            // Tracing 
            _attributeTables[attribute] = table;
            // Transformation 
            return table;
        }
    }
}
