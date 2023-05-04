package transformations.util.traverse;

import java.util.HashMap;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Function;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import transformations.util.trace.Tracer;

public class Traverser {
    private HashMap<Class<?>, Consumer<EObject>> functions = new HashMap<>();
    private Tracer tracer;

    public Traverser(Tracer tracer) {
        this.tracer = tracer;
    }

    public void addFunction(Class<?> class_, Consumer<EObject> function) {
        functions.put(class_, function);
    }

    private void traverseAndAccept(Iterator<EObject> iterator, Function<EObject, Boolean> condition) {
        while (iterator.hasNext()) {
            var next = iterator.next();
            var nClass = next.getClass();
            Consumer<EObject> fun = functions.get(nClass);
            if (condition.apply(next)) {
                boolean accepted = false;
                do {
                    if (fun != null) {
                        fun.accept(next);
                        accepted = true;
                    } else {
                        var superClass = nClass.getSuperclass();
                        if (superClass != null) {
                            nClass = (Class<? extends EObject>) superClass;
                            fun = functions.get(nClass);
                        } else {
                            accepted = true;
                        }
                    }
                } while (!accepted && !nClass.equals(Object.class));
            }
        }
    }

    public void traverseAndAccept(Iterator<EObject> iterator) {
        traverseAndAccept(iterator, next -> tracer.checkTrace(next, "").isPresent());
    }


    public void traverseAndAcceptPre(Iterator<EObject> iterator) {
        traverseAndAccept(iterator, next -> true);
    }
}
