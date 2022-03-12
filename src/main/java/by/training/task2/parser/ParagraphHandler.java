package by.training.task2.parser;

import java.util.regex.Pattern;

public class ParagraphHandler extends AbstractTextHandler {
    private static final String SENTENCE_REGEX = "([^.!?;]+[.!?;])";

    @Override
    protected Pattern getPattern() {
        return Pattern.compile(SENTENCE_REGEX);
    }
}