package c2r.init;

import org.eclipse.emf.ecore.EObject;

import c2r.version2.IncrementalC2R_v2;

// Setup
public class ViatraIncrementalSolution extends AbstractDriver {
    public static void main(String[] args) throws Exception {
    	// SETUP
    	ViatraIncrementalSolution solution = new ViatraIncrementalSolution();

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

    @Override
    protected void applyTransformation() {
    	IncrementalC2R_v2 val = new IncrementalC2R_v2(resourceSet,target);
    }

}
