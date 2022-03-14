package by.training.task2.parser;

import by.training.task2.entity.Component;
import by.training.task2.entity.CompositeLevelInfo;
import by.training.task2.entity.PunctuationLeave;
import by.training.task2.entity.TextComposite;
import by.training.task2.entity.WordLeave;
import by.training.task2.interpreter.Client;
import by.training.task2.util.StringTransformer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndPunctuationHandler extends AbstractTextHandler{
    private static final String WORD_REGEX = "(([^,.!?; ]+)([,.!?;])*)";
    private static final Pattern pattern = Pattern.compile(WORD_REGEX);
    private static final StringTransformer transformer = new StringTransformer();

    @Override
    public Component handleRequest(String text) {
        final Matcher matcher = pattern.matcher(text);
        TextComposite composite = new TextComposite(CompositeLevelInfo.WORD_AND_PUNCTUATION);
        while (matcher.find()) {
            String word = matcher.group(2).trim();
            composite.add(new WordLeave(fromInfixToValue(word), CompositeLevelInfo.WORD));
            String second = matcher.group(3);
            if (second != null) {
                var pleave = new PunctuationLeave(second.trim(), CompositeLevelInfo.PUNCTUATION);
                composite.add(pleave);
            }
        }
        return composite;
    }

    private String fromInfixToValue(String string) {
        String result = transformer.convertIfPossibleToPolandNotation(string);
        if (result.equals(string)) {
            return string;
        }
        System.out.println(result);
        Client client = new Client(result);
        return client.calculate().toString();
    }
}