/**
 */
package atl.research.class_.impl;

import atl.research.class_.Attribute;
import atl.research.class_.Class_Package;
import atl.research.class_.Classifier;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object ' <em> <b>Attribute </b> </em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link atl.research.class_.impl.AttributeImpl#getMultiValued <em>Multi Valued </em>} </li>
 *   <li>{@link atl.research.class_.impl.AttributeImpl#getType <em>Type </em>} </li>
 *   <li>{@link atl.research.class_.impl.AttributeImpl#getOwner <em>Owner </em>} </li>
 * </ul>
 *
 * @generated
 */
public class AttributeImpl extends NamedEltImpl implements Attribute {
	/**
	 * The default value of the '{@link #getMultiValued() <em>Multi Valued </em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiValued()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean MULTI_VALUED_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getMultiValued() <em>Multi Valued </em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMultiValued()
	 * @generated
	 * @ordered
	 */
	protected Boolean multiValued = MULTI_VALUED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type </em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Classifier type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Class_Package.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getMultiValued() {
		return multiValued;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMultiValued(Boolean newMultiValued) {
		Boolean oldMultiValued = multiValued;
		multiValued = newMultiValued;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Class_Package.ATTRIBUTE__MULTI_VALUED, oldMultiValued, multiValued));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Classifier getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Classifier)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Class_Package.ATTRIBUTE__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Classifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Classifier newType) {
		Classifier oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Class_Package.ATTRIBUTE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public atl.research.class_.Class getOwner() {
		if (eContainerFeatureID() != Class_Package.ATTRIBUTE__OWNER) return null;
		return (atl.research.class_.Class)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public atl.research.class_.Class basicGetOwner() {
		if (eContainerFeatureID() != Class_Package.ATTRIBUTE__OWNER) return null;
		return (atl.research.class_.Class)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(atl.research.class_.Class newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, Class_Package.ATTRIBUTE__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(atl.research.class_.Class newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != Class_Package.ATTRIBUTE__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, Class_Package.CLASS__ATTR, atl.research.class_.Class.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Class_Package.ATTRIBUTE__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Class_Package.ATTRIBUTE__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((atl.research.class_.Class)otherEnd, msgs);
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
			case Class_Package.ATTRIBUTE__OWNER:
				return basicSetOwner(null, msgs);
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
			case Class_Package.ATTRIBUTE__OWNER:
				return eInternalContainer().eInverseRemove(this, Class_Package.CLASS__ATTR, atl.research.class_.Class.class, msgs);
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
			case Class_Package.ATTRIBUTE__MULTI_VALUED:
				return getMultiValued();
			case Class_Package.ATTRIBUTE__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case Class_Package.ATTRIBUTE__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
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
			case Class_Package.ATTRIBUTE__MULTI_VALUED:
				setMultiValued((Boolean)newValue);
				return;
			case Class_Package.ATTRIBUTE__TYPE:
				setType((Classifier)newValue);
				return;
			case Class_Package.ATTRIBUTE__OWNER:
				setOwner((atl.research.class_.Class)newValue);
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
			case Class_Package.ATTRIBUTE__MULTI_VALUED:
				setMultiValued(MULTI_VALUED_EDEFAULT);
				return;
			case Class_Package.ATTRIBUTE__TYPE:
				setType((Classifier)null);
				return;
			case Class_Package.ATTRIBUTE__OWNER:
				setOwner((atl.research.class_.Class)null);
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
			case Class_Package.ATTRIBUTE__MULTI_VALUED:
				return MULTI_VALUED_EDEFAULT == null ? multiValued != null : !MULTI_VALUED_EDEFAULT.equals(multiValued);
			case Class_Package.ATTRIBUTE__TYPE:
				return type != null;
			case Class_Package.ATTRIBUTE__OWNER:
				return basicGetOwner() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (multiValued: ");
		result.append(multiValued);
		result.append(')');
		return result.toString();
	}

} //AttributeImpl
