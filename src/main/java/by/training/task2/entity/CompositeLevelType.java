package by.training.task2.entity;

public enum CompositeLevelType {
    TEXT("", ""),
    PARAGRAPH("   ", System.lineSeparator()),
    SENTENCE("", ""),
    WORD_AND_PUNCTUATION(" ", ""),
    WORD("", ""),
    PUNCTUATION("", "");

    private final String suffix;
    private final String prefix;

    CompositeLevelType(String prefix, String suffix) {
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
