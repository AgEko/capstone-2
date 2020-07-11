package assets.town;

import assets.Town;
import assets.Utility;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Baker {

    public void interaction(){
        if (!WorldState.getInstance().isInBakery()){
            Utility.awaitInput("You enter the bakery and see the Baker pounding on some cake.");
            WorldState.getInstance().setInBakery(true);
        }
        System.out.println("0 - Leave" +
                "\n1 - Ask for a donation." +
                "\n2 - Steal from the register.");
        try {
            Scanner a = new Scanner(System.in);
            int choice = a.nextInt();

            switch (choice){
                case 0:
                    WorldState.getInstance().setInBakery(false);
                    Town town = new Town();
                    town.townMenu();
                    break;
                case 1:
                    if (!WorldState.getInstance().isTookDonationBaker()){
                        Utility.awaitInput("\"Sure thing, it ain't much but here's what I can spare. \"");
                        Utility.awaitInput("He gives you 15 gold.");
                        WorldState.getInstance().addGold(15);
                        WorldState.getInstance().setTookDonationBaker(true);
                        interaction();
                    } else {
                        Utility.awaitInput("You already took a donation!");
                        interaction();
                    }
                    break;
                case 2:
                    if (!WorldState.getInstance().isStoleFromBaker()){
                        Utility.awaitInput("You distract the Baker by pointing behind him. \"Look! an orc kissing a mermaid!\"");
                        Utility.awaitInput("You reach into the register and make off with the dough. *hur hur*" +
                                "\nYou grabbed 30 gold." +
                                "\nYou call the Baker a weirdo for looking.");
                        WorldState.getInstance().addGold(30);
                        WorldState.getInstance().setStoleFromBaker(true);
                        WorldState.getInstance().subtractKarma(1);
                        interaction();
                    }else {
                        Utility.awaitInput("You already stole from here!");
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
