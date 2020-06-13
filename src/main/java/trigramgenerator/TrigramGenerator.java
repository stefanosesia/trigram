package main.java.trigramgenerator;

import main.resources.IO;

import java.util.*;

public class TrigramGenerator {

    private Map<String, ArrayList<String>> trigram;

    public TrigramGenerator(){

        this.trigram = new HashMap<>();
    }

    public Map<String, ArrayList<String>> getTrigram(){

        return trigram;
    }

    public void generateTrigram(List<String> inputText) {
        if (inputText == null || inputText.size() == 0){
            IO.consolePrint("error", "Input text is empty");
            System.exit(0);
        }
        for (String line : inputText) {
            List<String> input = Arrays.asList(line.split(" "));
            if (input.size() < 3){
                IO.consolePrint("error", "Line is too short");
                System.exit(0);
            }
            for (int i = 0; i < input.size() - 2; i++) {
                String trigramKey = IO.concatenate(input.get(i),input.get(i+1));
                String trigramValue = input.get(i+2);

                if (trigram.containsKey(trigramKey)){
                   trigram.get(trigramKey).add(trigramValue);
                } else {
                    ArrayList<String> trigramValues = new ArrayList<String>();
                    trigramValues.add(trigramValue);
                    trigram.put(trigramKey, trigramValues);
                }
            }
        }
        IO.consolePrint("success", "Trigram map successfully generated");
    }


}
