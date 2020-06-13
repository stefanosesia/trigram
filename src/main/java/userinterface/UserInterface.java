package main.java.userinterface;

public class UserInterface {

    private Integer requiredLength;
    private Integer selectedInput;

    public UserInterface(){

        this.requiredLength = 0;
        this.selectedInput = 0;
    }
    public void setRequiredLength(Integer requiredLength){

        this.requiredLength = requiredLength;
    }

    public void setSelectedInput(Integer selectedInput){

        this.selectedInput = selectedInput;
    }

    public Integer getRequiredLength(){

        return this.requiredLength;
    }

    public Integer getSelectedInput(){

        return this.selectedInput;
    }

    // TODO: 13/06/2020 fix console print
    public void consolePrint(String type, String message){

        System.out.println("[" + type + "] : " + message);
    }

    // TODO: 13/06/2020 create the main
    public void main(){

    }


}
