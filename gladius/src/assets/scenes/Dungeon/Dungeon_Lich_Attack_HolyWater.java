package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Lich_Attack_HolyWater extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("1 - \"How do I kill you skeletons?\"" +
                "\n2 - \"Are there any useful trinkets here?\"" +
                "\n3 - \"Where the gold at monster?\"" +
                "\n4 - Command Mr.Boneregard to lead you safely out of the dungeon.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_Attack_HolyWater);
        }
        switch (choice){
            case 1:
                awaitInput("The Lich gives a hollow, slow response, \"Fire... dragon fire... will seal our fate...\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_Attack_HolyWater);
                break;
            case 2:
                awaitInput("\"None...\" the Lich gasps,  \"all used... only gold...\"");
                singleInput("\"Well hork it over bozo!\"");
                awaitInput("You gather what you can carry. A clean 500 gold!");
                awaitInput("Mr. Boneregard who is also under your command leads you to the entrance of the dungeon.");
                WorldState.getInstance().addGold(500);
                WorldState.getInstance().setStoleFromLich(true);
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
                break;
            case 3:
                awaitInput(" Thel'zad points a bony finger to a corner of the room.");
                awaitInput("You gather what you can carry. 500 gold. Cash money!");
                awaitInput("Mr. Boneregard who is also under your command leads you to the entrance of the dungeon.");
                WorldState.getInstance().addGold(500);
                WorldState.getInstance().setStoleFromLich(true);
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
                break;
            case 4:
                awaitInput("Mr. Boneregard who is also under your command leads you to the entrance of the dungeon.");
                WorldState.getInstance().setStoleFromLich(true);
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_Attack_HolyWater);
        }
    }
}
