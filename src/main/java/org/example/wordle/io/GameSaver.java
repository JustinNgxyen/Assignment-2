package org.example.wordle.io;

import org.example.wordle.model.SavedGame;
import org.example.wordle.model.WordleGame;
import java.io.*;
import java.nio.file.*;

public class GameSaver {
    private static final String SAVE_FILE = "savegame.dat";

    public static void saveGame(WordleGame game, java.util.List<String> guesses) {
        SavedGame saved = new SavedGame(game.getWord(), game.getCurrentIndex(), guesses);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE))) {
            oos.writeObject(saved);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearSave() {
        try {
            Files.deleteIfExists(Path.of(SAVE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
