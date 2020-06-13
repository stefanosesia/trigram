package main.java.filemanager;

import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private List<String> availableFiles;

    public FileManager(){

        this.availableFiles = new ArrayList<>();
    }

    public List<String> getFileList(){

        return this.availableFiles;
    }

    // TODO: 13/06/2020 add folder reader functionality
    public void readFolder(){

        this.availableFiles = new ArrayList<>();
    }


}
