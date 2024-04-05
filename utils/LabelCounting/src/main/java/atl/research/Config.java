package atl.research;

public class Config {
    
    public static final String COMMENT_SYMBOL = "//"; //lines starting with this sequence, will be marked as comment and not counted
    public static final String LIB_IMPORT = "using"; //lines starting with this word, will be skipped
    
    public static final String IGNORED_TOKENS = "[;|=|\\*| =>|. |::| \\( | \\)]";  // these tokens will be replaced by a whitespace
    public static final String IGNORED_DIRS = "src-gen";  //  directories with the specified names will be ignored when counting labels
    public static final String FILE_EXTENSIONS = "cs";  //  files for which the labels are provided
    
    // labels ->not needed currently

    // public static final String LABELS = "TRANSFORMATION|LABEL|HELPER"; 
    // public static final String TRANSFORMATION_LABEL ="Transformation";
    // public static final String TRAVERSAL_LABEL ="Model Traversal";
    // public static final String HELPER_LABEL ="Helper";
    // public static final String TRACING_LABEL = "Tracing";
    // public static final String CHANGE_IDENTIFICATION = "Change Identification";
    // public static final String CHANGE_PROPAGATION = "Change Propagation";
    
    
}
    