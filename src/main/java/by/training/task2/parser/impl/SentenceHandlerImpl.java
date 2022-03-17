package by.training.task2.parser.impl;

import by.training.task2.entity.CompositeLevelType;

import java.util.regex.Pattern;

public class SentenceHandlerImpl extends AbstractTextHandlerImpl {
    private static final String WORD_AND_PUNCTUATION = "([^,.!?; ]+[,.!?; ])";

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(WORD_AND_PUNCTUATION);
    }

    @Override
    protected CompositeLevelType getLevelInfo() {
        return CompositeLevelType.SENTENCE;
    }
}
