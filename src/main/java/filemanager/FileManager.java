package main.java.filemanager;

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

        this.availableFiles = Arrays.asList(directory.list());
    }


}
