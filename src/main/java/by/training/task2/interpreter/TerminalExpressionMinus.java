package by.training.task2.interpreter;

public class TerminalExpressionMinus implements AbstractMathExpression{
    @Override
    public void interpret(Context c) {
        c.pushValue(c.popValue() - c.popValue());
    }
}
