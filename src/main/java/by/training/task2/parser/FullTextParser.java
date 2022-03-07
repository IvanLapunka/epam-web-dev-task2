package by.training.task2.parser;

import by.training.task2.entity.FullText;
import by.training.task2.entity.Text;

import java.util.ArrayList;
import java.util.List;

public class FullTextParser extends AbstractTextParser {
    public static final String PARAGRAPH_REGEX = " {4}";

    public void nextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Text parse(String text) {
        final String[] array = text.split(PARAGRAPH_REGEX);
        List<Text> paragraphs = new ArrayList<>();
        for (String paragraph: array) {
            if (paragraph.length() > 0) {
                paragraphs.add(nextParser.parse(paragraph));
            }
        }
        return new FullText(paragraphs);
    }
}
