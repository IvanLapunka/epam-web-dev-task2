package by.training.task2.parser.impl;

import by.training.task2.entity.Component;

import by.training.task2.entity.impl.TextCompositeImpl;

public class TextHandlerImpl extends AbstractTextHandlerImpl {
    public static final String PARAGRAPH_REGEX = " {4}";

    @Override
    public Component handleRequest(String text) {
        final String[] array = text.split(PARAGRAPH_REGEX);
        Component composite = new TextCompositeImpl(getLevelInfo());
        for (String paragraph: array) {
            if (paragraph.length() > 0) {
                composite.add(handler.handleRequest(paragraph.trim()));
            }
        }
        return composite;
    }
}
