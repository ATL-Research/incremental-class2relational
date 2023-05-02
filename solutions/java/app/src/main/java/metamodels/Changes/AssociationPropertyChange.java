/**
 */
package metamodels.Changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Association Property Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Changes.AssociationPropertyChange#getNewValue <em>New Value</em>}</li>
 *   <li>{@link metamodels.Changes.AssociationPropertyChange#getOldValue <em>Old Value</em>}</li>
 * </ul>
 *
 * @see metamodels.Changes.ChangesPackage#getAssociationPropertyChange()
 * @model
 * @generated
 */
public interface AssociationPropertyChange extends AssociationChange {
	/**
	 * Returns the value of the '<em><b>New Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' reference.
	 * @see #setNewValue(EObject)
	 * @see metamodels.Changes.ChangesPackage#getAssociationPropertyChange_NewValue()
	 * @model
	 * @generated
	 */
	EObject getNewValue();

	/**
	 * Sets the value of the '{@link metamodels.Changes.AssociationPropertyChange#getNewValue <em>New Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' reference.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(EObject value);

	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' reference.
	 * @see #setOldValue(EObject)
	 * @see metamodels.Changes.ChangesPackage#getAssociationPropertyChange_OldValue()
	 * @model
	 * @generated
	 */
	EObject getOldValue();

	/**
	 * Sets the value of the '{@link metamodels.Changes.AssociationPropertyChange#getOldValue <em>Old Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value</em>' reference.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(EObject value);

} // AssociationPropertyChange
