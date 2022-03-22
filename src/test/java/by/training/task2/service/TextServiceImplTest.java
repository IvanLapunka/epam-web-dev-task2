package by.training.task2.service;

import by.training.task2.entity.Client;
import by.training.task2.entity.Component;
import by.training.task2.entity.VowelsAndConsonants;
import by.training.task2.exception.CustomException;
import by.training.task2.parser.ParseHandler;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class TextServiceImplTest {
    final ParseHandler textParser = Client.getParseHandler();
    final TextService service = new TextServiceImpl();

    @Test
    void sortParagraphsByAmountOfSentences() {
        String source = "    A. B. C. D." + System.lineSeparator() +
                "    A. B. C." + System.lineSeparator() +
                "    A. B." + System.lineSeparator() +
                "    A. ";
        String target =
                "    A. " + System.lineSeparator() +
                "    A. B." + System.lineSeparator() +
                "    A. B. C." + System.lineSeparator() +
                "    A. B. C. D.";
        final Component sourceComponent = textParser.parse(source);
        try {
            service.sortParagraphsByAmountOfSentences(sourceComponent);
        } catch (CustomException e) {
            e.printStackTrace();
        }

        final Component expectedComponent = textParser.parse(target);
        assertEquals(expectedComponent.toString(), sourceComponent.toString());
    }

    @Test
    void findSentencesWithLongestWord() throws CustomException {
        String sourceText = "    A. B. C. D e fg." + System.lineSeparator() +
                "    A. B. C." + System.lineSeparator() +
                "    A. B." + System.lineSeparator() +
                "    A bc. ";
        List<String> expected = List.of(" A bc.", " D e fg.");
        final Component text = textParser.parse(sourceText);

        List<Component> sentencesWithLongestWord = service.findSentencesWithLongestWord(text);
        final List<String> result = sentencesWithLongestWord.stream().map(sentence -> sentence.toString())
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        assertIterableEquals(expected, result);
    }

    @Test
    void deleteSentencesWithLessThenAmountOfWords() throws CustomException {
        String source = "    A B C, D." + System.lineSeparator() +
                "    A B, C." + System.lineSeparator() +
                "    A B." + System.lineSeparator() +
                "    A. ";
        final Component parse = textParser.parse(source);
        service.deleteSentencesWithLessThenAmountOfWords(parse, 3);
        String target = "    A B C, D." + System.lineSeparator() +
                "    A B, C.";
        final Component targetComponent = textParser.parse(target);
        assertEquals(targetComponent.toString(), parse.toString());
    }

    @Test
    void countWordsByLengthCaseInsensitive() throws CustomException {
        String source = "    A Bb Ccc, Dddd." + System.lineSeparator() +
                "    A bB, ccc." + System.lineSeparator() +
                "    A bb." + System.lineSeparator() +
                "    A. ";
        final Component sourceComponent = textParser.parse(source);
        final Map<String, List<String>> expected = Map.of("a", List.of("A", "A", "A", "A"),
                "bb", List.of("Bb", "bB", "bb"),
                "ccc", List.of("Ccc", "ccc"),
                "dddd", List.of("Dddd"));
        final Map<String, List<String>> result = service.countWordsByLengthCaseInsensitive(sourceComponent);
        assertTrue(expected.equals(result));
    }

    @Test
    void countVowelsAndConsonantsInComponent() {
        StringBuilder sb = new StringBuilder();
        sb.append("    ");
        for(char c = 'a'; c <= 'z'; c++)
            sb.append(c);
        sb.append(".");
        String source = sb.toString();
        final Component text = textParser.parse(source);
        VowelsAndConsonants vc = new VowelsAndConsonants(5, 21);
        final VowelsAndConsonants result = service.countVowelsAndConsonantsInComponent(text);
        assertEquals(vc, result);
    }
}