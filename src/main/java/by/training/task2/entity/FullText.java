package by.training.task2.entity;

import java.util.List;

public class FullText implements Text {
    private List<Text> parts;

    public FullText(List<Text> parts) {
        this.parts = parts;
    }

    @Override
    public String getText() {
        return null;
    }
}