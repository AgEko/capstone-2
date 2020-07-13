package assets.scenes.Town;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.Blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Noble extends Scene {

    public void interaction(){
        int choice = -1;
        if (!WorldState.getInstance().isAtNoble()) {
            awaitInput("You approach the estate a guard halts your progress. From behind him th Noble Lord calls out rather pointedly:" +
                    "\n \"What do YOU want?");
            WorldState.getInstance().setAtNoble(true);
        }

            WorldState.getInstance();
            System.out.println("0 - Leave" +
                    "\n1 - Ask for a donation" +
                    "\n2 - Steal from the Noble");

            try {
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
            } catch (InputMismatchException e){
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Noble);
            }
            switch (choice){
                case 0:
                    WorldState.getInstance().setAtNoble(false);
                    WorldState.getInstance().game.setGameState(GameState.TownMenu);
                    break;
                case 1:
                    awaitInput("\"Begone with you, thou beggar! Guards, remove this tripe at once!\"");
                    awaitInput("The guards tromp towards you and don't even slow down as they scoop you up and toss you off the premises.");
                    awaitInput("You return to town.");
                    WorldState.getInstance().setAtNoble(false);
                    WorldState.getInstance().game.setGameState(GameState.TownMenu);
                    break;
                case 2:
                    if (!WorldState.getInstance().isStoleFromNoble()  && !objectExists(WorldState.getInstance().game.player.getInventory(), Blackjack.class)){
                        awaitInput("You prowl about the premises until night time. You sneak into the loot room and load up your pockets with that sweet sweet gold");
                        awaitInput("On your way out a guard spots you and raises the alarm. You try to flee but all the gold weighs you down. " +
                                "\nThe guards quickly apprehend you. The Captain of the guard takes you before the Noble Lord.");
                        gameOver("\"How dare thou attempt to steal from me! You WILL learn! Un-head him Captain.\"");
                        break;
                    } else if (!WorldState.getInstance().isStoleFromNoble()  && objectExists(WorldState.getInstance().game.player.getInventory(), Blackjack.class)){
                        awaitInput("You prowl about the premises until night time. You see your opportunity and knock out a few guards and get to the loot room. You make off with a small fortune. Ez money Bae-bEE!");
                        awaitInput("You receive 450 gold.");
                        WorldState.getInstance().addGold(450);
                        WorldState.getInstance().subtractKarma(2);
                        WorldState.getInstance().setStoleFromNoble(true);
                        WorldState.getInstance().game.setGameState(GameState.Noble);
                        break;
                    } else {
                        awaitInput("You already burglarized the Noble. It is far too rash go back for seconds.");
                        awaitInput("You head back to town.");
                        WorldState.getInstance().setAtNoble(false);
                        WorldState.getInstance().game.setGameState(GameState.TownMenu);
                        break;
                    }
                default:
                    System.out.println("That is not a valid option.");
                    WorldState.getInstance().game.setGameState(GameState.Noble);
                }

    }

}
