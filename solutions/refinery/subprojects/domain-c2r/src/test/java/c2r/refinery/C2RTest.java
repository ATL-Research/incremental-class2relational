package c2r.refinery;

import atl.research.AbstractDriver;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class C2RTest extends C2RRefineryMain {
	private final String base =
			"/home/wsl/incremental-class2relational/models/correctness1";
	@Test
	@Disabled
	public void incrementalTest() throws Exception {
		this.init();

		applyChange();//Batch mode
		applyTransformation();
		//applyChange();//Incremental mode
		saveTarget();
	}

	@Override
	protected void loadModels() throws Exception {
		Method loadModel = Arrays.stream(AbstractDriver.class.getDeclaredMethods())
				.filter(m -> "loadModel".equals(m.getName()))
				.findFirst().get();
		Method createModel = Arrays.stream(AbstractDriver.class.getDeclaredMethods())
				.filter(m -> "createModel".equals(m.getName()))
				.findFirst().get();

		loadModel.setAccessible(true);
		createModel.setAccessible(true);

		var source = AbstractDriver.class.getDeclaredField("source");
		source.setAccessible(true);
		source.set(this,loadModel.invoke(this, base+"/class.xmi"));
		var change = AbstractDriver.class.getDeclaredField("changes");
		change.setAccessible(true);
		change.set(this,loadModel.invoke(this, base+"/change.xmi"));
		var target = AbstractDriver.class.getDeclaredField("target");
		target.setAccessible(true);
		target.set(this,createModel.invoke(this, base+"/refinery.xmi"));

		var rs = AbstractDriver.class.getDeclaredField("resourceSet");
		rs.setAccessible(true);
		EcoreUtil.resolveAll((ResourceSet) rs.get(this));
	}
}
