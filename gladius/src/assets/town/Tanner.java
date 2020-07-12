package assets.town;

import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tanner extends Scene{

    public void interaction(){
        boolean quit = false;
        int choice = -1;

        if(!WorldState.getInstance().isInTannery()){
            awaitInput("You enter the Tannery. The Tanner greets you but remains focused on his work.");
            WorldState.getInstance().setInTannery(true);
        }

        while (!quit){
            System.out.println("0 - Leave" +
                "\n1 - Ask for a donation" +
                "\n2 - Rob the Tanner");

            try {
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
            } catch (InputMismatchException e){
                System.out.println("That is not a valid option.");
            }
            switch (choice){
                case 0:
                    WorldState.getInstance().setInTannery(false);
                    quit = true;
                    break;
                case 1:
                    if (WorldState.getInstance().isStoleFromTanner()){
                        awaitInput("You robbed the Tanner already, he doesn't have any more gold.");
                    } else if (!WorldState.getInstance().isTookDonationTanner()){
                        awaitInput("\"Of course, of course we all have skin in this game, I'll give what I can if it means saving our home.\"");
                        awaitInput("He gives you 20 gold.");
                        WorldState.getInstance().addGold(20);
                        WorldState.getInstance().setTookDonationTanner(true);
                    } else {
                        awaitInput("You already took a donation!");
                    }
                    break;
                case 2:
                    if (!WorldState.getInstance().isStoleFromTanner()){
                        awaitInput("\"Aw heck, first the dragon burns half the town and now this?\" You make off with 45 G");
                        WorldState.getInstance().addGold(45);
                        WorldState.getInstance().setStoleFromTanner(true);
                        WorldState.getInstance().subtractKarma(2);
                    }else {
                        awaitInput("You already robbed the Tanner, you're a jerk bro.");
                    }
                    break;
                default:
                    System.out.println("That is not a valid option.");
            }
        }
    }
}
