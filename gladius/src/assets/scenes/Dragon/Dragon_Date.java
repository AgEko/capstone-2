package assets.scenes.Dragon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.Booze;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dragon_Date extends Scene {

    public void interaction(){
        int choice = -1;
        awaitInput("You enter the Tavern and Lirastrasza is there waiting for you.");
        awaitInput("Sitting down at the table you begin your dragon date with Lirastrasza.");

        System.out.println("1 - Negotiate a better deal to pay her for the safety of Kleinstadt." +
                "\n2 - Hit on Lirastrasza with some smooth af pick-up lines." +
                "\n3 - Attack Lirastrasza.");
        if(!WorldState.getInstance().isDrunkDragon() && objectExists(WorldState.getInstance().game.player.getInventory(), Booze.class)){
            System.out.println("4 - Pull out your bottle of 'Devil's Water' and polish it off with Lirastrasza.");
        }

        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dragon_Date);
        }
        switch (choice){
            case 1:
                businessDate();
                break;
            case 2:
                awaitInput("You start hitting on Lirastrasza " +
                        "\n\"I'm going to need some fire resistance because you're hot.\"");
                singleInput("Keep the charm comin'!");
                awaitInput("You lean in a little closer, \"On a scale from one to ten; you're a natural twenty.\"");
                awaitInput("Lirastrasza blushes! You're almost there! One more should do the trick!");
                goldCheck();
                break;
            case 3:
                awaitInput("You attempt to slay Lirastrasa!");
                WorldState.getInstance().game.setGameState(GameState.Dragon_Date_AttackOnDragon);
                break;
            case 4:
                if (!WorldState.getInstance().isDrunkDragon() && objectExists(WorldState.getInstance().game.player.getInventory(), Booze.class)){
                    awaitInput("You and the Lirastraza play a drinking game and get pretty trashed. " +
                            "\nYou are now both drunk.");
                    WorldState.getInstance().setDrunkDragon(true);
                } else {
                    System.out.println("That is not a valid option.");
                }
                WorldState.getInstance().game.setGameState(GameState.Dragon_Date);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dragon_Date);
        }
    }

    private void businessDate(){
        awaitInput("Lirastrasza looks a bit let down. She agrees to 300 gold.");
        if (WorldState.getInstance().getGold() > 300) {
            awaitInput("Ending the date she flies off into the night. The town is saved!");
            WorldState.getInstance().game.setGameState(GameState.Epilogue);
        } else {
            awaitInput("You only have " + WorldState.getInstance().getGold() + " gold!");
            WorldState.getInstance().game.setGameState(GameState.Dragon_Date);
        }
    }

    private void goldCheck(){
        awaitInput("Turns out dragons are golddiggers. Who woulda guessed? Gold check! Do you have enough gold to impress Lirastrasza?");
        if (WorldState.getInstance().getGold() > 1000 || (WorldState.getInstance().isDrunkDragon() && WorldState.getInstance().getGold() > 750)){
            awaitInput("Aw yiss! You got the gold, she is so into you!");
            awaitInput("One more pick up line and you seal the deal.");
            singleInput("\"I put on my robe and wizard hat...\"");
            awaitInput("You and Lirastrasza are now going steady. Dragon Girlfriend. You rapscallion you.");
            WorldState.getInstance().setDragonGF(true);
            if(WorldState.getInstance().isAmbush()){
                WorldState.getInstance().game.setGameState(GameState.Ambush_Event);
            }
            WorldState.getInstance().game.setGameState(GameState.Epilogue);
        } else {
            awaitInput("Too bad, no Dragon GF, but Lirastrasza has a good time on the date and decides to spare the town free of charge.");
            if(WorldState.getInstance().isAmbush()){
                WorldState.getInstance().game.setGameState(GameState.Ambush_Event);
            }
            WorldState.getInstance().game.setGameState(GameState.Epilogue);
        }
    }

}
