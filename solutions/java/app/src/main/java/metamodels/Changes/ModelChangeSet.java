/**
 */
package metamodels.Changes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Change Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Changes.ModelChangeSet#getChanges <em>Changes</em>}</li>
 * </ul>
 *
 * @see metamodels.Changes.ChangesPackage#getModelChangeSet()
 * @model
 * @generated
 */
public interface ModelChangeSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Changes</b></em>' containment reference list.
	 * The list contents are of type {@link metamodels.Changes.ModelChange}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changes</em>' containment reference list.
	 * @see metamodels.Changes.ChangesPackage#getModelChangeSet_Changes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelChange> getChanges();

} // ModelChangeSet
