package assets.scenes.Dragon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dragon_KindaCute extends Scene {

    public void interaction(){
        int choice = -1;
        awaitInput("The dragon growls. \"I am called Lirastrasza, mortal.\"");

        System.out.println("1 - \"Thank you for your kind mercy Lirastrasza, here is your gold.\"" +
                "\n2 - \"You're kinda cute, How about we go a drink?\"" +
                "\n3 - \"Is 'mortal' your last name? That's stupid, you're stupid. Dumb lizard.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dragon_KindaCute);
        }
        switch (choice){
            case 1:
                if(WorldState.getInstance().getGold() > 350){
                    WorldState.getInstance().game.setGameState(GameState.Epilogue);
                } else {
                    awaitInput("You dont have enough gold! " +
                            "\n You only have " + WorldState.getInstance().getGold() + " gold.");
                    WorldState.getInstance().game.setGameState(GameState.Dragon_KindaCute);
                }
                break;
            case 2:
                awaitInput("The dragon blushes a deep red clearly caught off guard by your proposal. She accepts.");
                singleInput("Noice.jpg \"Meet me at the tavern this evening.\" you tell her.");
                awaitInput("Lirastrasza takes flight with a small hop in her step.");
                WorldState.getInstance().game.setGameState(GameState.Dragon_Date_Pre);
                break;
            case 3:
                awaitInput("Lirastrasza is not amused.");
                singleInput("\"Well...\" you say, \"Get on with it and eat me.\"");
                gameOver("With a small shrug and an agreeable nod Lirastraza gives you the chomp!");
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dragon_KindaCute);
        }
    }
}
