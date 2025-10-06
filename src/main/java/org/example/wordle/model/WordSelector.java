package org.example.wordle.model;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Collectors;

public class WordSelector {
    private List<String> dictionary;
    private Random random;

    public WordSelector() {
        this.dictionary = loadWords();
        this.random = new Random();
    }

    // Load all 5-letter words from words.txt
    private List<String> loadWords() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/org/example/wordle/words.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return reader.lines()
                    .map(String::trim)
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public String getRandomWord() {
        if (dictionary.isEmpty()) {
            throw new IllegalStateException("Dictionary is empty!");
        }
        return dictionary.get(random.nextInt(dictionary.size()));
    }
}
