package by.training.task2.entity.impl;

import by.training.task2.entity.CompositeLevelType;

public class PunctuationLeafImpl extends AbstractComponentImpl {
    String leaf;

    public PunctuationLeafImpl(String leave, CompositeLevelType info) {
        super(info);
        this.leaf = leave;
    }

    @Override
    public String toString() {
        return leaf;
    }
}
