/**
 */
package metamodels.Changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composition List Insertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Changes.CompositionListInsertion#getAddedElement <em>Added Element</em>}</li>
 *   <li>{@link metamodels.Changes.CompositionListInsertion#getIndex <em>Index</em>}</li>
 * </ul>
 *
 * @see metamodels.Changes.ChangesPackage#getCompositionListInsertion()
 * @model
 * @generated
 */
public interface CompositionListInsertion extends CompositionChange {
	/**
	 * Returns the value of the '<em><b>Added Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Added Element</em>' containment reference.
	 * @see #setAddedElement(EObject)
	 * @see metamodels.Changes.ChangesPackage#getCompositionListInsertion_AddedElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EObject getAddedElement();

	/**
	 * Sets the value of the '{@link metamodels.Changes.CompositionListInsertion#getAddedElement <em>Added Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Added Element</em>' containment reference.
	 * @see #getAddedElement()
	 * @generated
	 */
	void setAddedElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Index</em>' attribute.
	 * @see #setIndex(int)
	 * @see metamodels.Changes.ChangesPackage#getCompositionListInsertion_Index()
	 * @model required="true"
	 * @generated
	 */
	int getIndex();

	/**
	 * Sets the value of the '{@link metamodels.Changes.CompositionListInsertion#getIndex <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Index</em>' attribute.
	 * @see #getIndex()
	 * @generated
	 */
	void setIndex(int value);

} // CompositionListInsertion
