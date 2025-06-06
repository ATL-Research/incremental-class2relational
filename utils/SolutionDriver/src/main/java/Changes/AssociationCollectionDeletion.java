/**
 */
package Changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object ' <em> <b>Association Collection Deletion </b> </em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Changes.AssociationCollectionDeletion#getDeletedElement <em>Deleted Element </em>} </li>
 * </ul>
 *
 * @see Changes.ChangesPackage#getAssociationCollectionDeletion()
 * @model
 * @generated
 */
public interface AssociationCollectionDeletion extends AssociationChange {
	/**
	 * Returns the value of the ' <em> <b>Deleted Element </b> </em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the ' <em>Deleted Element </em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the ' <em>Deleted Element </em>' reference.
	 * @see #setDeletedElement(EObject)
	 * @see Changes.ChangesPackage#getAssociationCollectionDeletion_DeletedElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getDeletedElement();

	/**
	 * Sets the value of the '{@link Changes.AssociationCollectionDeletion#getDeletedElement <em>Deleted Element </em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the ' <em>Deleted Element </em>' reference.
	 * @see #getDeletedElement()
	 * @generated
	 */
	void setDeletedElement(EObject value);

} // AssociationCollectionDeletion
