package de.tbuchmann.bxtenddsl;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import atl.research.AbstractDriver;
import de.tbuchmann.ttc.trafo.Class2Relational;

// Setup
public class BXtendDSLSolution extends AbstractDriver {
	private Class2Relational trafo;
    protected Resource corr;    

    @Override
    public void init() {
    	try {
			super.init();
		} catch (Exception e) {
			e.printStackTrace();
		}

    	trafo = new Class2Relational(getSource(), getTarget(), corr);
    }

    // Setup
    @Override
    protected void loadModels() {
    	try {
			super.loadModels();
		} catch (Exception e) {
			e.printStackTrace();
		}
    	corr =  getResourceSet().createResource(URI.createFileURI(System.getenv("SOURCE_PATH") + ".corr.xmi"));
        EcoreUtil.resolveAll(getResourceSet());
    }

    protected void applyChange() {
    	super.applyChange();
    	if (!isBatchMode())
    		// Transformation
    		trafo.sourceToTarget();
    }

    // TODO is this trafo or setup?
    public static void main(String[] args) throws Exception {
    	BXtendDSLSolution solution = new BXtendDSLSolution();

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

    protected void applyTransformation() {
    	// Transformation
    	trafo.sourceToTarget();
    }

}
