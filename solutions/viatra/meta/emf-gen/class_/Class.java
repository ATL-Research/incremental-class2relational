/**
 */
package class_;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link class_.Class#getAttr <em>Attr</em>}</li>
 * </ul>
 *
 * @see class_.Class_Package#getClass_()
 * @model
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>Attr</b></em>' containment reference list.
	 * The list contents are of type {@link class_.Attribute}.
	 * It is bidirectional and its opposite is '{@link class_.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attr</em>' containment reference list.
	 * @see class_.Class_Package#getClass_Attr()
	 * @see class_.Attribute#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttr();

} // Class
