/**
 */
package Changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Add To Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link changes_new.Changes.AddToRoot#getNewObject <em>New Object</em>}</li>
 * </ul>
 *
 * @see changes_new.Changes.ChangesPackage#getAddToRoot()
 * @model
 * @generated
 */
public interface AddToRoot extends ElementaryChange {
	/**
	 * Returns the value of the '<em><b>New Object</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Object</em>' containment reference.
	 * @see #setNewObject(EObject)
	 * @see changes_new.Changes.ChangesPackage#getAddToRoot_NewObject()
	 * @model containment="true"
	 * @generated
	 */
	EObject getNewObject();

	/**
	 * Sets the value of the '{@link changes_new.Changes.AddToRoot#getNewObject <em>New Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Object</em>' containment reference.
	 * @see #getNewObject()
	 * @generated
	 */
	void setNewObject(EObject value);

} // AddToRoot
