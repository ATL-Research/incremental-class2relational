package de.tbuchmann.bxtendImperative;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import atl.research.AbstractDriver;
import class2relationalImperative.rules.Class2relationalImperativeTransformation;


public class BXtendSolution extends AbstractDriver {
	private Class2relationalImperativeTransformation trafo;
    protected Resource corr;    

    // Setup
    @Override
    public void init() {
    	try {
			super.init();
		} catch (Exception e) {
			e.printStackTrace();
		}

    	trafo = new Class2relationalImperativeTransformation(getSource(), getTarget(), corr);
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
    
    
    public static void main(String[] args) throws Exception {
    	BXtendSolution solution = new BXtendSolution();

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
