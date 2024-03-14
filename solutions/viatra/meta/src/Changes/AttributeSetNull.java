/**
 */
package Changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Set Null</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link changes_new.Changes.AttributeSetNull#getNewValue <em>New Value</em>}</li>
 * </ul>
 *
 * @see changes_new.Changes.ChangesPackage#getAttributeSetNull()
 * @model
 * @generated
 */
public interface AttributeSetNull extends ElementaryChange {
	/**
	 * Returns the value of the '<em><b>New Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' reference.
	 * @see #setNewValue(EObject)
	 * @see changes_new.Changes.ChangesPackage#getAttributeSetNull_NewValue()
	 * @model
	 * @generated
	 */
	EObject getNewValue();

	/**
	 * Sets the value of the '{@link changes_new.Changes.AttributeSetNull#getNewValue <em>New Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' reference.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(EObject value);

} // AttributeSetNull
