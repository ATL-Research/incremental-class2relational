/**
 */
package relational_;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object ' <em> <b>Table </b> </em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link relational_.Table#getCol <em>Col </em>} </li>
 *   <li>{@link relational_.Table#getKey <em>Key </em>} </li>
 * </ul>
 *
 * @see relational_.Relational_Package#getTable()
 * @model
 * @generated
 */
public interface Table extends Named {
	/**
	 * Returns the value of the ' <em> <b>Col </b> </em>' containment reference list.
	 * The list contents are of type {@link relational_.Column}.
	 * It is bidirectional and its opposite is '{@link relational_.Column#getOwner <em>Owner </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the ' <em>Col </em>' containment reference list.
	 * @see relational_.Relational_Package#getTable_Col()
	 * @see relational_.Column#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList <Column> getCol();

	/**
	 * Returns the value of the ' <em> <b>Key </b> </em>' reference list.
	 * The list contents are of type {@link relational_.Column}.
	 * It is bidirectional and its opposite is '{@link relational_.Column#getKeyOf <em>Key Of </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the ' <em>Key </em>' reference list.
	 * @see relational_.Relational_Package#getTable_Key()
	 * @see relational_.Column#getKeyOf
	 * @model opposite="keyOf" ordered="false"
	 * @generated
	 */
	EList <Column> getKey();

} // Table
