package JClass2RelationalIncremental;

import atl.research.AbstractDriver;
import transformations.incremental.Class2RelationalIncremental;

// setup
public class App extends AbstractDriver {

	public static void main(String[] args) {
		App solution = new App();

		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	protected void applyTransformation() {		
		Class2RelationalIncremental.start(this.getSource(), this.getTarget());
	}

}