package main.java.filemanager;

import main.resources.IO;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FileManager {

    private List<String> availableFiles;

    public FileManager(){

        this.availableFiles = new ArrayList<>();
    }

    public List<String> getFileList(){

        return this.availableFiles;
    }

    public void readFolder(File directory){
        if (directory.list() == null){
            IO.consolePrint("error","Please add some source files in the library directory");
            System.exit(0);
        }
        this.availableFiles = Arrays.asList(directory.list());
        IO.consolePrint("success", "files retrived from the library:");
    }


}
