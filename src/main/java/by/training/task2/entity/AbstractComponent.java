package by.training.task2.entity;

public class AbstractComponent implements Component {
    protected CompositeLevelInfo info;

    public AbstractComponent(CompositeLevelInfo info) {
        this.info = info;
    }
}
