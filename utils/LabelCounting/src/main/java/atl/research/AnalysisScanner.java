package atl.research;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import atl.research.Config;

/**
 * 
 */
public class AnalysisScanner {

    protected static String analyzedDirectory = "../../solutions/nmf";
    // statistical data
    long fileCt = 0;
    long lineCt = 0;
    long wordCt = 0;
    int chars = 0;
    
    protected int currentLine = 0;
    protected String currentLabel = Config.EMPTY_LABEL;
    protected int currentLabelCount = 0;
    protected int labelStartLine = 0;


    public static final boolean DEBUG = true;
    protected final File mappingFile;
    protected final Path mappingFileAbsPath; 


    public AnalysisScanner(String mappingFilePath) {
        mappingFile = new File(mappingFilePath);
        mappingFileAbsPath = Paths.get(mappingFile.getAbsolutePath());
        if (mappingFile.exists())
            mappingFile.delete();
        
           try{
               mappingFile.getParentFile().mkdirs();
               mappingFile.createNewFile();

               // create header
               String header =  "'File name, Label, Count, Lines\n";
               Files.write(mappingFileAbsPath, header.getBytes() , StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
            catch (IOException e) {
                System.out.println("Could not create file " + mappingFilePath);
            }
        
    }

    public void extractLabelsFromFiles(List<String> files) {
        System.out.println("inputFile size " + files.size());
        for (String filePath : files) {
                fileCt++;
                System.out.println("-------------------------------");
                System.out.println("scanning file " + filePath);
                resetFileCounters();
                // add name of file to csv for tracing/logging reasons
                try{
                    Files.write(mappingFileAbsPath, (filePath + ",,\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    if (filePath.endsWith("ClassToRelational.cs"))
                        scanTrafoFile(filePath);
                } catch(IOException e ) {
                    System.out.println("couldnt append the file name of " + filePath);
                }
        }
    }

    public void scanTrafoFile(String filepath) throws IOException {
        currentLine = 1;
        Scanner in;
        try {
            in = new Scanner(new File(filepath));
                 while (in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.length() > 0){
                        lineCt++;
                        processLine(in, line);
                        currentLine++;
                    }
                }
            in.close();
        } catch (FileNotFoundException e) {
     
            e.printStackTrace();
        }
            
    }

    public void processLine(Scanner in, String line) throws IOException {
        line = line.stripLeading();
        line  = line.replaceAll(Config.IGNORED_TOKENS, " ");
        line = line.replaceAll("\\s+", " ");
        String preprocessed = line; 
        System.out.println("process line: " + preprocessed);
        
        try{
            String[] wordArray = preprocessed.split(" ");
            if (!isComment(preprocessed) && !isLibImport(preprocessed)) {
                if (DEBUG) {
                    System.out.println(line + " \t consists of " + wordArray.length + " words");
                }
                currentLabelCount += wordArray.length; 
                wordCt += wordArray.length;
            }
            if (isComment(preprocessed) && wordArray.length > 1 )
            {
               String prospectiveLabel = wordArray[1].toUpperCase();  
                switch (wordArray[1].toUpperCase()) {
                    case Config.TRANSFORMATION_LABEL: {
                        if (currentLabel != Config.TRANSFORMATION_LABEL) {
                            updateLabels(Config.TRANSFORMATION_LABEL);
                        } break;
                    }
                    case Config.TRAVERSAL_LABEL: {
                        if (currentLabel != Config.TRAVERSAL_LABEL) {
                            updateLabels(Config.TRAVERSAL_LABEL);
                        } break;
                    }
                    
                    case Config.SETUP_LABEL: {
                        if (currentLabel != Config.SETUP_LABEL) {
                            updateLabels(Config.SETUP_LABEL);
                        } break;
                    }
                    
                    case Config.TRACING_LABEL: 
                    if (currentLabel!= Config.TRACING_LABEL) {
                       updateLabels(Config. TRACING_LABEL); 
                    }
                    break;
                    
                    case Config.CHANGE_IDENTIFICATION: {
                        if (currentLabel != Config.CHANGE_IDENTIFICATION) {
                            updateLabels(Config.CHANGE_IDENTIFICATION);
                        } break;
                    }
                    case Config.HELPER_LABEL: {
                        if (currentLabel != Config.HELPER_LABEL) {
                            updateLabels(Config.HELPER_LABEL);
                        } break;
                    }
                    case Config.WRAPPER_LABEL: {
                        if (currentLabel != Config.WRAPPER_LABEL) {
                            updateLabels(Config.WRAPPER_LABEL);
                        } break;
                    }
                //         TRANSFORMATION_LABEL + "|" 
                //                            + TRAVERSAL_LABEL + "|"  
                //                            + HELPER_LABEL + "|"
                //                            + HELPER_LABEL + "|"
                //                            + SETUP_LABEL + "|"
                //                            + CHANGE_PROPAGATION + "|"
                //                            + WRAPPER_LABEL + 
                 }
            }
        }
        catch(IOException e ) {
            System.out.println("couldnt append numbers of " + line);
        }
    }

    private void updateLabels(String newLabel) throws IOException {
        String csvLine = "," + currentLabel + "," + currentLabelCount + "," + labelStartLine + "-"+ currentLine + "\n";
        Files.write(mappingFileAbsPath, csvLine.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        currentLabel= newLabel;
        currentLabelCount = 0;
        labelStartLine = currentLine;
    }

    private boolean isComment(String line) {
        if (line.startsWith(Config.COMMENT_SYMBOL))
            System.out.println("Line is a comment " + line);
        return line.startsWith(Config.COMMENT_SYMBOL)? true :false;
    }
    
    private boolean isLibImport(String line) {
        if (line.startsWith(Config.LIB_IMPORT))
            System.out.println("Line is a lib import " + line);
        return line.startsWith(Config.LIB_IMPORT)? true :false;
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
            String absPath =  srcFile.toAbsolutePath().toString(); 
            String fileName = srcFile.getFileName().toString();
            filesToScan.add(srcFile.toString());
        }
        return filesToScan;
    }

    public static void main(String[] args) {

        System.out.println("Starting evaluation of solutions...");
        // solution folder
        AnalysisScanner analysis = new AnalysisScanner("../../labels/blub.csv");
        List<String> files = analysis.extractFilesFromPath(analyzedDirectory);
        analysis.extractLabelsFromFiles(files);

        System.out.println("-------------------------------");
        System.out.println ("analyzed " + analysis.wordCt + " words in " + analysis.lineCt + " lines of " + analysis.fileCt + " files" );
                
    }
    protected void resetFileCounters() {
        currentLine = 0;
        currentLabel = Config.EMPTY_LABEL;
        currentLabelCount = 0;
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