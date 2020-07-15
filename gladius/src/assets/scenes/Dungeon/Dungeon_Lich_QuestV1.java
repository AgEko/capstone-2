package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Lich_QuestV1 extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("1 - \"I would be honored to help Thel'zan.\"" +
                "\n2 - \"Sorry I can't help you.\"");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_QuestV1);
        }
        switch (choice){
            case 1:
                awaitInput("Thel'zan is noticeably excited, \"Good! Many that come through here have not show us the kindness you have this day! Now go, I eagerly await your return. " +
                        "\nMr. Boneregard please escort our guest out,\"");
                WorldState.getInstance().setOnLichQuest(true);
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
                break;
            case 2:
                awaitInput("\"I do understand, the offer is still available should you change your mind. Mr. Boneregard please escort our guest out.\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_QuestV1);
        }
    }
}
