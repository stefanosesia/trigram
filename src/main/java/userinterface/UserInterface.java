package main.java.userinterface;

import main.java.filemanager.FileManager;
import main.resources.Constants;
import main.resources.IO;

import java.util.List;

public class UserInterface {

    private static String inputFile;

    public UserInterface(){

    }

    public static void main(String[] args) {

        IO.consolePrint("step", "Welcome to the trigram generator");

        IO.consolePrint("info", "Retriving the input files from the library:");
        try {
            FileManager files = new FileManager();
            files.readFolder(Constants.libraryDirectory);
            List<String> availableFiles = files.getFileList();
            IO.consolePrint("success", "the following files are available for input:");
            IO.optionsPrinter(availableFiles);
            inputFile = availableFiles.get(IO.userInput("Select a file",0,availableFiles.size() - 1));

        } catch (Exception e){
            IO.consolePrint("error","an error was encountered while selecting the input file:");
            IO.consolePrint("info",e.getMessage());
            System.exit(0);
        }

        IO.consolePrint("info", inputFile + " will be used to generate the trigram.");


    }


}
