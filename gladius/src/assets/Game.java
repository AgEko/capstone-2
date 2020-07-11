package assets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    public void startGame(){
        mainMenu();

    }


    public void mainMenu(){
        System.out.println("Select an option");
        System.out.println("======");
        System.out.println("0 - Exit Game.");
        System.out.println("1 - Start Game.");

        try{
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice){
                case 0:
                    //System.out.println("Exit game");
                    break;
                case 1:
                    //System.out.println("Start assets.Game");
                    Adventure newAdventure = new Adventure(this);
                    newAdventure.startAdventure();
                    break;
                default:
                    System.out.println("That is not an option");
                    mainMenu();
            }
        } catch (InputMismatchException e){
            System.out.println("That is not an option");
            mainMenu();
        }
    }





}
