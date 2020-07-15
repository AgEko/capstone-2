package assets.scenes.Dragon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ambush_Event extends Scene {

    public void interaction(){
        int choice = -1;
        awaitInput("A sudden crash snaps your attention to the windows of the tavern as they collapse inward one by one.");
        awaitInput("The ambush that you have set up with the people of Kleinstadt has begun!");

        System.out.println("1 - Fight along side the ambushers." +
                "\n2 - Fight against the ambushers." +
                "\n3 - Kick back and watch the show.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Ambush_Event);
        }

        if(WorldState.getInstance().isDrunkDragon()){
            awaitInput("Getting the dragon drunk appears to have enhanced her fireball!");
            awaitInput("The entire wall of the building is blown out, incinerating many of the ambushers.");
            awaitInput("Instantly demoralized the survivors retreat!");
            awaitInput("Having dealt with the ambushers Lirastrasza turns her attention to you and begins to channel a massive fireball.");
            singleInput("\"It's just a prank bro!\"");
            gameOver("She incinerates you on the spot with incredible fury. There is only a small oily stain left where you once were.");
        }

        switch (choice){
            case 1:
                awaitInput("Lirastrasza is distracted by the attackers! Here is your chance!");
                singleInput("Take your sword and drive it into her underbelly.");
                awaitInput("You find your opportunity and jut your blade into her soft scales.");
                awaitInput("The Dragon's guts burst out as if they were under pressure.");
                awaitInput("Your hand is scalded as the hot inners bursts out consuming an attacker in boiling fluid.");
                awaitInput("You have slain the Dragon and saved the Town!");
                WorldState.getInstance().addKarma(2);
                WorldState.getInstance().setDeadDragon(true);
                WorldState.getInstance().game.setGameState(GameState.Epilogue);
                break;
            case 2:
                    WorldState.getInstance().game.setGameState(GameState.Ambush_Event_BetrayAmbush);
                break;
            case 3:
                awaitInput("The numerous ambushers attack from all sides and overwhelm the dragon by sheer numbers taking full advantage of the confined space of the tavern.");
                awaitInput("The dragon is slain. Kleinstadt is saved from her fire.");
                awaitInput("The ambushers look to you sitting back and just watching.");
                awaitInput("\"What the hell man? You just sat back? Some of us died!\"");
                singleInput("\"Yeah, but I didn't. Also the town is saved. You're welcome.\"");
                awaitInput("\"You're a jackass, come on fellow town. Drinks on me.\"");
                WorldState.getInstance().setLazyDragonKill(true);
                WorldState.getInstance().subtractKarma(2);
                WorldState.getInstance().game.setGameState(GameState.Epilogue);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Ambush_Event);
        }
    }
}
