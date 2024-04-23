package atl.research;

public class Config {
    
    public static final String COMMENT_SYMBOL = "//"; // lines starting with this sequence are marked as comment and not counted

    
    public static final String IGNORED_TOKENS = "[;|=|\\*|=>|.|::| \\( | \\) | \\{ | \\} | \\[| \\]]";  // these tokens will be replaced by a whitespace
    public static final String ALLOWED_DIRS = "nmf";  //  directories with the specified names will be ignored when counting labels
    
    
    public static final String EMPTY_LABEL = "EMPTY";    //starting state
    
    public static final String SETUP_LABEL = "SETUP";
    public static final String TRAVERSAL_LABEL = "MODEL_NAVIGATION";     
    public static final String TRANSFORMATION_LABEL ="TRANSFORMATION";
    public static final String TRACING_LABEL = "TRACING";
    public static final String HELPER_LABEL = "HELPER";
    public static final String CHANGE_IDENTIFICATION = "CHANGE_IDENTIFICATION"; 
    public static final String CHANGE_PROPAGATION = "CHANGE_PROPAGATION";
    public static final String WRAPPER_LABEL = "WRAPPER";

   // TODO may not be necessary anymore, if we enumerate files
    public static final String LIB_IMPORT = "using"; // lines starting with this word, will be skipped
 }
