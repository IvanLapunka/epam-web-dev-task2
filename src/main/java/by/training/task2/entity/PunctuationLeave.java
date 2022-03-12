package by.training.task2.entity;

public class PunctuationLeave implements Component{
    String leave;

    public PunctuationLeave(String leave) {
        this.leave = leave;
    }

    @Override
    public String toString() {
        return leave;
    }
}
