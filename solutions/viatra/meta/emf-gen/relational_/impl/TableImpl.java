/**
 */
package relational_.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import relational_.Column;
import relational_.Relational_Package;
import relational_.Table;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object ' <em> <b>Table </b> </em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link relational_.impl.TableImpl#getCol <em>Col </em>} </li>
 *   <li>{@link relational_.impl.TableImpl#getKey <em>Key </em>} </li>
 * </ul>
 *
 * @generated
 */
public class TableImpl extends NamedImpl implements Table {
	/**
	 * The cached value of the '{@link #getCol() <em>Col </em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCol()
	 * @generated
	 * @ordered
	 */
	protected EList <Column> col;

	/**
	 * The cached value of the '{@link #getKey() <em>Key </em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected EList <Column> key;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Relational_Package.Literals.TABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList <Column> getCol() {
		if (col == null) {
			col = new EObjectContainmentWithInverseEList <Column>(Column.class, this, Relational_Package.TABLE__COL, Relational_Package.COLUMN__OWNER);
		}
		return col;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList <Column> getKey() {
		if (key == null) {
			key = new EObjectWithInverseResolvingEList <Column>(Column.class, this, Relational_Package.TABLE__KEY, Relational_Package.COLUMN__KEY_OF);
		}
		return key;
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
			case Relational_Package.TABLE__COL:
				return ((InternalEList <InternalEObject>)(InternalEList <?>)getCol()).basicAdd(otherEnd, msgs);
			case Relational_Package.TABLE__KEY:
				return ((InternalEList <InternalEObject>)(InternalEList <?>)getKey()).basicAdd(otherEnd, msgs);
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
			case Relational_Package.TABLE__COL:
				return ((InternalEList <?>)getCol()).basicRemove(otherEnd, msgs);
			case Relational_Package.TABLE__KEY:
				return ((InternalEList <?>)getKey()).basicRemove(otherEnd, msgs);
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
			case Relational_Package.TABLE__COL:
				return getCol();
			case Relational_Package.TABLE__KEY:
				return getKey();
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
			case Relational_Package.TABLE__COL:
				getCol().clear();
				getCol().addAll((Collection <? extends Column>)newValue);
				return;
			case Relational_Package.TABLE__KEY:
				getKey().clear();
				getKey().addAll((Collection <? extends Column>)newValue);
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
			case Relational_Package.TABLE__COL:
				getCol().clear();
				return;
			case Relational_Package.TABLE__KEY:
				getKey().clear();
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
			case Relational_Package.TABLE__COL:
				return col != null && !col.isEmpty();
			case Relational_Package.TABLE__KEY:
				return key != null && !key.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TableImpl
