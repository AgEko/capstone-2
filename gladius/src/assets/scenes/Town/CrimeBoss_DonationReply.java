package assets.scenes.Town;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CrimeBoss_DonationReply extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println(
                "\n1 - \"No town means no money for you and your gang to steal from.\"" +
                "\n2 - Hey there's no money in petty crime, Look at the Noble Lord. Owning this town is the real racket. " +
                "\n     Help me and im sure we can get you the run of the place.  It would all be legal, that just means no one will stop you," +
                "\n3 - For the first time in your miserable existence you can be the good guy. Waddya say porky?");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.CrimeBoss_DonationReply);
        }
        switch (choice){
            case 1:
                awaitInput("\"Oi, we'll just find another town, now beat it.\"");
                WorldState.getInstance().setAtCrimeBoss(false);
                WorldState.getInstance().game.setGameState(GameState.TownMenu);
                break;
            case 2:
                awaitInput("\"I like the sound of the town owin' the gang. Don't go forgettin', you owe me too.\"");
                awaitInput("'Ere's 200 gold. We'll be keepin' an eye you.");
                WorldState.getInstance().setOweTheMob(true);
                WorldState.getInstance().addGold(200);
                WorldState.getInstance().subtractKarma(2);
                WorldState.getInstance().game.setGameState(GameState.CrimeBoss);
                break;
            case 3:
                awaitInput("Well, well , well... This won't do at all. gen'tile'men escort 'our esteemed guest to 'is private quarters.");
                gameOver("The Crime Boss'es goons take you out back and take turns kicking you in the head. Until you die. Brutal!");
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.CrimeBoss_DonationReply);
        }
    }
}
