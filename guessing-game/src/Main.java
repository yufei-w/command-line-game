import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress 1 to start the game, 2 to exit:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("1")) {
                GuessingGameStarter starter = new GuessingGameStarter();
                starter.start();
                break;
            }else if (input.equals("2")){
                System.out.println("Exit");
                break;
            }
            System.out.println("Press 1 to start the game, 2 to exit:");
        }
    }
}