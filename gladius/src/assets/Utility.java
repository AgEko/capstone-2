package assets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Utility {

    public static void awaitInput() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public static void singleInput(String a) {
        System.out.println("1 - " + a);

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("");
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    singleInput(a);
            }

        } catch (InputMismatchException e) {
            System.out.println("That is not a valid option.");
            singleInput(a);
        }
    }

    public static void gameOver(String a){
        System.out.println(a);
        Utility.awaitInput();
        System.out.println("As you die you never learn the fate of what happens to you town. Don't do that thing you did that get dead next time.");
        WorldState.getInstance().gameOver = true;
    }


}
