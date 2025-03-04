//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:6.0.16
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

using NMF.Collections.Generic;
using NMF.Collections.ObjectModel;
using NMF.Expressions;
using NMF.Expressions.Linq;
using NMF.Models;
using NMF.Models.Collections;
using NMF.Models.Expressions;
using NMF.Models.Meta;
using NMF.Models.Repository;
using NMF.Serialization;
using NMF.Utilities;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;

namespace HSRM.TTC2023.ClassToRelational.Class_
{
    
    
    /// <summary>
    /// The public interface for Attribute
    /// </summary>
    [DefaultImplementationTypeAttribute(typeof(Attribute))]
    [XmlDefaultImplementationTypeAttribute(typeof(Attribute))]
    [ModelRepresentationClassAttribute("https://github.com/ATL-Research/incremental-class2relational/Class.nmeta#//Attrib" +
        "ute")]
    public interface IAttribute : IModelElement, INamedElt
    {
        
        /// <summary>
        /// The multiValued property
        /// </summary>
        [DefaultValueAttribute(false)]
        [TypeConverterAttribute(typeof(LowercaseBooleanConverter))]
        [DisplayNameAttribute("multiValued")]
        [CategoryAttribute("Attribute")]
        [XmlElementNameAttribute("multiValued")]
        [XmlAttributeAttribute(true)]
        bool MultiValued
        {
            get;
            set;
        }
        
        /// <summary>
        /// The type property
        /// </summary>
        [DisplayNameAttribute("type")]
        [CategoryAttribute("Attribute")]
        [XmlElementNameAttribute("type")]
        [XmlAttributeAttribute(true)]
        IClassifier Type
        {
            get;
            set;
        }
        
        /// <summary>
        /// The owner property
        /// </summary>
        [BrowsableAttribute(false)]
        [XmlElementNameAttribute("owner")]
        [DesignerSerializationVisibilityAttribute(DesignerSerializationVisibility.Hidden)]
        [XmlAttributeAttribute(true)]
        [XmlOppositeAttribute("attr")]
        HSRM.TTC2023.ClassToRelational.Class_.IClass Owner
        {
            get;
            set;
        }
        
        /// <summary>
        /// Gets fired before the MultiValued property changes its value
        /// </summary>
        event System.EventHandler <ValueChangedEventArgs> MultiValuedChanging;
        
        /// <summary>
        /// Gets fired when the MultiValued property changed its value
        /// </summary>
        event System.EventHandler <ValueChangedEventArgs> MultiValuedChanged;
        
        /// <summary>
        /// Gets fired before the Type property changes its value
        /// </summary>
        event System.EventHandler <ValueChangedEventArgs> TypeChanging;
        
        /// <summary>
        /// Gets fired when the Type property changed its value
        /// </summary>
        event System.EventHandler <ValueChangedEventArgs> TypeChanged;
        
        /// <summary>
        /// Gets fired before the Owner property changes its value
        /// </summary>
        event System.EventHandler <ValueChangedEventArgs> OwnerChanging;
        
        /// <summary>
        /// Gets fired when the Owner property changed its value
        /// </summary>
        event System.EventHandler <ValueChangedEventArgs> OwnerChanged;
    }
}

