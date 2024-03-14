package c2r.init;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import Changes.ChangesPackage;
import Changes.ModelChange;
import Changes.ModelChangeSet;
import class_.Class_Package;
import relational_.Relational_Package;

public abstract class AbstractDriver {
    ResourceSet resourceSet = new ResourceSetImpl();
    Resource source;
    Resource target;
    Resource changes;

    boolean batchMode = false;

    public Resource getSource() {
        return source;
    }

    public Resource getTarget() {
        return target;
    }

    protected ResourceSet getResourceSet() {
        return resourceSet;
    }

    public boolean isBatchMode() {
        return batchMode;
    }

    public void init() throws Exception {
        batchMode = (System.getenv("BATCH_MODE") != null);
        setupResourceSet();
        loadModels();
    }
    
    protected void setupResourceSet() {
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
            "xmi",
            new XMIResourceFactoryImpl()
        );

        // Register source, change and target metamodels in global registry
        EPackage e1 = Class_Package.eINSTANCE;
        EPackage e2 = Relational_Package.eINSTANCE;
        EPackage e3 = ChangesPackage.eINSTANCE;
    }

    protected void loadModels() throws Exception {
        if (System.getenv("SOURCE_PATH") == null) {
            throw new Exception("SOURCE_PATH environment variable not set");
        }
        else if (System.getenv("CHANGE_PATH") == null) {
            throw new Exception("CHANGE_PATH environment variable not set");
        }
        else if (System.getenv("TARGET_PATH") == null) {
            throw new Exception("TARGET_PATH environment variable not set");
        }

        source = loadModel(System.getenv("SOURCE_PATH"));
        changes = loadModel(System.getenv("CHANGE_PATH"));
        target = createModel(System.getenv("TARGET_PATH"));
        EcoreUtil.resolveAll(resourceSet);
    }

    private Resource loadModel(String modelPath) {
        System.out.println("Loading model from " + modelPath);
        return resourceSet.getResource(URI.createFileURI(modelPath), true);
    }

    private Resource createModel(String modelPath) {
        return resourceSet.createResource(URI.createFileURI(modelPath));
    }

    protected void applyChange() {
        // we ignore change models that are empty (for checking correctness)
        if (changes.getContents().size() > 0) {
            ModelChangeSet change = (ModelChangeSet) changes.getContents().get(0);
            for (ModelChange c : change.getChanges()) {
                System.out.println("Applying change " + c);
                c.apply();
            }
        }
    }

    protected void saveTarget() throws IOException {
        target.save(Collections.emptyMap());
    }

    protected abstract void applyTransformation();

}