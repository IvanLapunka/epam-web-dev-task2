package by.training.task2.entity;

public class PunctuationLeave extends AbstractComponent{
    String leave;

    public PunctuationLeave(String leave, CompositeLevelInfo info) {
        super(info);
        this.leave = leave;
    }

    @Override
    public String toString() {
        return leave;
    }
}
