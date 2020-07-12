package assets.scenes;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.HolyWater;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Temple extends Scene {

    public void interaction(){
        int choice = -1;
        if (!WorldState.getInstance().isInTemple()){
            awaitInput("Welcome to the Temple if the Lord of Storms traveler, how can we aid you this day?");
            WorldState.getInstance().setInTemple(true);
        }

        System.out.println("0 - Leave" +
                "\n1 - Ask for a donation." +
                "\n2 - Steal from the temple." +
                "\n3 - Ask for some Holy Water.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Temple);
        }
        switch (choice){
            case 0:
                awaitInput("You leave the Temple.");
                WorldState.getInstance().setInTemple(false);
                WorldState.getInstance().game.setGameState(GameState.TownMenu);
                break;
            case 1:
                if(!WorldState.getInstance().isTookDonationTemple()){
                    awaitInput("Well this is indeed a change of pace. Very well. For the future of the town. Have the blessing of Talos.");
                    awaitInput("You receive 10 gold.");
                    WorldState.getInstance().addGold(10);
                    WorldState.getInstance().setTookDonationTemple(true);
                } else {
                    awaitInput("You already took a donation from here.");
                }
                WorldState.getInstance().game.setGameState(GameState.Temple);
                break;
            case 2:
                awaitInput("You reach your hand into the Temple's donation box.");
                awaitInput("As your fingers scratch the bottom of the empty container a Priest of Talos approaches you.");
                awaitInput("\"Donations have been slow as of late, but Talos sees your transgression traveler. The Lord of Storms will deal with you.\"");
                awaitInput("Woops!");
                WorldState.getInstance().setTalosMad(true);
                WorldState.getInstance().game.setGameState(GameState.Temple);
                break;
            case 3:
                awaitInput("You ask the High preist of Talos for Holy water.");
                awaitInput("Yes of course, The Lord of Storms blesses those who seek his gifts.");
                awaitInput("You receive Holy Water");
                WorldState.getInstance().game.player.getInventory().add(new HolyWater("Holy Water of Talos"));
                WorldState.getInstance().game.setGameState(GameState.Temple);
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Temple);
        }
    }

}
