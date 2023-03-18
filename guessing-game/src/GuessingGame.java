import java.util.Random;

public class GuessingGame {
    // instance variables
    private int answer;
    private final Random generator;
    private boolean gameOver;
    private int differential;
    private int max; // maximum value of the number to guess
    private int maxGuessesAllowed;
    private int numGuessesTaken;

    // Constructors
    GuessingGame() {
        this.max = 0;
        this.generator = new Random();
    }

    GuessingGame(int max) {
        this.max = max;
        this.generator = new Random();
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMax() {
        return this.max;
    }

    public boolean isGameOver() {
        return this.gameOver;
    }

    public void newGame(int maxGuessesAllowed) {
        // make sure the game is reset
        if (this.max > 0) {
            this.answer = this.generator.nextInt(max); // DEBUG: nextInt() takes only positive input
        }else
            this.answer = 0;
        this.gameOver = false;
        this.differential = max;
        this.numGuessesTaken = 0;
        this.maxGuessesAllowed = maxGuessesAllowed;
    }

    public String guess(int newGuess) {
        // Check remaining guess
        if (this.numGuessesTaken == this.maxGuessesAllowed) {
            this.gameOver = true;
            return "No guess remaining. Game Over...\n";
        }
        this.numGuessesTaken += 1;
        // Guess out of range
        if (newGuess < 0 || newGuess > this.max) {
            return String.format("Guess out of range. The guess must be between 0 and %d", this.max);
        }
        // Correct guess
        if (newGuess == answer) {
            this.gameOver = true;
            return "Congratulations!\n";
        }
        // Wrong guess
        StringBuilder sb = new StringBuilder(); // build the guessing result string
        if (newGuess > answer) {
            sb.append("Too High. ");
        }else {
            sb.append("Too Low. ");
        }
        int newDiff = Math.abs(newGuess - this.answer);
        if (newDiff <= this.differential) {
            sb.append("Getting Warmer...");
        }else {
            sb.append("Getting Colder...");
        }
        this.differential = newDiff;
        return sb.toString();
    }


}
