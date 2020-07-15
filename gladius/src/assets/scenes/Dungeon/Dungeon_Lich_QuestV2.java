package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Lich_QuestV2 extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("1 - \"I change my mind, I'm in!\"" +
                "\n2 - \"Sorry Thel'zan, can't do it. I just have to find another way.\"");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_QuestV2);
        }
        switch (choice){
            case 1:
                awaitInput("\"Very well, Mr. Boneregard please escort our guest out. I look forward to your return.\"");
                WorldState.getInstance().setOnLichQuest(true);
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
                break;
            case 2:
                awaitInput("\"Understood, the offer is still available should you change your mind. Mr. Boneregard please escort our guest out.\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_QuestV2);
        }
    }
}
