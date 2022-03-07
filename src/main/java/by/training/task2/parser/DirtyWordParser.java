package by.training.task2.parser;

import by.training.task2.entity.DirtyWord;
import by.training.task2.entity.Text;
import by.training.task2.entity.Word;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirtyWordParser extends AbstractTextParser{
    private static Logger log = LogManager.getLogger();
    private static final String DIRTY_WORD_REGEX = "(([^,.!?; ]+)([,.!?;])*)";
    private static final Pattern pattern = Pattern.compile(DIRTY_WORD_REGEX);

    @Override
    public Text parse(String text) {
        final Matcher matcher = pattern.matcher(text);
        List<Text> words = new ArrayList<>();
        while (matcher.find()) {
            words.add(new Word(matcher.group(2)));
            String second = matcher.group(3);
            if (second != null) {
                words.add(new Word(matcher.group(3)));
            }
        }
        return new DirtyWord(words);
    }
}
