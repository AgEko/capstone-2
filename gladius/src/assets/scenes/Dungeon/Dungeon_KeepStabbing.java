package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_KeepStabbing extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("1 - Nay! Stab him a third time! I HAVE THE POWER!!!.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_KeepStabbing);
        }
        switch (choice){
            case 1:
                awaitInput("\"Alright, you come into my house and try to kill me, three times, I'm sick of you 'paladin types'. Welcome to the Bone Zone!\"");
                gameOver("A mob of skeletons block your exit as they swarm upon you and rip the flesh from your bones.");
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_KeepStabbing);
        }
    }
}
