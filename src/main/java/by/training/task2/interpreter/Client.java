package by.training.task2.interpreter;

import java.util.ArrayList;
import java.util.List;

public class Client {
    List<AbstractMathExpression> expressions = new ArrayList<>();

    public Client(String text) {
        parse(text);
    }

    private void parse(String expression) {
        for (String value: expression.trim().split("\\p{Blank}+")) {
            switch (value.charAt(0)){
                case '+': expressions.add(new TerminalExpressionPlus());
                break;
                case '-': expressions.add(new TerminalExpressionMinus());
                break;
                case '*': expressions.add(new TerminalExpressionMultiply());
                break;
                case '/': expressions.add(new TerminalExpressionDivide());
                break;
                default:
                    expressions.add(new NonTerminalExpression(Integer.parseInt(value)));
            }
        }
    }

    public Integer calculate() {
        Context context = new Context();
        for (AbstractMathExpression expression:expressions) {
            expression.interpret(context);
        }
        return context.popValue();
    }
}
