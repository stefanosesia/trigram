package main.java.textgenerator;

import main.resources.Constants;
import main.resources.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextGenerator {

    private Integer textLength;
    private String resultingText;

    public TextGenerator(){

        this.textLength = Constants.requiredLength;
        this.resultingText = Constants.resultingText;
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


    public void generateText(Map<String, ArrayList<String>> trigram) {
        List<String> generatedList = new ArrayList<>();
        List<String> trigramKeys = new ArrayList<>(trigram.keySet());
        String startingWords = trigramKeys.get(IO.randomChoice(trigramKeys.size()));
        generatedList.add(IO.separate(startingWords).get(0));
        generatedList.add(IO.separate(startingWords).get(1));
        String key = startingWords;
        Integer lastPositionPointer = 1;
        while (trigram.containsKey(key) && generatedList.size() < this.textLength){
            ArrayList<String> nextWordCandidates = trigram.get(key);
            generatedList.add(nextWordCandidates.get(IO.randomChoice(nextWordCandidates.size())));
            lastPositionPointer += 1;
            key = IO.concatenate(generatedList.get(lastPositionPointer-1), generatedList.get(lastPositionPointer));
        }

        joinText(generatedList);
        IO.consolePrint("success","Text generated.");
    }


}
