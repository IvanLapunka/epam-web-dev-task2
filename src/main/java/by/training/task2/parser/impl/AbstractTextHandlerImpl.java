package by.training.task2.parser.impl;

import by.training.task2.entity.Component;
import by.training.task2.entity.CompositeLevelType;
import by.training.task2.entity.impl.TextCompositeImpl;
import by.training.task2.parser.ParseHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractTextHandlerImpl implements ParseHandler {
    private static Logger log = LogManager.getLogger();
    ParseHandler handler;

    @Override
    public void setNextHandler(ParseHandler handler) {
        this.handler = handler;
    }

    protected Pattern getPattern() {
        return null;
    }

    protected CompositeLevelType getLevelInfo() {
        return CompositeLevelType.TEXT;
    }

    @Override
    public Component parse(String text) {
        Pattern pattern = getPattern();
        final Matcher matcher = pattern.matcher(text);
        TextCompositeImpl composite = new TextCompositeImpl(getLevelInfo());
        while (matcher.find()) {
            composite.add(handler.parse(matcher.group().trim()));
        }
        return composite;
    }
}
