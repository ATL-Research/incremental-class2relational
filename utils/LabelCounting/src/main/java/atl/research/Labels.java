package atl.research;

import java.util.List;

public class Labels {
        
    public static final String EMPTY_LABEL = "EMPTY";        //starting state    
    public static final String SETUP_LABEL = "SETUP";   
    public static final String TRAVERSAL_LABEL = "MODEL_TRAVERSAL";
    public static final String NAVIGATION_LABEL = "MODEL_NAVIGATION";     
    public static final String TRANSFORMATION_LABEL ="TRANSFORMATION";
    public static final String TRACING_LABEL = "TRACING";
    public static final String HELPER_LABEL = "HELPER";
    public static final String CHANGE_IDENTIFICATION = "CHANGE_IDENTIFICATION"; 
    public static final String CHANGE_PROPAGATION = "CHANGE_PROPAGATION";
    public static final String WRAPPER_LABEL = "WRAPPER";
    public static final String GENERATED_LABEL = "GENERATED";

    public static final List<String> ASPECTS_LABELS = List.of(
        EMPTY_LABEL,
        SETUP_LABEL,
        TRAVERSAL_LABEL,
        // NAVIGATION_LABEL, // navigation is no longer used
        TRANSFORMATION_LABEL,
        TRACING_LABEL,
        HELPER_LABEL,
        CHANGE_IDENTIFICATION,
        CHANGE_PROPAGATION,
        GENERATED_LABEL
        // WRAPPER_LABEL // wrapper is no longer used
        );
}
