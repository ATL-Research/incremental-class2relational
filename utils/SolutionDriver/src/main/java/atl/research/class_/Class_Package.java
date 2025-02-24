/**
 */
package atl.research.class_;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package </b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class, </li>
 *   <li>each feature of each class, </li>
 *   <li>each operation of each class, </li>
 *   <li>each enum, </li>
 *   <li>and each data type </li>
 * </ul>
 * <!-- end-user-doc -->
 * @see atl.research.class_.Class_Factory
 * @model kind="package"
 * @generated
 */
public interface Class_Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "class_";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "Class";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "class_";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Class_Package eINSTANCE = atl.research.class_.impl.Class_PackageImpl.init();

	/**
	 * The meta object id for the '{@link atl.research.class_.impl.NamedEltImpl <em>Named Elt </em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see atl.research.class_.impl.NamedEltImpl
	 * @see atl.research.class_.impl.Class_PackageImpl#getNamedElt()
	 * @generated
	 */
	int NAMED_ELT = 0;

	/**
	 * The feature id for the ' <em> <b>Name </b> </em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELT__NAME = 0;

	/**
	 * The number of structural features of the ' <em>Named Elt </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the ' <em>Named Elt </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link atl.research.class_.impl.ClassifierImpl <em>Classifier </em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see atl.research.class_.impl.ClassifierImpl
	 * @see atl.research.class_.impl.Class_PackageImpl#getClassifier()
	 * @generated
	 */
	int CLASSIFIER = 1;

	/**
	 * The feature id for the ' <em> <b>Name </b> </em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER__NAME = NAMED_ELT__NAME;

	/**
	 * The number of structural features of the ' <em>Classifier </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_FEATURE_COUNT = NAMED_ELT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the ' <em>Classifier </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASSIFIER_OPERATION_COUNT = NAMED_ELT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link atl.research.class_.impl.DataTypeImpl <em>Data Type </em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see atl.research.class_.impl.DataTypeImpl
	 * @see atl.research.class_.impl.Class_PackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 2;

	/**
	 * The feature id for the ' <em> <b>Name </b> </em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = CLASSIFIER__NAME;

	/**
	 * The number of structural features of the ' <em>Data Type </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the ' <em>Data Type </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link atl.research.class_.impl.ClassImpl <em>Class </em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see atl.research.class_.impl.ClassImpl
	 * @see atl.research.class_.impl.Class_PackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 3;

	/**
	 * The feature id for the ' <em> <b>Name </b> </em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = CLASSIFIER__NAME;

	/**
	 * The feature id for the ' <em> <b>Attr </b> </em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__ATTR = CLASSIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the ' <em>Class </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = CLASSIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the ' <em>Class </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = CLASSIFIER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link atl.research.class_.impl.AttributeImpl <em>Attribute </em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see atl.research.class_.impl.AttributeImpl
	 * @see atl.research.class_.impl.Class_PackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 4;

	/**
	 * The feature id for the ' <em> <b>Name </b> </em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = NAMED_ELT__NAME;

	/**
	 * The feature id for the ' <em> <b>Multi Valued </b> </em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__MULTI_VALUED = NAMED_ELT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the ' <em> <b>Type </b> </em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TYPE = NAMED_ELT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the ' <em> <b>Owner </b> </em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__OWNER = NAMED_ELT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the ' <em>Attribute </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = NAMED_ELT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the ' <em>Attribute </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = NAMED_ELT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link atl.research.class_.NamedElt <em>Named Elt </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class ' <em>Named Elt </em>'.
	 * @see atl.research.class_.NamedElt
	 * @generated
	 */
	EClass getNamedElt();

	/**
	 * Returns the meta object for the attribute '{@link atl.research.class_.NamedElt#getName <em>Name </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute ' <em>Name </em>'.
	 * @see atl.research.class_.NamedElt#getName()
	 * @see #getNamedElt()
	 * @generated
	 */
	EAttribute getNamedElt_Name();

	/**
	 * Returns the meta object for class '{@link atl.research.class_.Classifier <em>Classifier </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class ' <em>Classifier </em>'.
	 * @see atl.research.class_.Classifier
	 * @generated
	 */
	EClass getClassifier();

	/**
	 * Returns the meta object for class '{@link atl.research.class_.DataType <em>Data Type </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class ' <em>Data Type </em>'.
	 * @see atl.research.class_.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for class '{@link atl.research.class_.Class <em>Class </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class ' <em>Class </em>'.
	 * @see atl.research.class_.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the containment reference list '{@link atl.research.class_.Class#getAttr <em>Attr </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list ' <em>Attr </em>'.
	 * @see atl.research.class_.Class#getAttr()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_Attr();

	/**
	 * Returns the meta object for class '{@link atl.research.class_.Attribute <em>Attribute </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class ' <em>Attribute </em>'.
	 * @see atl.research.class_.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the attribute '{@link atl.research.class_.Attribute#getMultiValued <em>Multi Valued </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute ' <em>Multi Valued </em>'.
	 * @see atl.research.class_.Attribute#getMultiValued()
	 * @see #getAttribute()
	 * @generated
	 */
	EAttribute getAttribute_MultiValued();

	/**
	 * Returns the meta object for the reference '{@link atl.research.class_.Attribute#getType <em>Type </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference ' <em>Type </em>'.
	 * @see atl.research.class_.Attribute#getType()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Type();

	/**
	 * Returns the meta object for the container reference '{@link atl.research.class_.Attribute#getOwner <em>Owner </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference ' <em>Owner </em>'.
	 * @see atl.research.class_.Attribute#getOwner()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Owner();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Class_Factory getClass_Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class, </li>
	 *   <li>each feature of each class, </li>
	 *   <li>each operation of each class, </li>
	 *   <li>each enum, </li>
	 *   <li>and each data type </li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link atl.research.class_.impl.NamedEltImpl <em>Named Elt </em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see atl.research.class_.impl.NamedEltImpl
		 * @see atl.research.class_.impl.Class_PackageImpl#getNamedElt()
		 * @generated
		 */
		EClass NAMED_ELT = eINSTANCE.getNamedElt();

		/**
		 * The meta object literal for the ' <em> <b>Name </b> </em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELT__NAME = eINSTANCE.getNamedElt_Name();

		/**
		 * The meta object literal for the '{@link atl.research.class_.impl.ClassifierImpl <em>Classifier </em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see atl.research.class_.impl.ClassifierImpl
		 * @see atl.research.class_.impl.Class_PackageImpl#getClassifier()
		 * @generated
		 */
		EClass CLASSIFIER = eINSTANCE.getClassifier();

		/**
		 * The meta object literal for the '{@link atl.research.class_.impl.DataTypeImpl <em>Data Type </em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see atl.research.class_.impl.DataTypeImpl
		 * @see atl.research.class_.impl.Class_PackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link atl.research.class_.impl.ClassImpl <em>Class </em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see atl.research.class_.impl.ClassImpl
		 * @see atl.research.class_.impl.Class_PackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the ' <em> <b>Attr </b> </em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__ATTR = eINSTANCE.getClass_Attr();

		/**
		 * The meta object literal for the '{@link atl.research.class_.impl.AttributeImpl <em>Attribute </em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see atl.research.class_.impl.AttributeImpl
		 * @see atl.research.class_.impl.Class_PackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the ' <em> <b>Multi Valued </b> </em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE__MULTI_VALUED = eINSTANCE.getAttribute_MultiValued();

		/**
		 * The meta object literal for the ' <em> <b>Type </b> </em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__TYPE = eINSTANCE.getAttribute_Type();

		/**
		 * The meta object literal for the ' <em> <b>Owner </b> </em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__OWNER = eINSTANCE.getAttribute_Owner();

	}

} //Class_Package
