package by.training.task2.entity;

import java.util.StringJoiner;

public class WordLeave extends AbstractComponent {
    private String word;

    public WordLeave(String word, CompositeLevelInfo info) {
        super(info);
        this.word = word;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(info.getPrefix()).append(word).append(info.getSuffix());
        return sb.toString();
    }
}
