# Assignment 2 - Wordle

## Team Members
- Justin Nguyen

## How to Run
1. Clone repository: `git clone https://github.com/JustinNgxyen/Assignment-2.git`
2. Open in IntelliJ
3. [If JavaFX] Configure VM options: `--module-path [path-of-your-JavaFX-lib-folder] --add-modules javafx.controls`
4. Run `HelloApplication.java`

## Features Implemented
- Secret Word Selection: Random 5-letter word from a dictionary
- Guess Input: Accept user guesses (keyboard or on-screen keyboard)
- Feedback System:
    - Green: correct letter in correct position
    - Yellow: correct letter in wrong position
    - Gray: letter not in word
- Dictionary Validation: Only accept valid English words
- Win/Lose Conditions: Win by guessing correctly within 6 tries, lose otherwise
- Visual Keyboard: Show which letters have been used and their status

## Controls
- Use keyboard to type guess into text box
- Use on-screen keyboard to input guess

## Known Issues
- Issue 1: Save file would not save last unfinished game. Figured out a way to write the last guess onto the file.
- Issue 2: On screen-keyboard would change colors everytime a new guess was given instead of keeping the highest value (green if correct). I prevented the keys from changing colors if it is correct and only change it if the letter is in the correct spot in the box.

## External Libraries
- Just JavaFX 25
