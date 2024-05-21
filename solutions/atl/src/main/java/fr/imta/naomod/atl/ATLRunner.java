package fr.imta.naomod.atl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.eclipse.m2m.atl.emftvm.Metamodel;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.compiler.AtlToEmftvmCompiler;
import org.eclipse.m2m.atl.emftvm.impl.resource.EMFTVMResourceFactoryImpl;
import org.eclipse.m2m.atl.emftvm.util.DefaultModuleResolver;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver;

import atl.research.AbstractDriver;
import atl.research.class_.Class_Package;
import atl.research.relational_.Relational_Package;

// Setup
public class ATLRunner extends AbstractDriver {
	public static void main(String[] args) throws IOException {
		try {
			ATLRunner solution = new ATLRunner();
			solution.init();
			// always do batch transformation because ATL is not incremental
			solution.applyChange();
			solution.applyTransformation();
			solution.saveTarget();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	protected void setupResourceSet() {
		super.setupResourceSet();

		getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			"emftvm",
			new EMFTVMResourceFactoryImpl()
		);
	}


	@Override
	protected void applyTransformation() {
		// create an execution environment
		ExecEnv execEnv = EmftvmFactory.eINSTANCE.createExecEnv();


		// register source and target metamodels in ExecEnv
		Metamodel sourceMM = EmftvmFactory.eINSTANCE.createMetamodel();
		sourceMM.setResource(Class_Package.eINSTANCE.eResource());
		execEnv.registerMetaModel("class_", sourceMM);


		Metamodel targetMM = EmftvmFactory.eINSTANCE.createMetamodel();
		targetMM.setResource(Relational_Package.eINSTANCE.eResource());
		execEnv.registerMetaModel("Relational", targetMM);
		

		// compile the ATL transformation
		compileATLModule("./src/main/resources/Class2Relational");
		compileATLModule("./src/main/resources/strings");
		
		
		Model sourceModel = EmftvmFactory.eINSTANCE.createModel();
		sourceModel.setResource(getSource());
		// register source model as the IN model in ATL transformation
		execEnv.registerInputModel("IN", sourceModel);


		Model targetModel = EmftvmFactory.eINSTANCE.createModel();
		targetModel.setResource(getTarget());
		// register target model as the OUT model in ATL transformation
		execEnv.registerOutputModel("OUT", targetModel);

		// create a new ClassModuleResolver
		// this is used resolve ATL modules
		final ModuleResolver mr = new DefaultModuleResolver("./src/main/resources/", getResourceSet());
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
