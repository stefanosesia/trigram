package main.java.trigramgenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrigramGenerator {

    private Map<String, List<String>> trigram;

    public TrigramGenerator(){

        this.trigram = new HashMap<>();
    }

    public Map<String, List<String>> getTrigram(){

        return trigram;
    }

    // TODO: 13/06/2020 generate trigram from text
    public void generateTrigram(String inputText) {

        this.trigram = new HashMap<>();
    }
}
