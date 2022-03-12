package by.training.task2.parser;

import by.training.task2.entity.CompositeLevelInfo;

import java.util.regex.Pattern;

public class ParagraphHandler extends AbstractTextHandler {
    private static final String SENTENCE_REGEX = "([^.!?;]+[.!?;])";

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(SENTENCE_REGEX);
    }

    @Override
    protected CompositeLevelInfo getLevelInfo() {
        return CompositeLevelInfo.PARAGRAPH;
    }
}
