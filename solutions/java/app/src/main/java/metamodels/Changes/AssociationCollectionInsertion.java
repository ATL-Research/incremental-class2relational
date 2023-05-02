/**
 */
package metamodels.Changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Collection Insertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Changes.AssociationCollectionInsertion#getAddedElement <em>Added Element</em>}</li>
 * </ul>
 *
 * @see metamodels.Changes.ChangesPackage#getAssociationCollectionInsertion()
 * @model
 * @generated
 */
public interface AssociationCollectionInsertion extends AssociationChange {
	/**
	 * Returns the value of the '<em><b>Added Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Added Element</em>' reference.
	 * @see #setAddedElement(EObject)
	 * @see metamodels.Changes.ChangesPackage#getAssociationCollectionInsertion_AddedElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getAddedElement();

	/**
	 * Sets the value of the '{@link metamodels.Changes.AssociationCollectionInsertion#getAddedElement <em>Added Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Added Element</em>' reference.
	 * @see #getAddedElement()
	 * @generated
	 */
	void setAddedElement(EObject value);

} // AssociationCollectionInsertion
