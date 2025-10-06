package org.example.wordle.io;

import org.example.wordle.model.SavedGame;
import java.io.*;

public class GameLoader {
    private static final String SAVE_FILE = "savegame.dat";

    public static SavedGame loadGame() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE))) {
            return (SavedGame) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
