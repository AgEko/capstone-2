package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Lich extends Scene {

    public void interaction(){
        int choice = -1;

        if(!WorldState.getInstance().isMetLich()){
            awaitInput("The skeleton leads you though a dark labyrinth with the skeletons guidance you would certainly be lost in the darkness.");
            awaitInput("You arrive at a chamber were there is a pale blue light coming from a towering figure that floats eerily across the stone floor.");
            awaitInput("Mr. Boneregard calls out to the figure \"My Lich I bring to you an adventurer that may prove useful.\"");
            awaitInput("The Lich turns his ethereal gaze your direction, although chilling to behold, you sense no malice in his unearthly visage.");
            awaitInput("\"Ah yes, I am Thel'zan. The ruling Lich over this crypt. For many years we have attempted to isolate ourselves from the outside world in order to advance our work in rehabilitating skeletons to their former lives of flesh, freeing them from inevitable madness.\"");
            awaitInput("\"As of the last few years, isolation has been difficult. Our research supplies dwindle, our tomes outdated and equipment turns to dust. \"");
            awaitInput("\"Our work has come to an agonizing halt.\"");
            WorldState.getInstance().setMetLich(true);
        } else {
            awaitInput("The Lich is silent a moment. Abruptly he asks if you are willing to take his quest once again.");
        }

        System.out.println("1 -\"Sound rough Thel'zan, can't you go get more supplies?\"" +
                "\n2 - \"I can't help you Thel'zan, I have enough problems of my own.\" You explain your quest to save your town." +
                "\n3 - \"Aha! So you're in charge! Take this numbskull!\" You attack");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon);
        }
        switch (choice){
            case 1:
                awaitInput("\"If it were only so easy. Believe it or not many humans care for the undead for understandable reasons. " +
                        "\nWe cannot  trade for supplies and I have forbidden my servants from ransacking trade routes." +
                        "\nKeeping only to attacking bandit camps.\"");
                awaitInput("\"Only then will we have a steady influx of regents to continue our work.\" the Lich explains.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_QuestV1);
                break;
            case 2:
                awaitInput("\"I see, your circumstance are most unfortunate.\"");
                awaitInput(" \"We do collect much gold from the bandits that we attack.\"" +
                        "\n\"I have no use for gold without trade I am willing to pay you to speak to the townsfolk and open trade between us.\"" +
                        "\n\"Would you be interested in brokering my proposal?\" asks the Lich.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_QuestV2);
                break;
            case 3:
                awaitInput("You attack Thel'zan! Choose your attack!");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_Attack);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
        }
    }
}
