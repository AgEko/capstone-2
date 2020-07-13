package assets.scenes.Dragon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dragon_Event extends Scene {

    public void interaction(){
        int choice = -1;
        awaitInput("You fire the DragonFlare into the sky. After a few minutes the dragon crashes into the earth before you. You struggle to maintain your balance as the ground heaves around you.");
        awaitInput("\"Do you have my gold?\" demands the Dragon.");
        singleInput("\"Aye, I have the gold. Tell me your demand once more to be sure dragon.\"");
        awaitInput("\"I'm going to need about 350.\"");
        System.out.println("0 - Return home." +
                "\n1 - \"Here's your gold begone monster.\"" +
                "\n2 - \"Hey dragon! Whats your name?\"" +
                "\n3 - \"We will not live under the shadow of your terror! Die monster!\"" +
                "\n4 - It's about then you notice the dragon is about eight stories tall and is a crustacean from the pedadoic era.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dragon_Event);
        }
        switch (choice){
            case 0:
                awaitInput("\"Uh, nevermind!\" You hurry off and return home");
                WorldState.getInstance().game.setGameState(GameState.HomeMenu);
                break;
            case 1:
                if (WorldState.getInstance().getGold() > 350){
                    awaitInput("You pay the dragon and the beast flies away, the town is safe... for now.");
                    WorldState.getInstance().game.setGameState(GameState.Epilogue);
                } else {
                    awaitInput("You don't have enough gold! You only have " +
                            WorldState.getInstance().getGold() + " gold.");
                    WorldState.getInstance().game.setGameState(GameState.Dragon_Event);
                }
                break;
            case 2:
                WorldState.getInstance().game.setGameState(GameState.Dragon_KindaCute);
                break;
            case 3:
                awaitInput("You attack the dragon with your sword.");
                awaitInput("Unable to reach the soft underbelly of the dragon your sword bounces in futility against the scales of the beast.");
                gameOver("The dragon gobbles you up \"Mmm, crunchy\" the dragon smacks, as your bones are crushed and you are eaten alive.");
                break;
            case 4:
                singleInput("\"DAMN IT MONSTER GET OFF MY LAWN!\" you yell.");
                awaitInput("\"I Ain't giving you no tree fiddy!\"");
                awaitInput("The dragon responds \"Well how about two fiddy?\"");
                singleInput(">\"Oh now it's only two fiddy?! What is it in for lock-ness munchies or somethin?\"");
                gameOver("Although correct that this was for the Dragon's severe case of the munchies, " +
                        "\nyou could not have had worse timing. The Dragon makes you it's snack. Bon appetit!");
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dragon_Event);
        }
    }
}
