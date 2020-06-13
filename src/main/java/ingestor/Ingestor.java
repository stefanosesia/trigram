package main.java.ingestor;

import main.resources.Constants;
import main.resources.IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ingestor {
    private List<String> inputText;

    public Ingestor(){

        this.inputText = new ArrayList<>();
    }

    public List<String> getInputText(){

        return inputText;
    }

    public void writeToFile(String generatedText, String filename){
        File destinationFile = new File(Constants.outputDirectory + "/" + filename);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.outputDirectory));
            writer.write(generatedText);
            writer.close();

        } catch(Exception e) {
            IO.consolePrint("error", "An error occourred while writing to a file");
            IO.consolePrint("info",e.getMessage());
            System.exit(0);
        }
    }

    public void hasAccess(File file){
        if (!file.exists() || !file.canRead()){
            IO.consolePrint("error", "Error reading " + file.toString() + " do you have the right access?");
            System.exit(0);
        }
    }

    public void readFile(File file){
        hasAccess(file);
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                this.inputText.add(scanner.nextLine());
            }
            scanner.close();
            IO.consolePrint("success","File ingested");
        } catch(Exception e) {
            IO.consolePrint("error", "An error occourred while reading a file");
            IO.consolePrint("info",e.getMessage());
            System.exit(0);
        }

    }



}
