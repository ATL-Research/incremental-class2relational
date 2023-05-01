/**
 */
package Changes.impl;

import Changes.ChangesPackage;
import Changes.ReferenceSetNull;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reference Set Null</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class ReferenceSetNullImpl extends ElementaryChangeImpl implements ReferenceSetNull {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReferenceSetNullImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangesPackage.Literals.REFERENCE_SET_NULL;
	}

	@Override
	public void apply() {
//		Object featSetToNull = 
				getAffectedElement().eSet(feature, null);
//		featSetToNull  = null;
	}

} //ReferenceSetNullImpl
