package by.training.task2.service;

import by.training.task2.entity.Component;
import by.training.task2.entity.CompositeLevelInfo;
import by.training.task2.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
    Logger log = LogManager.getLogger();

    @Override
    public Component sortParagraphsByAmountOfSentences(Component component) {
        if (!component.getInfo().equals(CompositeLevelInfo.TEXT)){
            return component;//throw exception
        }
        final List<Component> collect = component.getParts().stream()
                .sorted(Comparator.comparingInt(a -> a.getParts().size()))
                .collect(Collectors.toList());
        ((TextComposite)component).setParts(collect);
        return component;
    }

    @Override
    public List<Component> findSentencesWithLongestWord(Component component) {
        if (!component.getInfo().equals(CompositeLevelInfo.TEXT)) {
            return Collections.emptyList();
        }
        Stack<Integer> maxValue = new Stack<>();
        maxValue.push(0);
        final List<Map.Entry<Integer, Component>> wordLengthSentence = component.getParts().stream()
                .flatMap(paragraph -> paragraph.getParts().stream())
                .map(sentence -> {
                    final Integer wordMaxLength = sentence.getParts().stream()
                            .flatMap(wordAndPunctuation -> wordAndPunctuation.getParts().stream())
                            .map(word -> word.toString().length())
                            .max(Integer::compareTo)
                            .get();
                    if (maxValue.peek() < wordMaxLength) {
                        maxValue.pop();
                        maxValue.push(wordMaxLength);
                    }
                    return Map.entry(wordMaxLength, sentence);
                })
                .collect(Collectors.toList());

        final List<Component> result = wordLengthSentence.stream()
                .filter(entry -> entry.getKey().equals(maxValue.peek()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        log.info("maximum word length is " + maxValue.pop());
        return result;
    }

    @Override
    public Component deleteSentencesWithLessThenAmountOfWords(Component component, int amount) {
        return null;
    }

    @Override
    public Map<String, Integer> countWordsCaseInsensitive(Component component) {
        return null;
    }
}
