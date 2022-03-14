package by.training.task2.parser;

import by.training.task2.entity.Component;

import by.training.task2.entity.TextComposite;

public class TextHandler extends AbstractTextHandler {
    public static final String PARAGRAPH_REGEX = " {4}";

    @Override
    public Component handleRequest(String text) {
        final String[] array = text.split(PARAGRAPH_REGEX);
        Component composite = new TextComposite(getLevelInfo());
        for (String paragraph: array) {
            if (paragraph.length() > 0) {
                composite.add(handler.handleRequest(paragraph.trim()));
            }
        }
        return composite;
    }
}
