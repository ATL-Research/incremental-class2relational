package fr.eseo.eris.ttc2023.class2relational.ceptre;

import atl.research.AbstractDriver;
import atl.research.class_.Class_Package;
import atl.research.relational_.Relational_Package;


import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

import java.util.regex.Pattern;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.FileOutputStream;

// Setup
public class Runner extends AbstractDriver {
	private static final boolean debug = false;
	private static final boolean engineOutput = false;

	public static void main(String[] args) throws IOException {
		try {
			Runner solution = new Runner();
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
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String output;

	private static class IdProvider {
		Map <EObject, String> ids = new HashMap<>();
		int nextId = 0;
		public String getId(EObject eo) {
			String id = ids.get(eo);
			if(id == null) {
				id = "a" + nextId++;
				ids.put(eo, id);
			}
			return id;
		}
	}

	private void convertValue(IdProvider idProvider, EObject eo, StringBuilder ret, EStructuralFeature sf, Object value) {
		if(sf instanceof EAttribute) {
			ret.append("attr '");
			ret.append(idProvider.getId(eo));
			ret.append(" '");
			ret.append(sf.getName());
			ret.append(" (");
			if(value instanceof String s) {
				ret.append("str \"");
				ret.append(s.replaceAll("\\\\", "\\\\").replaceAll("\\n", "\\\\n").replaceAll("\"", "\\\""));
				ret.append("\"");
			} else if(value instanceof Boolean) {
				ret.append("boolean ");
				ret.append(value);
			} else {
				throw new RuntimeException("unsupported value conversion from: " + value + " :" + value.getClass());
			}
			ret.append("),");
		} else if(sf instanceof EReference er) {
			if(er.isContainment()) {
				ret.append("comp '");
				ret.append(idProvider.getId(eo));
				ret.append(" '");
				ret.append(sf.getName());
				ret.append(" '");
				ret.append(idProvider.getId((EObject)value));
				ret.append(",");
			} else {
				ret.append("cref '");
				ret.append(idProvider.getId(eo));
				ret.append(" '");
				ret.append(sf.getName());
				ret.append(" '");
				ret.append(idProvider.getId((EObject)value));
				ret.append(",");
			}
		} else {
			throw new IllegalStateException();
		}
	}

	private String convert(Resource r) {
		StringBuilder ret = new StringBuilder();
		var idProvider = new IdProvider();
		for(var i = r.getAllContents() ; i.hasNext() ; ) {
			EObject eo = i.next();
			ret.append("node 'IN '");
			ret.append(eo.eClass().getName());
			ret.append(" '");
			ret.append(idProvider.getId(eo));
			ret.append(",");

			for(var sf : eo.eClass().getEAllStructuralFeatures()) {
				var value = eo.eGet(sf);
				if(value == null && sf instanceof EAttribute) {
					ret.append("attr '");
					ret.append(idProvider.getId(eo));
					ret.append(" '");
					ret.append(sf.getName());
					ret.append(" nullv,");
				} else if(value instanceof Collection <?> col) {
					for(var val : col) {
						convertValue(idProvider, eo, ret, sf, val);
					}
				} else {
					convertValue(idProvider, eo, ret, sf, value);
				}
			}
		}
		return ret.toString();
	}

	Process process;
	PrintStream stdin;
	BufferedReader stdout;
	BufferedReader stderr;

	@Override
	protected void loadModels() throws Exception {
		super.loadModels();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			System.out.println("Killing cheptre");
			if(process != null) {
				try {
					Runtime.getRuntime().exec(new String[] {
						"docker", "container", "kill", "cheptre_runner"
					}).waitFor();
				} catch (Exception e) {
					System.out.println("Error killing cheptre container");
					e.printStackTrace();
				}
				System.out.println("Killing cheptre");
				process.destroyForcibly();
			}
		}));
		String transfoName = "Class2Relational.cep";
		String transfoPath = new File("src/main/resources/").getAbsolutePath();
		this.process = Runtime.getRuntime().exec(new String[] {
			"docker", "run", "--rm", "--name=cheptre_runner", "-i", "--mount", "type=bind,source=" + transfoPath + ",target=/examples", "ghcr.io/np/incremental-class2relational-ceptre-cheptre", "/bin/cheptre", "/examples/" + transfoName, "--omit-pointless-choices"
		});
		new Thread(() -> {
			try {
				process.waitFor();
			} catch(InterruptedException ie) {
				ie.printStackTrace(System.out);
			}
		}).start();

		stdin = new PrintStream(process.getOutputStream());
		stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
		stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		this.setContext();
	}


	protected void setContext() throws Exception {
		String cmd = "set_context {" + convert(this.getSource()) + "stage idle}";
		if(debug) System.out.println(cmd);
		stdin.println(cmd);
		stdin.flush();

		String line;
		while((line = stdout.readLine()) != null) {
			if(engineOutput) System.out.println("CEPTRE1: " + line);
			if(line.startsWith("1:")) {
				break;
			}
		}

		System.out.println("LOADED");
	}

	@Override
	protected void applyTransformation() {
		output = null;
		try {
			// launch transformation
			stdin.println("1");
			stdin.flush();

			String line;
			while((line = stdout.readLine()) != null) {
				if(engineOutput) System.out.println("CEPTRE2: " + line);
				if(line.startsWith("1:")) {
					break;
				}
			}

			System.out.println("TRANSFORMED");
		} catch(Exception e) {
			System.out.println("ERROR");
			throw new RuntimeException(e);
		}
	}

	@Override
	public void init() throws Exception {
		super.init();
	}

	private static final String toLowerRegexp = "°([A-Z])";
	private static final Pattern toLowerPattern = Pattern.compile(toLowerRegexp);

	@Override
	protected void saveTarget() throws IOException {
		stdin.println("1");
		stdin.println("quit");
		stdin.flush();
		//BufferedReader stderr = new BufferedReader(new InputStreamReader(process.getErrorStream()));
		String line;
		while((line = stdout.readLine()) != null) {
			if(engineOutput) System.out.println("CEPTRE3: " + line);
			var output = line.replaceFirst("^.*: output 'OUT \"(.*)\",", "$1");
			if(!line.equals(output)) {
				this.output = output;
				break;
			}
		}
		System.out.println("SERIALIZED");
		if(this.output != null) {
			String output = this.output
				.replaceAll("\\\\n", "\n")
				.replaceAll("\\\\\"", "\"")
				// post processing around cheptre issue
				.replaceAll("(_[0-9]+)?¤", "")
			;
			// implementing firstToLower with post-processing
			output = toLowerPattern.matcher(output).replaceAll(match -> match.group(1).toLowerCase());
			if(debug) System.out.println("OUTPUT: " + output);
			PrintStream out = new PrintStream(new FileOutputStream(System.getenv("TARGET_PATH")));
			out.println(" <?xml version=\"1.0\" encoding=\"ASCII\"?>");
			out.println(" <xmi:XMI xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns=\"Relational\">");
			out.print(output);
			out.println(" </xmi:XMI>");
			out.close();
		} else {
			System.out.println("ERROR: finished without output");
			while((line = stderr.readLine()) != null) {
				System.out.println("CEPTRE: " + line);
			}
		}
	}

	@Override
	protected void applyChange() {
		super.applyChange();
		try {
			if(isBatchMode()) {
				// we must translate from EMF to ceptre again
				this.setContext();
			} else {
				// uncomment the following lines to make this solution naively "incremental" (i.e., by rerunning the transformation)
//*
				this.setContext();
				this.applyTransformation();
/**/
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
}

