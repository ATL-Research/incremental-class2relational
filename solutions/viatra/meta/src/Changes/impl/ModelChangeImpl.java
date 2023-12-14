/**
 */
package Changes.impl;

import Changes.ChangesPackage;
import Changes.ModelChange;

import Changes.ModelChangeSet;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Changes.impl.ModelChangeImpl#getChangeSet <em>Change Set</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ModelChangeImpl extends MinimalEObjectImpl.Container implements ModelChange {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelChangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangesPackage.Literals.MODEL_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelChangeSet getChangeSet() {
		if (eContainerFeatureID() != ChangesPackage.MODEL_CHANGE__CHANGE_SET) return null;
		return (ModelChangeSet)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetChangeSet(ModelChangeSet newChangeSet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newChangeSet, ChangesPackage.MODEL_CHANGE__CHANGE_SET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeSet(ModelChangeSet newChangeSet) {
		if (newChangeSet != eInternalContainer() || (eContainerFeatureID() != ChangesPackage.MODEL_CHANGE__CHANGE_SET && newChangeSet != null)) {
			if (EcoreUtil.isAncestor(this, newChangeSet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newChangeSet != null)
				msgs = ((InternalEObject)newChangeSet).eInverseAdd(this, ChangesPackage.MODEL_CHANGE_SET__CHANGES, ModelChangeSet.class, msgs);
			msgs = basicSetChangeSet(newChangeSet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangesPackage.MODEL_CHANGE__CHANGE_SET, newChangeSet, newChangeSet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ChangesPackage.MODEL_CHANGE__CHANGE_SET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetChangeSet((ModelChangeSet)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ChangesPackage.MODEL_CHANGE__CHANGE_SET:
				return basicSetChangeSet(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ChangesPackage.MODEL_CHANGE__CHANGE_SET:
				return eInternalContainer().eInverseRemove(this, ChangesPackage.MODEL_CHANGE_SET__CHANGES, ModelChangeSet.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ChangesPackage.MODEL_CHANGE__CHANGE_SET:
				return getChangeSet();
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
			case ChangesPackage.MODEL_CHANGE__CHANGE_SET:
				setChangeSet((ModelChangeSet)newValue);
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
			case ChangesPackage.MODEL_CHANGE__CHANGE_SET:
				setChangeSet((ModelChangeSet)null);
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
			case ChangesPackage.MODEL_CHANGE__CHANGE_SET:
				return getChangeSet() != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelChangeImpl
