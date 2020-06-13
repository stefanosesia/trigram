package main.resources;

import java.util.List;

public class IO {

    public IO(){

    }

    public static void consolePrint(String type, String message){

        System.out.println("[" + Constants.messageType.get(type) + "] : " + message);
    }

    public static void optionsPrinter(List<String> listedElements){

        for (int i = 0; i < listedElements.size(); i++) {
            System.out.println("\t[" + String.valueOf(i)  + "]: " + listedElements.get(i));
        }
    }


}
