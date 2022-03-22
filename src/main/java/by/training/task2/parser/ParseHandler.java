package by.training.task2.parser;

import by.training.task2.entity.Component;

public interface ParseHandler {
    Component parse(String text);
    void setNextHandler(ParseHandler handler);
}
