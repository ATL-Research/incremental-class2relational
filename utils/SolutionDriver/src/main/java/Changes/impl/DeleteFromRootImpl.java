/**
 */
package Changes.impl;

import Changes.ChangesPackage;
import Changes.DeleteFromRoot;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete From Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link changes_new.Changes.impl.DeleteFromRootImpl#getDeletedElement <em>Deleted Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeleteFromRootImpl extends ElementaryChangeImpl implements DeleteFromRoot {
	/**
	 * The cached value of the '{@link #getDeletedElement() <em>Deleted Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeletedElement()
	 * @generated
	 * @ordered
	 */
	protected EObject deletedElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteFromRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangesPackage.Literals.DELETE_FROM_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getDeletedElement() {
		if (deletedElement != null && deletedElement.eIsProxy()) {
			InternalEObject oldDeletedElement = (InternalEObject)deletedElement;
			deletedElement = eResolveProxy(oldDeletedElement);
			if (deletedElement != oldDeletedElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ChangesPackage.DELETE_FROM_ROOT__DELETED_ELEMENT, oldDeletedElement, deletedElement));
			}
		}
		return deletedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetDeletedElement() {
		return deletedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeletedElement(EObject newDeletedElement) {
		EObject oldDeletedElement = deletedElement;
		deletedElement = newDeletedElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangesPackage.DELETE_FROM_ROOT__DELETED_ELEMENT, oldDeletedElement, deletedElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ChangesPackage.DELETE_FROM_ROOT__DELETED_ELEMENT:
				if (resolve) return getDeletedElement();
				return basicGetDeletedElement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ChangesPackage.DELETE_FROM_ROOT__DELETED_ELEMENT:
				setDeletedElement((EObject)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ChangesPackage.DELETE_FROM_ROOT__DELETED_ELEMENT:
				setDeletedElement((EObject)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ChangesPackage.DELETE_FROM_ROOT__DELETED_ELEMENT:
				return deletedElement != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void apply() {
		Resource sourceModel = deletedElement.eResource();
		if (sourceModel != null) {
			List<EObject> contents = sourceModel.getContents();
			
			if (contents != null && contents.size() > 0) {
				EcoreUtil.delete(deletedElement, true);
			}
		}
	}

} //DeleteFromRootImpl
