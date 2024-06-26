 package atl.research;
 
 import java.io.IOException;
 import java.io.Reader;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.util.Properties;

 public class Config {
    
    public static final String ANALYSIS_DIR = "solution.analysis-dir";  // these tokens will be replaced by a whitespace
    public static final String ANALYSIS_RESULT = "solution.analysis-result";  // these tokens will be replaced by a whitespace
    public static final String SKIPPED_SYMBOLS_REGEX = "solution.skipped-symbols-regex";  // these tokens will be replaced by a whitespace
    public static final String COMMENT_SYMBOL = "solution.comment-symbol";  // these tokens will be replaced by a whitespace
    public static final String STRING_SYMBOL = "solution.string-symbol";  // list of files and directories to be scanned
    public static final String IMPORT_TOKENS = "solution.import-tokens";  // these tokens initiate import-statements,
    public static final String FILES_TO_SCAN = "solution.files-to-scan";  // list of files and directories to be scanned
     
    private final Properties properties;
    
    public Config(Path pathToProperties) {
        properties = new Properties();

        try (final Reader reader = Files.newBufferedReader(pathToProperties)) {
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public String skippedSymbolsRegex() {
        return (this.properties.getProperty(SKIPPED_SYMBOLS_REGEX));
    }

    public Path getAnalysisDir() {
        return Path.of(this.properties.getProperty(ANALYSIS_DIR));
    }
    public String getAnalysisResult() {
        // return Path.of(this.properties.getProperty(ANALYSIS_RESULT));
        return properties.getProperty(ANALYSIS_RESULT);
    }
    
    public String[] getCommentSymbols() {
        String symbolString = this.properties.getProperty(COMMENT_SYMBOL);
        if (symbolString.startsWith("[")) {
            return parseListString(symbolString);
        }
        else {
            return new String[] {symbolString};
        }
    }

    public String[] getStringSymbols() {
        String symbolString = this.properties.getProperty(STRING_SYMBOL);
        return parseListString(symbolString);
        
    }

    public String[] getImportTokens() {
        String symbolString = this.properties.getProperty(IMPORT_TOKENS);
            return parseListString(symbolString);
    }

    public String[] getFilesToScan() {
        return parseListString(this.properties.getProperty(FILES_TO_SCAN));
    }

    private static String[] parseListString(String str) {
        return str.substring(1, str.length() - 1).split(",");
    }
}