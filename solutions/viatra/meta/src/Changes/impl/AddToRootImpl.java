/**
 */
package Changes.impl;

import Changes.AddToRoot;
import Changes.ChangesPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add To Root</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link changes_new.Changes.impl.AddToRootImpl#getNewObject <em>New Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddToRootImpl extends ElementaryChangeImpl implements AddToRoot {
	/**
	 * The cached value of the '{@link #getNewObject() <em>New Object</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewObject()
	 * @generated
	 * @ordered
	 */
	protected EObject newObject;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddToRootImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangesPackage.Literals.ADD_TO_ROOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getNewObject() {
		return newObject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewObject(EObject newNewObject, NotificationChain msgs) {
		EObject oldNewObject = newObject;
		newObject = newNewObject;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ChangesPackage.ADD_TO_ROOT__NEW_OBJECT, oldNewObject, newNewObject);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewObject(EObject newNewObject) {
		if (newNewObject != newObject) {
			NotificationChain msgs = null;
			if (newObject != null)
				msgs = ((InternalEObject)newObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ChangesPackage.ADD_TO_ROOT__NEW_OBJECT, null, msgs);
			if (newNewObject != null)
				msgs = ((InternalEObject)newNewObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ChangesPackage.ADD_TO_ROOT__NEW_OBJECT, null, msgs);
			msgs = basicSetNewObject(newNewObject, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangesPackage.ADD_TO_ROOT__NEW_OBJECT, newNewObject, newNewObject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ChangesPackage.ADD_TO_ROOT__NEW_OBJECT:
				return basicSetNewObject(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ChangesPackage.ADD_TO_ROOT__NEW_OBJECT:
				return getNewObject();
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
			case ChangesPackage.ADD_TO_ROOT__NEW_OBJECT:
				setNewObject((EObject)newValue);
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
			case ChangesPackage.ADD_TO_ROOT__NEW_OBJECT:
				setNewObject((EObject)null);
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
			case ChangesPackage.ADD_TO_ROOT__NEW_OBJECT:
				return newObject != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public void apply() {
		Resource srcModel = getAffectedElement().eResource();
		if( srcModel != null)
			srcModel.getContents().add(newObject); 
	}

} //AddToRootImpl
