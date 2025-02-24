package transformations.util.trace;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Optional;
import java.util.UUID;
import org.eclipse.emf.ecore.EObject;

// TRACING
public class Tracer {
    private final HashMap <TraceSource, EObject> traces = new HashMap<>();
    private final HashMap <TraceSource, List <? extends EObject>> multiTraces = new HashMap<>();

    public Optional <EObject> firstJust(List <Optional<EObject>> ms) {
        var js = ms.stream().filter(m -> m.isPresent()).collect(Collectors.toCollection(LinkedList::new));

        if (js.size() > 0) {
            return js.getFirst();
        } else {
            return Optional.empty();
        }
    }

    public void addTrace(EObject source, String method, EObject target) {
        var traceSource = new TraceSource(source, method);
        traces.put(traceSource, target);
    }

    public void addTrace(EObject source, EObject target) {
        addTrace(source, "", target);
    }

    public void addTrace(EObject source, String method, List <? extends EObject> target) {
        var traceSource = new TraceSource(source, method);
        multiTraces.put(traceSource, target);
    }

    public Optional <EObject> checkTrace(EObject source, String method) {
        var target = traces.get(new TraceSource(source, method));

        var optional = Optional.ofNullable(target);

        return optional;
    }

    public Optional <List<? extends EObject>> checkMultiTrace(EObject source, String method) {
        var target = multiTraces.get(new TraceSource(source, method));


        Optional <List<? extends EObject>> optional = Optional.ofNullable(target);

        return optional;
    }

    public Optional <EObject> checkTrace(EObject source) {
        EObject target = null;
        var entrySet = traces.entrySet();

        // find first TraceSourceObject that is the source Object
        for (Entry <TraceSource, EObject> entry : entrySet) {
            if (entry.getKey().checkSourceObject(source)) {
                target = entry.getValue();
                break;
            }
        }

        var optional = Optional.ofNullable(target);

        return optional;
    }

    public Optional <List<? extends EObject>> checkMultiTrace(EObject source) {
        List <? extends EObject> target = null;
        var entrySet = multiTraces.entrySet();

        // find first TraceSourceObject that is the source Object
        for (Entry <TraceSource, List <? extends EObject>> entry : entrySet) {
            if (entry.getKey().checkSourceObject(source)) {
                target = entry.getValue();
                break;
            }
        }

        Optional <List<? extends EObject>> optional = Optional.ofNullable(target);

        return optional;
    }

    public <T extends EObject> T resolve(EObject source, T defaultObject) {
        // check if target already present then return
        // else use default (add to traces with "") and return
        return resolve(source, "", defaultObject);
    }

    public <T extends EObject> T resolve(EObject source, Class <T> clazz) {
        // check if target already present then return
        // else use default (add to traces with "") and return
        return resolve(source, "", clazz);
    }

    public List <? extends EObject> resolve(EObject source, List <EObject> defaultList) {
        return resolve(source, "", defaultList);
    }


    public <T extends EObject> T resolve(EObject source, String nameInRule, T defaultObject) {
        var mTarget = checkTrace(source, nameInRule);

        if (mTarget.isEmpty()) {
            return null;
        } else {
            return (T) mTarget.get();
        }
    }

    public <T extends EObject> T resolve(EObject source, String nameInRule, Class <T> clazz) {
        var mTarget = checkTrace(source, nameInRule);

        if (mTarget.isEmpty()) {
            return null;
        } else {
            return clazz.cast(mTarget.get());
        }
    }


    public <T extends EObject> T resolveNull(EObject source, String nameInRule, T defaultObject) {
        var mTarget = checkTrace(source, nameInRule);

        if (mTarget.isEmpty()) {
            return null;
        } else {
            return (T) mTarget.get();
        }
    }

    public List <? extends EObject> resolve(EObject source, String nameInRule, List <? extends EObject> defaultList) {
        var mTarget = checkMultiTrace(source, nameInRule);

        if (mTarget.isEmpty()) {
            return defaultList;
        } else {
            return mTarget.get();
        }
    }
    
    public List <EObject> resolveAll(EObject source) {
    	var targets = new LinkedList <EObject>();
    	
    	traces.forEach((traceSource, target) -> {
    		if(traceSource.sourceObject == source) {targets.add(target);}
    	});
    	
    	return targets;
    }
}


class TraceSource {
    EObject sourceObject;
    String nameInRule;

    public TraceSource(EObject source, String method) {
        this.sourceObject = source;
        this.nameInRule = method;
    }

    public boolean checkSourceObject(EObject other) {
        return sourceObject == other;
    }

    @Override
    public boolean equals(Object obj) {
        boolean equal;

        if (obj instanceof TraceSource) {
            var other = (TraceSource) obj;
            // traces are equal if the objects are one an the same
            // and the source is one and the same
            equal = this.sourceObject == other.sourceObject;
            equal &= this.nameInRule.equals(other.nameInRule);
        } else {
            equal = false;
        }

        return equal;
    }

    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        if (sourceObject != null && nameInRule != null) {
            return sourceObject.hashCode() + nameInRule.hashCode();
        } else {
            return UUID.randomUUID().hashCode();
        }
        // return super.hashCode();
    }
}
