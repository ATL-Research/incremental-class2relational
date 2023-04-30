/**
 */
package Changes.impl;

import Changes.ChangesPackage;
import Changes.ModelChange;
import Changes.ModelChangeSet;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Change Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link changes_new.Changes.impl.ModelChangeSetImpl#getChanges <em>Changes</em>}</li>
 *   <li>{@link changes_new.Changes.impl.ModelChangeSetImpl#getSourceModel <em>Source Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelChangeSetImpl extends MinimalEObjectImpl.Container implements ModelChangeSet {
	/**
	 * The cached value of the '{@link #getChanges() <em>Changes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelChange> changes;

	/**
	 * The cached value of the '{@link #getSourceModel() <em>Source Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceModel()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelChangeSetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ChangesPackage.Literals.MODEL_CHANGE_SET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelChange> getChanges() {
		if (changes == null) {
			changes = new EObjectContainmentWithInverseEList<ModelChange>(ModelChange.class, this, ChangesPackage.MODEL_CHANGE_SET__CHANGES, ChangesPackage.MODEL_CHANGE__CHANGE_SET);
		}
		return changes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSourceModel() {
		if (sourceModel != null && sourceModel.eIsProxy()) {
			InternalEObject oldSourceModel = (InternalEObject)sourceModel;
			sourceModel = eResolveProxy(oldSourceModel);
			if (sourceModel != oldSourceModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ChangesPackage.MODEL_CHANGE_SET__SOURCE_MODEL, oldSourceModel, sourceModel));
			}
		}
		return sourceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSourceModel() {
		return sourceModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceModel(EObject newSourceModel) {
		EObject oldSourceModel = sourceModel;
		sourceModel = newSourceModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ChangesPackage.MODEL_CHANGE_SET__SOURCE_MODEL, oldSourceModel, sourceModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ChangesPackage.MODEL_CHANGE_SET__CHANGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChanges()).basicAdd(otherEnd, msgs);
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
			case ChangesPackage.MODEL_CHANGE_SET__CHANGES:
				return ((InternalEList<?>)getChanges()).basicRemove(otherEnd, msgs);
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
			case ChangesPackage.MODEL_CHANGE_SET__CHANGES:
				return getChanges();
			case ChangesPackage.MODEL_CHANGE_SET__SOURCE_MODEL:
				if (resolve) return getSourceModel();
				return basicGetSourceModel();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ChangesPackage.MODEL_CHANGE_SET__CHANGES:
				getChanges().clear();
				getChanges().addAll((Collection<? extends ModelChange>)newValue);
				return;
			case ChangesPackage.MODEL_CHANGE_SET__SOURCE_MODEL:
				setSourceModel((EObject)newValue);
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
			case ChangesPackage.MODEL_CHANGE_SET__CHANGES:
				getChanges().clear();
				return;
			case ChangesPackage.MODEL_CHANGE_SET__SOURCE_MODEL:
				setSourceModel((EObject)null);
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
			case ChangesPackage.MODEL_CHANGE_SET__CHANGES:
				return changes != null && !changes.isEmpty();
			case ChangesPackage.MODEL_CHANGE_SET__SOURCE_MODEL:
				return sourceModel != null;
		}
		return super.eIsSet(featureID);
	}

} //ModelChangeSetImpl
