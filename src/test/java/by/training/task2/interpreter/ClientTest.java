package by.training.task2.interpreter;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    static class CorrectPostfixNotations implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("0 3 - 5 -", -8),
                    Arguments.of("0 1 2 + 4 * - 3 +", -9),
                    Arguments.of("6 9 * 3 4 + /", 7),
                    Arguments.of("7 5 12 * 2 5 + 2 - 71 - * + 12 /", -329)
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(CorrectPostfixNotations.class)
    void testConvertCorrectExpressionPolishNotation(String sourceExpression, int expected) {
        Client client = new Client(sourceExpression);
        int result = client.calculate();
        assertEquals(expected, result);
    }

}