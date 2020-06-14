package main.java.textgenerator;

import main.resources.Constants;
import main.resources.IO;

import java.util.*;

public class TextGenerator {

    private Integer textLength;
    private String resultingText;
    private Map<String, ArrayList<String>> backtrackingMap;

    public TextGenerator(){

        this.textLength = Constants.requiredLength;
        this.resultingText = Constants.resultingText;
        this.backtrackingMap = new HashMap<>();
    }

    public void setTextLength(Integer textLength){

        this.textLength = textLength;
    }

    public String getResultingText(){

        return this.resultingText;
    }

    public void joinText(List<String> generatedList){

        String generatedText = "";
        for (int i = 0; i < generatedList.size(); i++){
            generatedText += generatedList.get(i);
            generatedText += " ";
        }
        this.resultingText = generatedText.substring(0, generatedText.length() -1) ;
    }

    private ArrayList<String> backtrack(String previousWord, String deadEndWord){
        ArrayList<String> alternatives = this.backtrackingMap.get(previousWord);
        alternatives.removeAll(Collections.singletonList(deadEndWord));
        return alternatives;
    }

    private void generateTrigramBacktrackingMap(Map<String, ArrayList<String>> trigram){
        if (!trigram.isEmpty()){
            List<String> keys = new ArrayList<>(trigram.keySet());
            for (String key : keys){
                List<String> components = Arrays.asList(key.split(" "));
                if (this.backtrackingMap.containsKey(components.get(0))){
                    backtrackingMap.get(components.get(0)).add(components.get(1));
                } else {
                    ArrayList<String> alternatives = new ArrayList<String>();
                    alternatives.add(components.get(1));
                    backtrackingMap.put(components.get(0), alternatives);
                }
            }
            IO.consolePrint("success", "An alternative trigram has been generated should the program need to backtrack");
        }
    }

    public void generateText(Map<String, ArrayList<String>> trigram) {
        generateTrigramBacktrackingMap(trigram);
        List<String> generatedList = new ArrayList<>();
        List<String> trigramKeys = new ArrayList<>(trigram.keySet());
        String startingWords = trigramKeys.get(IO.randomChoice(trigramKeys.size()));
        generatedList.add(IO.separate(startingWords).get(0));
        generatedList.add(IO.separate(startingWords).get(1));
        String key = startingWords;
        Integer lastPositionPointer = 1;
        while (generatedList.size() < this.textLength){
            if (trigram.containsKey(key)){
                ArrayList<String> nextWordCandidates = trigram.get(key);
                generatedList.add(nextWordCandidates.get(IO.randomChoice(nextWordCandidates.size())));
                lastPositionPointer += 1;
                key = IO.concatenate(generatedList.get(lastPositionPointer-1), generatedList.get(lastPositionPointer));
            } else {
                ArrayList<String> alternatives = backtrack(generatedList.get(lastPositionPointer-1),generatedList.get(lastPositionPointer));
                if (alternatives.size() != 0) {
                    generatedList.add(lastPositionPointer,alternatives.get(IO.randomChoice(alternatives.size())));
                } else {
                    break;
                }

            }
        }

        joinText(generatedList);
        IO.consolePrint("success","Text generated.");
    }


}
