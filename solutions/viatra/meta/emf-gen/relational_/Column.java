/**
 */
package relational_;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link relational_.Column#getOwner <em>Owner</em>}</li>
 *   <li>{@link relational_.Column#getKeyOf <em>Key Of</em>}</li>
 *   <li>{@link relational_.Column#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see relational_.Relational_Package#getColumn()
 * @model
 * @generated
 */
public interface Column extends Named {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link relational_.Table#getCol <em>Col</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(Table)
	 * @see relational_.Relational_Package#getColumn_Owner()
	 * @see relational_.Table#getCol
	 * @model opposite="col" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link relational_.Column#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

	/**
	 * Returns the value of the '<em><b>Key Of</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link relational_.Table#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key Of</em>' reference.
	 * @see #setKeyOf(Table)
	 * @see relational_.Relational_Package#getColumn_KeyOf()
	 * @see relational_.Table#getKey
	 * @model opposite="key" ordered="false"
	 * @generated
	 */
	Table getKeyOf();

	/**
	 * Sets the value of the '{@link relational_.Column#getKeyOf <em>Key Of</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key Of</em>' reference.
	 * @see #getKeyOf()
	 * @generated
	 */
	void setKeyOf(Table value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see relational_.Relational_Package#getColumn_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link relational_.Column#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // Column
