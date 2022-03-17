package by.training.task2.interpreter.impl;

import by.training.task2.interpreter.AbstractMathExpression;
import by.training.task2.interpreter.Context;

public class TerminalExpressionDivide implements AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        int down = c.popValue();
        int up = c.popValue();
        c.pushValue(up / down);
    }
}
