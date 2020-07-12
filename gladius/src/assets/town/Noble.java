package assets.town;

import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Noble extends Scene {

    public void interaction(){
        boolean quit = false;
        int choice = -1;
        if (!WorldState.getInstance().isAtNoble()){
            awaitInput("You approach the estate a guard halts your progress. From behind him th Noble Lord calls out rather pointedly:" +
                    "\n \"What do YOU want?");
            WorldState.getInstance().setAtNoble(true);

            WorldState.getInstance();
            while (!quit){
            System.out.println("0 - Leave" +
                    "\n1 - Ask for a donation" +
                    "\n2 - Steal from the Noble");

            try {
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
            } catch (InputMismatchException e){
                System.out.println("That is not a valid option.");
            }
            switch (choice){
                case 0:
                    WorldState.getInstance().setAtNoble(false);
                    quit = true;
                    break;
                case 1:
                    awaitInput("\"Begone with you, thou beggar! Guards, remove this tripe at once!\"");
                    awaitInput("The guards tromp towards you and don't even slow down as they scoop you up and toss you out of the premises.");
                    WorldState.getInstance().setAtNoble(false);
                    quit = true;
                    break;
                case 2:
                    if (!WorldState.getInstance().isStoleFromNoble()  && !WorldState.getInstance().isHasBlackjack()){
                        awaitInput("You prowl about the premises until night time. You sneak into the loot room and load up your pockets with that sweet sweet gold");
                        awaitInput("On your way out a guard sees you and raises the alarm. You try to flee but all the gold weighs you down. The guards quickly apprehend you. The Captain of the guard takes you before the Noble Lord.");
                        gameOver("\"How dare thou attempt to steal from me! You WILL learn! Un-head him Captain.\"");
                        break;
                    } else if (!WorldState.getInstance().isStoleFromNoble()  && WorldState.getInstance().isHasBlackjack()){
                        awaitInput("You prowl about the premises until night time. You see your opportunity and knock out a few guards and get to the loot room. You make off with a small fortune.");
                        awaitInput("You receive 450 gold");
                        WorldState.getInstance().addGold(450);
                        WorldState.getInstance().subtractKarma(2);
                        break;
                    } else {
                        awaitInput("You already burglarized the Noble. It would be far too rash go back for seconds.");
                        WorldState.getInstance().setAtNoble(false);
                        quit = true;
                        break;
                    }
                default:
                    System.out.println("That is not a valid option.");
                }
            }
        }
    }

}
