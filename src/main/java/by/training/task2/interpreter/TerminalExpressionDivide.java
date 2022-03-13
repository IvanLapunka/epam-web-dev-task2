package by.training.task2.interpreter;

public class TerminalExpressionDivide implements AbstractMathExpression {
    @Override
    public void interpret(Context c) {
        int down = c.popValue();
        int up = c.popValue();
        c.pushValue(up / down);
    }
}
