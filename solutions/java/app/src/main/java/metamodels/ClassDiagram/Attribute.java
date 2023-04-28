/**
 */
package metamodels.ClassDiagram;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.ClassDiagram.Attribute#isMultiValued <em>Multi Valued</em>}</li>
 *   <li>{@link metamodels.ClassDiagram.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link metamodels.ClassDiagram.Attribute#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see metamodels.ClassDiagram.ClassDiagramPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends NamedElt {
	/**
	 * Returns the value of the '<em><b>Multi Valued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multi Valued</em>' attribute.
	 * @see #setMultiValued(boolean)
	 * @see metamodels.ClassDiagram.ClassDiagramPackage#getAttribute_MultiValued()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isMultiValued();

	/**
	 * Sets the value of the '{@link metamodels.ClassDiagram.Attribute#isMultiValued <em>Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Multi Valued</em>' attribute.
	 * @see #isMultiValued()
	 * @generated
	 */
	void setMultiValued(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Classifier)
	 * @see metamodels.ClassDiagram.ClassDiagramPackage#getAttribute_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Classifier getType();

	/**
	 * Sets the value of the '{@link metamodels.ClassDiagram.Attribute#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Classifier value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link metamodels.ClassDiagram.Class#getAttr <em>Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(metamodels.ClassDiagram.Class)
	 * @see metamodels.ClassDiagram.ClassDiagramPackage#getAttribute_Owner()
	 * @see metamodels.ClassDiagram.Class#getAttr
	 * @model opposite="attr" required="true" transient="false" ordered="false"
	 * @generated
	 */
	metamodels.ClassDiagram.Class getOwner();

	/**
	 * Sets the value of the '{@link metamodels.ClassDiagram.Attribute#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(metamodels.ClassDiagram.Class value);

} // Attribute
