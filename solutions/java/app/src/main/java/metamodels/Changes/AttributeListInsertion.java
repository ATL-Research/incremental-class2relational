/**
 */
package metamodels.Changes;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute List Insertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Changes.AttributeListInsertion#getAddedValue <em>Added Value</em>}</li>
 *   <li>{@link metamodels.Changes.AttributeListInsertion#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see metamodels.Changes.ChangesPackage#getAttributeListInsertion()
 * @model
 * @generated
 */
public interface AttributeListInsertion extends AttributeChange {
	/**
	 * Returns the value of the '<em><b>Added Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Added Value</em>' attribute.
	 * @see #setAddedValue(String)
	 * @see metamodels.Changes.ChangesPackage#getAttributeListInsertion_AddedValue()
	 * @model required="true"
	 * @generated
	 */
	String getAddedValue();

	/**
	 * Sets the value of the '{@link metamodels.Changes.AttributeListInsertion#getAddedValue <em>Added Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Added Value</em>' attribute.
	 * @see #getAddedValue()
	 * @generated
	 */
	void setAddedValue(String value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see metamodels.Changes.ChangesPackage#getAttributeListInsertion_Index()
	 * @model required="true"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link metamodels.Changes.AttributeListInsertion#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

} // AttributeListInsertion
