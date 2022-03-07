package by.training.task2.parser;

import by.training.task2.entity.Paragraph;
import by.training.task2.entity.Sentence;
import by.training.task2.entity.Text;
import by.training.task2.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractTextParser{

    private static Logger log = LogManager.getLogger();
    private static final String DIRTY_WORD_REGEX = "([^,.!?; ]+[,.!?; ])";
    private static final String NEW_LINE = "\\r?\\n|\\r";
    private static final Pattern pattern = Pattern.compile(DIRTY_WORD_REGEX);

    public void nextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }

    @Override
    public Text parse(String text) {
        final Matcher matcher = pattern.matcher(text);
        List<Text> words = new ArrayList<>();
        while (matcher.find()) {
            log.info("start index: " + matcher.start());
            log.info("end index: " + matcher.end());
            words.add(nextParser.parse(matcher.group()));
        }

        return new Sentence(words);
    }
}
