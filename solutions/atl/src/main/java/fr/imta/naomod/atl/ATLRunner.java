package fr.imta.naomod.atl;

import atl.research.AbstractDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.compiler.AtlToEmftvmCompiler;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;

import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;

public class ATLRunner extends AbstractDriver {
	private ResourceSet rs = new ResourceSetImpl();
	public static void main(String[] args) throws IOException {
		try {
			ATLRunner solution = new ATLRunner();
			solution.init();
			if (solution.isBatchMode()) {
				solution.applyChange();
				solution.applyTransformation();
			}
			else {
				solution.applyTransformation();
				solution.applyChange();
			}
			solution.saveTarget();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ATLRunner() {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			"emftvm",
			new EMFTVMResourceFactoryImpl()
		);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			"ecore",
			new XMIResourceFactoryImpl()
		);
		rs.getPackageRegistry().put(
			EcorePackage.eNS_URI,
			EcorePackage.eINSTANCE
		);
	}

	private void injectMetamodel(Resource resource) {
		EMFModelFactory factory = new EMFModelFactory();
		EMFInjector emfinjector = new EMFInjector();
		EMFReferenceModel inMetamodel = (EMFReferenceModel) factory.newReferenceModel();
		emfinjector.inject(inMetamodel, resource);
		try {
			emfinjector.inject(inMetamodel, (Resource)null);	// making sure garbage collecting the EMFReferenceModel will not unload the resource (see EMFModel.finalize())
		} catch(NullPointerException e) {}
	}

	@Override
	protected void applyTransformation() {
		
		// create an execution environment
		ExecEnv execEnv = EmftvmFactory.eINSTANCE.createExecEnv();


		// register source and target metamodels in ExecEnv
		Resource sourceMMResource = rs.getResource(URI.createFileURI("src/main/resources/Class.ecore"), true);
		injectMetamodel(sourceMMResource);

		rs.getPackageRegistry().put(
			"Class",
			sourceMMResource.getContents().get(1)
		);

		Metamodel sourceMM = EmftvmFactory.eINSTANCE.createMetamodel();
		sourceMM.setResource(sourceMMResource);
		execEnv.registerMetaModel("Class", sourceMM);


		Resource targetMMResource = rs.getResource(URI.createFileURI("src/main/resources/Relational.ecore"), true);
		injectMetamodel(targetMMResource);

		Metamodel targetMM = EmftvmFactory.eINSTANCE.createMetamodel();
		targetMM.setResource(targetMMResource);
		execEnv.registerMetaModel("Relational", targetMM);
		

		// compile the ATL transformation
		compileATLModule("./src/main/resources/Class2Relational");
		compileATLModule("./src/main/resources/strings");
		
		
		Model sourceModel = EmftvmFactory.eINSTANCE.createModel();
		// EMFTVM doesn't like to use resources loaded from compiled classes, so we load the resource again
		Resource source = rs.getResource(URI.createFileURI(System.getenv("SOURCE_PATH")), true);
		sourceModel.setResource(source);
		// register source model as the IN model in ATL transformation
		execEnv.registerInputModel("IN", sourceModel);


		Model targetModel = EmftvmFactory.eINSTANCE.createModel();
		targetModel.setResource(getTarget());
		// register target model as the OUT model in ATL transformation
		execEnv.registerOutputModel("OUT", targetModel);

		// create a new ClassModuleResolver
		// this is used resolve ATL modules
		final ModuleResolver mr = new DefaultModuleResolver("./src/main/resources/", rs);
		execEnv.loadModule(mr, "Class2Relational");

		execEnv.run(null);
	}

	private static void compileATLModule(String path) {
		AtlToEmftvmCompiler compiler = new AtlToEmftvmCompiler();
		
		try {
			InputStream fin = new FileInputStream(path + ".atl");
			compiler.compile(fin, path + ".emftvm");
			fin.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
