package main.java.ingestor;

public class Ingestor {
    private String inputText;

    public Ingestor(){

        this.inputText = "";
    }

    // TODO: 13/06/2020 add file open, file close, maybe paging?
    public void openFile(){

        this.inputText = "";
    }

    public String getInputText(){

        return inputText;
    }

}
