package atl.research;

import org.eclipse.emf.ecore.EObject;

public class ExampleSolution extends AbstractDriver {
    public static void main(String[] args) throws Exception {
        ExampleSolution solution = new ExampleSolution();

        solution.init();
        solution.applyTransformation();
        solution.applyChange();
        solution.saveTarget();
    }

    @Override
    protected void applyTransformation() {
        for (EObject e : this.getSource().getContents()) {
            System.out.println(e);
        }
    }
}
