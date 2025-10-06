package org.example.wordle.model;

import java.io.Serializable;
import java.util.List;

public class SavedGame implements Serializable {
    private static final long serialVersionUID = 1L;
    public final String word;
    public final int currentIndex;
    public final List<String> guesses;

    public SavedGame(String word, int currentIndex, List<String> guesses) {
        this.word = word;
        this.currentIndex = currentIndex;
        this.guesses = guesses;
    }
}
