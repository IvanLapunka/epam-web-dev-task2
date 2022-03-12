package by.training.task2.interpreter;

import java.util.Stack;

public class Context {
    private Stack<Integer> numbers = new Stack<>();

    public Integer popValue() {
        return numbers.pop();
    }

    public void pushValue(Integer value) {
        numbers.push(value);
    }
}
