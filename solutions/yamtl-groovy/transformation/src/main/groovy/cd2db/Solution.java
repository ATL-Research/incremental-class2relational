package cd2db;

import atl.research.AbstractDriver;
import yamtl.core.YAMTLModule;
import yamtl.groovy.YAMTLGroovyExtensions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Solution extends AbstractDriver {
    CD2DB xform;

    public Solution() {
        xform = new CD2DB();
        YAMTLGroovyExtensions.init(xform);
        xform.setEnableCorrectnessCheck(false);
    }
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();

        solution.init();
        if (solution.isBatchMode()) {
            solution.applyChange();
            solution.applyTransformation();
        }
        else {
            solution.xform.adviseWithinThisNamespaceExpressions(List.of("atl.research.class_..*"));
            solution.xform.setExecutionMode(YAMTLModule.ExecutionMode.INCREMENTAL);
            solution.applyTransformation();
            solution.applyChange();
        }
        solution.saveTarget();
    }


    @Override
    protected void applyTransformation(){
        xform.loadInputResources(Map.of("cd", this.getSource()));
        xform.execute();
    };



    @Override
    protected void applyChange() {

        if (isBatchMode()) {
            super.applyChange();
        } else {
            xform.adaptInputModel("cd");
            super.applyChange();
            xform.propagateDelta("cd");
        }

    }


    @Override
    protected void saveTarget() throws IOException {
        xform.saveOutputModels(Map.of("db", System.getenv("TARGET_PATH")), List.of("Table", "Type"));
    }
}