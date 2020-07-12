package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_BoneregardInsult extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("1 - \"Do What?\"");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_BoneregardInsult);
        }
        switch (choice){
            case 1:
                gameOver("Skeletons surround you and rip you to pieces.");
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_BoneregardInsult);
        }
    }
}
