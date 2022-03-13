package by.training.task2.util;

import java.util.Stack;

public class StringTransformer {

    public static void main(String[] args) {
        String expr = "5*(1+2*(3/(4-(1-56-47)*73)+(-89+4/(42/7)))+1)";
        //expr = "(1+2)*4+3";
        StringTransformer transformer = new StringTransformer();
        final String s = transformer.tryConvertToPolandNotation(expr);
        System.out.println(s);
    }

    public String convertIfPossibleToPolandNotation(String text) {
        if (text.matches("[()*\\-\\/+0-9]+")) {
            return tryConvertToPolandNotation(text);
        }
        return text;
    }

    private String tryConvertToPolandNotation(String text) {
        boolean first = true;
        StringBuilder number = new StringBuilder();
        StringBuilder poland = new StringBuilder();
        Stack<Character> operations = new Stack<>();
        char c = 0;
        for (char curr: text.toCharArray()) {
            c = curr;
            if (first) {
                if (c == '-') {
                    poland.append('0').append(' ');
                    operations.push(c);
                    first = false;
                    continue;
                }
                first = false;
            }
            if (Character.isDigit(c)) {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    poland.append(number).append(' ');
                    number.replace(0, number.length(), "");//clear StringBuilder;
                }
                if ('(' == c) {
                    operations.push(c);
                    first = true;
                    continue;
                }
                if (')' == c) {
                    boolean foundOpenBracker = false;
                    while(!operations.isEmpty()) {
                        char oper = operations.pop();
                        if (oper == '(') {
                            foundOpenBracker = true;
                            break;
                        }
                        poland.append(oper).append(' ');
                    }
                    if (!foundOpenBracker) {
                        return text;
                    }
                    continue;
                }
                if ("+-*/".indexOf(c) != -1) {
                    while (isGetFromStack(c, operations)) {
                        poland.append(operations.pop()).append(" ");
                    }
                    operations.push(c);//add operation to stack
                } else {
                    return text;//not supported operation
                }
            }
        }
        if ("+-*/".indexOf(c) != -1) {//if the last symbol is operand then the expression is not correct
            return text;
        } else if (number.length() > 0) {
            poland.append(number).append(' ');
        }
        while (!operations.empty()) {
            char operation = operations.pop();
            if (operation == '(') {
                return text;
            } else {
                poland.append(operation).append(' ');
            }
        }
        return poland.toString().trim();
    }

    private boolean isGetFromStack(char current, Stack<Character> stack) {
        if (stack.isEmpty() || stack.peek() == '(') {
            return false;
        }
        return  !("*/".indexOf(current) != -1 && "-+".indexOf(stack.peek()) != -1);
    }
}
