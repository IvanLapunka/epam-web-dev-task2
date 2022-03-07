package by.training.task2.entity;

import java.util.List;

public class Sentence implements Text {

    private List<Text> parts;

    public Sentence(List<Text> parts) {
        this.parts = parts;
    }

    @Override
    public String getText() {
        return null;
    }
}
