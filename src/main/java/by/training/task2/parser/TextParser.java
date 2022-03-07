package by.training.task2.parser;

import by.training.task2.entity.Text;
import by.training.task2.exception.CustomException;

public class TextParser {

    private static AbstractTextParser fullText = new FullTextParser();
    private static AbstractTextParser paragraphText = new ParagraphParser();
    private static AbstractTextParser sentenceText = new SentenceParser();
    private static AbstractTextParser dirtyWordsText = new DirtyWordParser();
    private static AbstractTextParser parser;
    static {
        fullText.nextParser(paragraphText);
        paragraphText.nextParser(sentenceText);
        sentenceText.nextParser(dirtyWordsText);
        parser = fullText;
    }

    public static Text parse(String text) throws CustomException {
        if (text == null) {
            throw new CustomException("There is no text to parse");
        }

        return parser.parse(text);
    }
}
