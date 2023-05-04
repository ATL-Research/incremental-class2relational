/**
 */
package metamodels.Changes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Elementary Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Changes.ElementaryChange#getAffectedElement <em>Affected Element</em>}</li>
 *   <li>{@link metamodels.Changes.ElementaryChange#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see metamodels.Changes.ChangesPackage#getElementaryChange()
 * @model abstract="true"
 * @generated
 */
public interface ElementaryChange extends ModelChange {
	/**
	 * Returns the value of the '<em><b>Affected Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected Element</em>' reference.
	 * @see #setAffectedElement(EObject)
	 * @see metamodels.Changes.ChangesPackage#getElementaryChange_AffectedElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getAffectedElement();

	/**
	 * Sets the value of the '{@link metamodels.Changes.ElementaryChange#getAffectedElement <em>Affected Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affected Element</em>' reference.
	 * @see #getAffectedElement()
	 * @generated
	 */
	void setAffectedElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see metamodels.Changes.ChangesPackage#getElementaryChange_Feature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link metamodels.Changes.ElementaryChange#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

} // ElementaryChange
