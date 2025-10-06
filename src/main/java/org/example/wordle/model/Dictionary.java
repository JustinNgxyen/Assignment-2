package org.example.wordle.model;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Dictionary {
    private static final Set<String> words = new HashSet<>();

    static {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Dictionary.class.getResourceAsStream("/org/example/wordle/words.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidWord(String word) {
        return words.contains(word.toLowerCase());
    }
}
