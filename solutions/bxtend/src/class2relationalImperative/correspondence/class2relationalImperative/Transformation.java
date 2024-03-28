/**
 */
package class2relationalImperative.correspondence.class2relationalImperative;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link class2relationalImperative.correspondence.class2relationalImperative.Transformation#getCorrespondences <em>Correspondences</em>}</li>
 * </ul>
 *
 * @see class2relationalImperative.correspondence.class2relationalImperative.Class2relationalImperativePackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends EObject {
	/**
	 * Returns the value of the '<em><b>Correspondences</b></em>' containment reference list.
	 * The list contents are of type {@link class2relationalImperative.correspondence.class2relationalImperative.Corr}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Correspondences</em>' containment reference list.
	 * @see class2relationalImperative.correspondence.class2relationalImperative.Class2relationalImperativePackage#getTransformation_Correspondences()
	 * @model containment="true"
	 * @generated
	 */
	EList<Corr> getCorrespondences();

} // Transformation
