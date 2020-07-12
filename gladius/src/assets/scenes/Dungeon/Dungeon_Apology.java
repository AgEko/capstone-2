package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Apology extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("1 - Apologize to Mr.Boneregard and explain your quest to help your village.." +
                "\n1 - Stab him a second time! This time with more chutzpah!");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Apology);
        }
        switch (choice){
            case 1:
                awaitInput("Hmm, that is terrible news indeed. We have no love for dragons;  Our Lich may be of assistance to you. Come I shall lead you him.\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich);
                break;
            case 2:
                awaitInput("\"I said stop, friend. Did you need something?\" A little more annoyed, he once again hands you back your sword.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_KeepStabbing);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Apology);
        }
    }
}
