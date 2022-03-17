package by.training.task2.entity.impl;

import by.training.task2.entity.CompositeLevelType;

public class WordLeafImpl extends AbstractComponentImpl {
    private String word;

    public WordLeafImpl(String word, CompositeLevelType info) {
        super(info);
        this.word = word;
    }

    @Override
    public String toString(){
        return word;
    }
}
