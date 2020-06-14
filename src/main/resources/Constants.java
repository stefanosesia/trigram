package main.resources;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Constants {

    public static final File libraryDirectory = new File("library");
    public static final File outputDirectory = new File("output");
    public static final Integer requiredLength = 0;
    public static final Integer minimumOutputLength = 3;
    public static final Integer maximumOutputLength = 100;
    public static final String resultingText = "Error";
    public static final Map<String,String> messageType = new HashMap<>() {{
        put("info","?");
        put("step","*");
        put("success","✓");
        put("error","!");
    }};

    private Constants(){

    }

}
