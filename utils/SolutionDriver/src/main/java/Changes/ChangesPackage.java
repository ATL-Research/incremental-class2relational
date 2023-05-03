/**
 */
package Changes;

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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see changes_new.Changes.ChangesFactory
 * @model kind="package"
 * @generated
 */
public interface ChangesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Changes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://nmf.codeplex.com/changes";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "changes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ChangesPackage eINSTANCE = Changes.impl.ChangesPackageImpl.init();

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.ModelChangeSetImpl <em>Model Change Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.ModelChangeSetImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getModelChangeSet()
	 * @generated
	 */
	int MODEL_CHANGE_SET = 0;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_SET__CHANGES = 0;

	/**
	 * The number of structural features of the '<em>Model Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_SET_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model Change Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_SET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.ModelChangeImpl <em>Model Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.ModelChangeImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getModelChange()
	 * @generated
	 */
	int MODEL_CHANGE = 1;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE__CHANGE_SET = 0;

	/**
	 * The number of structural features of the '<em>Model Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Model Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_CHANGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.ElementaryChangeImpl <em>Elementary Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.ElementaryChangeImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getElementaryChange()
	 * @generated
	 */
	int ELEMENTARY_CHANGE = 2;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_CHANGE__CHANGE_SET = MODEL_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_CHANGE__AFFECTED_ELEMENT = MODEL_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_CHANGE__FEATURE = MODEL_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Elementary Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_CHANGE_FEATURE_COUNT = MODEL_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Elementary Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENTARY_CHANGE_OPERATION_COUNT = MODEL_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.ChangeTransactionImpl <em>Change Transaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.ChangeTransactionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getChangeTransaction()
	 * @generated
	 */
	int CHANGE_TRANSACTION = 3;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_TRANSACTION__CHANGE_SET = MODEL_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Source Change</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_TRANSACTION__SOURCE_CHANGE = MODEL_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nested Changes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_TRANSACTION__NESTED_CHANGES = MODEL_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Change Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_TRANSACTION_FEATURE_COUNT = MODEL_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Change Transaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_TRANSACTION_OPERATION_COUNT = MODEL_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionChangeImpl <em>Composition Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionChangeImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionChange()
	 * @generated
	 */
	int COMPOSITION_CHANGE = 4;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_CHANGE__CHANGE_SET = ELEMENTARY_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_CHANGE__AFFECTED_ELEMENT = ELEMENTARY_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_CHANGE__FEATURE = ELEMENTARY_CHANGE__FEATURE;

	/**
	 * The number of structural features of the '<em>Composition Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_CHANGE_FEATURE_COUNT = ELEMENTARY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Composition Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_CHANGE_OPERATION_COUNT = ELEMENTARY_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AssociationChangeImpl <em>Association Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AssociationChangeImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationChange()
	 * @generated
	 */
	int ASSOCIATION_CHANGE = 5;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CHANGE__CHANGE_SET = ELEMENTARY_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CHANGE__AFFECTED_ELEMENT = ELEMENTARY_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CHANGE__FEATURE = ELEMENTARY_CHANGE__FEATURE;

	/**
	 * The number of structural features of the '<em>Association Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CHANGE_FEATURE_COUNT = ELEMENTARY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Association Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_CHANGE_OPERATION_COUNT = ELEMENTARY_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AttributeChangeImpl <em>Attribute Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AttributeChangeImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeChange()
	 * @generated
	 */
	int ATTRIBUTE_CHANGE = 6;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE__CHANGE_SET = ELEMENTARY_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE__AFFECTED_ELEMENT = ELEMENTARY_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE__FEATURE = ELEMENTARY_CHANGE__FEATURE;

	/**
	 * The number of structural features of the '<em>Attribute Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_FEATURE_COUNT = ELEMENTARY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_CHANGE_OPERATION_COUNT = ELEMENTARY_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AssociationCollectionDeletionImpl <em>Association Collection Deletion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AssociationCollectionDeletionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationCollectionDeletion()
	 * @generated
	 */
	int ASSOCIATION_COLLECTION_DELETION = 7;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_DELETION__CHANGE_SET = ASSOCIATION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_DELETION__AFFECTED_ELEMENT = ASSOCIATION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_DELETION__FEATURE = ASSOCIATION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Deleted Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_DELETION__DELETED_ELEMENT = ASSOCIATION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Association Collection Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_DELETION_FEATURE_COUNT = ASSOCIATION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Association Collection Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_DELETION_OPERATION_COUNT = ASSOCIATION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionCollectionDeletionImpl <em>Composition Collection Deletion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionCollectionDeletionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionCollectionDeletion()
	 * @generated
	 */
	int COMPOSITION_COLLECTION_DELETION = 8;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_DELETION__CHANGE_SET = COMPOSITION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_DELETION__AFFECTED_ELEMENT = COMPOSITION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_DELETION__FEATURE = COMPOSITION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Deleted Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_DELETION__DELETED_ELEMENT = COMPOSITION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composition Collection Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_DELETION_FEATURE_COUNT = COMPOSITION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composition Collection Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_DELETION_OPERATION_COUNT = COMPOSITION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AttributeCollectionDeletionImpl <em>Attribute Collection Deletion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AttributeCollectionDeletionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeCollectionDeletion()
	 * @generated
	 */
	int ATTRIBUTE_COLLECTION_DELETION = 9;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_DELETION__CHANGE_SET = ATTRIBUTE_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_DELETION__AFFECTED_ELEMENT = ATTRIBUTE_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_DELETION__FEATURE = ATTRIBUTE_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Deleted Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_DELETION__DELETED_VALUE = ATTRIBUTE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Collection Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_DELETION_FEATURE_COUNT = ATTRIBUTE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Collection Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_DELETION_OPERATION_COUNT = ATTRIBUTE_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AssociationCollectionInsertionImpl <em>Association Collection Insertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AssociationCollectionInsertionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationCollectionInsertion()
	 * @generated
	 */
	int ASSOCIATION_COLLECTION_INSERTION = 10;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_INSERTION__CHANGE_SET = ASSOCIATION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_INSERTION__AFFECTED_ELEMENT = ASSOCIATION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_INSERTION__FEATURE = ASSOCIATION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Added Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_INSERTION__ADDED_ELEMENT = ASSOCIATION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Association Collection Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_INSERTION_FEATURE_COUNT = ASSOCIATION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Association Collection Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_INSERTION_OPERATION_COUNT = ASSOCIATION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionCollectionInsertionImpl <em>Composition Collection Insertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionCollectionInsertionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionCollectionInsertion()
	 * @generated
	 */
	int COMPOSITION_COLLECTION_INSERTION = 11;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_INSERTION__CHANGE_SET = COMPOSITION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_INSERTION__AFFECTED_ELEMENT = COMPOSITION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_INSERTION__FEATURE = COMPOSITION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Added Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_INSERTION__ADDED_ELEMENT = COMPOSITION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composition Collection Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_INSERTION_FEATURE_COUNT = COMPOSITION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Composition Collection Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_INSERTION_OPERATION_COUNT = COMPOSITION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AttributeCollectionInsertionImpl <em>Attribute Collection Insertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AttributeCollectionInsertionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeCollectionInsertion()
	 * @generated
	 */
	int ATTRIBUTE_COLLECTION_INSERTION = 12;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_INSERTION__CHANGE_SET = ATTRIBUTE_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_INSERTION__AFFECTED_ELEMENT = ATTRIBUTE_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_INSERTION__FEATURE = ATTRIBUTE_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Added Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_INSERTION__ADDED_VALUE = ATTRIBUTE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute Collection Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_INSERTION_FEATURE_COUNT = ATTRIBUTE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Attribute Collection Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_INSERTION_OPERATION_COUNT = ATTRIBUTE_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AssociationCollectionResetImpl <em>Association Collection Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AssociationCollectionResetImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationCollectionReset()
	 * @generated
	 */
	int ASSOCIATION_COLLECTION_RESET = 13;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_RESET__CHANGE_SET = ASSOCIATION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_RESET__AFFECTED_ELEMENT = ASSOCIATION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_RESET__FEATURE = ASSOCIATION_CHANGE__FEATURE;

	/**
	 * The number of structural features of the '<em>Association Collection Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_RESET_FEATURE_COUNT = ASSOCIATION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Association Collection Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_COLLECTION_RESET_OPERATION_COUNT = ASSOCIATION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionCollectionResetImpl <em>Composition Collection Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionCollectionResetImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionCollectionReset()
	 * @generated
	 */
	int COMPOSITION_COLLECTION_RESET = 14;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_RESET__CHANGE_SET = COMPOSITION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_RESET__AFFECTED_ELEMENT = COMPOSITION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_RESET__FEATURE = COMPOSITION_CHANGE__FEATURE;

	/**
	 * The number of structural features of the '<em>Composition Collection Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_RESET_FEATURE_COUNT = COMPOSITION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Composition Collection Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_COLLECTION_RESET_OPERATION_COUNT = COMPOSITION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AttributeCollectionResetImpl <em>Attribute Collection Reset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AttributeCollectionResetImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeCollectionReset()
	 * @generated
	 */
	int ATTRIBUTE_COLLECTION_RESET = 15;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_RESET__CHANGE_SET = ATTRIBUTE_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_RESET__AFFECTED_ELEMENT = ATTRIBUTE_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_RESET__FEATURE = ATTRIBUTE_CHANGE__FEATURE;

	/**
	 * The number of structural features of the '<em>Attribute Collection Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_RESET_FEATURE_COUNT = ATTRIBUTE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Attribute Collection Reset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_COLLECTION_RESET_OPERATION_COUNT = ATTRIBUTE_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AssociationListDeletionImpl <em>Association List Deletion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AssociationListDeletionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationListDeletion()
	 * @generated
	 */
	int ASSOCIATION_LIST_DELETION = 16;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_DELETION__CHANGE_SET = ASSOCIATION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_DELETION__AFFECTED_ELEMENT = ASSOCIATION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_DELETION__FEATURE = ASSOCIATION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Deleted Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_DELETION__DELETED_ELEMENT = ASSOCIATION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_DELETION__INDEX = ASSOCIATION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association List Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_DELETION_FEATURE_COUNT = ASSOCIATION_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Association List Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_DELETION_OPERATION_COUNT = ASSOCIATION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionListDeletionImpl <em>Composition List Deletion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionListDeletionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionListDeletion()
	 * @generated
	 */
	int COMPOSITION_LIST_DELETION = 17;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_DELETION__CHANGE_SET = COMPOSITION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_DELETION__AFFECTED_ELEMENT = COMPOSITION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_DELETION__FEATURE = COMPOSITION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Deleted Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_DELETION__DELETED_ELEMENT = COMPOSITION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_DELETION__INDEX = COMPOSITION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composition List Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_DELETION_FEATURE_COUNT = COMPOSITION_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composition List Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_DELETION_OPERATION_COUNT = COMPOSITION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AttributeListDeletionImpl <em>Attribute List Deletion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AttributeListDeletionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeListDeletion()
	 * @generated
	 */
	int ATTRIBUTE_LIST_DELETION = 18;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_DELETION__CHANGE_SET = ATTRIBUTE_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_DELETION__AFFECTED_ELEMENT = ATTRIBUTE_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_DELETION__FEATURE = ATTRIBUTE_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Deleted Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_DELETION__DELETED_VALUE = ATTRIBUTE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_DELETION__INDEX = ATTRIBUTE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute List Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_DELETION_FEATURE_COUNT = ATTRIBUTE_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute List Deletion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_DELETION_OPERATION_COUNT = ATTRIBUTE_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AssociationListInsertionImpl <em>Association List Insertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AssociationListInsertionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationListInsertion()
	 * @generated
	 */
	int ASSOCIATION_LIST_INSERTION = 19;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_INSERTION__CHANGE_SET = ASSOCIATION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_INSERTION__AFFECTED_ELEMENT = ASSOCIATION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_INSERTION__FEATURE = ASSOCIATION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Added Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_INSERTION__ADDED_ELEMENT = ASSOCIATION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_INSERTION__INDEX = ASSOCIATION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association List Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_INSERTION_FEATURE_COUNT = ASSOCIATION_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Association List Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_LIST_INSERTION_OPERATION_COUNT = ASSOCIATION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionListInsertionImpl <em>Composition List Insertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionListInsertionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionListInsertion()
	 * @generated
	 */
	int COMPOSITION_LIST_INSERTION = 20;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_INSERTION__CHANGE_SET = COMPOSITION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_INSERTION__AFFECTED_ELEMENT = COMPOSITION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_INSERTION__FEATURE = COMPOSITION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Added Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_INSERTION__ADDED_ELEMENT = COMPOSITION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_INSERTION__INDEX = COMPOSITION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composition List Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_INSERTION_FEATURE_COUNT = COMPOSITION_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composition List Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_LIST_INSERTION_OPERATION_COUNT = COMPOSITION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AttributeListInsertionImpl <em>Attribute List Insertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AttributeListInsertionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeListInsertion()
	 * @generated
	 */
	int ATTRIBUTE_LIST_INSERTION = 21;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_INSERTION__CHANGE_SET = ATTRIBUTE_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_INSERTION__AFFECTED_ELEMENT = ATTRIBUTE_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_INSERTION__FEATURE = ATTRIBUTE_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Added Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_INSERTION__ADDED_VALUE = ATTRIBUTE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_INSERTION__INDEX = ATTRIBUTE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute List Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_INSERTION_FEATURE_COUNT = ATTRIBUTE_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute List Insertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_LIST_INSERTION_OPERATION_COUNT = ATTRIBUTE_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AttributePropertyChangeImpl <em>Attribute Property Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AttributePropertyChangeImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributePropertyChange()
	 * @generated
	 */
	int ATTRIBUTE_PROPERTY_CHANGE = 22;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPERTY_CHANGE__CHANGE_SET = ATTRIBUTE_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPERTY_CHANGE__AFFECTED_ELEMENT = ATTRIBUTE_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPERTY_CHANGE__FEATURE = ATTRIBUTE_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPERTY_CHANGE__NEW_VALUE = ATTRIBUTE_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPERTY_CHANGE__OLD_VALUE = ATTRIBUTE_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Property Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPERTY_CHANGE_FEATURE_COUNT = ATTRIBUTE_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Property Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_PROPERTY_CHANGE_OPERATION_COUNT = ATTRIBUTE_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AssociationPropertyChangeImpl <em>Association Property Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AssociationPropertyChangeImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationPropertyChange()
	 * @generated
	 */
	int ASSOCIATION_PROPERTY_CHANGE = 23;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_PROPERTY_CHANGE__CHANGE_SET = ASSOCIATION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_PROPERTY_CHANGE__AFFECTED_ELEMENT = ASSOCIATION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_PROPERTY_CHANGE__FEATURE = ASSOCIATION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_PROPERTY_CHANGE__NEW_VALUE = ASSOCIATION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_PROPERTY_CHANGE__OLD_VALUE = ASSOCIATION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Association Property Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_PROPERTY_CHANGE_FEATURE_COUNT = ASSOCIATION_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Association Property Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSOCIATION_PROPERTY_CHANGE_OPERATION_COUNT = ASSOCIATION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionPropertyChangeImpl <em>Composition Property Change</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionPropertyChangeImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionPropertyChange()
	 * @generated
	 */
	int COMPOSITION_PROPERTY_CHANGE = 24;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_PROPERTY_CHANGE__CHANGE_SET = COMPOSITION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_PROPERTY_CHANGE__AFFECTED_ELEMENT = COMPOSITION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_PROPERTY_CHANGE__FEATURE = COMPOSITION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_PROPERTY_CHANGE__NEW_VALUE = COMPOSITION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_PROPERTY_CHANGE__OLD_VALUE = COMPOSITION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Composition Property Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_PROPERTY_CHANGE_FEATURE_COUNT = COMPOSITION_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Composition Property Change</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_PROPERTY_CHANGE_OPERATION_COUNT = COMPOSITION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionMoveIntoPropertyImpl <em>Composition Move Into Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionMoveIntoPropertyImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionMoveIntoProperty()
	 * @generated
	 */
	int COMPOSITION_MOVE_INTO_PROPERTY = 25;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_INTO_PROPERTY__CHANGE_SET = COMPOSITION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_INTO_PROPERTY__AFFECTED_ELEMENT = COMPOSITION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_INTO_PROPERTY__FEATURE = COMPOSITION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>New Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_INTO_PROPERTY__NEW_VALUE = COMPOSITION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Old Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_INTO_PROPERTY__OLD_VALUE = COMPOSITION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_INTO_PROPERTY__ORIGIN = COMPOSITION_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composition Move Into Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_INTO_PROPERTY_FEATURE_COUNT = COMPOSITION_CHANGE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Composition Move Into Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_INTO_PROPERTY_OPERATION_COUNT = COMPOSITION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionMoveToListImpl <em>Composition Move To List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionMoveToListImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionMoveToList()
	 * @generated
	 */
	int COMPOSITION_MOVE_TO_LIST = 26;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_LIST__CHANGE_SET = COMPOSITION_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_LIST__AFFECTED_ELEMENT = COMPOSITION_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_LIST__FEATURE = COMPOSITION_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_LIST__INDEX = COMPOSITION_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Moved Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_LIST__MOVED_ELEMENT = COMPOSITION_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_LIST__ORIGIN = COMPOSITION_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Composition Move To List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_LIST_FEATURE_COUNT = COMPOSITION_CHANGE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Composition Move To List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_LIST_OPERATION_COUNT = COMPOSITION_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.CompositionMoveToCollectionImpl <em>Composition Move To Collection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.CompositionMoveToCollectionImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionMoveToCollection()
	 * @generated
	 */
	int COMPOSITION_MOVE_TO_COLLECTION = 27;

	/**
	 * The feature id for the '<em><b>Moved Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_COLLECTION__MOVED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_COLLECTION__ORIGIN = 1;

	/**
	 * The number of structural features of the '<em>Composition Move To Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_COLLECTION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Composition Move To Collection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITION_MOVE_TO_COLLECTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.OperationCallImpl <em>Operation Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.OperationCallImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getOperationCall()
	 * @generated
	 */
	int OPERATION_CALL = 28;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL__CHANGE_SET = MODEL_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL__OPERATION = MODEL_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL__TARGET_ELEMENT = MODEL_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL__ARGUMENTS = MODEL_CHANGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_FEATURE_COUNT = MODEL_CHANGE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Operation Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_OPERATION_COUNT = MODEL_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.OperationArgumentImpl <em>Operation Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.OperationArgumentImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getOperationArgument()
	 * @generated
	 */
	int OPERATION_ARGUMENT = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ARGUMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Operation Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ARGUMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Operation Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_ARGUMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.ValueArgumentImpl <em>Value Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.ValueArgumentImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getValueArgument()
	 * @generated
	 */
	int VALUE_ARGUMENT = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ARGUMENT__NAME = OPERATION_ARGUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ARGUMENT__VALUE = OPERATION_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Value Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ARGUMENT_FEATURE_COUNT = OPERATION_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Value Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ARGUMENT_OPERATION_COUNT = OPERATION_ARGUMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.ReferenceArgumentImpl <em>Reference Argument</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.ReferenceArgumentImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getReferenceArgument()
	 * @generated
	 */
	int REFERENCE_ARGUMENT = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ARGUMENT__NAME = OPERATION_ARGUMENT__NAME;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ARGUMENT__VALUE = OPERATION_ARGUMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Reference Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ARGUMENT_FEATURE_COUNT = OPERATION_ARGUMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Reference Argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_ARGUMENT_OPERATION_COUNT = OPERATION_ARGUMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.AddToRootImpl <em>Add To Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.AddToRootImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getAddToRoot()
	 * @generated
	 */
	int ADD_TO_ROOT = 32;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TO_ROOT__CHANGE_SET = ELEMENTARY_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TO_ROOT__AFFECTED_ELEMENT = ELEMENTARY_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TO_ROOT__FEATURE = ELEMENTARY_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>New Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TO_ROOT__NEW_OBJECT = ELEMENTARY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Add To Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TO_ROOT_FEATURE_COUNT = ELEMENTARY_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Add To Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_TO_ROOT_OPERATION_COUNT = ELEMENTARY_CHANGE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.DeleteFromRootImpl <em>Delete From Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.DeleteFromRootImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getDeleteFromRoot()
	 * @generated
	 */
	int DELETE_FROM_ROOT = 33;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FROM_ROOT__CHANGE_SET = ELEMENTARY_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FROM_ROOT__AFFECTED_ELEMENT = ELEMENTARY_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FROM_ROOT__FEATURE = ELEMENTARY_CHANGE__FEATURE;

	/**
	 * The feature id for the '<em><b>Deleted Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FROM_ROOT__DELETED_ELEMENT = ELEMENTARY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delete From Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FROM_ROOT_FEATURE_COUNT = ELEMENTARY_CHANGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delete From Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELETE_FROM_ROOT_OPERATION_COUNT = ELEMENTARY_CHANGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link changes_new.Changes.impl.ReferenceSetNullImpl <em>Reference Set Null</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see changes_new.Changes.impl.ReferenceSetNullImpl
	 * @see changes_new.Changes.impl.ChangesPackageImpl#getReferenceSetNull()
	 * @generated
	 */
	int REFERENCE_SET_NULL = 34;

	/**
	 * The feature id for the '<em><b>Change Set</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SET_NULL__CHANGE_SET = ELEMENTARY_CHANGE__CHANGE_SET;

	/**
	 * The feature id for the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SET_NULL__AFFECTED_ELEMENT = ELEMENTARY_CHANGE__AFFECTED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SET_NULL__FEATURE = ELEMENTARY_CHANGE__FEATURE;

	/**
	 * The number of structural features of the '<em>Reference Set Null</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SET_NULL_FEATURE_COUNT = ELEMENTARY_CHANGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reference Set Null</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REFERENCE_SET_NULL_OPERATION_COUNT = ELEMENTARY_CHANGE_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link changes_new.Changes.ModelChangeSet <em>Model Change Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Change Set</em>'.
	 * @see changes_new.Changes.ModelChangeSet
	 * @generated
	 */
	EClass getModelChangeSet();

	/**
	 * Returns the meta object for the containment reference list '{@link changes_new.Changes.ModelChangeSet#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Changes</em>'.
	 * @see changes_new.Changes.ModelChangeSet#getChanges()
	 * @see #getModelChangeSet()
	 * @generated
	 */
	EReference getModelChangeSet_Changes();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.ModelChange <em>Model Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Change</em>'.
	 * @see changes_new.Changes.ModelChange
	 * @generated
	 */
	EClass getModelChange();

	/**
	 * Returns the meta object for the container reference '{@link changes_new.Changes.ModelChange#getChangeSet <em>Change Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Change Set</em>'.
	 * @see changes_new.Changes.ModelChange#getChangeSet()
	 * @see #getModelChange()
	 * @generated
	 */
	EReference getModelChange_ChangeSet();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.ElementaryChange <em>Elementary Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Elementary Change</em>'.
	 * @see changes_new.Changes.ElementaryChange
	 * @generated
	 */
	EClass getElementaryChange();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.ElementaryChange#getAffectedElement <em>Affected Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Affected Element</em>'.
	 * @see changes_new.Changes.ElementaryChange#getAffectedElement()
	 * @see #getElementaryChange()
	 * @generated
	 */
	EReference getElementaryChange_AffectedElement();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.ElementaryChange#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see changes_new.Changes.ElementaryChange#getFeature()
	 * @see #getElementaryChange()
	 * @generated
	 */
	EReference getElementaryChange_Feature();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.ChangeTransaction <em>Change Transaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Transaction</em>'.
	 * @see changes_new.Changes.ChangeTransaction
	 * @generated
	 */
	EClass getChangeTransaction();

	/**
	 * Returns the meta object for the containment reference '{@link changes_new.Changes.ChangeTransaction#getSourceChange <em>Source Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source Change</em>'.
	 * @see changes_new.Changes.ChangeTransaction#getSourceChange()
	 * @see #getChangeTransaction()
	 * @generated
	 */
	EReference getChangeTransaction_SourceChange();

	/**
	 * Returns the meta object for the containment reference list '{@link changes_new.Changes.ChangeTransaction#getNestedChanges <em>Nested Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nested Changes</em>'.
	 * @see changes_new.Changes.ChangeTransaction#getNestedChanges()
	 * @see #getChangeTransaction()
	 * @generated
	 */
	EReference getChangeTransaction_NestedChanges();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionChange <em>Composition Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition Change</em>'.
	 * @see changes_new.Changes.CompositionChange
	 * @generated
	 */
	EClass getCompositionChange();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AssociationChange <em>Association Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Change</em>'.
	 * @see changes_new.Changes.AssociationChange
	 * @generated
	 */
	EClass getAssociationChange();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AttributeChange <em>Attribute Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Change</em>'.
	 * @see changes_new.Changes.AttributeChange
	 * @generated
	 */
	EClass getAttributeChange();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AssociationCollectionDeletion <em>Association Collection Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Collection Deletion</em>'.
	 * @see changes_new.Changes.AssociationCollectionDeletion
	 * @generated
	 */
	EClass getAssociationCollectionDeletion();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.AssociationCollectionDeletion#getDeletedElement <em>Deleted Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Deleted Element</em>'.
	 * @see changes_new.Changes.AssociationCollectionDeletion#getDeletedElement()
	 * @see #getAssociationCollectionDeletion()
	 * @generated
	 */
	EReference getAssociationCollectionDeletion_DeletedElement();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionCollectionDeletion <em>Composition Collection Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition Collection Deletion</em>'.
	 * @see changes_new.Changes.CompositionCollectionDeletion
	 * @generated
	 */
	EClass getCompositionCollectionDeletion();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.CompositionCollectionDeletion#getDeletedElement <em>Deleted Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Deleted Element</em>'.
	 * @see changes_new.Changes.CompositionCollectionDeletion#getDeletedElement()
	 * @see #getCompositionCollectionDeletion()
	 * @generated
	 */
	EReference getCompositionCollectionDeletion_DeletedElement();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AttributeCollectionDeletion <em>Attribute Collection Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Collection Deletion</em>'.
	 * @see changes_new.Changes.AttributeCollectionDeletion
	 * @generated
	 */
	EClass getAttributeCollectionDeletion();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AttributeCollectionDeletion#getDeletedValue <em>Deleted Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deleted Value</em>'.
	 * @see changes_new.Changes.AttributeCollectionDeletion#getDeletedValue()
	 * @see #getAttributeCollectionDeletion()
	 * @generated
	 */
	EAttribute getAttributeCollectionDeletion_DeletedValue();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AssociationCollectionInsertion <em>Association Collection Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Collection Insertion</em>'.
	 * @see changes_new.Changes.AssociationCollectionInsertion
	 * @generated
	 */
	EClass getAssociationCollectionInsertion();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.AssociationCollectionInsertion#getAddedElement <em>Added Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Added Element</em>'.
	 * @see changes_new.Changes.AssociationCollectionInsertion#getAddedElement()
	 * @see #getAssociationCollectionInsertion()
	 * @generated
	 */
	EReference getAssociationCollectionInsertion_AddedElement();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionCollectionInsertion <em>Composition Collection Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition Collection Insertion</em>'.
	 * @see changes_new.Changes.CompositionCollectionInsertion
	 * @generated
	 */
	EClass getCompositionCollectionInsertion();

	/**
	 * Returns the meta object for the containment reference '{@link changes_new.Changes.CompositionCollectionInsertion#getAddedElement <em>Added Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Added Element</em>'.
	 * @see changes_new.Changes.CompositionCollectionInsertion#getAddedElement()
	 * @see #getCompositionCollectionInsertion()
	 * @generated
	 */
	EReference getCompositionCollectionInsertion_AddedElement();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AttributeCollectionInsertion <em>Attribute Collection Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Collection Insertion</em>'.
	 * @see changes_new.Changes.AttributeCollectionInsertion
	 * @generated
	 */
	EClass getAttributeCollectionInsertion();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AttributeCollectionInsertion#getAddedValue <em>Added Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Added Value</em>'.
	 * @see changes_new.Changes.AttributeCollectionInsertion#getAddedValue()
	 * @see #getAttributeCollectionInsertion()
	 * @generated
	 */
	EAttribute getAttributeCollectionInsertion_AddedValue();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AssociationCollectionReset <em>Association Collection Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Collection Reset</em>'.
	 * @see changes_new.Changes.AssociationCollectionReset
	 * @generated
	 */
	EClass getAssociationCollectionReset();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionCollectionReset <em>Composition Collection Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition Collection Reset</em>'.
	 * @see changes_new.Changes.CompositionCollectionReset
	 * @generated
	 */
	EClass getCompositionCollectionReset();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AttributeCollectionReset <em>Attribute Collection Reset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Collection Reset</em>'.
	 * @see changes_new.Changes.AttributeCollectionReset
	 * @generated
	 */
	EClass getAttributeCollectionReset();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AssociationListDeletion <em>Association List Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association List Deletion</em>'.
	 * @see changes_new.Changes.AssociationListDeletion
	 * @generated
	 */
	EClass getAssociationListDeletion();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.AssociationListDeletion#getDeletedElement <em>Deleted Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Deleted Element</em>'.
	 * @see changes_new.Changes.AssociationListDeletion#getDeletedElement()
	 * @see #getAssociationListDeletion()
	 * @generated
	 */
	EReference getAssociationListDeletion_DeletedElement();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AssociationListDeletion#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see changes_new.Changes.AssociationListDeletion#getIndex()
	 * @see #getAssociationListDeletion()
	 * @generated
	 */
	EAttribute getAssociationListDeletion_Index();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionListDeletion <em>Composition List Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition List Deletion</em>'.
	 * @see changes_new.Changes.CompositionListDeletion
	 * @generated
	 */
	EClass getCompositionListDeletion();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.CompositionListDeletion#getDeletedElement <em>Deleted Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Deleted Element</em>'.
	 * @see changes_new.Changes.CompositionListDeletion#getDeletedElement()
	 * @see #getCompositionListDeletion()
	 * @generated
	 */
	EReference getCompositionListDeletion_DeletedElement();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.CompositionListDeletion#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see changes_new.Changes.CompositionListDeletion#getIndex()
	 * @see #getCompositionListDeletion()
	 * @generated
	 */
	EAttribute getCompositionListDeletion_Index();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AttributeListDeletion <em>Attribute List Deletion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute List Deletion</em>'.
	 * @see changes_new.Changes.AttributeListDeletion
	 * @generated
	 */
	EClass getAttributeListDeletion();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AttributeListDeletion#getDeletedValue <em>Deleted Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Deleted Value</em>'.
	 * @see changes_new.Changes.AttributeListDeletion#getDeletedValue()
	 * @see #getAttributeListDeletion()
	 * @generated
	 */
	EAttribute getAttributeListDeletion_DeletedValue();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AttributeListDeletion#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see changes_new.Changes.AttributeListDeletion#getIndex()
	 * @see #getAttributeListDeletion()
	 * @generated
	 */
	EAttribute getAttributeListDeletion_Index();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AssociationListInsertion <em>Association List Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association List Insertion</em>'.
	 * @see changes_new.Changes.AssociationListInsertion
	 * @generated
	 */
	EClass getAssociationListInsertion();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.AssociationListInsertion#getAddedElement <em>Added Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Added Element</em>'.
	 * @see changes_new.Changes.AssociationListInsertion#getAddedElement()
	 * @see #getAssociationListInsertion()
	 * @generated
	 */
	EReference getAssociationListInsertion_AddedElement();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AssociationListInsertion#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see changes_new.Changes.AssociationListInsertion#getIndex()
	 * @see #getAssociationListInsertion()
	 * @generated
	 */
	EAttribute getAssociationListInsertion_Index();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionListInsertion <em>Composition List Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition List Insertion</em>'.
	 * @see changes_new.Changes.CompositionListInsertion
	 * @generated
	 */
	EClass getCompositionListInsertion();

	/**
	 * Returns the meta object for the containment reference '{@link changes_new.Changes.CompositionListInsertion#getAddedElement <em>Added Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Added Element</em>'.
	 * @see changes_new.Changes.CompositionListInsertion#getAddedElement()
	 * @see #getCompositionListInsertion()
	 * @generated
	 */
	EReference getCompositionListInsertion_AddedElement();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.CompositionListInsertion#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see changes_new.Changes.CompositionListInsertion#getIndex()
	 * @see #getCompositionListInsertion()
	 * @generated
	 */
	EAttribute getCompositionListInsertion_Index();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AttributeListInsertion <em>Attribute List Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute List Insertion</em>'.
	 * @see changes_new.Changes.AttributeListInsertion
	 * @generated
	 */
	EClass getAttributeListInsertion();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AttributeListInsertion#getAddedValue <em>Added Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Added Value</em>'.
	 * @see changes_new.Changes.AttributeListInsertion#getAddedValue()
	 * @see #getAttributeListInsertion()
	 * @generated
	 */
	EAttribute getAttributeListInsertion_AddedValue();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AttributeListInsertion#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see changes_new.Changes.AttributeListInsertion#getIndex()
	 * @see #getAttributeListInsertion()
	 * @generated
	 */
	EAttribute getAttributeListInsertion_Index();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AttributePropertyChange <em>Attribute Property Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Property Change</em>'.
	 * @see changes_new.Changes.AttributePropertyChange
	 * @generated
	 */
	EClass getAttributePropertyChange();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AttributePropertyChange#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New Value</em>'.
	 * @see changes_new.Changes.AttributePropertyChange#getNewValue()
	 * @see #getAttributePropertyChange()
	 * @generated
	 */
	EAttribute getAttributePropertyChange_NewValue();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.AttributePropertyChange#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old Value</em>'.
	 * @see changes_new.Changes.AttributePropertyChange#getOldValue()
	 * @see #getAttributePropertyChange()
	 * @generated
	 */
	EAttribute getAttributePropertyChange_OldValue();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AssociationPropertyChange <em>Association Property Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Association Property Change</em>'.
	 * @see changes_new.Changes.AssociationPropertyChange
	 * @generated
	 */
	EClass getAssociationPropertyChange();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.AssociationPropertyChange#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Value</em>'.
	 * @see changes_new.Changes.AssociationPropertyChange#getNewValue()
	 * @see #getAssociationPropertyChange()
	 * @generated
	 */
	EReference getAssociationPropertyChange_NewValue();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.AssociationPropertyChange#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Value</em>'.
	 * @see changes_new.Changes.AssociationPropertyChange#getOldValue()
	 * @see #getAssociationPropertyChange()
	 * @generated
	 */
	EReference getAssociationPropertyChange_OldValue();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionPropertyChange <em>Composition Property Change</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition Property Change</em>'.
	 * @see changes_new.Changes.CompositionPropertyChange
	 * @generated
	 */
	EClass getCompositionPropertyChange();

	/**
	 * Returns the meta object for the containment reference '{@link changes_new.Changes.CompositionPropertyChange#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Value</em>'.
	 * @see changes_new.Changes.CompositionPropertyChange#getNewValue()
	 * @see #getCompositionPropertyChange()
	 * @generated
	 */
	EReference getCompositionPropertyChange_NewValue();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.CompositionPropertyChange#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Value</em>'.
	 * @see changes_new.Changes.CompositionPropertyChange#getOldValue()
	 * @see #getCompositionPropertyChange()
	 * @generated
	 */
	EReference getCompositionPropertyChange_OldValue();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionMoveIntoProperty <em>Composition Move Into Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition Move Into Property</em>'.
	 * @see changes_new.Changes.CompositionMoveIntoProperty
	 * @generated
	 */
	EClass getCompositionMoveIntoProperty();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.CompositionMoveIntoProperty#getNewValue <em>New Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Value</em>'.
	 * @see changes_new.Changes.CompositionMoveIntoProperty#getNewValue()
	 * @see #getCompositionMoveIntoProperty()
	 * @generated
	 */
	EReference getCompositionMoveIntoProperty_NewValue();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.CompositionMoveIntoProperty#getOldValue <em>Old Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Old Value</em>'.
	 * @see changes_new.Changes.CompositionMoveIntoProperty#getOldValue()
	 * @see #getCompositionMoveIntoProperty()
	 * @generated
	 */
	EReference getCompositionMoveIntoProperty_OldValue();

	/**
	 * Returns the meta object for the containment reference '{@link changes_new.Changes.CompositionMoveIntoProperty#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Origin</em>'.
	 * @see changes_new.Changes.CompositionMoveIntoProperty#getOrigin()
	 * @see #getCompositionMoveIntoProperty()
	 * @generated
	 */
	EReference getCompositionMoveIntoProperty_Origin();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionMoveToList <em>Composition Move To List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition Move To List</em>'.
	 * @see changes_new.Changes.CompositionMoveToList
	 * @generated
	 */
	EClass getCompositionMoveToList();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.CompositionMoveToList#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see changes_new.Changes.CompositionMoveToList#getIndex()
	 * @see #getCompositionMoveToList()
	 * @generated
	 */
	EAttribute getCompositionMoveToList_Index();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.CompositionMoveToList#getMovedElement <em>Moved Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Moved Element</em>'.
	 * @see changes_new.Changes.CompositionMoveToList#getMovedElement()
	 * @see #getCompositionMoveToList()
	 * @generated
	 */
	EReference getCompositionMoveToList_MovedElement();

	/**
	 * Returns the meta object for the containment reference '{@link changes_new.Changes.CompositionMoveToList#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Origin</em>'.
	 * @see changes_new.Changes.CompositionMoveToList#getOrigin()
	 * @see #getCompositionMoveToList()
	 * @generated
	 */
	EReference getCompositionMoveToList_Origin();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.CompositionMoveToCollection <em>Composition Move To Collection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composition Move To Collection</em>'.
	 * @see changes_new.Changes.CompositionMoveToCollection
	 * @generated
	 */
	EClass getCompositionMoveToCollection();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.CompositionMoveToCollection#getMovedElement <em>Moved Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Moved Element</em>'.
	 * @see changes_new.Changes.CompositionMoveToCollection#getMovedElement()
	 * @see #getCompositionMoveToCollection()
	 * @generated
	 */
	EReference getCompositionMoveToCollection_MovedElement();

	/**
	 * Returns the meta object for the containment reference '{@link changes_new.Changes.CompositionMoveToCollection#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Origin</em>'.
	 * @see changes_new.Changes.CompositionMoveToCollection#getOrigin()
	 * @see #getCompositionMoveToCollection()
	 * @generated
	 */
	EReference getCompositionMoveToCollection_Origin();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.OperationCall <em>Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call</em>'.
	 * @see changes_new.Changes.OperationCall
	 * @generated
	 */
	EClass getOperationCall();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.OperationCall#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see changes_new.Changes.OperationCall#getOperation()
	 * @see #getOperationCall()
	 * @generated
	 */
	EReference getOperationCall_Operation();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.OperationCall#getTargetElement <em>Target Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Element</em>'.
	 * @see changes_new.Changes.OperationCall#getTargetElement()
	 * @see #getOperationCall()
	 * @generated
	 */
	EReference getOperationCall_TargetElement();

	/**
	 * Returns the meta object for the containment reference list '{@link changes_new.Changes.OperationCall#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see changes_new.Changes.OperationCall#getArguments()
	 * @see #getOperationCall()
	 * @generated
	 */
	EReference getOperationCall_Arguments();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.OperationArgument <em>Operation Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Argument</em>'.
	 * @see changes_new.Changes.OperationArgument
	 * @generated
	 */
	EClass getOperationArgument();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.OperationArgument#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see changes_new.Changes.OperationArgument#getName()
	 * @see #getOperationArgument()
	 * @generated
	 */
	EAttribute getOperationArgument_Name();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.ValueArgument <em>Value Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Argument</em>'.
	 * @see changes_new.Changes.ValueArgument
	 * @generated
	 */
	EClass getValueArgument();

	/**
	 * Returns the meta object for the attribute '{@link changes_new.Changes.ValueArgument#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see changes_new.Changes.ValueArgument#getValue()
	 * @see #getValueArgument()
	 * @generated
	 */
	EAttribute getValueArgument_Value();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.ReferenceArgument <em>Reference Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Argument</em>'.
	 * @see changes_new.Changes.ReferenceArgument
	 * @generated
	 */
	EClass getReferenceArgument();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.ReferenceArgument#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see changes_new.Changes.ReferenceArgument#getValue()
	 * @see #getReferenceArgument()
	 * @generated
	 */
	EReference getReferenceArgument_Value();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.AddToRoot <em>Add To Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add To Root</em>'.
	 * @see changes_new.Changes.AddToRoot
	 * @generated
	 */
	EClass getAddToRoot();

	/**
	 * Returns the meta object for the containment reference '{@link changes_new.Changes.AddToRoot#getNewObject <em>New Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>New Object</em>'.
	 * @see changes_new.Changes.AddToRoot#getNewObject()
	 * @see #getAddToRoot()
	 * @generated
	 */
	EReference getAddToRoot_NewObject();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.DeleteFromRoot <em>Delete From Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delete From Root</em>'.
	 * @see changes_new.Changes.DeleteFromRoot
	 * @generated
	 */
	EClass getDeleteFromRoot();

	/**
	 * Returns the meta object for the reference '{@link changes_new.Changes.DeleteFromRoot#getDeletedElement <em>Deleted Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Deleted Element</em>'.
	 * @see changes_new.Changes.DeleteFromRoot#getDeletedElement()
	 * @see #getDeleteFromRoot()
	 * @generated
	 */
	EReference getDeleteFromRoot_DeletedElement();

	/**
	 * Returns the meta object for class '{@link changes_new.Changes.ReferenceSetNull <em>Reference Set Null</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reference Set Null</em>'.
	 * @see changes_new.Changes.ReferenceSetNull
	 * @generated
	 */
	EClass getReferenceSetNull();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ChangesFactory getChangesFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.ModelChangeSetImpl <em>Model Change Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.ModelChangeSetImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getModelChangeSet()
		 * @generated
		 */
		EClass MODEL_CHANGE_SET = eINSTANCE.getModelChangeSet();

		/**
		 * The meta object literal for the '<em><b>Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CHANGE_SET__CHANGES = eINSTANCE.getModelChangeSet_Changes();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.ModelChangeImpl <em>Model Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.ModelChangeImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getModelChange()
		 * @generated
		 */
		EClass MODEL_CHANGE = eINSTANCE.getModelChange();

		/**
		 * The meta object literal for the '<em><b>Change Set</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_CHANGE__CHANGE_SET = eINSTANCE.getModelChange_ChangeSet();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.ElementaryChangeImpl <em>Elementary Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.ElementaryChangeImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getElementaryChange()
		 * @generated
		 */
		EClass ELEMENTARY_CHANGE = eINSTANCE.getElementaryChange();

		/**
		 * The meta object literal for the '<em><b>Affected Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENTARY_CHANGE__AFFECTED_ELEMENT = eINSTANCE.getElementaryChange_AffectedElement();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENTARY_CHANGE__FEATURE = eINSTANCE.getElementaryChange_Feature();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.ChangeTransactionImpl <em>Change Transaction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.ChangeTransactionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getChangeTransaction()
		 * @generated
		 */
		EClass CHANGE_TRANSACTION = eINSTANCE.getChangeTransaction();

		/**
		 * The meta object literal for the '<em><b>Source Change</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_TRANSACTION__SOURCE_CHANGE = eINSTANCE.getChangeTransaction_SourceChange();

		/**
		 * The meta object literal for the '<em><b>Nested Changes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_TRANSACTION__NESTED_CHANGES = eINSTANCE.getChangeTransaction_NestedChanges();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionChangeImpl <em>Composition Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionChangeImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionChange()
		 * @generated
		 */
		EClass COMPOSITION_CHANGE = eINSTANCE.getCompositionChange();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AssociationChangeImpl <em>Association Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AssociationChangeImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationChange()
		 * @generated
		 */
		EClass ASSOCIATION_CHANGE = eINSTANCE.getAssociationChange();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AttributeChangeImpl <em>Attribute Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AttributeChangeImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeChange()
		 * @generated
		 */
		EClass ATTRIBUTE_CHANGE = eINSTANCE.getAttributeChange();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AssociationCollectionDeletionImpl <em>Association Collection Deletion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AssociationCollectionDeletionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationCollectionDeletion()
		 * @generated
		 */
		EClass ASSOCIATION_COLLECTION_DELETION = eINSTANCE.getAssociationCollectionDeletion();

		/**
		 * The meta object literal for the '<em><b>Deleted Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_COLLECTION_DELETION__DELETED_ELEMENT = eINSTANCE.getAssociationCollectionDeletion_DeletedElement();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionCollectionDeletionImpl <em>Composition Collection Deletion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionCollectionDeletionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionCollectionDeletion()
		 * @generated
		 */
		EClass COMPOSITION_COLLECTION_DELETION = eINSTANCE.getCompositionCollectionDeletion();

		/**
		 * The meta object literal for the '<em><b>Deleted Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_COLLECTION_DELETION__DELETED_ELEMENT = eINSTANCE.getCompositionCollectionDeletion_DeletedElement();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AttributeCollectionDeletionImpl <em>Attribute Collection Deletion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AttributeCollectionDeletionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeCollectionDeletion()
		 * @generated
		 */
		EClass ATTRIBUTE_COLLECTION_DELETION = eINSTANCE.getAttributeCollectionDeletion();

		/**
		 * The meta object literal for the '<em><b>Deleted Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_COLLECTION_DELETION__DELETED_VALUE = eINSTANCE.getAttributeCollectionDeletion_DeletedValue();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AssociationCollectionInsertionImpl <em>Association Collection Insertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AssociationCollectionInsertionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationCollectionInsertion()
		 * @generated
		 */
		EClass ASSOCIATION_COLLECTION_INSERTION = eINSTANCE.getAssociationCollectionInsertion();

		/**
		 * The meta object literal for the '<em><b>Added Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_COLLECTION_INSERTION__ADDED_ELEMENT = eINSTANCE.getAssociationCollectionInsertion_AddedElement();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionCollectionInsertionImpl <em>Composition Collection Insertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionCollectionInsertionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionCollectionInsertion()
		 * @generated
		 */
		EClass COMPOSITION_COLLECTION_INSERTION = eINSTANCE.getCompositionCollectionInsertion();

		/**
		 * The meta object literal for the '<em><b>Added Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_COLLECTION_INSERTION__ADDED_ELEMENT = eINSTANCE.getCompositionCollectionInsertion_AddedElement();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AttributeCollectionInsertionImpl <em>Attribute Collection Insertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AttributeCollectionInsertionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeCollectionInsertion()
		 * @generated
		 */
		EClass ATTRIBUTE_COLLECTION_INSERTION = eINSTANCE.getAttributeCollectionInsertion();

		/**
		 * The meta object literal for the '<em><b>Added Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_COLLECTION_INSERTION__ADDED_VALUE = eINSTANCE.getAttributeCollectionInsertion_AddedValue();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AssociationCollectionResetImpl <em>Association Collection Reset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AssociationCollectionResetImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationCollectionReset()
		 * @generated
		 */
		EClass ASSOCIATION_COLLECTION_RESET = eINSTANCE.getAssociationCollectionReset();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionCollectionResetImpl <em>Composition Collection Reset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionCollectionResetImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionCollectionReset()
		 * @generated
		 */
		EClass COMPOSITION_COLLECTION_RESET = eINSTANCE.getCompositionCollectionReset();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AttributeCollectionResetImpl <em>Attribute Collection Reset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AttributeCollectionResetImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeCollectionReset()
		 * @generated
		 */
		EClass ATTRIBUTE_COLLECTION_RESET = eINSTANCE.getAttributeCollectionReset();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AssociationListDeletionImpl <em>Association List Deletion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AssociationListDeletionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationListDeletion()
		 * @generated
		 */
		EClass ASSOCIATION_LIST_DELETION = eINSTANCE.getAssociationListDeletion();

		/**
		 * The meta object literal for the '<em><b>Deleted Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_LIST_DELETION__DELETED_ELEMENT = eINSTANCE.getAssociationListDeletion_DeletedElement();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_LIST_DELETION__INDEX = eINSTANCE.getAssociationListDeletion_Index();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionListDeletionImpl <em>Composition List Deletion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionListDeletionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionListDeletion()
		 * @generated
		 */
		EClass COMPOSITION_LIST_DELETION = eINSTANCE.getCompositionListDeletion();

		/**
		 * The meta object literal for the '<em><b>Deleted Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_LIST_DELETION__DELETED_ELEMENT = eINSTANCE.getCompositionListDeletion_DeletedElement();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITION_LIST_DELETION__INDEX = eINSTANCE.getCompositionListDeletion_Index();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AttributeListDeletionImpl <em>Attribute List Deletion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AttributeListDeletionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeListDeletion()
		 * @generated
		 */
		EClass ATTRIBUTE_LIST_DELETION = eINSTANCE.getAttributeListDeletion();

		/**
		 * The meta object literal for the '<em><b>Deleted Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_LIST_DELETION__DELETED_VALUE = eINSTANCE.getAttributeListDeletion_DeletedValue();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_LIST_DELETION__INDEX = eINSTANCE.getAttributeListDeletion_Index();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AssociationListInsertionImpl <em>Association List Insertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AssociationListInsertionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationListInsertion()
		 * @generated
		 */
		EClass ASSOCIATION_LIST_INSERTION = eINSTANCE.getAssociationListInsertion();

		/**
		 * The meta object literal for the '<em><b>Added Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_LIST_INSERTION__ADDED_ELEMENT = eINSTANCE.getAssociationListInsertion_AddedElement();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSOCIATION_LIST_INSERTION__INDEX = eINSTANCE.getAssociationListInsertion_Index();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionListInsertionImpl <em>Composition List Insertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionListInsertionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionListInsertion()
		 * @generated
		 */
		EClass COMPOSITION_LIST_INSERTION = eINSTANCE.getCompositionListInsertion();

		/**
		 * The meta object literal for the '<em><b>Added Element</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_LIST_INSERTION__ADDED_ELEMENT = eINSTANCE.getCompositionListInsertion_AddedElement();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITION_LIST_INSERTION__INDEX = eINSTANCE.getCompositionListInsertion_Index();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AttributeListInsertionImpl <em>Attribute List Insertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AttributeListInsertionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributeListInsertion()
		 * @generated
		 */
		EClass ATTRIBUTE_LIST_INSERTION = eINSTANCE.getAttributeListInsertion();

		/**
		 * The meta object literal for the '<em><b>Added Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_LIST_INSERTION__ADDED_VALUE = eINSTANCE.getAttributeListInsertion_AddedValue();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_LIST_INSERTION__INDEX = eINSTANCE.getAttributeListInsertion_Index();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AttributePropertyChangeImpl <em>Attribute Property Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AttributePropertyChangeImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAttributePropertyChange()
		 * @generated
		 */
		EClass ATTRIBUTE_PROPERTY_CHANGE = eINSTANCE.getAttributePropertyChange();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PROPERTY_CHANGE__NEW_VALUE = eINSTANCE.getAttributePropertyChange_NewValue();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_PROPERTY_CHANGE__OLD_VALUE = eINSTANCE.getAttributePropertyChange_OldValue();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AssociationPropertyChangeImpl <em>Association Property Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AssociationPropertyChangeImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAssociationPropertyChange()
		 * @generated
		 */
		EClass ASSOCIATION_PROPERTY_CHANGE = eINSTANCE.getAssociationPropertyChange();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_PROPERTY_CHANGE__NEW_VALUE = eINSTANCE.getAssociationPropertyChange_NewValue();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSOCIATION_PROPERTY_CHANGE__OLD_VALUE = eINSTANCE.getAssociationPropertyChange_OldValue();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionPropertyChangeImpl <em>Composition Property Change</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionPropertyChangeImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionPropertyChange()
		 * @generated
		 */
		EClass COMPOSITION_PROPERTY_CHANGE = eINSTANCE.getCompositionPropertyChange();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_PROPERTY_CHANGE__NEW_VALUE = eINSTANCE.getCompositionPropertyChange_NewValue();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_PROPERTY_CHANGE__OLD_VALUE = eINSTANCE.getCompositionPropertyChange_OldValue();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionMoveIntoPropertyImpl <em>Composition Move Into Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionMoveIntoPropertyImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionMoveIntoProperty()
		 * @generated
		 */
		EClass COMPOSITION_MOVE_INTO_PROPERTY = eINSTANCE.getCompositionMoveIntoProperty();

		/**
		 * The meta object literal for the '<em><b>New Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_MOVE_INTO_PROPERTY__NEW_VALUE = eINSTANCE.getCompositionMoveIntoProperty_NewValue();

		/**
		 * The meta object literal for the '<em><b>Old Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_MOVE_INTO_PROPERTY__OLD_VALUE = eINSTANCE.getCompositionMoveIntoProperty_OldValue();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_MOVE_INTO_PROPERTY__ORIGIN = eINSTANCE.getCompositionMoveIntoProperty_Origin();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionMoveToListImpl <em>Composition Move To List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionMoveToListImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionMoveToList()
		 * @generated
		 */
		EClass COMPOSITION_MOVE_TO_LIST = eINSTANCE.getCompositionMoveToList();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPOSITION_MOVE_TO_LIST__INDEX = eINSTANCE.getCompositionMoveToList_Index();

		/**
		 * The meta object literal for the '<em><b>Moved Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_MOVE_TO_LIST__MOVED_ELEMENT = eINSTANCE.getCompositionMoveToList_MovedElement();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_MOVE_TO_LIST__ORIGIN = eINSTANCE.getCompositionMoveToList_Origin();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.CompositionMoveToCollectionImpl <em>Composition Move To Collection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.CompositionMoveToCollectionImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getCompositionMoveToCollection()
		 * @generated
		 */
		EClass COMPOSITION_MOVE_TO_COLLECTION = eINSTANCE.getCompositionMoveToCollection();

		/**
		 * The meta object literal for the '<em><b>Moved Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_MOVE_TO_COLLECTION__MOVED_ELEMENT = eINSTANCE.getCompositionMoveToCollection_MovedElement();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITION_MOVE_TO_COLLECTION__ORIGIN = eINSTANCE.getCompositionMoveToCollection_Origin();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.OperationCallImpl <em>Operation Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.OperationCallImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getOperationCall()
		 * @generated
		 */
		EClass OPERATION_CALL = eINSTANCE.getOperationCall();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL__OPERATION = eINSTANCE.getOperationCall_Operation();

		/**
		 * The meta object literal for the '<em><b>Target Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL__TARGET_ELEMENT = eINSTANCE.getOperationCall_TargetElement();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL__ARGUMENTS = eINSTANCE.getOperationCall_Arguments();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.OperationArgumentImpl <em>Operation Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.OperationArgumentImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getOperationArgument()
		 * @generated
		 */
		EClass OPERATION_ARGUMENT = eINSTANCE.getOperationArgument();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_ARGUMENT__NAME = eINSTANCE.getOperationArgument_Name();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.ValueArgumentImpl <em>Value Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.ValueArgumentImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getValueArgument()
		 * @generated
		 */
		EClass VALUE_ARGUMENT = eINSTANCE.getValueArgument();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_ARGUMENT__VALUE = eINSTANCE.getValueArgument_Value();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.ReferenceArgumentImpl <em>Reference Argument</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.ReferenceArgumentImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getReferenceArgument()
		 * @generated
		 */
		EClass REFERENCE_ARGUMENT = eINSTANCE.getReferenceArgument();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REFERENCE_ARGUMENT__VALUE = eINSTANCE.getReferenceArgument_Value();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.AddToRootImpl <em>Add To Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.AddToRootImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getAddToRoot()
		 * @generated
		 */
		EClass ADD_TO_ROOT = eINSTANCE.getAddToRoot();

		/**
		 * The meta object literal for the '<em><b>New Object</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_TO_ROOT__NEW_OBJECT = eINSTANCE.getAddToRoot_NewObject();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.DeleteFromRootImpl <em>Delete From Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.DeleteFromRootImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getDeleteFromRoot()
		 * @generated
		 */
		EClass DELETE_FROM_ROOT = eINSTANCE.getDeleteFromRoot();

		/**
		 * The meta object literal for the '<em><b>Deleted Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELETE_FROM_ROOT__DELETED_ELEMENT = eINSTANCE.getDeleteFromRoot_DeletedElement();

		/**
		 * The meta object literal for the '{@link changes_new.Changes.impl.ReferenceSetNullImpl <em>Reference Set Null</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see changes_new.Changes.impl.ReferenceSetNullImpl
		 * @see changes_new.Changes.impl.ChangesPackageImpl#getReferenceSetNull()
		 * @generated
		 */
		EClass REFERENCE_SET_NULL = eINSTANCE.getReferenceSetNull();

	}

} //ChangesPackage
