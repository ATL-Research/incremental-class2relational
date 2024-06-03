/**
 */
package class2relationalImperative.correspondence.class2relationalImperative;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see class2relationalImperative.correspondence.class2relationalImperative.Class2relationalImperativeFactory
 * @model kind="package"
 * @generated
 */
public interface Class2relationalImperativePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "class2relationalImperative";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://class2relationalImperative/correspondence.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "class2relationalImperative.correspondence";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Class2relationalImperativePackage eINSTANCE = class2relationalImperative.correspondence.class2relationalImperative.impl.Class2relationalImperativePackageImpl.init();

	/**
	 * The meta object id for the '{@link class2relationalImperative.correspondence.class2relationalImperative.impl.TransformationImpl <em>Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.TransformationImpl
	 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.Class2relationalImperativePackageImpl#getTransformation()
	 * @generated
	 */
	int TRANSFORMATION = 0;

	/**
	 * The feature id for the '<em><b>Correspondences</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__CORRESPONDENCES = 0;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link class2relationalImperative.correspondence.class2relationalImperative.impl.CorrImpl <em>Corr</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.CorrImpl
	 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.Class2relationalImperativePackageImpl#getCorr()
	 * @generated
	 */
	int CORR = 1;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORR__SOURCE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Target Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORR__TARGET_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORR__DESC = 2;

	/**
	 * The number of structural features of the '<em>Corr</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link class2relationalImperative.correspondence.class2relationalImperative.impl.BasicElemImpl <em>Basic Elem</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.BasicElemImpl
	 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.Class2relationalImperativePackageImpl#getBasicElem()
	 * @generated
	 */
	int BASIC_ELEM = 2;

	/**
	 * The feature id for the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEM__SOURCE_ELEMENT = CORR__SOURCE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Target Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEM__TARGET_ELEMENT = CORR__TARGET_ELEMENT;

	/**
	 * The feature id for the '<em><b>Desc</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEM__DESC = CORR__DESC;

	/**
	 * The number of structural features of the '<em>Basic Elem</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_ELEM_FEATURE_COUNT = CORR_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link class2relationalImperative.correspondence.class2relationalImperative.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see class2relationalImperative.correspondence.class2relationalImperative.Transformation
	 * @generated
	 */
	EClass getTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link class2relationalImperative.correspondence.class2relationalImperative.Transformation#getCorrespondences <em>Correspondences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Correspondences</em>'.
	 * @see class2relationalImperative.correspondence.class2relationalImperative.Transformation#getCorrespondences()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Correspondences();

	/**
	 * Returns the meta object for class '{@link class2relationalImperative.correspondence.class2relationalImperative.Corr <em>Corr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Corr</em>'.
	 * @see class2relationalImperative.correspondence.class2relationalImperative.Corr
	 * @generated
	 */
	EClass getCorr();

	/**
	 * Returns the meta object for the reference '{@link class2relationalImperative.correspondence.class2relationalImperative.Corr#getSourceElement <em>Source Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Element</em>'.
	 * @see class2relationalImperative.correspondence.class2relationalImperative.Corr#getSourceElement()
	 * @see #getCorr()
	 * @generated
	 */
	EReference getCorr_SourceElement();

	/**
	 * Returns the meta object for the reference '{@link class2relationalImperative.correspondence.class2relationalImperative.Corr#getTargetElement <em>Target Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Element</em>'.
	 * @see class2relationalImperative.correspondence.class2relationalImperative.Corr#getTargetElement()
	 * @see #getCorr()
	 * @generated
	 */
	EReference getCorr_TargetElement();

	/**
	 * Returns the meta object for the attribute '{@link class2relationalImperative.correspondence.class2relationalImperative.Corr#getDesc <em>Desc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Desc</em>'.
	 * @see class2relationalImperative.correspondence.class2relationalImperative.Corr#getDesc()
	 * @see #getCorr()
	 * @generated
	 */
	EAttribute getCorr_Desc();

	/**
	 * Returns the meta object for class '{@link class2relationalImperative.correspondence.class2relationalImperative.BasicElem <em>Basic Elem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Elem</em>'.
	 * @see class2relationalImperative.correspondence.class2relationalImperative.BasicElem
	 * @generated
	 */
	EClass getBasicElem();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Class2relationalImperativeFactory getClass2relationalImperativeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link class2relationalImperative.correspondence.class2relationalImperative.impl.TransformationImpl <em>Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.TransformationImpl
		 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.Class2relationalImperativePackageImpl#getTransformation()
		 * @generated
		 */
		EClass TRANSFORMATION = eINSTANCE.getTransformation();

		/**
		 * The meta object literal for the '<em><b>Correspondences</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__CORRESPONDENCES = eINSTANCE.getTransformation_Correspondences();

		/**
		 * The meta object literal for the '{@link class2relationalImperative.correspondence.class2relationalImperative.impl.CorrImpl <em>Corr</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.CorrImpl
		 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.Class2relationalImperativePackageImpl#getCorr()
		 * @generated
		 */
		EClass CORR = eINSTANCE.getCorr();

		/**
		 * The meta object literal for the '<em><b>Source Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORR__SOURCE_ELEMENT = eINSTANCE.getCorr_SourceElement();

		/**
		 * The meta object literal for the '<em><b>Target Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORR__TARGET_ELEMENT = eINSTANCE.getCorr_TargetElement();

		/**
		 * The meta object literal for the '<em><b>Desc</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CORR__DESC = eINSTANCE.getCorr_Desc();

		/**
		 * The meta object literal for the '{@link class2relationalImperative.correspondence.class2relationalImperative.impl.BasicElemImpl <em>Basic Elem</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.BasicElemImpl
		 * @see class2relationalImperative.correspondence.class2relationalImperative.impl.Class2relationalImperativePackageImpl#getBasicElem()
		 * @generated
		 */
		EClass BASIC_ELEM = eINSTANCE.getBasicElem();

	}

} //Class2relationalImperativePackage
