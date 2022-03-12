package by.training.task2.entity;

public enum CompositeLevelInfo {
    TEXT("", ""),
    PARAGRAPH("   ", System.lineSeparator()),
    SENTENCE("", ""),
    WORD(" ", ""),
    PUNCTUATION("", "");

    private final String suffix;
    private final String prefix;

    CompositeLevelInfo(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getPrefix() {
        return prefix;
    }
}
