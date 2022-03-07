package by.training.task2.reader;

import by.training.task2.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;

public class DataReader {
    private static Logger log = LogManager.getLogger();

    public String read(String filePath) throws CustomException {
        String result;
        try {
            final BufferedReader reader = new BufferedReader(new FileReader(filePath));
            result = reader.lines().collect(Collectors.joining());
        } catch (FileNotFoundException e) {
            log.error("There were errors during reading source file" + filePath, e);
            throw new CustomException("Problems during file reading", e);
        }
        return result;
    }
}
