/**
 */
package Changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete From Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link changes_new.Changes.DeleteFromRoot#getDeletedElement <em>Deleted Element</em>}</li>
 * </ul>
 *
 * @see changes_new.Changes.ChangesPackage#getDeleteFromRoot()
 * @model
 * @generated
 */
public interface DeleteFromRoot extends ElementaryChange {
	/**
	 * Returns the value of the '<em><b>Deleted Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deleted Element</em>' reference.
	 * @see #setDeletedElement(EObject)
	 * @see changes_new.Changes.ChangesPackage#getDeleteFromRoot_DeletedElement()
	 * @model
	 * @generated
	 */
	EObject getDeletedElement();

	/**
	 * Sets the value of the '{@link changes_new.Changes.DeleteFromRoot#getDeletedElement <em>Deleted Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deleted Element</em>' reference.
	 * @see #getDeletedElement()
	 * @generated
	 */
	void setDeletedElement(EObject value);

} // DeleteFromRoot
