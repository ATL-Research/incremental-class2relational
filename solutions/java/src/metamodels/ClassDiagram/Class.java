/**
 */
package metamodels.ClassDiagram;

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
 *   <li>{@link metamodels.ClassDiagram.Class#getSuper <em>Super</em>}</li>
 *   <li>{@link metamodels.ClassDiagram.Class#getAttr <em>Attr</em>}</li>
 *   <li>{@link metamodels.ClassDiagram.Class#isIsAbstract <em>Is Abstract</em>}</li>
 * </ul>
 *
 * @see metamodels.ClassDiagram.ClassDiagramPackage#getClass_()
 * @model
 * @generated
 */
public interface Class extends Classifier {
	/**
	 * Returns the value of the '<em><b>Super</b></em>' reference list.
	 * The list contents are of type {@link metamodels.ClassDiagram.Class}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super</em>' reference list.
	 * @see metamodels.ClassDiagram.ClassDiagramPackage#getClass_Super()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Class> getSuper();

	/**
	 * Returns the value of the '<em><b>Attr</b></em>' containment reference list.
	 * The list contents are of type {@link metamodels.ClassDiagram.Attribute}.
	 * It is bidirectional and its opposite is '{@link metamodels.ClassDiagram.Attribute#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attr</em>' containment reference list.
	 * @see metamodels.ClassDiagram.ClassDiagramPackage#getClass_Attr()
	 * @see metamodels.ClassDiagram.Attribute#getOwner
	 * @model opposite="owner" containment="true"
	 * @generated
	 */
	EList<Attribute> getAttr();

	/**
	 * Returns the value of the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Abstract</em>' attribute.
	 * @see #setIsAbstract(boolean)
	 * @see metamodels.ClassDiagram.ClassDiagramPackage#getClass_IsAbstract()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsAbstract();

	/**
	 * Sets the value of the '{@link metamodels.ClassDiagram.Class#isIsAbstract <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Abstract</em>' attribute.
	 * @see #isIsAbstract()
	 * @generated
	 */
	void setIsAbstract(boolean value);

} // Class
