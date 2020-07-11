package assets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    public void startGame() {
        System.out.println("Select an option");
        System.out.println("======");
        System.out.println("0 - Exit Game.");
        System.out.println("1 - Start Game.");
        int choice = -1;


        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That is not an option");
            startGame();
        }
        switch (choice) {
            case 0:
                break;
            case 1:
                new Adventure().adventureIntro();
                break;
            default:
                System.out.println("That is not an option");
                startGame();
        }
    }


}
