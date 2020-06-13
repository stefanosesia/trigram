package main.java.userinterface;

import main.java.filemanager.FileManager;
import main.resources.Constants;
import main.resources.IO;

import java.util.List;

public class UserInterface {

    public UserInterface(){

    }
    // TODO: 13/06/2020 create the main
    public static void main(String[] args) {

        IO.consolePrint("step", "Welcome to the trigram generator");

        IO.consolePrint("info", "Retriving the input files from the library:");
        try {
            FileManager files = new FileManager();
            files.readFolder(Constants.libraryDirectory);
            List<String> availableFiles = files.getFileList();
            IO.consolePrint("success", "select an input file from the list:");
            IO.optionsPrinter(availableFiles);

        } catch (Exception e){
            IO.consolePrint("error","an error was encountered while reading the library:");
            IO.consolePrint("info",e.getMessage());
            return;

        }

    }


}
