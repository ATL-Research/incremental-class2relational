/**
 */
package metamodels.ClassDiagram.impl;

import metamodels.ClassDiagram.ClassDiagramPackage;
import metamodels.ClassDiagram.Classifier;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Classifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ClassifierImpl extends NamedEltImpl implements Classifier {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassDiagramPackage.Literals.CLASSIFIER;
	}

} //ClassifierImpl
