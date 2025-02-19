package atl.research;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;

/**
 * 
 */
public class AnalysisScanner {

    public static final boolean DEBUG = true;
    
    // statistical data
    long fileCt = 0;
    long lineCt = 0;
    long wordCt = 0;
    int chars = 0;
    int importLineCt = 0;

    // states of file analysis
    protected int currentLine = 1;
    protected String currentLabel = Labels.EMPTY_LABEL;
    protected int currentLabelCount = 0;
    protected int labelStartLine = 1;
    protected boolean skipLinesWithManualAnnotation = false;
    
    // solution-specific properties
    protected static Path analyzedDirectory;
    protected final File labelCountFile;
    protected final Path labelCountFileAbsPath; 
    protected String skippedSymbolsRegex = "";
    protected List<String> commentSymbols = new LinkedList<String>();
    protected List<String> importTokens = new LinkedList<String>();
    protected List<String> filesToScan = new LinkedList<String>();


    public AnalysisScanner(Config config) {
        analyzedDirectory = config.getAnalysisDir();
        skippedSymbolsRegex = config.skippedSymbolsRegex();
        commentSymbols = Arrays.asList(config.getCommentSymbols());
        importTokens = Arrays.asList(config.getImportTokens());
        filesToScan = Arrays.asList(config.getFilesToScan());
        labelCountFile = new File(config.getAnalysisResult());
        labelCountFileAbsPath = Paths.get(labelCountFile.getAbsolutePath());
        setupLabelCountFile();
    }

