package by.training.task2.parser;

import by.training.task2.entity.Component;
import by.training.task2.entity.CompositeLevelInfo;
import by.training.task2.entity.PunctuationLeave;
import by.training.task2.entity.TextComposite;
import by.training.task2.entity.WordLeave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler extends AbstractTextHandler{
    private static final String DIRTY_WORD_REGEX = "(([^,.!?; ]+)([,.!?;])*)";
    private static final Pattern pattern = Pattern.compile(DIRTY_WORD_REGEX);

    @Override
    public Component handleRequest(String text) {
        final Matcher matcher = pattern.matcher(text);
        TextComposite composite = new TextComposite(CompositeLevelInfo.TEXT);
        while (matcher.find()) {
            composite.add(new WordLeave(matcher.group(2).trim(), CompositeLevelInfo.WORD));
            String second = matcher.group(3);
            if (second != null) {
                var pleave = new PunctuationLeave(second.trim(), CompositeLevelInfo.PUNCTUATION);
                composite.add(pleave);
            }
        }
        return composite;
    }
}