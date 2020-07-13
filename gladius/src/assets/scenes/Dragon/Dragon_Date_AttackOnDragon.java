package assets.scenes.Dragon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.Hammer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dragon_Date_AttackOnDragon extends Scene {

    public void interaction() {
        int choice = -1;

        if (WorldState.getInstance().isAmbush()) {
            awaitInput("You wait for an opening to slay the dragon. It's not yet time for the ambush: Will you wait?");
            System.out.println("1 - Yes, wait for the ambush. There is strength in numbers." +
                    "\n2 - No! The glory will be mine!");
            try {
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid option.");
            }
            if (choice == 1){
                WorldState.getInstance().game.setGameState(GameState.Ambush_Event);
            }
            choice = -1;
        }

        System.out.println("1 - Decide against fighting the dragon alone." +
                "\n2 - Attack with your sword");
        if (objectExists(WorldState.getInstance().game.player.getInventory(), Hammer.class) && WorldState.getInstance().isDrunkDragon()){
            System.out.println("3 - Strike First with your Warhammer.");
        }

        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Dragon_Date_AttackOnDragon);
        }
        switch (choice) {
            case 1:
                awaitInput("You patiently wait for the ambush to begin.");
                WorldState.getInstance().game.setGameState(GameState.Ambush_Event);
                break;
            case 2:
                awaitInput("You order a large plate of turkey legs and begin to eat.");
                awaitInput("When the Dragon throws her head back to gulp down a plate of Turkey legs you see your opportunity.");
                awaitInput("You overturn the table as you leap forward, lashing out for her throat.");
                awaitInput("You narrowly miss the killing blow.");
                awaitInput("The dragon whips her tail around and makes distance between you and her.");
                awaitInput("\"How dare you!\" She snarls \"I will raze this hovel until there is only ash!\"");
                awaitInput("She fireballs you.");
                gameOver("You are blasted through a wall as you burn to crisp.");
                break;
            case 3:
                if (objectExists(WorldState.getInstance().game.player.getInventory(), Hammer.class) && WorldState.getInstance().isDrunkDragon()){
                    awaitInput("The dragon cheers and orders, food in a drunken stupor.");
                    awaitInput("The Dragon drunkenly throws her head back to gulp down a plate of Turkey legs, missing half the plate. " +
                            "\nYou see your opportunity.");
                    awaitInput("You overturn the table as you leap forward, raising your warhammer.");
                    awaitInput("The dragon jerks her head back to focus on you taken by surprise.");
                    awaitInput("You force the hammer down hard onto her head with all of your might.");
                    awaitInput("The shock reverberates off her scales, you feel your arms start to go numb to the recoil.");
                    awaitInput("The dragon is stunned by the blow. Giving you ample opportunity to take your sword and drive it deep into it's heart.");
                    awaitInput("The dragon gasps as it's eyes bulge with confusion. You wrench your sword out and hot blood spills forth from the wound.");
                    awaitInput("You strike again. This time in the dragons throat. You force the blade lengthwise,  cracking open the dragons neck like a crab leg.");
                    awaitInput(" You behead the dragon.");
                    awaitInput("You saved Kleinstadt, the townsfolk rejoice! Woo!");
                    awaitInput("You have slain the dragon! All by yourself! Impressive! ");
                    WorldState.getInstance().setDragonSoloKill(true);
                    WorldState.getInstance().addKarma(3);
                    WorldState.getInstance().game.setGameState(GameState.Epilogue);
                } else {
                    System.out.println("That is not a valid option.");
                    WorldState.getInstance().game.setGameState(GameState.Dragon_Date_AttackOnDragon);
                }
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Dragon_Date_AttackOnDragon);
        }
    }




}

