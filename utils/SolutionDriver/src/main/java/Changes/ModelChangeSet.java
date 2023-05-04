/**
 */
package Changes;

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
 *   <li>{@link changes_new.Changes.ModelChangeSet#getChanges <em>Changes</em>}</li>
 * </ul>
 *
 * @see changes_new.Changes.ChangesPackage#getModelChangeSet()
 * @model
 * @generated
 */
public interface ModelChangeSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Changes</b></em>' containment reference list.
	 * The list contents are of type {@link changes_new.Changes.ModelChange}.
	 * It is bidirectional and its opposite is '{@link changes_new.Changes.ModelChange#getChangeSet <em>Change Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Changes</em>' containment reference list.
	 * @see changes_new.Changes.ChangesPackage#getModelChangeSet_Changes()
	 * @see changes_new.Changes.ModelChange#getChangeSet
	 * @model opposite="changeSet" containment="true"
	 * @generated
	 */
	EList<ModelChange> getChanges();

} // ModelChangeSet
