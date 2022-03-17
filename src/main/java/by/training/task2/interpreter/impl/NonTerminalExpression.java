package by.training.task2.interpreter.impl;

import by.training.task2.interpreter.AbstractMathExpression;
import by.training.task2.interpreter.Context;

public class NonTerminalExpression implements AbstractMathExpression {
    private int number;

    public NonTerminalExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context c) {
        c.pushValue(number);
    }
}
