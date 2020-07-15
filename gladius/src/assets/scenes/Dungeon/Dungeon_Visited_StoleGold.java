package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Visited_StoleGold extends Scene {
    public void interaction(){
        int choice = -1;
        awaitInput("Upon entry to the Crypt you stand at the entrance.");
        awaitInput("In unison every skeleton locks their sight on you.");
        awaitInput("\"He returns!\" Mr. Boneregard cries out. \"Un-flesh him!\"");

        System.out.println("1 - Fight the skeletons." +
                "\n2 - Run for it! ");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Visited_StoleGold);
        }
        switch (choice) {
            case 1:
                awaitInput("Are you simple? There are like ten skeles and they don't die. You better run.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Visited_StoleGold_Attack);
                break;
            case 2:
                awaitInput("Without hesitation you about-face and sprint away. Safe!.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Visited_StoleGold);
        }
    }
}
