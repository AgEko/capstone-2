package assets.scenes;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tavern_Drunk extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("0 - Leave" +
                "\n1 - Ask for a donation." +
                "\n2 - Ask for a drink.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Tavern_Drunk);
        }
        switch (choice){
            case 0:
                WorldState.getInstance().game.setGameState(GameState.Tavern);
                break;
            case 1:
                awaitInput("\"The heck? Do I look like I ain't drunk, all my money already?\" With a raspy burp, he passes out.");
                WorldState.getInstance().game.setGameState(GameState.Tavern_Drunk_Steal);
                break;
            case 2:
                awaitInput("\"Get bent, but uh, ill sell you this bottle for 35 gold.\"");
                WorldState.getInstance().game.setGameState(GameState.Tavern_Drunk_Buy);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Tavern_Drunk);
        }
    }
}
