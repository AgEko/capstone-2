package assets.town;


import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Baker extends Scene {

    public void interaction(){
        boolean quit = false;
        int choice = -1;
        if (!WorldState.getInstance().isInBakery()){
            awaitInput("You enter the bakery and see the Baker pounding on some cake.");
            WorldState.getInstance().setInBakery(true);
        }

        while (!quit){
            System.out.println("0 - Leave" +
                    "\n1 - Ask for a donation." +
                    "\n2 - Steal from the register.");
            try {
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
            } catch (InputMismatchException e){
                System.out.println("That is not a valid option.");
            }
            switch (choice){
                case 0:
                    WorldState.getInstance().setInBakery(false);
                    quit = true;
                    break;
                case 1:
                    if (!WorldState.getInstance().isTookDonationBaker()){
                        awaitInput("\"Sure thing, it ain't much but here's what I can spare. \"");
                        awaitInput("He gives you 15 gold.");
                        WorldState.getInstance().addGold(15);
                        WorldState.getInstance().setTookDonationBaker(true);
                    } else {
                        awaitInput("You already took a donation!");
                    }
                    break;
                case 2:
                    if (!WorldState.getInstance().isStoleFromBaker()){
                        awaitInput("You distract the Baker by pointing behind him. \"Look! an orc kissing a mermaid!\"");
                        awaitInput("You reach into the register and make off with the dough. *hur hur*" +
                                "\nYou grabbed 30 gold." +
                                "\nYou call the Baker a weirdo for looking.");
                        WorldState.getInstance().addGold(30);
                        WorldState.getInstance().setStoleFromBaker(true);
                        WorldState.getInstance().subtractKarma(1);
                    }else {
                        awaitInput("You already stole from here!");
                    }
                    break;
                default:
                    System.out.println("That is not a valid option.");
            }
        }
    }

}
