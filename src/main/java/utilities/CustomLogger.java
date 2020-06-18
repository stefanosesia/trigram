package utilities;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

public class CustomLogger {

    public CustomLogger(){

    }

    public void logEvent(String message){
        try{
            FileWriter fr = new FileWriter(Constants.logfileDirectory, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write("[" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()) + "] "+message + "\n");

            br.close();
            fr.close();
        } catch(Exception e) {
            System.out.println("[!!] logfile is encountering errors, some events might get lost.");
        }

    }
}