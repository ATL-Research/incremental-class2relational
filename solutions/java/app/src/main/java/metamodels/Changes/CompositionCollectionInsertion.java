/**
 */
package metamodels.Changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composition Collection Insertion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Changes.CompositionCollectionInsertion#getAddedElement <em>Added Element</em>}</li>
 * </ul>
 *
 * @see metamodels.Changes.ChangesPackage#getCompositionCollectionInsertion()
 * @model
 * @generated
 */
public interface CompositionCollectionInsertion extends CompositionChange {
	/**
	 * Returns the value of the '<em><b>Added Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Added Element</em>' containment reference.
	 * @see #setAddedElement(EObject)
	 * @see metamodels.Changes.ChangesPackage#getCompositionCollectionInsertion_AddedElement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EObject getAddedElement();

	/**
	 * Sets the value of the '{@link metamodels.Changes.CompositionCollectionInsertion#getAddedElement <em>Added Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Added Element</em>' containment reference.
	 * @see #getAddedElement()
	 * @generated
	 */
	void setAddedElement(EObject value);

} // CompositionCollectionInsertion
