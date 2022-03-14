package by.training.task2.entity;

public class AbstractComponent implements Component {
    protected CompositeLevelInfo info;

    public AbstractComponent(CompositeLevelInfo info) {
        this.info = info;
    }

    public CompositeLevelInfo getInfo() {
        return info;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String pr = info.getPrefix();
        String sf = info.getSuffix();
        for (Component part: getParts()) {
            sb.append(pr).append(part.toString()).append(sf);
        }
        return sb.toString();
    }
}
