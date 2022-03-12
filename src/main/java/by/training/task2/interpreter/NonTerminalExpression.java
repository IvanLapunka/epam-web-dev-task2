package by.training.task2.interpreter;

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
