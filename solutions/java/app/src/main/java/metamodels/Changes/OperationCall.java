/**
 */
package metamodels.Changes;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link metamodels.Changes.OperationCall#getOperation <em>Operation</em>}</li>
 *   <li>{@link metamodels.Changes.OperationCall#getTargetElement <em>Target Element</em>}</li>
 *   <li>{@link metamodels.Changes.OperationCall#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see metamodels.Changes.ChangesPackage#getOperationCall()
 * @model
 * @generated
 */
public interface OperationCall extends ModelChange {
	/**
	 * Returns the value of the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' reference.
	 * @see #setOperation(EOperation)
	 * @see metamodels.Changes.ChangesPackage#getOperationCall_Operation()
	 * @model required="true"
	 * @generated
	 */
	EOperation getOperation();

	/**
	 * Sets the value of the '{@link metamodels.Changes.OperationCall#getOperation <em>Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' reference.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(EOperation value);

	/**
	 * Returns the value of the '<em><b>Target Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Element</em>' reference.
	 * @see #setTargetElement(EObject)
	 * @see metamodels.Changes.ChangesPackage#getOperationCall_TargetElement()
	 * @model
	 * @generated
	 */
	EObject getTargetElement();

	/**
	 * Sets the value of the '{@link metamodels.Changes.OperationCall#getTargetElement <em>Target Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Element</em>' reference.
	 * @see #getTargetElement()
	 * @generated
	 */
	void setTargetElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link metamodels.Changes.OperationArgument}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see metamodels.Changes.ChangesPackage#getOperationCall_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<OperationArgument> getArguments();

} // OperationCall
