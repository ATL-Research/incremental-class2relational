package atl.research;

import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import atl.research.relational_.Relational_Package;
import io.github.atlresearch.emfmodelfuzzer.SimpleEMFModelComparator;

public class Comparator {
    

    public static void main(String[] args) {
        final String expectedModelPath = System.getenv("EXPECTED_MODEL");
        final String currentModelPath = System.getenv("CURRENT_MODEL");

        if (expectedModelPath == null) {
            System.err.println("EXPECTED_MODEL environment variable not set");
            System.exit(1);
        }
        else if(currentModelPath == null) {
            System.err.println("CURRENT_MODEL environment variable not set");
            System.exit(1);
        }

        final ResourceSet rs = new ResourceSetImpl();

        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
        rs.getPackageRegistry().put("Relational", Relational_Package.eINSTANCE);

        Resource expectedResource = null;
        try {
            expectedResource = rs.getResource(URI.createFileURI(expectedModelPath), true);
        } catch(Exception e) {
            System.err.println("Error loading expected model: " + e.getMessage());
            System.exit(1);
        }

        Resource currentResource = null;
        try {
            currentResource = rs.getResource(URI.createFileURI(currentModelPath), true);
        } catch(Exception e) {
            System.err.println("Error loading current model: " + e.getMessage());
            System.exit(1);
        }

        final SimpleEMFModelComparator comparator = new SimpleEMFModelComparator();

        final StringBuffer messageBuffer = new StringBuffer();
        comparator.compare("/contents", expectedResource.getContents(), currentResource.getContents(), new HashMap<>(), messageBuffer, (index, value) ->
		value instanceof EObject eo
		?	eo.eGet(eo.eClass().getEStructuralFeature("name"))
		:	value
	);

        if (messageBuffer.length() > 0) {
            System.err.println(messageBuffer.toString());
            System.exit(1);
        }
        else {
            System.exit(0);
        }
    }
}
