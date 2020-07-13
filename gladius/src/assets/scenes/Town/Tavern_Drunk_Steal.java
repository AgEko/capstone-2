package assets.scenes.Town;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.Booze;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tavern_Drunk_Steal extends Scene {
    public void interaction(){
        int choice = -1;

        System.out.println("0 - Leave" +
                "\n1 - Steal his booze.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Tavern_Drunk_Steal);
        }
        switch (choice){
            case 0:
                WorldState.getInstance().game.setGameState(GameState.Tavern);
                break;
            case 1:
                if (!WorldState.getInstance().isStoleFromDrunk()){
                    awaitInput("You pinch a bottle of 'Devil Water' off the drunk. It looks like he's had enough.");
                    WorldState.getInstance().setStoleFromDrunk(true);
                    WorldState.getInstance().subtractKarma(1);
                    WorldState.getInstance().game.player.getInventory().add(new Booze("Devil Water"));
                } else {
                    awaitInput("You already stole a bottle from the drunk. You leave him be and return to the entrance of the tavern.");
                }
                WorldState.getInstance().game.setGameState(GameState.Tavern);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Tavern_Drunk_Steal);
        }
    }

}