    private void setupLabelCountFile() {
        if (labelCountFile.exists())
            labelCountFile.delete();
        
           try{
               labelCountFile.getParentFile().mkdirs();
               labelCountFile.createNewFile();

               // create header
               String header =  "File name, Transformation Aspect, Value, Lines\n";
               Files.write(labelCountFileAbsPath, header.getBytes() , StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
            catch (IOException e) {
                System.out.println("Could not create label-count file " + e);
            }
    }

    public void extractLabelsFromFiles() {
        for (String fileString : filesToScan) {
             Path filePath  = Paths.get(System.getProperty("user.dir") + "/" + analyzedDirectory + "/" + fileString);
                if (Files.isDirectory(filePath)) {
                    // iterate directory and add each file (!) to the list of filesToscan
                    continue;
                }
                fileCt++;
                System.out.println("-------------------------------");
                System.out.println("scanning file " + fileString);
                resetFileCounters();
                // add name of file to csv for tracing/logging reasons
                try{
                    scanTrafoFile(filePath);
                } catch(IOException e ) {
                    System.out.println("couldnt append the file name of " + fileString);
                }
        }
    }

    public void scanTrafoFile(Path filepath) throws IOException {
        currentLine = 1;
        Scanner in;
        try {
            in = new Scanner(new File(filepath.toString()));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                lineCt++;
                if (line.length() > 0) {
                    processLine(in, line, filepath.getFileName().toString());
                }
                currentLine++;
            }
            in.close();

            // add analysis of last line
            writeLabelCount(filepath.getFileName().toString());   

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
            
    }

    private boolean isImport(String line) {
        for (String token : importTokens) {
            if (line.startsWith(token)) {
                return true;
            }
        }
        return false;
    }

    public void processLine(Scanner in, String line, String filepath) throws IOException {
        if (!line.isEmpty()) {
            // preprocessing of String for counting
            line = line.stripLeading();
            line = line.replaceAll("\"([^\"]|\\\")*\"", "a"); //TODO replace by configurable comments
  
            line  = line.replaceAll(skippedSymbolsRegex, " ");
            line = line.replaceAll("\\s+", " ");

            String preprocessed = line; 
            
            if (isImport(preprocessed)) {
                importLineCt++;
                labelStartLine = currentLine + 1;
                return; //skip process
            }

            try{
                String[] wordArray = getCleanedArray(preprocessed);
                if (!isComment(preprocessed) && !skipLinesWithManualAnnotation) {
                    if (DEBUG) {
                        System.out.println(line + " \t consists of " + wordArray.length + " words associated with label: " + currentLabel);
                    }
                    currentLabelCount += wordArray.length; 
                    wordCt += wordArray.length;
                }
                else if (isComment(preprocessed) && wordArray.length > 1 ) {
                    int manualLabelCt = getCustomLabelCount(wordArray);

                    switch (wordArray[1].toUpperCase()) {
                        case Labels.TRANSFORMATION_LABEL: 
                            if (currentLabel != Labels.TRANSFORMATION_LABEL) {
                                updateLabels(Labels.TRANSFORMATION_LABEL, filepath);
                            } 
                            break;

                        case Labels.TRAVERSAL_LABEL: 
                        case Labels.NAVIGATION_LABEL:
                            if (currentLabel != Labels.TRAVERSAL_LABEL) {
                                updateLabels(Labels.TRAVERSAL_LABEL, filepath);
                            } 
                            break;
                                                
                        case Labels.SETUP_LABEL: 
                            if (currentLabel != Labels.SETUP_LABEL) {
                                updateLabels(Labels.SETUP_LABEL, filepath);
                            } 
                            break;
                        
                        case Labels.TRACING_LABEL: 
                            if (currentLabel!= Labels.TRACING_LABEL) {
                                updateLabels(Labels. TRACING_LABEL, filepath); 
                            }
                            break;
                        
                        case Labels.CHANGE_IDENTIFICATION: 
                            if (currentLabel != Labels.CHANGE_IDENTIFICATION) {
                                updateLabels(Labels.CHANGE_IDENTIFICATION, filepath);
                            } 
                            break;
                        
                        case Labels.CHANGE_PROPAGATION: 
                            if (currentLabel != Labels.CHANGE_PROPAGATION) {
                                updateLabels(Labels.CHANGE_PROPAGATION, filepath);
                            } 
                            break;
                        case Labels.HELPER_LABEL: 
                            if (currentLabel != Labels.HELPER_LABEL) {
                                updateLabels(Labels.HELPER_LABEL, filepath);
                            } 
                            break;
                        
                        case Labels.WRAPPER_LABEL: 
                            if (currentLabel != Labels.WRAPPER_LABEL) {
                                updateLabels(Labels.WRAPPER_LABEL, filepath);
                            } 
                            break;                        
                    }
                    if (manualLabelCt != -1) {
                        currentLabelCount += manualLabelCt;
                    }
                }
            }
            catch (IOException e) {
                System.out.println("couldnt append numbers of " + line);
            }
        }
    }
    String[] getCleanedArray(String preprocessed) {
        String[] array = preprocessed.split(" ");
        List<String> arraylist = new LinkedList<>();
        for (String a : array) {
            if (!a.equals(""))
                arraylist.add(a);
        }
        return arraylist.toArray(new String[0]);
    }

    private void updateLabels(String newLabel, String filepath) throws IOException {
        writeLabelCount(filepath);
        updateForNewLabelType(newLabel);
    }

    private void writeLabelCount(String filePath) throws IOException {
        String csvLine = filePath +"," + currentLabel + "," + currentLabelCount + "," + labelStartLine + "-"+ currentLine + "\n";
        Files.write(labelCountFileAbsPath, csvLine.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
   
    private void updateForNewLabelType(String newLabel) {
        currentLabel= newLabel;
        currentLabelCount = 0;
        labelStartLine = currentLine + 1;
    }

    private boolean isComment(String line) {
        return commentSymbols.stream().anyMatch((s) -> line.startsWith(s));
    }

    private int getCustomLabelCount(String[] wordArray) {
        if (wordArray.length > 2) {
            String secondEntry = wordArray[2];
            if (secondEntry.matches("\\d+")) {
                System.out.println("second entry " + secondEntry + " current label " + currentLabel);
                skipLinesWithManualAnnotation = true;
                return Integer.parseInt(secondEntry);
            }
            else
                skipLinesWithManualAnnotation = false;
        }
        else 
            skipLinesWithManualAnnotation = false;
        return -1;
    }

    public List<String> extractFilesFromPath(String path) {

        List<String> filesToScan = new LinkedList<String>();
        // get all files in directory
        FileIterator<Path> fiMV = new FileIterator<Path>();
        try {
            Files.walkFileTree(Paths.get(path), fiMV);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // store the files
        for (Path srcFile : fiMV.getRegFiles()) {
            System.out.println(srcFile.toString());
            filesToScan.add(srcFile.toString());
        }
        return filesToScan;
    }

    public static void main(String[] args) {
        String solution;

        if (args.length != 1) {
            System.out.println("Usage: java AnalysisScanner <solution>");
            // set default value so that you can use the LabelCounting directly from your IDE:
            solution = "bxtend-dsl"; 
        }
        else {
            solution = args[0];
        }

        System.out.println("Starting evaluation of " + solution + "...");
        Path properties = Path.of(System.getProperty("user.dir") + "/data/" + solution  + ".properties");
        Config config = new Config(properties);

        AnalysisScanner analysis = new AnalysisScanner(config);

        analysis.extractLabelsFromFiles();

        System.out.println("-------------------------------");
        System.out.println ("analyzed " + analysis.wordCt + " words in " + analysis.lineCt + " lines of " + analysis.fileCt + " files with " + analysis.importLineCt + " import statements." );
    }

    /**
     * resets the counters for each file -> move the state of the scanning to the beginning 
     * (Empty label, currentLine =1, no counts yet)
     */
    protected void resetFileCounters() {
        currentLine = 1;
        currentLabel = Labels.EMPTY_LABEL;
        currentLabelCount = 0;
        labelStartLine = 1;
    }
}

class FileIterator<Path> implements FileVisitor<Path> {
    private List<Path> regFiles = new LinkedList<Path>();

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
        if (attr.isSymbolicLink()) {
                System.out.format("Symbolic link: %s ", file);
            } else if (attr.isRegularFile()) {
                regFiles.add(file);
            } else {
                System.out.format("Other: %s ", file);
            }
            return FileVisitResult.CONTINUE;

    }

    public List<Path> getRegFiles() {
        return regFiles;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;

    }
}