package test.java.ingestor;

import main.java.ingestor.Ingestor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

}