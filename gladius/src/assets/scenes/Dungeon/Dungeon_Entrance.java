package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Entrance extends Scene {



    public void interaction(){
        int choice = -1;
        if(WorldState.getInstance().isVisitedCrypt()){
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Visited);
        }

        if(!WorldState.getInstance().isMetBoneregard()){
            awaitInput("You walk inside and are met by a shambling figure.");
            awaitInput("\"Welcome to the Blarrg encampment traveler. I am Mr. Boneregard servant of Lich Thel'zan.\"");
            awaitInput("You see the face of the figure and its a skeleton!");
            WorldState.getInstance().setMetBoneregard(true);
        }

        System.out.println("1 - \"You can talk?!\"" +
                "\n2 - Oh hey haven't talked to a skeleton before, you're not the eat-the-flesh-of-the-living type, are you?\"" +
                "\n3 - \"Die undead beast!\" Strike the skeleton with your sword!\"");

        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Entrance);
        }
        switch (choice){
            case 1:
                awaitInput("\"Yes we all can, we're just stripped of our mortal coil and a few bad eggs gave the rest of us lot a bad reputation with humans.\"");
                awaitInput("\"We're not so bad once you get past the whole undead thing.\"");
                awaitInput("\"Come now, I shall take you to our Lich. He would have a word with you.\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich);
                break;
            case 2:
                awaitInput("The skeleton laughs \" No, not at all. Since losing our flesh we haven't succumbed to the Black Rage like most skeletons do, it's all thanks to us being led by our Lich.\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_BoneregardChat);
                break;
            case 3:
                awaitInput("You ram your sword between the ribs to the skeleton. It appears at a loss for words.");
                awaitInput("\"Oh come off it. You can't hurt me with that.\" He takes your sword out of him and hands it back to you");
                awaitInput("\"Did you come here for a reason?\" he asks.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Apology);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Entrance);
        }
    }
}
