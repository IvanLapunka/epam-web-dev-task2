package by.training.task2.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StringTransformerTest {

    static class CorrectArithmeticExpressions implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("-3-5", "0 3 - 5 -"),
                    Arguments.of("-(1+2)*4+3", "0 1 2 + 4 * - 3 +"),
                    Arguments.of("6*9/(3+4)", "6 9 * 3 4 + /"),
                    Arguments.of("(7+5*12*(2+5-2-71))/12", "7 5 12 * 2 5 + 2 - 71 - * + 12 /")
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(CorrectArithmeticExpressions.class)
    void testConvertCorrectExpressionPolishNotation(String sourceExpression, String expected) {
        StringTransformer st = new StringTransformer();
        String result = st.convertIfPossibleToPolandNotation(sourceExpression);
        assertEquals(expected, result);
    }

    static class InCorrectArithmeticExpressions implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("-(3-5"),
                    Arguments.of("-()1+2)*4+3"),
                    Arguments.of("6*9/(3+4))"),
                    Arguments.of("(7*******/*5**12*(2+5-2-71))/12")/////how to check that this is incorrect?
            );
        }
    }

    @ParameterizedTest
    @ArgumentsSource(InCorrectArithmeticExpressions.class)
    void testInConvertCorrectExpressionPolishNotation(String sourceExpression) {
        StringTransformer st = new StringTransformer();
        String result = st.convertIfPossibleToPolandNotation(sourceExpression);
        assertEquals(sourceExpression, result);
    }
}