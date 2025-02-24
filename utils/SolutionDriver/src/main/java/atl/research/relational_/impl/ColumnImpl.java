/**
 */
package atl.research.relational_.impl;

import atl.research.relational_.Column;
import atl.research.relational_.Relational_Package;
import atl.research.relational_.Table;
import atl.research.relational_.Type;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object ' <em> <b>Column </b> </em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link atl.research.relational_.impl.ColumnImpl#getOwner <em>Owner </em>} </li>
 *   <li>{@link atl.research.relational_.impl.ColumnImpl#getKeyOf <em>Key Of </em>} </li>
 *   <li>{@link atl.research.relational_.impl.ColumnImpl#getType <em>Type </em>} </li>
 * </ul>
 *
 * @generated
 */
public class ColumnImpl extends NamedImpl implements Column {
	/**
	 * The cached value of the '{@link #getKeyOf() <em>Key Of </em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyOf()
	 * @generated
	 * @ordered
	 */
	protected Table keyOf;

	/**
	 * The cached value of the '{@link #getType() <em>Type </em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColumnImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Relational_Package.Literals.COLUMN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getOwner() {
		if (eContainerFeatureID() != Relational_Package.COLUMN__OWNER) return null;
		return (Table)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetOwner() {
		if (eContainerFeatureID() != Relational_Package.COLUMN__OWNER) return null;
		return (Table)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwner(Table newOwner, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwner, Relational_Package.COLUMN__OWNER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(Table newOwner) {
		if (newOwner != eInternalContainer() || (eContainerFeatureID() != Relational_Package.COLUMN__OWNER && newOwner != null)) {
			if (EcoreUtil.isAncestor(this, newOwner))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwner != null)
				msgs = ((InternalEObject)newOwner).eInverseAdd(this, Relational_Package.TABLE__COL, Table.class, msgs);
			msgs = basicSetOwner(newOwner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Relational_Package.COLUMN__OWNER, newOwner, newOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Table getKeyOf() {
		if (keyOf != null && keyOf.eIsProxy()) {
			InternalEObject oldKeyOf = (InternalEObject)keyOf;
			keyOf = (Table)eResolveProxy(oldKeyOf);
			if (keyOf != oldKeyOf) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Relational_Package.COLUMN__KEY_OF, oldKeyOf, keyOf));
			}
		}
		return keyOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Table basicGetKeyOf() {
		return keyOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetKeyOf(Table newKeyOf, NotificationChain msgs) {
		Table oldKeyOf = keyOf;
		keyOf = newKeyOf;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Relational_Package.COLUMN__KEY_OF, oldKeyOf, newKeyOf);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKeyOf(Table newKeyOf) {
		if (newKeyOf != keyOf) {
			NotificationChain msgs = null;
			if (keyOf != null)
				msgs = ((InternalEObject)keyOf).eInverseRemove(this, Relational_Package.TABLE__KEY, Table.class, msgs);
			if (newKeyOf != null)
				msgs = ((InternalEObject)newKeyOf).eInverseAdd(this, Relational_Package.TABLE__KEY, Table.class, msgs);
			msgs = basicSetKeyOf(newKeyOf, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Relational_Package.COLUMN__KEY_OF, newKeyOf, newKeyOf));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Relational_Package.COLUMN__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Relational_Package.COLUMN__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Relational_Package.COLUMN__OWNER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwner((Table)otherEnd, msgs);
			case Relational_Package.COLUMN__KEY_OF:
				if (keyOf != null)
					msgs = ((InternalEObject)keyOf).eInverseRemove(this, Relational_Package.TABLE__KEY, Table.class, msgs);
				return basicSetKeyOf((Table)otherEnd, msgs);
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
			case Relational_Package.COLUMN__OWNER:
				return basicSetOwner(null, msgs);
			case Relational_Package.COLUMN__KEY_OF:
				return basicSetKeyOf(null, msgs);
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
			case Relational_Package.COLUMN__OWNER:
				return eInternalContainer().eInverseRemove(this, Relational_Package.TABLE__COL, Table.class, msgs);
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
			case Relational_Package.COLUMN__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case Relational_Package.COLUMN__KEY_OF:
				if (resolve) return getKeyOf();
				return basicGetKeyOf();
			case Relational_Package.COLUMN__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case Relational_Package.COLUMN__OWNER:
				setOwner((Table)newValue);
				return;
			case Relational_Package.COLUMN__KEY_OF:
				setKeyOf((Table)newValue);
				return;
			case Relational_Package.COLUMN__TYPE:
				setType((Type)newValue);
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
			case Relational_Package.COLUMN__OWNER:
				setOwner((Table)null);
				return;
			case Relational_Package.COLUMN__KEY_OF:
				setKeyOf((Table)null);
				return;
			case Relational_Package.COLUMN__TYPE:
				setType((Type)null);
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
			case Relational_Package.COLUMN__OWNER:
				return basicGetOwner() != null;
			case Relational_Package.COLUMN__KEY_OF:
				return keyOf != null;
			case Relational_Package.COLUMN__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}

} //ColumnImpl
