package by.training.task2.entity.impl;

import by.training.task2.entity.Component;
import by.training.task2.entity.CompositeLevelType;

import java.util.ArrayList;
import java.util.List;

public class TextCompositeImpl extends AbstractComponentImpl {
    private List<Component> parts = new ArrayList<>();
    public TextCompositeImpl(CompositeLevelType info) {
        super(info);
    }

    @Override
    public void add(Component component) {
        parts.add(component);
    }

    @Override
    public void remove(Component component) {
        parts.remove(component);
    }

    public List<Component> getParts() {
        return parts;
    }

    public void setParts(List<Component> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component part: parts) {
            sb.append(part.getType().getPrefix())
                    .append(part)
                    .append(part.getType().getSuffix());
        }
        return sb.toString();
    }
}
