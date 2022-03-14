package by.training.task2.service;

import by.training.task2.entity.Component;

import java.util.List;
import java.util.Map;

public interface TextService {
    Component sortParagraphsByAmountOfSentences(Component component);
    List<Component> findSentencesWithLongestWord(Component component);
    Component deleteSentencesWithLessThenAmountOfWords(Component component, int amount);
    Map<String, Integer> countWordsCaseInsensitive(Component component);
}
