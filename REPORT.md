# Project Report

## Design Decisions

### Architecture
Explain your MVC structure:
- Model: Hold's the game structure and logic (word validation, correct guess, win/loss state).
- View: Handles the game UI. Renders data and outputs results to user.
- Controller: Gets inputs from view and calls model methods. Updates the view.
- I chose JavaFX because it is a more modern UI toolkit, using FXML and CSS to easily style components.

### Data Structures
- I stored the secret word as a String, chosen randomly from a dictionary text file.
- I used a List of Strings called guesses to keep track of each guess. This is used to maintain the save/load state of the game.
- I used a 6x5 2D array called boxes to store the labels representing the board of the game.
- I used Buttons for each keyboard key for the on-screen keyboard, which changes colors depending on the user's guess.
- I used an enum results to determine the outcome of the guess (CORRECT, PRESENT, ABSENT).
- I used a SavedGame state called saved to save the current progress of the user based on the list of guesses and secret word.

### Algorithms
- Word validation: validate if the guess is the correct length of 5, as well as if it is a valid word in the dictionary.
   - O(n) dictionary loading, O(1) word check
- Guess Evaulation: We check each letter in the guess, checking if it matches the letter of the secret word at that index.
   - O(n^2) worst case if we have to go through the whole word
   - O(n) for storing word in the row
- Keyboard update: change the color of the on-screen keyboard depending on the user's guess (green, yellow gray).
   - O(n) for updating each letter
- Persistance: We store the current game state if there has not been a win/loss yet, as well as loading it to continue later. We serialize and deserialize a SavedGame object.
   - O(n) for serialization/deserialization   

## Challenges Faced
1. **Challenge 1:** Seperating Model-View-Controller
   - **Solution:** Made sure Model contains ALL game logic and state and NO references to UI classes. Made sure View renders model state to screen with NO game logic decisions. Made sure Controller handles user input and communicates between Model and View.

2. **Challenge 2:** Implementing Game Persistance
   - **Solution:** Created a GameLoader and GameSaver that uses ObjectOutputStream and ObjectInputStream. A SavedGame object is created to serialize and deserialize in order to know where the last progress was.

## What We Learned
- JavaFX and GUI development
- OOP
- Git/Version control

## If We Had More Time
- Hint system
- Add Streaks
- Difficulty levels (6,7,8 letter words)
- Leaderboard (least amount of guesses)

