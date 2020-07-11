package assets;

import assets.town.Baker;
import assets.town.Shop;
import assets.town.Tanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Town {




    public void townMenu(){
        Utility.awaitInput("There are a few people in town who may be willing to donate.");
        System.out.println("1 - Go to the Baker." +
                "\n2 - Go to  the General Shop" +
                "\n3 - Go to  the Tanner" +
                "\n4 - Go to the Noble Lord of the town" +
                "\n5 - Go to  the Tavern" +
                "\n6 - Go to the Local Crime Boss" +
                "\n7 - Go to the at the Temple" +
                "\n8 - Go Home");
        townMenuAction();

    }

    public void townMenuAction(){
        try {
            Scanner a = new Scanner(System.in);
            int choice = a.nextInt();

            switch (choice){
                case 1:
                    Utility.awaitInput("You head to the baker.");
                    Baker baker = new Baker();
                    baker.interaction();
//                    interactionBaker();
                    break;
                case 2:
                    Utility.awaitInput("You head to the General Shop.");
                    Shop shop = new Shop();
                    shop.interaction();
                    break;
                case 3:
                    Utility.awaitInput("You head to the Tanner");
                    Tanner tanner = new Tanner();
                    tanner.interaction();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    HomeMenu home = new HomeMenu();
                    home.homeMenu();
                    break;
                default:
                    System.out.println("That is not a valid option. return to town");
                    townMenu();
            }

        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            townMenu();
        }
    }



}
