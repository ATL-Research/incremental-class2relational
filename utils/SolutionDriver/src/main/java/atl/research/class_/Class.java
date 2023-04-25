/**
 */
package atl.research.class_;

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
 *   <li>{@link atl.research.class_.Class#getAttr <em>Attr</em>}</li>
 * </ul>
 *
 * @see atl.research.class_.Class_Package#getClass_()
 * @model
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>Attr</b></em>' containment reference list.
	 * The list contents are of type {@link atl.research.class_.Attribute}.
	 * It is bidirectional and its opposite is '{@link atl.research.class_.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attr</em>' containment reference list.
	 * @see atl.research.class_.Class_Package#getClass_Attr()
	 * @see atl.research.class_.Attribute#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttr();

} // Class
