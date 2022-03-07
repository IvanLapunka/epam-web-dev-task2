package by.training.task2.parser;

import by.training.task2.entity.FullText;
import by.training.task2.entity.Paragraph;
import by.training.task2.entity.Text;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractTextParser {
    private static Logger log = LogManager.getLogger();
    private static final String SENTENCE_REGEX = "([^.!?;]+[.!?;])";
    private static final Pattern pattern = Pattern.compile(SENTENCE_REGEX);

    public void nextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Text parse(String text) {
        final Matcher matcher = pattern.matcher(text);
        List<Text> paragraphs = new ArrayList<>();
        while (matcher.find()) {
            log.info("start index: " + matcher.start());
            log.info("end index: " + matcher.end());
            paragraphs.add(nextParser.parse(matcher.group()));
        }

        return new Paragraph(paragraphs);
    }
}
