package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Visited_StoleGold_Attack extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("1 - Yeah, I better book it!." +
                "\n2 - Nah, I got this.! ");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Visited_StoleGold_Attack);
        }
        switch (choice) {
            case 1:
                singleInput("Yeah! Forget this! I want to Liiiiiive!!!");
                awaitInput("You narrowly escape being skinned alive! Whew!");
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
                break;
            case 2:
                awaitInput("You charge into combat with the skeletons, Yea! You got this!.");
                gameOver("You most certainly did not got this, the skeletons rip out your femurs and beat you to death with them.");
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Visited_StoleGold_Attack);
        }
    }

}
