package by.training.task2.parser;

import by.training.task2.entity.Component;
import by.training.task2.entity.CompositeLevelInfo;
import by.training.task2.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractTextHandler implements ParseHandler{
    Logger log = LogManager.getLogger();
    ParseHandler handler;

    @Override
    public void setNextHandler(ParseHandler handler) {
        this.handler = handler;
    }

    protected Pattern getPattern() {
        return null;
    }

    protected CompositeLevelInfo getLevelInfo() {
        return CompositeLevelInfo.TEXT;
    }

    @Override
    public Component handleRequest(String text) {
        Pattern pattern = getPattern();
        final Matcher matcher = pattern.matcher(text);
        TextComposite composite = new TextComposite(getLevelInfo());
        while (matcher.find()) {
            log.info("start index: " + matcher.start());
            log.info("end index: " + matcher.end());
            composite.add(handler.handleRequest(matcher.group().trim()));
        }
        return composite;
    }
}
