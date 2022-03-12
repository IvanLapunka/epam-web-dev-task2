package by.training.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements Component {
    private List<Component> parts = new ArrayList<>();

    @Override
    public void add(Component component) {
        parts.add(component);
    }

    @Override
    public void remove(Component component) {
        parts.remove(component);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        parts.forEach(part -> sb.append(part.toString()).append(' '));
        return sb.toString();
    }
}
