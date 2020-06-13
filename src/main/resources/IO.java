package main.resources;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

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

    public static void choiceValidator(Integer choice, Integer min, Integer max){

        if (choice < min || choice > max){
            consolePrint("error","Invalid input!");
            System.exit(0);
        }
    }

    public static Integer userInput(String message, Integer min, Integer max){
        Scanner myObj = new Scanner(System.in);
        consolePrint("step",message + " between " + String.valueOf(min) + " and " + String.valueOf(max));

        String input = myObj.nextLine();
        Integer choice = Integer.valueOf(input);
        choiceValidator(choice,min,max);
        return choice;
    }

    public static String concatenate(String element1, String element2){
        return element1 + " " + element2;
    }

    public static List<String> separate(String concatenatedKey){
        return Arrays.asList(concatenatedKey.split(" "));
    }

    public static Integer randomChoice(Integer max){return ThreadLocalRandom.current().nextInt(0, max);}
}
