package assets;

import assets.items.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeMenu extends Scene {

    public void homeMenu(){
        if (!WorldState.getInstance().isHasBeenToHomeMenu()){
            WorldState.getInstance().setHasBeenToHomeMenu(true);
            Scene.awaitInput("The town mayor comes to your house and asks you to collect the Dragon's fee.");
            Scene.awaitInput("You have a few options as to where you want to gather gold from.");
            homeMenuAction();
        } else{
            homeMenuAction();
        }
    }

    private void homeMenuAction(){
       int choice = -1;

            System.out.println("1 - Try to fundraise from townsfolk of Kleinstadt for the gold." +
                    "\n 2 - You grab your sword and shield and head off to the nearest dungeon to scavenge for some loot." +
                    "\n 3 - Summon the dragon with the dragon flare." +
                    "\n 4 - Check your current gold." +
                    "\n 5 - Check your collected items.");
            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.HomeMenu);
            }
            switch (choice) {
                case 0:
                    break;
                case 1:
                    WorldState.getInstance().game.setGameState(GameState.TownMenu);
                    break;
                case 2:
                    //todo goto dungeon(S?)
                    break;
                case 3:
                    //todo Dragon Event class
                    break;
                case 4:
                    awaitInput("You have " + WorldState.getInstance().getGold() + " gold.");
                    WorldState.getInstance().game.setGameState(GameState.HomeMenu);
                    break;
                case 5:
                    for(Item a : WorldState.getInstance().game.player.inventory){
                        System.out.println(a.getName());
                    }
                    awaitInput("");
                    WorldState.getInstance().game.setGameState(GameState.HomeMenu);
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    WorldState.getInstance().game.setGameState(GameState.HomeMenu);
            }


    }

}
