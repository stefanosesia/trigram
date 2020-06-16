package main.java.trigramgenerator;

import main.resources.IO;

import java.util.*;

public class TrigramGenerator {

    private final Map<String, ArrayList<String>> trigram;

    public TrigramGenerator(){

        this.trigram = new HashMap<>();
    }

    public Map<String, ArrayList<String>> getTrigram(){

        return trigram;
    }

    private Boolean hasNext(Integer listSize, Integer recursiveCounter){

        return recursiveCounter < listSize - 1;
    }

    public void generateTrigram(List<String> inputText) {
        if (inputText == null || inputText.size() == 0){
            IO.consolePrint("error", "Input text is empty");
            System.exit(0);
        }
        for (int i = 0; i < inputText.size(); i++) {
            ArrayList<String> input = new ArrayList<String>(Arrays.asList(IO.stripValues(inputText.get(i)).split(" ")));
            input.removeAll(Collections.singletonList(" "));
            input.removeAll(Collections.singletonList(""));
            if (hasNext(inputText.size(), i)) {
                List<String> nextLineBeginning = Arrays.asList(IO.stripValues(inputText.get(i+1)).split(" ",3));
                if (nextLineBeginning.size() > 1){
                    input.add(nextLineBeginning.get(0));
                    input.add(nextLineBeginning.get(1));
                }

            }
            if (input.size() < 3){
                continue;
            }

            for (int j = 0; j < input.size() - 2; j++) {
                String trigramKey = IO.concatenate(IO.stripKey(input.get(j)),IO.stripKey(input.get(j+1)));
                String trigramValue = input.get(j+2);

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
