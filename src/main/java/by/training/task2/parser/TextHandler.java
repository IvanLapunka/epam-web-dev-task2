package by.training.task2.parser;

import by.training.task2.entity.Component;
import by.training.task2.entity.CompositeLevelInfo;
import by.training.task2.entity.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class TextHandler extends AbstractTextHandler {
    public static final String PARAGRAPH_REGEX = " {4}";
    private ParseHandler handler;

    @Override
    public void setNextHandler(ParseHandler handler) {
        this.handler = handler;
    }

    @Override
    public Component handleRequest(String text) {
        final String[] array = text.split(PARAGRAPH_REGEX);
        List<Component> paragraphs = new ArrayList<>();
        Component composite = new TextComposite(getLevelInfo());
        for (String paragraph: array) {
            if (paragraph.length() > 0) {
                composite.add(handler.handleRequest(paragraph.trim()));
            }
        }
        return composite;
    }
}
