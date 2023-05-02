/**
 */
package metamodels.Changes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Property Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Changes.AttributePropertyChange#getNewValue <em>New Value</em>}</li>
 *   <li>{@link metamodels.Changes.AttributePropertyChange#getOldValue <em>Old Value</em>}</li>
 * </ul>
 *
 * @see metamodels.Changes.ChangesPackage#getAttributePropertyChange()
 * @model
 * @generated
 */
public interface AttributePropertyChange extends AttributeChange {
	/**
	 * Returns the value of the '<em><b>New Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Value</em>' attribute.
	 * @see #setNewValue(String)
	 * @see metamodels.Changes.ChangesPackage#getAttributePropertyChange_NewValue()
	 * @model
	 * @generated
	 */
	String getNewValue();

	/**
	 * Sets the value of the '{@link metamodels.Changes.AttributePropertyChange#getNewValue <em>New Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Value</em>' attribute.
	 * @see #getNewValue()
	 * @generated
	 */
	void setNewValue(String value);

	/**
	 * Returns the value of the '<em><b>Old Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Old Value</em>' attribute.
	 * @see #setOldValue(String)
	 * @see metamodels.Changes.ChangesPackage#getAttributePropertyChange_OldValue()
	 * @model
	 * @generated
	 */
	String getOldValue();

	/**
	 * Sets the value of the '{@link metamodels.Changes.AttributePropertyChange#getOldValue <em>Old Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Old Value</em>' attribute.
	 * @see #getOldValue()
	 * @generated
	 */
	void setOldValue(String value);

} // AttributePropertyChange
