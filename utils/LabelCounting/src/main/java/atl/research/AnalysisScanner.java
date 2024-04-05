package atl.research;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
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
import java.util.regex.Pattern;

/**
 * 
 */
public class AnalysisScanner {

    // statitical data
    long fileCt = 0;
    long lineCt = 0;
    long wordCt = 0;
    int chars = 0;
    public static final boolean DEBUG = true;
    public static final boolean DIRECT_FILE_MANIPULATION = false;
    protected final File mappingFile;
    protected final Path mappingFileAbsPath; 

    public static final String NUMBER_REGEX = "\\[0..9]+.?[0..9]*";

    public AnalysisScanner(String mappingFilePath) {
        mappingFile = new File(mappingFilePath);
        mappingFileAbsPath = Paths.get(mappingFile.getAbsolutePath());
        if (mappingFile.exists())
            mappingFile.delete();
        
           try{
                mappingFile.getParentFile().mkdirs();
                mappingFile.createNewFile();
            }
            catch (IOException e) {
                System.out.println("Could not create file " + mappingFilePath);
            }
        
    }

    public static void main(String[] args) {

        System.out.println("Starting evaluation of solutions...");
        // solution folder
        AnalysisScanner analysis = new AnalysisScanner("../../labels/nmf.csv");
        List<String> files = analysis.extractFilesFromPath("../../solutions/nmf");
        analysis.extractLabelsFormFiles(files);

        System.out.println("-------------------------------");
        System.out.println ("analyzed " + analysis.wordCt + " words in " + analysis.lineCt + " lines of " + analysis.fileCt + " files" );
                
    }

    public void extractLabelsFormFiles(List<String> files) {
        System.out.println("inputFile size " + files.size());
    
        for (String filePath : files) {
            if (filePath.endsWith(Config.FILE_EXTENSIONS)) {
                fileCt++;
                System.out.println("-------------------------------");
                System.out.println("scanning file " + filePath);
                try{
                    Files.write(mappingFileAbsPath, (filePath + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                } catch(IOException e ) {
                    System.out.println("couldnt append the file name of " + filePath);
                }
                scanTrafoFile(filePath);
            }
        }
    }

    public void scanTrafoFile(String filepath) {
        Scanner in;
        try {
            in = new Scanner(new File(filepath));
            
            if (DIRECT_FILE_MANIPULATION) {
                String previousLine = "";
                for (int i = 1; in.hasNextLine(); i++) {
                    String line = in.nextLine();
                    if (line.length() > 0)
                    lineCt++;				
                 //   processLine(in, line, previousLine);
                    previousLine = line;
                }
            }
            else {
                for (int i = 1; in.hasNextLine(); i++) {
                    String line = in.nextLine();
                    if (line.length() > 0){
                        lineCt++;
                        processLine(in, line, i);
                    }
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
     
            e.printStackTrace();
        }
            
    }

    public void processLine(Scanner in, String line, int lineNo) {
        line = line.stripLeading();
        line  = line.replaceAll(Config.IGNORED_TOKENS, " ");
        line = line.replaceAll("\\s+", " ");
        
        System.out.println("process line: " + line);
        
        try{
            if (!isComment(line) && !isLibImport(line)) {
                Files.write(mappingFileAbsPath, (lineNo + ",").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                String[] wordArray = line.split(" ");
        
                if (DEBUG) {
                    System.out.println(line + " \t consists of " + wordArray.length + " words");
                }
                Files.write(mappingFileAbsPath, (wordArray.length + "\n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                wordCt += wordArray.length;
            }
            if (isComment(line))
                Files.write(mappingFileAbsPath, (lineNo+ ",COMMENT \n").getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            
        }
        catch(IOException e ) {
            System.out.println("couldnt append numbers of " + line);
        }
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

    // private boolean isLabeled(String prevLine) {
    //     if (Pattern.matches(Config.LABELS, prevLine.toUpperCase()))
    //         System.out.println("Line is labeled " + prevLine);
    //     return Pattern.matches(Config.LABELS, prevLine.toUpperCase());
    // }

    private boolean hasNoLabelCount(String prevLine) {
        if (!prevLine.endsWith(NUMBER_REGEX))
            System.out.println("Has no label " + prevLine);
        return prevLine.endsWith(NUMBER_REGEX)? true :false;
    }

    public List<String> extractFilesFromPath(String path) {

        List<String> mvFiles = new LinkedList<String>();
        // get all files in directory
        FileIterator<Path> fiMV = new FileIterator<Path>();
        try {
            Files.walkFileTree(Paths.get(path), fiMV);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // store the files
        for (Path srcFile : fiMV.getRegFiles()) {
            String fileName = srcFile.getFileName().toString();
                mvFiles.add(srcFile.toString());
            // }
        }
        return mvFiles;
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