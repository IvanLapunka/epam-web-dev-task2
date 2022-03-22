package by.training.task2.service;

import by.training.task2.entity.Component;
import by.training.task2.entity.VowelsAndConsonants;
import by.training.task2.exception.CustomException;

import java.util.List;
import java.util.Map;

public interface TextService {
    void sortParagraphsByAmountOfSentences(Component component) throws CustomException;
    List<Component> findSentencesWithLongestWord(Component component) throws CustomException;
    void deleteSentencesWithLessThenAmountOfWords(Component component, int amount) throws CustomException;
    Map<String, List<String>> countWordsByLengthCaseInsensitive(Component component) throws CustomException;
    VowelsAndConsonants countVowelsAndConsonantsInComponent(Component component);
}
