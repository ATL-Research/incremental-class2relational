/**
 */
package metamodels.Relational;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Relational.Table#getCol <em>Col</em>}</li>
 *   <li>{@link metamodels.Relational.Table#getKey <em>Key</em>}</li>
 * </ul>
 *
 * @see metamodels.Relational.RelationalPackage#getTable()
 * @model
 * @generated
 */
public interface Table extends Named {
	/**
	 * Returns the value of the '<em><b>Col</b></em>' containment reference list.
	 * The list contents are of type {@link metamodels.Relational.Column}.
	 * It is bidirectional and its opposite is '{@link metamodels.Relational.Column#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Col</em>' containment reference list.
	 * @see metamodels.Relational.RelationalPackage#getTable_Col()
	 * @see metamodels.Relational.Column#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Column> getCol();

	/**
	 * Returns the value of the '<em><b>Key</b></em>' reference list.
	 * The list contents are of type {@link metamodels.Relational.Column}.
	 * It is bidirectional and its opposite is '{@link metamodels.Relational.Column#getKeyOf <em>Key Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' reference list.
	 * @see metamodels.Relational.RelationalPackage#getTable_Key()
	 * @see metamodels.Relational.Column#getKeyOf
	 * @model opposite="keyOf" ordered="false"
	 * @generated
	 */
	EList<Column> getKey();

} // Table
