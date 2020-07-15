package assets.scenes.Town;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.Blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CrimeBoss_Buy extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("1 - Buy a BlackJack for 75 gold.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.CrimeBoss_Buy);
        }
        switch (choice){
            case 1:
                if(WorldState.getInstance().getGold() > 75){
                    awaitInput("Twas a pleasure doin' business with yea.");
                    awaitInput("You receive a Blackjack.");
                    WorldState.getInstance().subtractGold(75);
                    WorldState.getInstance().game.player.getInventory().add(new Blackjack("Blackjack"));
                    WorldState.getInstance().game.setGameState(GameState.CrimeBoss);
                } else {
                    awaitInput("Eee, you don't have the coin. \"That price is a bit too steep for me Boss\"");
                    awaitInput("The CrimeBoss roars, \"Then get the HEKkk out!\"");
                    awaitInput("You flee back to town");
                    WorldState.getInstance().setAtCrimeBoss(false);
                    WorldState.getInstance().game.setGameState(GameState.TownMenu);
                }
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.CrimeBoss_Buy);
        }
    }
}
