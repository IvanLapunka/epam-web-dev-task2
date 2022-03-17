package by.training.task2.interpreter;

public enum MathOperations {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/');
    private final char operation;

    MathOperations(char operation) {
        this.operation = operation;
    }

    public char getOperation() {
        return operation;
    }
}
