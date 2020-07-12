package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_BoneregardChat extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("1 - \"What does your Lich want?\"" +
                "\n2 - \"Can you offer any help for my town?\" Explain the plight of your village." +
                "\n3 - \"Nah I bet you are, suck eggs bonehead.\"" +
                "\n4 - \"Oh hey, I gotta go, I *just* remembered I have to vacuum my carpet.\"");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_BoneregardChat);
        }
        switch (choice){
            case 1:
                awaitInput("\"We are interested in technological advancement and seeking away back into the land of the living. Not trying to stay dead forever you know.\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_BoneregardChat);
                break;
            case 2:
                awaitInput("\"Interesting, I don't know if im the bone to say, but perhaps our Lich has a solution for you. I will take you to him now, come..\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich);
                break;
            case 3:
                awaitInput("The skeleton sighs drearily \"Okay how do you want to do this?\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_BoneregardInsult);
                break;
            case 4:
                awaitInput("The skeleton chuckles \"Heh, everyone knows vacuums are not real, come I shall introduce you to our Lich, he would have use of you.\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich);
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_BoneregardChat);
        }
    }
}
