package org.example.wordle.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.wordle.model.*;
import org.example.wordle.io.*;
import org.example.wordle.view.WordleView;
import java.util.ArrayList;
import java.util.List;

public class WordleController {

    WordSelector selector = new WordSelector();
    String secretWord = selector.getRandomWord();
    WordleGame game = new WordleGame(secretWord);
    private WordleView view;
    private final List<String> guesses = new ArrayList<>();

    @FXML
    private TextField guessInput;
    @FXML
    private Label welcomeText;
    @FXML
    private Label box00;
    @FXML
    private Label box01;
    @FXML
    private Label box02;
    @FXML
    private Label box03;
    @FXML
    private Label box04;

    @FXML
    private Label box10;
    @FXML
    private Label box11;
    @FXML
    private Label box12;
    @FXML
    private Label box13;
    @FXML
    private Label box14;

    @FXML
    private Label box20;
    @FXML
    private Label box21;
    @FXML
    private Label box22;
    @FXML
    private Label box23;
    @FXML
    private Label box24;

    @FXML
    private Label box30;
    @FXML
    private Label box31;
    @FXML
    private Label box32;
    @FXML
    private Label box33;
    @FXML
    private Label box34;

    @FXML
    private Label box40;
    @FXML
    private Label box41;
    @FXML
    private Label box42;
    @FXML
    private Label box43;
    @FXML
    private Label box44;

    @FXML
    private Label box50;
    @FXML
    private Label box51;
    @FXML
    private Label box52;
    @FXML
    private Label box53;
    @FXML
    private Label box54;

    @FXML private Button keyQ;
    @FXML private Button keyW;
    @FXML private Button keyE;
    @FXML private Button keyR;
    @FXML private Button keyT;
    @FXML private Button keyY;
    @FXML private Button keyU;
    @FXML private Button keyI;
    @FXML private Button keyO;
    @FXML private Button keyP;
    @FXML private Button keyA;
    @FXML private Button keyS;
    @FXML private Button keyD;
    @FXML private Button keyF;
    @FXML private Button keyG;
    @FXML private Button keyH;
    @FXML private Button keyJ;
    @FXML private Button keyK;
    @FXML private Button keyL;
    @FXML private Button keyZ;
    @FXML private Button keyX;
    @FXML private Button keyC;
    @FXML private Button keyV;
    @FXML private Button keyB;
    @FXML private Button keyN;
    @FXML private Button keyM;
    @FXML private Button keyENTER;
    @FXML private Button keyBACKSPACE;

    @FXML
    public void initialize() {
        Label[][] boxes = {
                { box00, box01, box02, box03, box04 },
                { box10, box11, box12, box13, box14 },
                { box20, box21, box22, box23, box24 },
                { box30, box31, box32, box33, box34 },
                { box40, box41, box42, box43, box44 },
                { box50, box51, box52, box53, box54 }
        };
        view = new WordleView(boxes, welcomeText);
        SavedGame saved = GameLoader.loadGame();

        if (saved != null) {
            game = new WordleGame(saved.word);
            for (String guess : saved.guesses) {
                LetterResult[] results = game.checkGuess(guess);
                view.updateRow(game.getCurrentIndex(), guess, results);
                game.nextGuess();
            }
            guesses.addAll(saved.guesses);
            view.showMessage("Previous game loaded!");
        } else {
            String secretWord = selector.getRandomWord();
            game = new WordleGame(secretWord);
            view.showMessage("New game started!");
        }
    }

    @FXML
    protected void handleKey(javafx.event.ActionEvent event) {
        Button button = (Button) event.getSource();
        String letter = button.getText();
        if (guessInput.getText().length() < 5) {
            guessInput.setText(guessInput.getText() + letter);
        }
    }

    @FXML
    protected void handleBackspace() {
        String current = guessInput.getText();
        if (!current.isEmpty()) {
            guessInput.setText(current.substring(0, current.length() - 1));
        }
    }

    @FXML
    protected void handleEnter() {
        String guess = guessInput.getText();
        if (guess.length() != 5) {
            view.showMessage("Enter a 5-letter word!");
            return;
        }
        if (!Dictionary.isValidWord(guess)) {
            view.showMessage("Not a valid word. Try again.");
            guessInput.clear();
            return;
        }

        LetterResult[] results = game.checkGuess(guess);
        view.updateRow(game.getCurrentIndex(), guess, results);

        // Update keyboard
        for (int i = 0; i < guess.length(); i++) {
            Button key = findKeyButton(guess.charAt(i));
            view.updateKeyboard(key, results[i]);
        }
        guesses.add(guess);

        if (game.isCorrectGuess(guess)) {
            view.showMessage("Great! The word was " + game.getWord());
            guessInput.setDisable(true);
            GameSaver.clearSave();
            return;
        }

        game.nextGuess();
        if (!game.hasMoreGuesses()) {
            view.showMessage("Nice try! The word was " + game.getWord());
            guessInput.setDisable(true);
            GameSaver.clearSave();
        } else {
            GameSaver.saveGame(game, guesses);
        }

        guessInput.clear();
    }

    private Button findKeyButton(char c) {
        return switch (Character.toUpperCase(c)) {
            case 'Q' -> keyQ;
            case 'W' -> keyW;
            case 'E' -> keyE;
            case 'R' -> keyR;
            case 'T' -> keyT;
            case 'Y' -> keyY;
            case 'U' -> keyU;
            case 'I' -> keyI;
            case 'O' -> keyO;
            case 'P' -> keyP;
            case 'A' -> keyA;
            case 'S' -> keyS;
            case 'D' -> keyD;
            case 'F' -> keyF;
            case 'G' -> keyG;
            case 'H' -> keyH;
            case 'J' -> keyJ;
            case 'K' -> keyK;
            case 'L' -> keyL;
            case 'Z' -> keyZ;
            case 'X' -> keyX;
            case 'C' -> keyC;
            case 'V' -> keyV;
            case 'B' -> keyB;
            case 'N' -> keyN;
            case 'M' -> keyM;
            default -> null;
        };
    }
}