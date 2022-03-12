package by.training.task2.parser;

import by.training.task2.entity.CompositeLevelInfo;

import java.util.regex.Pattern;

public class SentenceHandler extends AbstractTextHandler {
    private static final String DIRTY_WORD_REGEX = "([^,.!?; ]+[,.!?; ])";

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(DIRTY_WORD_REGEX);
    }

    @Override
    protected CompositeLevelInfo getLevelInfo() {
        return CompositeLevelInfo.SENTENCE;
    }
}
