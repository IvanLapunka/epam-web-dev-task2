package by.training.task2.entity;

public class WordLeave extends AbstractComponent {
    private String word;

    public WordLeave(String word, CompositeLevelInfo info) {
        super(info);
        this.word = word;
    }

    @Override
    public String toString(){
        return word;
    }
}
