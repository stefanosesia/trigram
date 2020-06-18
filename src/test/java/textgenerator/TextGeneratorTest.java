package textgenerator;

import org.junit.jupiter.api.Test;
import trigrammapgenerator.TrigramMapGenerator;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

class TextGeneratorTest {
    TrigramMapGenerator trigramMapGenerator = new TrigramMapGenerator();
    TextGenerator generator = new TextGenerator();

    @Test
    void generatingTextFlatTrigram() {
        List<String> input = Collections.singletonList("testing flat trigram");
        trigramMapGenerator.generateTrigramMap(input);
        generator.setTextLength(3);
        generator.generateText(trigramMapGenerator.getTrigram());
        String expectedGeneratedText = "testing flat trigram";
        assertEquals(expectedGeneratedText,generator.getResultingText());

    }


}