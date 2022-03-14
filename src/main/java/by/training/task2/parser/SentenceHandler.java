package by.training.task2.parser;

import by.training.task2.entity.CompositeLevelInfo;

import java.util.regex.Pattern;

public class SentenceHandler extends AbstractTextHandler {
    private static final String WORD_AND_PUNCTUATION = "([^,.!?; ]+[,.!?; ])";

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(WORD_AND_PUNCTUATION);
    }

    @Override
    protected CompositeLevelInfo getLevelInfo() {
        return CompositeLevelInfo.SENTENCE;
    }
}
