/**
 */
package Changes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model
 * Change Set</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link Changes.ModelChangeSet#getChanges <em>Changes</em>}</li>
 * </ul>
 *
 * @see Changes.ChangesPackage#getModelChangeSet()
 * @model
 * @generated
 */
public interface ModelChangeSet extends EObject {
	/**
	 * Returns the value of the '<em><b>Changes</b></em>' containment reference
	 * list. The list contents are of type {@link Changes.ModelChange}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Changes</em>' containment reference list.
	 * @see Changes.ChangesPackage#getModelChangeSet_Changes()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelChange> getChanges();

	/**
	 * Returns the value of the '<em><b>Source Model</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source Model</em>' reference.
	 * @see #setSourceModel(EObject)
	 * @see changes_new.Changes.ChangesPackage#getModelChangeSet_SourceModel()
	 * @model
	 * @generated
	 */
	EObject getSourceModel();

	/**
	 * Sets the value of the
	 * '{@link changes_new.Changes.ModelChangeSet#getSourceModel <em>Source
	 * Model</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source Model</em>' reference.
	 * @see #getSourceModel()
	 * @generated
	 */
	void setSourceModel(EObject value);
} // ModelChangeSet
