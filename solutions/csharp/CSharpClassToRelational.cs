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
        private Dictionary<object, IModelElement> _trace = new Dictionary<object, IModelElement>();
        private dynamic TraceOrTransform(object item)
        {
            if (!_trace.TryGetValue(item, out var transformed))
            {
                transformed = Transform((dynamic)item);
                _trace.Add(item, transformed);
            }

            return transformed;
        }


        private Type _integerType = new Type { Name = "Integer" };

        public Model Transform(Model classModel)
        {
            var result = new Model();
            foreach (var item in classModel.RootElements)
            {
                result.RootElements.Add(TraceOrTransform(item));
            }
            foreach (var tableValuedAttribute in from cl in classModel.RootElements.OfType<IClass>()
                                                 from att in cl.Attr
                                                 where att.MultiValued
                                                 select att)
            {
                result.RootElements.Add(CreateAttributeTable(tableValuedAttribute));
            }
            return result;
        }


        private ITable Transform(IClass @class)
        {
            var primaryKey = new Column
            {
                Name = "objectId",
                Type = _integerType
            };
            var table = new Table
            {
                Name = @class.Name,
                Col =
                {
                    primaryKey
                }
            };

            foreach (var attr in @class.Attr.Where(att => !att.MultiValued))
            {
                table.Col.Add(TraceOrTransform(attr));
            }
            ((INotifyCollectionChanged)@class.Attr).CollectionChanged += (o, e) =>
            {
                if (e.Action == NotifyCollectionChangedAction.Reset)
                {
                    table.Col.Clear();
                    table.Col.Add(primaryKey);
                    return;
                }
                if (e.OldItems != null)
                {
                    foreach (var item in e.OldItems)
                    {
                        table.Col.Remove((IColumn)_trace[item]);
                    }
                }
                if (e.NewItems != null)
                {
                    foreach (var item in e.NewItems)
                    {
                        table.Col.Add(TraceOrTransform(item));
                    }
                }
            };

            @class.NameChanged += (s, e) => { table.Name = @class.Name; };
            return table;
        }

        private IType Transform(IDataType dataType)
        {
            if (dataType.Name == "Integer")
            {
                return _integerType;
            }
            var type = new Type
            {
                Name = dataType.Name
            };
            dataType.NameChanged += (o, e) => type.Name = dataType.Name;
            return type;
        }

        private IColumn Transform(IAttribute attribute)
        {
            var column = new Column();
            void UpdateNameAndType(object? sender, ValueChangedEventArgs? e)
            {
                if (attribute.Type is IClass)
                {
                    column!.Type = _integerType;
                    column.Name = attribute.Name + "Id";
                }
                else
                {
                    column!.Type = TraceOrTransform(attribute.Type);
                    column.Name = attribute.Name;
                }
            }
            UpdateNameAndType(null, null);
            attribute.TypeChanged += UpdateNameAndType;
            attribute.NameChanged += UpdateNameAndType;
            return column;
        }

        private ITable CreateAttributeTable(IAttribute attribute)
        {
            var key = new Column { Type = _integerType };
            var table = new Table
            {
                Col =
                {
                    key,
                    TraceOrTransform(attribute)
                }
            };
            void OnNameChanged(object? sender, ValueChangedEventArgs? e)
            {
                table.Name = attribute.Owner.Name + "_" + attribute.Name;
                key.Name = attribute.Owner.Name.ToCamelCase() + "Id";
            }
            OnNameChanged(null, null);
            attribute.Owner.NameChanged += OnNameChanged;
            attribute.OwnerChanged += (o, e) =>
            {
                if (e.OldValue != null) ((IClass)e.OldValue).NameChanged -= OnNameChanged;
                OnNameChanged(o, e);
                if (e.NewValue != null) ((IClass)e.NewValue).NameChanged += OnNameChanged;
            };
            return table;
        }
    }
}
