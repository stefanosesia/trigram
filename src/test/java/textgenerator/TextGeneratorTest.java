package test.java.textgenerator;

import main.java.textgenerator.TextGenerator;
import main.java.trigramgenerator.TrigramGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class TextGeneratorTest {
    TrigramGenerator trigramGenerator = new TrigramGenerator();
    TextGenerator generator = new TextGenerator();

    @BeforeEach
    void setUp() {
    }

    @Test
    void generatingTextFlatTrigram() {
        List<String> input = Arrays.asList("testing flat trigram");
        trigramGenerator.generateTrigram(input);
        generator.setTextLength(3);
        generator.generateText(trigramGenerator.getTrigram());
        String expectedGeneratedText = "testing flat trigram";
        assertEquals(expectedGeneratedText,generator.getResultingText());

    }


}