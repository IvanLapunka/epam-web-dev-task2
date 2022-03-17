package by.training.task2.entity.impl;

import by.training.task2.entity.Component;
import by.training.task2.entity.CompositeLevelType;

public class AbstractComponentImpl implements Component {
    protected CompositeLevelType type;

    public AbstractComponentImpl(CompositeLevelType info) {
        this.type = info;
    }

    public CompositeLevelType getType() {
        return type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String pr = type.getPrefix();
        String sf = type.getSuffix();
        for (Component part: getParts()) {
            sb.append(pr).append(part.toString()).append(sf);
        }
        return sb.toString();
    }
}
