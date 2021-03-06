package by.training.task2.parser.impl;

import by.training.task2.entity.Component;
import by.training.task2.entity.CompositeLevelType;
import by.training.task2.entity.impl.PunctuationLeafImpl;
import by.training.task2.entity.impl.TextCompositeImpl;
import by.training.task2.entity.impl.WordLeafImpl;
import by.training.task2.interpreter.Client;
import by.training.task2.util.StringTransformer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordAndPunctuationHandlerImpl extends AbstractTextHandlerImpl {
    private static final Logger log = LogManager.getLogger();
    private static final String WORD_REGEX = "(([^,.!?; ]+)([,.!?;])*)";
    private static final Pattern pattern = Pattern.compile(WORD_REGEX);
    private static final StringTransformer transformer = new StringTransformer();

    @Override
    public Component parse(String text) {
        final Matcher matcher = pattern.matcher(text);
        TextCompositeImpl composite = new TextCompositeImpl(CompositeLevelType.WORD_AND_PUNCTUATION);
        while (matcher.find()) {
            String word = matcher.group(2).trim();
            composite.add(new WordLeafImpl(fromInfixToValue(word), CompositeLevelType.WORD));
            String second = matcher.group(3);
            if (second != null) {
                var leaf = new PunctuationLeafImpl(second.trim(), CompositeLevelType.PUNCTUATION);
                composite.add(leaf);
            }
        }
        return composite;
    }

    private String fromInfixToValue(String string) {
        String result = transformer.convertIfPossibleToPolandNotation(string);
        if (result.equals(string)) {
            return string;
        }
        log.info(result);
        Client client = new Client(result);
        return client.calculate().toString();
    }
}