import java.util.*;

public class Game {
    Scanner scanner = new Scanner(System.in);



    public void startGame(){
        mainMenu();
    }

    public void mainMenu(){
        int choice;

        System.out.println("Select an option");
        System.out.println("======");
        System.out.println("1");
        System.out.println("2");

        try{
            choice = scanner.nextInt();
            switch (choice){
                case 0:
                    System.out.println("exit game");
                    break;
                case 1:
                    System.out.println(" button 1");
                    break;
            }
        } catch (InputMismatchException e){
            System.out.println("That is not an option");
            mainMenu();
        }




    }





}
