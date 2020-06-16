package main.java.ingestor;

import main.resources.Constants;
import main.resources.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ingestor {
    private final List<String> inputText;

    public Ingestor(){

        this.inputText = new ArrayList<>();
    }

    public List<String> getInputText(){

        return inputText;
    }

    public void writeToFile(String generatedText, String filename){
        File destinationFile = new File(Constants.outputDirectory + "/" + filename);
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile));
            writer.write(generatedText);
            writer.close();

        } catch(Exception e) {
            IO.consolePrint("error", "An error occourred while writing to a file");
            IO.consolePrint("info",e.getMessage());
            IO.consolePrint("success","Generated text:");
            IO.consolePrint("info",generatedText);
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
            FileInputStream fileStream = new FileInputStream(file);
            DataInputStream inputStream = new DataInputStream(fileStream);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferReader.readLine()) != null){
                this.inputText.add(line);
            }
            fileStream.close();
            IO.consolePrint("success","File ingested");
        } catch(Exception e) {
            IO.consolePrint("error", "An error occourred while reading a file");
            IO.consolePrint("info",e.getMessage());
            System.exit(0);
        }

    }



}
