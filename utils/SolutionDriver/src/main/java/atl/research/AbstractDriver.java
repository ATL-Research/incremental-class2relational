package atl.research;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import Changes.ChangesPackage;
import Changes.ModelChange;
import Changes.ModelChangeSet;
import atl.research.class_.Class_Package;
import atl.research.relational_.Relational_Package;

public abstract class AbstractDriver {
    ResourceSet resourceSet = new ResourceSetImpl();
    Resource source;
    Resource target;
    Resource changes;



    public Resource getSource() {
        return source;
    }



    public Resource getTarget() {
        return target;
    }

    public void init() throws Exception {
        setupResourceSet();
        loadModels();
    }
    
    protected void setupResourceSet() {
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
            "xmi",
            new XMIResourceFactoryImpl()
        );
        resourceSet.getPackageRegistry().put(
            ChangesPackage.eNS_URI,
            ChangesPackage.eINSTANCE
        );
        resourceSet.getPackageRegistry().put(
            Class_Package.eNS_URI, 
            Class_Package.eINSTANCE
        );
        resourceSet.getPackageRegistry().put(
            Relational_Package.eNS_URI, 
            Relational_Package.eINSTANCE
        );
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
                // System.out.println("Applying change " + c);
                c.apply();
            }
        }
    }

    protected void saveTarget() throws IOException {
        target.save(Collections.emptyMap());
    }

    protected abstract void applyTransformation();

}