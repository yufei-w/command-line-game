import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Q1: Print Area
        Shape shape1 = new Rectangle(2,3);
        Shape shape2 = new Triangle(2,3);
        Shape shape3 = new Circle(2);

        shape1.printArea();
        shape2.printArea();
        shape3.printArea();


        // Q2: Guessing Game
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPress 1 to start the game, 2 to exit:");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("1")) {
                GuessingGameTester gameTester = new GuessingGameTester();
                gameTester.test();
                break;
            }else if (input.equals("2")){
                System.out.println("Exit");
                break;
            }
            System.out.println("Press 1 to start the game, 2 to exit:");
        }


    }
}