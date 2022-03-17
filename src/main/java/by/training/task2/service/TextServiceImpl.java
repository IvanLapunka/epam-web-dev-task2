package by.training.task2.service;

import by.training.task2.entity.Component;
import by.training.task2.entity.VowelsAndConsonants;
import by.training.task2.entity.CompositeLevelType;
import by.training.task2.entity.impl.TextCompositeImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
    public static final String VOWELS = "aeiouAEIOU";
    Logger log = LogManager.getLogger();

    @Override
    public Component sortParagraphsByAmountOfSentences(Component component) {
        if (!component.getType().equals(CompositeLevelType.TEXT)){
            return component;//throw or not to throw exception?
        }
        final List<Component> collect = component.getParts().stream()
                .sorted(Comparator.comparingInt(a -> a.getParts().size()))
                .collect(Collectors.toList());
        ((TextCompositeImpl)component).setParts(collect);
        return component;
    }

    @Override
    public List<Component> findSentencesWithLongestWord(Component component) {
        if (!component.getType().equals(CompositeLevelType.TEXT)) {
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
    public void deleteSentencesWithLessThenAmountOfWords(Component component, int amount) {
        for (Component paragraph: component.getParts()) {
            paragraph.getParts().removeIf(sentence -> sentence.getParts().size() < amount);
        }
        component.getParts().removeIf(paragraph -> paragraph.getParts().size() < 1);
    }

    @Override
    public Map<String, List<String>> countWordsByLengthCaseInsensitive(Component component) {
        Map<String, List<String>> result = new HashMap<>();
        component.getParts().stream()
                .flatMap(paragraph -> paragraph.getParts().stream())
                .flatMap(sentence -> sentence.getParts().stream())
                .flatMap(wordAndPunctuation -> wordAndPunctuation.getParts().stream())
                .filter(leave -> leave.getType().equals(CompositeLevelType.WORD))
                .map(Component::toString)
                .peek(word -> {
                    if (result.containsKey(word.toLowerCase(Locale.ROOT))) {
                        result.get(word.toLowerCase(Locale.ROOT)).add(word);
                    } else {
                        result.put(word.toLowerCase(Locale.ROOT), new ArrayList<>(List.of(word)));
                    }
                })
                .count();
        return result;
    }

    @Override
    public VowelsAndConsonants countVowelsAndConsonantsInComponent(Component component) {
        if (component.getType() == CompositeLevelType.PUNCTUATION) {
            return new VowelsAndConsonants(0, 0);
        }
        if (component.getType() == CompositeLevelType.WORD) {
            int vowels = 0;
            int consonants = 0;
            for (char c: component.toString().toCharArray()) {
                if(Character.isLetter(c)) {
                    if (VOWELS.indexOf(c) != -1) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                }
            }
            return new VowelsAndConsonants(vowels, consonants);
        }
        VowelsAndConsonants result = new VowelsAndConsonants(0, 0);
        component.getParts().forEach(subcomponent -> {
            var curr = countVowelsAndConsonantsInComponent(subcomponent);
            result.setVowels(result.getVowels() + curr.getVowels());
            result.setConsonants(result.getConsonants() + curr.getConsonants());
        });
        return result;
    }
}
