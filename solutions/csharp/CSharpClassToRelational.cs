using HSRM.TTC2023.ClassToRelational.Class_;
using HSRM.TTC2023.ClassToRelational.Relational_;
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
        private Type _integerType = new Type { Name = "Integer" };

        public Model Transform(Model classModel)
        {
            var result = new Model();
            foreach (var item in classModel.RootElements)
            {
                if (!_trace.TryGetValue(item, out var transformed))
                {
                    transformed = Transform((dynamic)item);
                    _trace.Add(item, transformed);
                }
                result.RootElements.Add(transformed);
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
                table.Col.Add(Transform(attr));
            }
            ((INotifyCollectionChanged)@class.Attr).CollectionChanged += (o, e) =>
            {
                if (e.OldItems != null)
                {
                    foreach (var item in e.OldItems)
                    {

                    }
                }
                if (e.NewItems != null)
                {
                    foreach (var item in e.NewItems)
                    {

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
            var column = new Column
            {
                Name = attribute.Name,
            };
            if (attribute.Type is IClass)
            {
                column.Type = _integerType;
                column.Name += "Id";
            }
            else if (_trace.TryGetValue(attribute.Type, out var type))
            {
                column.Type = (IType)type;
            }
            else
            {
                var transformedType = Transform((IDataType)attribute.Type);
                column.Type = transformedType;
                _trace.Add(attribute.Type, transformedType);
            }
            return column;
        }

        private ITable CreateAttributeTable(IAttribute attribute)
        {
            var key = new Column { Name = attribute.Owner.Name.ToCamelCase() + "Id", Type = _integerType };
            return new Table
            {
                Col =
                {
                    key,
                    Transform(attribute)
                }
            };
        }
    }
}
