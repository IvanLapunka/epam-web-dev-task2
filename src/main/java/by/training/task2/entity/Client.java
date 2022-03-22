package by.training.task2.entity;

import by.training.task2.parser.ParseHandler;
import by.training.task2.parser.impl.ParagraphHandlerImpl;
import by.training.task2.parser.impl.SentenceHandlerImpl;
import by.training.task2.parser.impl.TextHandlerImpl;
import by.training.task2.parser.impl.WordAndPunctuationHandlerImpl;

import java.util.logging.Handler;

public class Client {
    private static TextHandlerImpl textHandler = new TextHandlerImpl();
    private static ParagraphHandlerImpl paragraphHandler = new ParagraphHandlerImpl();
    private static SentenceHandlerImpl sentenceHandler = new SentenceHandlerImpl();
    private static WordAndPunctuationHandlerImpl wordHandler = new WordAndPunctuationHandlerImpl();
    private static ParseHandler client;
    static
    {
        textHandler.setNextHandler(paragraphHandler);
        paragraphHandler.setNextHandler(sentenceHandler);
        sentenceHandler.setNextHandler(wordHandler);
        client = textHandler;
    }

    public static ParseHandler getParseHandler() {
        return client;
    }
}
