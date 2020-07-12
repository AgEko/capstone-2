package assets;

import assets.town.Baker;
import assets.town.Noble;
import assets.town.Shop;
import assets.town.Tanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Town extends Scene{


    public void townMenu(){

        townMenuAction();
    }

    public void townMenuAction(){
        boolean quit = false;
        int choice = -1;

        while (!quit){
            awaitInput("You arrive in the town of Kleinstadt.");
            System.out.println("0 - Go home" +
                    "\n1 - Go to the Baker." +
                    "\n2 - Go to  the General Shop" +
                    "\n3 - Go to  the Tanner" +
                    "\n4 - Go to the Noble Lord of the town" +
                    "\n5 - Go to  the Tavern" +
                    "\n6 - Go to the Local Crime Boss" +
                    "\n7 - Go to the at the Temple");
            try {
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
            } catch (InputMismatchException e){
                System.out.println("That is not a valid option.");
            }

            switch (choice){
                case 0:
                    awaitInput("You leave town.");
                    quit = true;
                    break;
                case 1:
                    awaitInput("You head to the baker.");
                    Baker baker = new Baker();
                    baker.interaction();
                    break;
                case 2:
                    awaitInput("You head to the General Shop.");
                    Shop shop = new Shop();
                    shop.interaction();
                    break;
                case 3:
                    awaitInput("You head to the Tanner");
                    Tanner tanner = new Tanner();
                    tanner.interaction();
                    break;
                case 4:
                    awaitInput("You head to the Noble Lord's Estate");
                    Noble noble = new Noble();
                    noble.interaction();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    System.out.println("That is not a valid option.");
            }
        }
    }



}
