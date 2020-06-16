package main.java.userinterface;

import main.java.filemanager.FileManager;
import main.java.ingestor.Ingestor;
import main.java.textgenerator.TextGenerator;
import main.java.trigramgenerator.TrigramGenerator;
import main.resources.Constants;
import main.resources.IO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

public class UserInterface {

    private static String inputFile;
    private static Integer outputLength;
    private static File sourceFile;
    private static final FileManager files = new FileManager();
    private static final Ingestor ingestor = new Ingestor();
    private static final TrigramGenerator trigram = new TrigramGenerator();
    private static final TextGenerator generator = new TextGenerator();

    public UserInterface(){

    }

    public static void main(String[] args) {

        IO.consolePrint("step", "Welcome to the trigram generator");
        try {

            files.readFolder(Constants.libraryDirectory);
            List<String> availableFiles = files.getFileList();
            IO.consolePrint("success", "the following files are available for input:");
            IO.optionsPrinter(availableFiles);
            inputFile = availableFiles.get(IO.userInput("Select a file",0,availableFiles.size() - 1));
            sourceFile = new File(Constants.libraryDirectory + "/" + inputFile);
            outputLength = IO.userInput("Select a length (in words) for the output", Constants.minimumOutputLength, Constants.maximumOutputLength);

        } catch (Exception e){
            IO.consolePrint("error","an error was encountered while selecting options:");
            IO.consolePrint("info",e.getMessage());
            System.exit(0);
        }

        IO.consolePrint("info", inputFile + " will be used to generate an output of " + outputLength + " words.");

        ingestor.readFile(sourceFile);
        trigram.generateTrigram(ingestor.getInputText());

        generator.setTextLength(outputLength);
        generator.generateText(trigram.getTrigram());
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        ingestor.writeToFile(generator.getResultingText(), inputFile + "_" + timeStamp + ".txt");

    }


}
