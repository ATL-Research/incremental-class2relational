package util;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

/**
 * Class with static methods to read metamodels and read/write models from .xmi and .ecore files.
 * 
 * @author stefan
 *
 */
public class IO {

    static {
        // register XMI
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        // register ecore
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
        // register uml
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl());
    }

    public static EPackage loadMetaModel(String metaModelName) {
        ResourceSet resourceSet = new ResourceSetImpl();

        // load MM from ecore file
        File f = new File(CONSTANTS.METAMODEL_DIR + metaModelName + ".ecore");
        URI fileURI = URI.createFileURI(f.getAbsolutePath());
        Resource resource = resourceSet.getResource(fileURI, true);

        EPackage pack = (EPackage) resource.getContents().get(0);

        assert (pack != null);
        return pack;
    }

    public static Resource createResource(String uri) {
        ResourceSet resSet = new ResourceSetImpl();
        return resSet.createResource(URI.createURI(uri));
    }

    public static void persist(Resource resource) {
        try {
            resource.save(Collections.EMPTY_MAP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void persistModel(List<? extends EObject> models, String uri) {
        var resource = createResource(uri);

        resource.getContents().addAll(models);

        persist(resource);
    }

    public static void persistModel(EObject model, String uri) {
        var resource = createResource(uri);

        resource.getContents().add(model);
        persist(resource);
    }

    /**
     * Reads all models from a file.
     * 
     * IMPORTANT: the EPackacke containing the MM to which the read model conforms to has to be loaded
     * in EPackage.Registry.INSTANCE.
     * 
     * for instance by calling MMPackage.eINSTANCE.eClass();
     * 
     * @param uri Path to xmi file containing the models to be read
     * @return list of model root objects for each model contained within the xmi file
     */
    public static List<EObject> readModels(String uri) {
        // have to somehow register the families metamodel
        ResourceSet resSet = new ResourceSetImpl();


        Resource resource = resSet.getResource(URI.createURI(uri), true);

        return resource.getContents();
    }
    public static Resource getResource(String uri) {
        // have to somehow register the families metamodel
        ResourceSet resSet = new ResourceSetImpl();


        return resSet.getResource(URI.createURI(uri), true);
    }
    
}
