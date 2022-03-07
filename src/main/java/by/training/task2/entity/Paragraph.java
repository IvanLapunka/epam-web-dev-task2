package by.training.task2.entity;

import java.util.List;

public class Paragraph implements Text{

    private List<Text> parts;

    public Paragraph(List<Text> parts) {
        this.parts = parts;
    }

    @Override
    public String getText() {
        return null;
    }
}
