package org.example.wordle.model;

public class WordleGame {
    private int currentIndex = 0;
    private String word;
    private final int maxGuesses = 6;

    public WordleGame(String word) {
        this.word = word.toLowerCase();
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public boolean isCorrectGuess(String guess) {
        return guess.toLowerCase().equals(word);
    }

    public boolean hasMoreGuesses() {
        return currentIndex < maxGuesses;
    }

    public void nextGuess() {
        currentIndex++;
    }

    public String getWord() {
        return word;
    }

    public LetterResult[] checkGuess(String guess) {
        LetterResult[] results = new LetterResult[guess.length()];
        for (int i = 0; i < guess.length(); i++) {
            char letter = guess.charAt(i);
            if (letter == word.charAt(i)) {
                results[i] = LetterResult.CORRECT;
            } else if (word.indexOf(letter) > -1) {
                results[i] = LetterResult.PRESENT;
            } else {
                results[i] = LetterResult.ABSENT;
            }
        }
        return results;
    }

}
