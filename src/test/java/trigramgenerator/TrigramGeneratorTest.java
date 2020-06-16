package test.java.trigramgenerator;

import main.java.trigramgenerator.TrigramGenerator;
import main.resources.IO;
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
        List<String> input = Collections.singletonList("I wish I may I wish I might");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("I wish", new ArrayList<String>() {{add("I"); add("I"); }});
        expectedTrigram.put("wish I", new ArrayList<String>() {{add("may"); add("might"); }});
        expectedTrigram.put("may I", new ArrayList<String>() {{add("wish");}});
        expectedTrigram.put("I may", new ArrayList<String>() {{add("I"); }});
        trigramGenerator.generateTrigram(input);
        Map<String, ArrayList<String>> actualTrigram = trigramGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

    @Test
    void generateMultilineTrigram() {
        List<String> input = Arrays.asList("I wish I may I wish I might","Did I wish");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("I wish", new ArrayList<String>() {{add("I"); add("I"); }});
        expectedTrigram.put("wish I", new ArrayList<String>() {{add("may"); add("might"); }});
        expectedTrigram.put("may I", new ArrayList<String>() {{add("wish");}});
        expectedTrigram.put("I may", new ArrayList<String>() {{add("I"); }});
        expectedTrigram.put("I might", new ArrayList<String>() {{add("Did"); }});
        expectedTrigram.put("Did I", new ArrayList<String>() {{add("wish"); }});
        expectedTrigram.put("might Did", new ArrayList<String>() {{add("I"); }});

        trigramGenerator.generateTrigram(input);
        Map<String, ArrayList<String>> actualTrigram = trigramGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

    @Test
    void concatenateMultipleLines() {
        List<String> input = Arrays.asList("I","like books");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("I like", new ArrayList<String>() {{add("books");}});

        trigramGenerator.generateTrigram(input);
        Map<String, ArrayList<String>> actualTrigram = trigramGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

    @Test
    void skipShortUnconcatenatedLines() {
        List<String> input = Arrays.asList("I","like","reading books");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("like reading", new ArrayList<String>() {{add("books");}});

        trigramGenerator.generateTrigram(input);
        Map<String, ArrayList<String>> actualTrigram = trigramGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

    @Test
    void testStrippingKeys(){
        String input = "keys Must, Not!{Have Any' non-alpha^Character";
        String expectedKey = "keysMustNotHaveAnynonalphaCharacter";
        String actualKey = IO.stripKey(input);
        assertEquals(expectedKey, actualKey);
    }

    @Test
    void testStrippingText() {
        String input = "The text( can, have;^ some punctuation.";
        String expectedValue = "The text can, have; some punctuation.";
        String actualValue = IO.stripValues(input);
        assertEquals(expectedValue, actualValue);
    }


}