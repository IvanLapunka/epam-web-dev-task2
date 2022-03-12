package by.training.task2.entity;

public class WordLeave implements Component {
    private String word;

    public WordLeave(String word) {
        this.word = word;
    }

    @Override
    public String toString(){
        return word;
    }
}
