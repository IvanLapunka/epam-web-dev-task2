package by.training.task2.util;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTransformer {

    private static final String ARITHMETIC_OPERATIONS = "+-*/";
    private static final String FIRST_PRIORITY_OPERATIONS = "*/";
    private static final String SECOND_PRIORITY_OPERATIONS = "-+";
    private static final String FIRST_CHECK_ARITHMETIC_EXPRESSION = "[()*\\-\\/+0-9]+";
    private static final String INCORRECT_ARITHMETIC_EXPRESSION = "([+\\-*\\/]){2,}";
    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';
    private static final String SPACE = " ";
    private static final char MINUS = '-';
    private static final String ZERO = "0";


    public String convertIfPossibleToPolandNotation(String text) {
        if (text.matches(FIRST_CHECK_ARITHMETIC_EXPRESSION)){
            Pattern pattern = Pattern.compile(INCORRECT_ARITHMETIC_EXPRESSION);
            Matcher m = pattern.matcher(text);
            if (!m.find()) {
                return tryConvertToPolandNotation(text);
            }
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
                if (c == MINUS) {
                    poland.append(ZERO).append(SPACE);
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
                    poland.append(number).append(SPACE);
                    clearStringBuilder(number);
                }
                if (OPEN_BRACKET == c) {
                    operations.push(c);
                    first = true;
                    continue;
                }
                if (CLOSE_BRACKET == c) {
                    boolean foundOpenBracker = false;
                    while(!operations.isEmpty()) {
                        char oper = operations.pop();
                        if (oper == OPEN_BRACKET) {
                            foundOpenBracker = true;
                            break;
                        }
                        poland.append(oper).append(SPACE);
                    }
                    if (!foundOpenBracker) {
                        return text;
                    }
                    continue;
                }
                if (ARITHMETIC_OPERATIONS.indexOf(c) != -1) {
                    while (isGetFromStack(c, operations)) {
                        poland.append(operations.pop()).append(SPACE);
                    }
                    operations.push(c);//add operation to stack
                } else {
                    return text;//not supported operation
                }
            }
        }
        if (ARITHMETIC_OPERATIONS.indexOf(c) != -1) {//if the last symbol is operand then the expression is not correct
            return text;
        } else if (number.length() > 0) {
            poland.append(number).append(SPACE);
        }
        while (!operations.empty()) {
            char operation = operations.pop();
            if (operation == OPEN_BRACKET) {
                return text;
            } else {
                poland.append(operation).append(SPACE);
            }
        }
        return poland.toString().trim();
    }

    private void clearStringBuilder(StringBuilder number) {
        number.replace(0, number.length(), "");//clear StringBuilder;
    }

    private boolean isGetFromStack(char current, Stack<Character> stack) {
        if (stack.isEmpty() || stack.peek() == OPEN_BRACKET) {
            return false;
        }
        return  !(FIRST_PRIORITY_OPERATIONS.indexOf(current) != -1
                && SECOND_PRIORITY_OPERATIONS.indexOf(stack.peek()) != -1);
    }
}
