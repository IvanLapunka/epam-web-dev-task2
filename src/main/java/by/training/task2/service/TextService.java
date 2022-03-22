package by.training.task2.service;

import by.training.task2.entity.Component;
import by.training.task2.entity.VowelsAndConsonants;

import java.util.List;
import java.util.Map;

public interface TextService {
    void sortParagraphsByAmountOfSentences(Component component);
    List<Component> findSentencesWithLongestWord(Component component);
    void deleteSentencesWithLessThenAmountOfWords(Component component, int amount);
    Map<String, List<String>> countWordsByLengthCaseInsensitive(Component component);
    VowelsAndConsonants countVowelsAndConsonantsInComponent(Component component);
}
