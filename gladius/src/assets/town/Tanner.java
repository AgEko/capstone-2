package assets.town;

import assets.Town;
import assets.Utility;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tanner {

    public void interaction(){
        if(!WorldState.getInstance().isInTannery()){
            Utility.awaitInput("You enter the Tannery. The Tanner greets you but remains focused on his work.");
            WorldState.getInstance().setInTannery(true);
        }
        System.out.println("0 - Leave" +
                "\n1 - Ask for a donation" +
                "\n2 - Rob the Tanner");

        try {
            Scanner a = new Scanner(System.in);
            int choice = a.nextInt();

            switch (choice){
                case 0:
                    WorldState.getInstance().setInTannery(false);
                    Town town = new Town();
                    town.townMenu();
                    break;
                case 1:
                    if (WorldState.getInstance().isStoleFromTanner()){
                        Utility.awaitInput("You robbed the Tanner already, he doesn't have any more gold.");
                        interaction();
                    } else if (!WorldState.getInstance().isTookDonationTanner()){
                        Utility.awaitInput("\"Of course, of course we all have skin in this game, I'll give what I can if it means saving our home.\"");
                        Utility.awaitInput("He gives you 20 gold.");
                        WorldState.getInstance().addGold(20);
                        WorldState.getInstance().setTookDonationTanner(true);
                        interaction();
                    } else {
                        Utility.awaitInput("You already took a donation!");
                        interaction();
                    }
                    break;
                case 2:
                    if (!WorldState.getInstance().isStoleFromTanner()){
                        Utility.awaitInput("\"Aw heck, first the dragon burns half the town and now this?\" You make off with 45 G");
                        WorldState.getInstance().addGold(45);
                        WorldState.getInstance().setStoleFromTanner(true);
                        WorldState.getInstance().subtractKarma(2);
                        interaction();
                    }else {
                        Utility.awaitInput("You already robbed the Tanner, you're a jerk bro.");
                        interaction();
                    }
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    interaction();
            }
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            interaction();
        }
    }
}
