/**
 */
package atl.research.relational_;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object ' <em> <b>Column </b> </em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link atl.research.relational_.Column#getOwner <em>Owner </em>} </li>
 *   <li>{@link atl.research.relational_.Column#getKeyOf <em>Key Of </em>} </li>
 *   <li>{@link atl.research.relational_.Column#getType <em>Type </em>} </li>
 * </ul>
 *
 * @see atl.research.relational_.Relational_Package#getColumn()
 * @model
 * @generated
 */
public interface Column extends Named {
	/**
	 * Returns the value of the ' <em> <b>Owner </b> </em>' container reference.
	 * It is bidirectional and its opposite is '{@link atl.research.relational_.Table#getCol <em>Col </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the ' <em>Owner </em>' container reference.
	 * @see #setOwner(Table)
	 * @see atl.research.relational_.Relational_Package#getColumn_Owner()
	 * @see atl.research.relational_.Table#getCol
	 * @model opposite="col" transient="false"
	 * @generated
	 */
	Table getOwner();

	/**
	 * Sets the value of the '{@link atl.research.relational_.Column#getOwner <em>Owner </em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the ' <em>Owner </em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(Table value);

	/**
	 * Returns the value of the ' <em> <b>Key Of </b> </em>' reference.
	 * It is bidirectional and its opposite is '{@link atl.research.relational_.Table#getKey <em>Key </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the ' <em>Key Of </em>' reference.
	 * @see #setKeyOf(Table)
	 * @see atl.research.relational_.Relational_Package#getColumn_KeyOf()
	 * @see atl.research.relational_.Table#getKey
	 * @model opposite="key"
	 * @generated
	 */
	Table getKeyOf();

	/**
	 * Sets the value of the '{@link atl.research.relational_.Column#getKeyOf <em>Key Of </em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the ' <em>Key Of </em>' reference.
	 * @see #getKeyOf()
	 * @generated
	 */
	void setKeyOf(Table value);

	/**
	 * Returns the value of the ' <em> <b>Type </b> </em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the ' <em>Type </em>' reference.
	 * @see #setType(Type)
	 * @see atl.research.relational_.Relational_Package#getColumn_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link atl.research.relational_.Column#getType <em>Type </em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the ' <em>Type </em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // Column
