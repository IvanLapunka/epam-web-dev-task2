package by.training.task2.parser;

import by.training.task2.entity.Text;

import java.util.List;

public abstract class AbstractTextParser {
    protected AbstractTextParser nextParser;

    public void nextParser(AbstractTextParser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract Text parse(String str);
}
