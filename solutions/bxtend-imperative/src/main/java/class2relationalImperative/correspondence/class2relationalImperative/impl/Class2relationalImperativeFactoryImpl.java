/**
 */
package class2relationalImperative.correspondence.class2relationalImperative.impl;

import class2relationalImperative.correspondence.class2relationalImperative.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Class2relationalImperativeFactoryImpl extends EFactoryImpl implements Class2relationalImperativeFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Class2relationalImperativeFactory init() {
		try {
			Class2relationalImperativeFactory theClass2relationalImperativeFactory = (Class2relationalImperativeFactory)EPackage.Registry.INSTANCE.getEFactory(Class2relationalImperativePackage.eNS_URI);
			if (theClass2relationalImperativeFactory != null) {
				return theClass2relationalImperativeFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Class2relationalImperativeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Class2relationalImperativeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case Class2relationalImperativePackage.TRANSFORMATION: return createTransformation();
			case Class2relationalImperativePackage.CORR: return createCorr();
			case Class2relationalImperativePackage.BASIC_ELEM: return createBasicElem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transformation createTransformation() {
		TransformationImpl transformation = new TransformationImpl();
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Corr createCorr() {
		CorrImpl corr = new CorrImpl();
		return corr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BasicElem createBasicElem() {
		BasicElemImpl basicElem = new BasicElemImpl();
		return basicElem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Class2relationalImperativePackage getClass2relationalImperativePackage() {
		return (Class2relationalImperativePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Class2relationalImperativePackage getPackage() {
		return Class2relationalImperativePackage.eINSTANCE;
	}

} //Class2relationalImperativeFactoryImpl
