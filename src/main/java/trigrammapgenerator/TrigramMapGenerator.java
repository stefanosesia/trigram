package trigrammapgenerator;

import utilities.IO;

import java.util.*;

public class TrigramMapGenerator {

    private final Map<String, ArrayList<String>> trigram;

    public TrigramMapGenerator(){

        this.trigram = new HashMap<>();
    }

    public Map<String, ArrayList<String>> getTrigram(){

        return trigram;
    }

    private Boolean hasNext(Integer listSize, Integer recursiveCounter){

        return recursiveCounter < listSize - 1;
    }

    private void extractLines(List<String> inputText) {
        for (int i = 0; i < inputText.size(); i++) {
            ArrayList<String> input = new ArrayList<>(Arrays.asList(IO.stripValues(inputText.get(i)).split(" ")));
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

            generateTrigram(input);
        }
    }

    private void generateTrigram(ArrayList<String> input) {
        for (int i = 0; i < input.size() - 2; i++) {
            String trigramKey = IO.concatenate(IO.stripKey(input.get(i)),IO.stripKey(input.get(i+1)));
            String trigramValue = input.get(i+2);

            if (trigram.containsKey(trigramKey)){
                trigram.get(trigramKey).add(trigramValue);
            } else {
                ArrayList<String> trigramValues = new ArrayList<>();
                trigramValues.add(trigramValue);
                trigram.put(trigramKey, trigramValues);
            }
        }
    }

    public void generateTrigramMap(List<String> inputText) {
        if (inputText == null || inputText.size() == 0){
            IO.consolePrint("error", "Input text is empty");
            System.exit(0);
        }
        extractLines(inputText);
        IO.consolePrint("success", "Trigram map successfully generated");
    }


}
