package by.training.task2.parser.impl;

import by.training.task2.entity.CompositeLevelType;

import java.util.regex.Pattern;

public class ParagraphHandlerImpl extends AbstractTextHandlerImpl {
    private static final String SENTENCE_REGEX = "([^.!?;]+[.!?;])";

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(SENTENCE_REGEX);
    }

    @Override
    protected CompositeLevelType getLevelInfo() {
        return CompositeLevelType.PARAGRAPH;
    }
}
