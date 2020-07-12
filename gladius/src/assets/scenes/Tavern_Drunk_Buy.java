package assets.scenes;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.Booze;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tavern_Drunk_Buy extends Scene {
    public void interaction(){
        int choice = -1;

        System.out.println("0 - Leave" +
                "\n1 - Yes, buy the booze for 35 gold." +
                "\n2 - No, \"How about YOU get bent?\"");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Tavern_Drunk_Buy);
        }
        switch (choice){
            case 0:
                WorldState.getInstance().game.setGameState(GameState.Tavern);
                break;
            case 1:
                if (WorldState.getInstance().getGold() > 35){
                    awaitInput("\"Smart lad ye are, now leave me to me troubles..\"");
                    awaitInput("You buy the 'Devil Water' for 35 gold.");
                    WorldState.getInstance().game.player.getInventory().add(new Booze("Devil Water"));
                    WorldState.getInstance().subtractGold(35);
                } else {
                    awaitInput("You tell the drunk you don't ave enough gold. He stares blankly at you for a moment and stands up.");
                    awaitInput("The drunk then hadoukens a fart at you, forcing you to retreat with tears in your eyes.");
                }
                WorldState.getInstance().game.setGameState(GameState.Tavern);
                break;
            case 2:
                awaitInput("\"Then get lost dog. I drink alone.\"");
                WorldState.getInstance().game.setGameState(GameState.Tavern);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Tavern_Drunk_Buy);
        }
    }
}
