package assets.scenes;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.Blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CrimeBoss extends Scene {

    public void interaction(){
        int choice = -1;

        if(!WorldState.getInstance().isAtCrimeBoss()){
            WorldState.getInstance().setAtCrimeBoss(true);
        }


        System.out.println("0 - Leave" +
                "\n1 - Ask for a donation." +
                "\n2 - Ask for help robbing the Noble Lord.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.CrimeBoss);
        }
        switch (choice){
            case 0:
                WorldState.getInstance().setAtCrimeBoss(false);
                WorldState.getInstance().game.setGameState(GameState.TownMenu);
                break;
            case 1:
                if (!WorldState.getInstance().isOweTheMob()){
                    awaitInput("\"Now just why should we give a damn about what happens to the this town? What's in it for me?\"");
                    WorldState.getInstance().game.setGameState(GameState.CrimeBoss_DonationReply);
                } else {
                    awaitInput("You already made a deal with the mob, better not cross them!");
                }
                WorldState.getInstance().game.setGameState(GameState.CrimeBoss);
                break;
            case 2:
                if(!objectExists(WorldState.getInstance().game.player.getInventory(), Blackjack.class)){
                    awaitInput(" Hey I'm looking to rob the Noble, I'm in need of something quiet to get past the guards.");
                    awaitInput("The CrimeBoss muses for a time. \"I do 'av it in for that ponce. I'll cut ye a deal, on a real fine piece of merchandise to get ye past the guards.\"");
                    WorldState.getInstance().game.setGameState(GameState.CrimeBoss_Buy);
                } else {
                    awaitInput("You already bought the Blackjack! Get to theivin' you!");
                }
                WorldState.getInstance().game.setGameState(GameState.CrimeBoss);
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.CrimeBoss);
        }
    }

}
