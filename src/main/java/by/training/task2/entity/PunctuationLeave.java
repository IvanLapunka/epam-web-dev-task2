package by.training.task2.entity;

import java.util.StringJoiner;

public class PunctuationLeave extends AbstractComponent{
    String leave;

    public PunctuationLeave(String leave, CompositeLevelInfo info) {
        super(info);
        this.leave = leave;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(info.getPrefix()).append(leave).append(info.getSuffix());
        return sb.toString();
    }
}
