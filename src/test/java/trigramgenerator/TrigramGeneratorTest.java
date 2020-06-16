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
        expectedTrigram.put("i wish", new ArrayList<String>() {{add("i"); add("i"); }});
        expectedTrigram.put("wish i", new ArrayList<String>() {{add("may"); add("might"); }});
        expectedTrigram.put("may i", new ArrayList<String>() {{add("wish");}});
        expectedTrigram.put("i may", new ArrayList<String>() {{add("i"); }});
        trigramGenerator.generateTrigram(input);
        Map<String, ArrayList<String>> actualTrigram = trigramGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

    @Test
    void generateMultilineTrigram() {
        List<String> input = Arrays.asList("I wish I may I wish I might","Did I wish");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("i wish", new ArrayList<String>() {{add("i"); add("i"); }});
        expectedTrigram.put("wish i", new ArrayList<String>() {{add("may"); add("might"); }});
        expectedTrigram.put("may i", new ArrayList<String>() {{add("wish");}});
        expectedTrigram.put("i may", new ArrayList<String>() {{add("i"); }});
        expectedTrigram.put("i might", new ArrayList<String>() {{add("did"); }});
        expectedTrigram.put("did i", new ArrayList<String>() {{add("wish"); }});
        expectedTrigram.put("might did", new ArrayList<String>() {{add("i"); }});

        trigramGenerator.generateTrigram(input);
        Map<String, ArrayList<String>> actualTrigram = trigramGenerator.getTrigram();
        assertEquals(expectedTrigram, actualTrigram);
    }

    @Test
    void concatenateMultipleLines() {
        List<String> input = Arrays.asList("I","like books");
        Map<String, ArrayList<String>> expectedTrigram = new HashMap<>();
        expectedTrigram.put("i like", new ArrayList<String>() {{add("books");}});

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
        String expectedKey = "keysmustnothaveanynonalphacharacter";
        String actualKey = IO.stripKey(input);
        assertEquals(expectedKey, actualKey);
    }

    @Test
    void testStrippingText() {
        String input = "The text( can, have;^ some punctuation.";
        String expectedValue = "the text can, have; some punctuation.";
        String actualValue = IO.stripValues(input);
        assertEquals(expectedValue, actualValue);
    }


}