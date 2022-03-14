package by.training.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite extends AbstractComponent {
    private List<Component> parts = new ArrayList<>();
    public TextComposite(CompositeLevelInfo info) {
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
            sb.append(part.getInfo().getPrefix())
                    .append(part)
                    .append(part.getInfo().getSuffix());
        }
        return sb.toString();
    }
}
