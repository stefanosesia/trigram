package test.java.ingestor;

import main.java.ingestor.Ingestor;
import main.resources.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class IngestorTest {
    Ingestor ingestor = new Ingestor();

    @BeforeEach
    void setUp() {
    }

    @Test
    void testSmallInputFile() {
        File testFile = new File("src/test/sources/example.txt");
        ingestor.readFile(testFile);
        List<String> expectedText = new ArrayList<String>();
        expectedText.add("I wish I may I wish I might");
        assertEquals(expectedText,ingestor.getInputText());
    }

    @Test
    void testMultipleLinesInputFile() {
        File testFile = new File("src/test/sources/LoremIpsum.txt");
        ingestor.readFile(testFile);
        List<String> expectedText = new ArrayList<String>();
        expectedText.add("Lorem ipsum dolor sit amet, consectetur adipiscing eli.");
        expectedText.add("Nullam eget ante quis risus imperdiet scelerisque.");
        expectedText.add("Fusce eget vestibulum odio.");
        expectedText.add("Etiam ut neque erat.");
        expectedText.add("Donec ut ex iaculis, tincidunt sapien a, consequat est.");
        expectedText.add("Praesent luctus arcu eu fringilla laoreet.");
        expectedText.add("Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.");
        assertEquals(expectedText,ingestor.getInputText());
    }

    @Test
    void testCreatingAFile(){
        File testFile = new File(Constants.outputDirectory + "/" + "test");
        ingestor.writeToFile("Example","test");
        assertTrue(testFile.exists());
        assertTrue(testFile.delete());
    }

}