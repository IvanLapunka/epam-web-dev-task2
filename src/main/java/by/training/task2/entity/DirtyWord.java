package by.training.task2.entity;

import by.training.task2.parser.AbstractTextParser;

import java.util.List;

public class DirtyWord implements Text {

    private List<Text> parts;

    public DirtyWord(List<Text> parts) {
        this.parts = parts;
    }

    @Override
    public String getText() {
        return null;
    }
}
