package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.Booze;
import assets.items.HolyWater;
import assets.items.Torch;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeon_Lich_Attack extends Scene {

    public void interaction(){
        int choice = -1;

        System.out.println("0 - Nevermind! You stop your attack before anyone notices." +
                "\n1 - Attack with your sword.");
        if(objectExists(WorldState.getInstance().game.player.getInventory(), Booze.class)){
            System.out.println("2 - Use booze as a fire bomb.");
        }
        if (objectExists(WorldState.getInstance().game.player.getInventory(), HolyWater.class)){
            System.out.println("3 - Use the Holy Water.");
        }

        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_Attack);
        }
        switch (choice){
            case 1:
                awaitInput("You attack with your sword! No effect! The Lich doesn't even flinch as your sword bounces off of his bones.");
                awaitInput("\"Mr. Boneregard what is the meaning of this?\" the Lich growls.");
                awaitInput("Flustered, Mr. Boneregard replies \"F-forgive me, my Lich, this adventurer presented them self quite differently upon entry to your Crypt. I shall handle this with due haste.\"");
                awaitInput("\"No need.\" He dismisses Mr. Boneregard with a wave. \"I shall deal with this interloper.\"");
                gameOver("You are lifted off your feet and expunged of your soft tissue. As the flesh is torn from your bones your mind crumples into madness.");
                break;
            case 2:
                if (objectExists(WorldState.getInstance().game.player.getInventory(), Booze.class)){
                    awaitInput("You create a molotov cocktail out of the Devil Water and chuck it at the Lich.");
                    awaitInput("It explodes engulfing the Lich and Mr.Boneregard in flames.");
                    awaitInput("It likely wont kill them but it has bought you time to grab what loot you can and make a dash for the exit.");
                    if(objectExists(WorldState.getInstance().game.player.getInventory(), Torch.class)){
                        awaitInput("Thankfully you picked up a torch, using its light you fend off incoming skeletons and make it to the exit.");
                        awaitInput("You make off with 400 gold!");
                        WorldState.getInstance().addGold(400);
                        WorldState.getInstance().setStoleFromLich(true);
                        WorldState.getInstance().game.setGameState(GameState.Dungeon);
                    } else {
                        awaitInput("You leap out of the room into a pitch black passageway. You attempt to feel your way towards the exit.");
                        awaitInput("Unfortunately for you skeletons can see in the dark and you just set their boss on fire.");
                        gameOver("You are dragged back to the underbelly of the dungeon where you are tortured to death during experimentations.");
                    }
                }
                awaitInput("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_Attack);
                break;
            case 3:
                if (objectExists(WorldState.getInstance().game.player.getInventory(), HolyWater.class)){
                    awaitInput("You throw the Holy Water at the Lich.");
                    awaitInput("The bottle shatters as it's contents are sprayed out, covering the Lich and Mr.Boneregard.");
                    awaitInput("You expect the Lich to be hurt by the Holy Water but Talos is the Lord of Storms, a chaotic evil deity.");
                    awaitInput("After a brief shudder the Lich blankly hovers before you. Apparently charmed. He awaits your command.");
                    WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_Attack_HolyWater);
                }
                awaitInput("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_Attack);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich_Attack);
        }
    }
}
