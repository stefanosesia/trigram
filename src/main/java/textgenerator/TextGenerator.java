package main.java.textgenerator;

import main.resources.Constants;

import java.util.List;
import java.util.Map;

public class TextGenerator {

    private Integer textLength;
    private String resultingText;

    public TextGenerator(Integer textLength){

        this.textLength = Constants.requiredLength;
        this.resultingText = Constants.resultingText;
    }

    public void setTextLength(Integer textLength){

        this.textLength = textLength;
    }

    public Integer getTextLength(){

        return this.textLength;
    }

    public String getResultingText(){

        return this.resultingText;
    }

    // TODO: 13/06/2020 add text generator
    public void generateText(Map<String, List<String>> trigram){

        this.resultingText = "";
    }


}
