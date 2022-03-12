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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String pr = info.getPrefix();
        String sf = info.getSuffix();
        for (Component part: parts) {
            sb.append(pr).append(part.toString()).append(sf);
        }
        return sb.toString();
    }
}
