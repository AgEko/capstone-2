package assets.scenes.Dragon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dragon_Date_Pre extends Scene {

    public void interaction(){
        int choice = -1;
        awaitInput("You return to town, with gold in hand and a date with a dragon.");
        awaitInput("Lirastrasza has not agreed to spare the village yet, so you plan your next move.");

        System.out.println("1 -  Inform the townspeople of the date. " +
                "\n      Attempt to set an ambush for Lirastrasza, while you distract her on the date." +
                "\n2 - \"Nah i'm cool as a cucumber, I'm going on a date with a dragon.\"");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dragon_Date_Pre);
        }
        switch (choice){
            case 1:
                awaitInput("The townspeople agree that dealing with the dragon would be better than living in fear of it." +
                        "\n They will ambush Lirastrasza on the date.");
                WorldState.getInstance().setAmbush(true);
                WorldState.getInstance().game.setGameState(GameState.Dragon_Date);
                break;
            case 2:
                awaitInput("You decide to wing it and rely on your sick dragon dating game. Good luck!");
                WorldState.getInstance().game.setGameState(GameState.Dragon_Date);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dragon_Date_Pre);
        }
    }
}
