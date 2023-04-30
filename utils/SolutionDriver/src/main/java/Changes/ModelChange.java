/**
 */
package Changes;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Change</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link changes_new.Changes.ModelChange#getChangeSet <em>Change Set</em>}</li>
 * </ul>
 *
 * @see changes_new.Changes.ChangesPackage#getModelChange()
 * @model abstract="true"
 * @generated
 */
public interface ModelChange extends EObject {

	/**
	 * Returns the value of the '<em><b>Change Set</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link changes_new.Changes.ModelChangeSet#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Set</em>' container reference.
	 * @see #setChangeSet(ModelChangeSet)
	 * @see changes_new.Changes.ChangesPackage#getModelChange_ChangeSet()
	 * @see changes_new.Changes.ModelChangeSet#getChanges
	 * @model opposite="changes" transient="false"
	 * @generated
	 */
	ModelChangeSet getChangeSet();

	/**
	 * Sets the value of the '{@link changes_new.Changes.ModelChange#getChangeSet <em>Change Set</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Set</em>' container reference.
	 * @see #getChangeSet()
	 * @generated
	 */
	void setChangeSet(ModelChangeSet value);
	
	void apply();
} // ModelChange
