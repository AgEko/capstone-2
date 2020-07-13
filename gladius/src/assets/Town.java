package assets;

import assets.scenes.Town.Shop;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Town extends Scene{


    public void townMenu(){

        townMenuAction();
    }

    public void townMenuAction(){
        int choice = -1;

            awaitInput("You arrive in the town of Kleinstadt.");
            System.out.println("0 - Go home" +
                    "\n1 - Go to the Baker." +
                    "\n2 - Go to  the General Shop" +
                    "\n3 - Go to  the Tanner" +
                    "\n4 - Go to the Noble Lord of the town" +
                    "\n5 - Go to  the Tavern" +
                    "\n6 - Go to the Local Crime Boss" +
                    "\n7 - Go to the at the Temple");
            try {
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
            } catch (InputMismatchException e){
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.TownMenu);
            }

            switch (choice){
                case 0:
                    awaitInput("You leave town.");
                    WorldState.getInstance().game.setGameState(GameState.HomeMenu);
                    break;
                case 1:
                    awaitInput("You head to the baker.");
                    WorldState.getInstance().game.setGameState(GameState.Baker);
                    break;
                case 2:
                    awaitInput("You head to the General Shop.");
                    WorldState.getInstance().game.setGameState(GameState.Shop);
                    new Shop().interaction();
                    break;
                case 3:
                    awaitInput("You head to the Tanner");
                    WorldState.getInstance().game.setGameState(GameState.Tanner);
                    break;
                case 4:
                    awaitInput("You head to the Noble Lord's Estate");
                    WorldState.getInstance().game.setGameState(GameState.Noble);
                    break;
                case 5:
                    awaitInput("You head to the Tavern");
                    WorldState.getInstance().game.setGameState(GameState.Tavern);
                    break;
                case 6:
                    awaitInput("You head to the CrimeBoss's evil crime lair.");
                    WorldState.getInstance().game.setGameState(GameState.CrimeBoss);
                    break;
                case 7:
                    awaitInput("You head to the Temple of Talos.");
                    WorldState.getInstance().game.setGameState(GameState.Temple);
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    WorldState.getInstance().game.setGameState(GameState.TownMenu);
            }
    }



}
