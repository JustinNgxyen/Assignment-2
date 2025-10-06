package org.example.wordle.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.wordle.model.LetterResult;

public class WordleView {

    private Label[][] boxArray;
    private Label statusLabel;

    public WordleView(Label[][] boxArray, Label statusLabel) {
        this.boxArray = boxArray;
        this.statusLabel = statusLabel;
    }

    public void showMessage(String message) {
        statusLabel.setText(message);
    }

    public void updateRow(int rowIndex, String guess, LetterResult[] results) {
        Label[] row = boxArray[rowIndex];
        for (int i = 0; i < 5; i++) {
            row[i].setText(String.valueOf(guess.charAt(i)));
            switch (results[i]) {
                case CORRECT -> row[i].setStyle("-fx-background-color: #8EEDA1;");
                case PRESENT -> row[i].setStyle("-fx-background-color: #FFD700;");
                case ABSENT -> row[i].setStyle("-fx-background-color: #A9A9A9;");
            }
        }
    }

    public void updateKeyboard(Button key, LetterResult result) {
        if (key == null) return;
        switch (result) {
            case CORRECT -> key.setStyle("-fx-background-color: #8EEDA1;");
            case PRESENT -> key.setStyle("-fx-background-color: #FFD700;");
            case ABSENT  -> key.setStyle("-fx-background-color: #A9A9A9;");
        }
    }
}
