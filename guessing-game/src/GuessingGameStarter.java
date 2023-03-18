import java.util.Scanner;

public class GuessingGameStarter {
    private final GuessingGame game;
    private final Scanner scanner = new Scanner(System.in);

    GuessingGameStarter() {
        this.game = new GuessingGame();
    }

    // helper method: read an integer from input
    private int readInt() {
        while (true) {
            try {
                String token = this.scanner.nextLine();
                return Integer.parseInt(token);
            }catch (Exception ex) {
                System.out.println("Invalid input. Please input a number:");
            }
        }
    }

    private int readPositiveInt() {
        while (true) {
            int num = this.readInt();
            if (num >= 0) {
                return num;
            }
            System.out.println("Invalid input. Please input a non-negative number:");
        }
    }

    // return true if we end the game, false if we continue the game
    private boolean endGame() {
        System.out.println("Would you like to play again, enter Y for yes, N for no.");
        while (true){
            try {
                String YesNo = this.scanner.nextLine();
                if (YesNo.equals("Y") || YesNo.equals("y"))
                    return false;
                if (YesNo.equals("N") || YesNo.equals("n"))
                    return true;
                System.out.println("Invalid input. Please input Y or N:");
            }catch (Exception ex) {
                System.out.println("Invalid input. Please input Y or N:");
            }
        }
    }

    private void startGame() {
        // get max value
        System.out.println("Welcome to the guessing game!\n\nEnter the maximum number:");
        // make sure we get a positive max
        int max = this.readPositiveInt();
        this.game.setMax(max);
        // get max number of guess allowed
        System.out.println("Enter the number of guesses allowed:");
        int guessesAllowed = this.readPositiveInt();
        this.game.newGame(guessesAllowed);
    }

    private void playGame() {
        // take a guess
        System.out.printf("Enter a guess, remember it must be between 0 to %d%n", this.game.getMax());
        int newGuess = this.readInt();
        String guessResult = this.game.guess(newGuess);
        System.out.println(guessResult);
    }

    // Driver method
    public void start() {
        this.startGame();
        while (true) {
            if (this.game.isGameOver()) {
                if(this.endGame())
                    break; // quit game if we choose to end the game
                // restart the game if we choose not to end the game
                this.startGame();
                continue;
            }
            this.playGame();
        }
        System.out.println("\nThank you for playing the game. Bye!");
    }
}
