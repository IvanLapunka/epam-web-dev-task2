package by.training.task2.entity;

import java.util.StringJoiner;

public class VowelsAndConsonants {
    private int vowels;
    private int consonants;

    public VowelsAndConsonants(int vowels, int consonats) {
        this.vowels = vowels;
        this.consonants = consonats;
    }

    public int getVowels() {
        return vowels;
    }

    public int getConsonants() {
        return consonants;
    }

    public void setVowels(int vowels) {
        this.vowels = vowels;
    }

    public void setConsonants(int consonants) {
        this.consonants = consonants;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("", "VowelsAndConsonants{", "}");
        return  sj.add("vowels=").add(vowels + "")
                .add(", consonants=").add(consonants +"")
                .toString();
    }
}
