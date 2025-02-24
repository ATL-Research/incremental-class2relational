/**
 */
package Trace;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package </b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class, </li>
 *   <li>each feature of each class, </li>
 *   <li>each operation of each class, </li>
 *   <li>each enum, </li>
 *   <li>and each data type </li>
 * </ul>
 * <!-- end-user-doc -->
 * @see Trace.TraceFactory
 * @model kind="package"
 * @generated
 */
public interface TracePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Trace";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "Trace";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Trace";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TracePackage eINSTANCE = Trace.impl.TracePackageImpl.init();

	/**
	 * The meta object id for the '{@link Trace.impl.TraceEntryImpl <em>Entry </em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Trace.impl.TraceEntryImpl
	 * @see Trace.impl.TracePackageImpl#getTraceEntry()
	 * @generated
	 */
	int TRACE_ENTRY = 0;

	/**
	 * The feature id for the ' <em> <b>Source </b> </em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTRY__SOURCE = 0;

	/**
	 * The feature id for the ' <em> <b>Target </b> </em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTRY__TARGET = 1;

	/**
	 * The feature id for the ' <em> <b>Index </b> </em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTRY__INDEX = 2;

	/**
	 * The number of structural features of the ' <em>Entry </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTRY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the ' <em>Entry </em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_ENTRY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link Trace.TraceEntry <em>Entry </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class ' <em>Entry </em>'.
	 * @see Trace.TraceEntry
	 * @generated
	 */
	EClass getTraceEntry();

	/**
	 * Returns the meta object for the reference '{@link Trace.TraceEntry#getSource <em>Source </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference ' <em>Source </em>'.
	 * @see Trace.TraceEntry#getSource()
	 * @see #getTraceEntry()
	 * @generated
	 */
	EReference getTraceEntry_Source();

	/**
	 * Returns the meta object for the reference '{@link Trace.TraceEntry#getTarget <em>Target </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference ' <em>Target </em>'.
	 * @see Trace.TraceEntry#getTarget()
	 * @see #getTraceEntry()
	 * @generated
	 */
	EReference getTraceEntry_Target();

	/**
	 * Returns the meta object for the attribute '{@link Trace.TraceEntry#getIndex <em>Index </em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute ' <em>Index </em>'.
	 * @see Trace.TraceEntry#getIndex()
	 * @see #getTraceEntry()
	 * @generated
	 */
	EAttribute getTraceEntry_Index();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TraceFactory getTraceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class, </li>
	 *   <li>each feature of each class, </li>
	 *   <li>each operation of each class, </li>
	 *   <li>each enum, </li>
	 *   <li>and each data type </li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link Trace.impl.TraceEntryImpl <em>Entry </em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Trace.impl.TraceEntryImpl
		 * @see Trace.impl.TracePackageImpl#getTraceEntry()
		 * @generated
		 */
		EClass TRACE_ENTRY = eINSTANCE.getTraceEntry();

		/**
		 * The meta object literal for the ' <em> <b>Source </b> </em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ENTRY__SOURCE = eINSTANCE.getTraceEntry_Source();

		/**
		 * The meta object literal for the ' <em> <b>Target </b> </em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRACE_ENTRY__TARGET = eINSTANCE.getTraceEntry_Target();

		/**
		 * The meta object literal for the ' <em> <b>Index </b> </em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACE_ENTRY__INDEX = eINSTANCE.getTraceEntry_Index();

	}

} //TracePackage
