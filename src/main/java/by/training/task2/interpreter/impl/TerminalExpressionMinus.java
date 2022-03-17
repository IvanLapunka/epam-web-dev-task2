package by.training.task2.interpreter.impl;

import by.training.task2.interpreter.AbstractMathExpression;
import by.training.task2.interpreter.Context;

public class TerminalExpressionMinus implements AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        c.pushValue(- c.popValue() + c.popValue());
    }
}
