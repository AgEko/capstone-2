package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Visited extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("0 - Leave and go Home" +
                "\n1 - Enter the dungeon.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon);
        }
        switch (choice){
            case 0:
                awaitInput("You head Home.");
                WorldState.getInstance().game.setGameState(GameState.HomeMenu);
                break;
            case 1:
                awaitInput("You venture into the Dungeon.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Entrance);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
        }
    }
}
