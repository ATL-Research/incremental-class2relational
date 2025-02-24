/**
 */
package atl.research.relational_;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object ' <em> <b>Named </b> </em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link atl.research.relational_.Named#getName <em>Name </em>} </li>
 * </ul>
 *
 * @see atl.research.relational_.Relational_Package#getNamed()
 * @model abstract="true"
 * @generated
 */
public interface Named extends EObject {
	/**
	 * Returns the value of the ' <em> <b>Name </b> </em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the ' <em>Name </em>' attribute.
	 * @see #setName(String)
	 * @see atl.research.relational_.Relational_Package#getNamed_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link atl.research.relational_.Named#getName <em>Name </em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the ' <em>Name </em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Named
