package assets.scenes.Town;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tanner extends Scene{

    public void interaction(){
        int choice = -1;

        if(!WorldState.getInstance().isInTannery()){
            awaitInput("You enter the Tannery. The Tanner greets you but remains focused on his work.");
            WorldState.getInstance().setInTannery(true);
        }

            System.out.println("0 - Leave" +
                "\n1 - Ask for a donation" +
                "\n2 - Rob the Tanner");

            try {
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
            } catch (InputMismatchException e){
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Tanner);

            }
            switch (choice){
                case 0:
                    WorldState.getInstance().setInTannery(false);
                    WorldState.getInstance().game.setGameState(GameState.TownMenu);
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
                    WorldState.getInstance().game.setGameState(GameState.Tanner);
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
                    WorldState.getInstance().game.setGameState(GameState.Tanner);
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    WorldState.getInstance().game.setGameState(GameState.Tanner);

            }
    }
}
