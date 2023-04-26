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
import atl.research.class_.Class_Package;
import atl.research.relational_.Relational_Package;

public abstract class AbstractDriver {
    ResourceSet resourceSet = new ResourceSetImpl();
    Resource source;
    Resource target;
    Resource changes;

    public AbstractDriver() throws Exception {
        // setup EMF resource set to load models
        setupResourceSet();

        // loading & creating models
        source = loadModel(System.getenv("SOURCE_PATH"));
        changes = loadModel(System.getenv("CHANGES_PATH"));
        target = createModel(System.getenv("TARGET_PATH"));

        // apply transformation
        applyTransformation();

        // apply changes
        applyChange();

        // save target model
        saveTarget();
    }

    
    

    public Resource getSource() {
        return source;
    }



    public Resource getTarget() {
        return target;
    }


    void setupResourceSet() {
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

    Resource loadModel(String modelPath) {
        return resourceSet.getResource(URI.createFileURI(modelPath), false);
    }

    Resource createModel(String modelPath) {
        return resourceSet.createResource(URI.createFileURI(modelPath));
    }

    void applyChange() {
        // we ignore change models that are empty (for checking correctness)
        if (changes.getContents().size() > 0) {
            ModelChange change = (ModelChange) changes.getContents().get(0);
            change.apply();
        }
    }

    void saveTarget() throws IOException {
        target.save(Collections.emptyMap());
    }

    protected abstract void applyTransformation();

}