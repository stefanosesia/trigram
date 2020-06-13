package test.java.trigramgenerator;

import main.java.trigramgenerator.TrigramGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

class TrigramGeneratorTest {
    TrigramGenerator trigramGenerator = new TrigramGenerator();

    @BeforeEach
    void setUp() {
    }

    @Test
    void generateKataTrigram() {
        List<String> input = Arrays.asList("I wish I may I wish I might");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("I wish", new ArrayList<String>() {{add("I"); add("I"); }});
        expectedTrigram.put("wish I", new ArrayList<String>() {{add("may"); add("might"); }});
        expectedTrigram.put("may I", new ArrayList<String>() {{add("wish");}});
        expectedTrigram.put("I may", new ArrayList<String>() {{add("I"); }});
        trigramGenerator.generateTrigram(input);
        Map<String, ArrayList<String>> actualTrigram = trigramGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

}