package main.java.trigramgenerator;

import java.util.*;

public class TrigramGenerator {

    private Map<String, ArrayList<String>> trigram;

    public TrigramGenerator(){

        this.trigram = new HashMap<>();
    }

    public Map<String, ArrayList<String>> getTrigram(){

        return trigram;
    }

    public String concatenate(String element1, String element2){
        return element1 + " " + element2;
    }

    public void generateTrigram(List<String> inputText) {
        for (String line : inputText) {
            List<String> input = Arrays.asList(line.split(" "));
            for (int i = 0; i < input.size() - 2; i++) {
                String trigramKey = concatenate(input.get(i),input.get(i+1));
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
    }


}
