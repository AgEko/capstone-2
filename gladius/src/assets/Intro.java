package assets;

import assets.items.DragonFlare;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Intro extends Scene {

    public void introToQuest(){
        int choice = -1;
        boolean quit = false;

        if (!WorldState.getInstance().isIntroMessage()){
            awaitInput("You are the resident adventurer the small town of Kleinstadt.");
            awaitInput("You awaken to an explosion, as you run outside there's a massive dragon!");
            awaitInput("Dragon roars \"Humans I demand a tribute of gold! Agree or I shall burn this hovel into the earth.\"");
            awaitInput("\"Any questions?\"");
            WorldState.getInstance().setIntroMessage(true);
        }

        while(!quit){

            System.out.println("1 - \"Hey Dragon, get stuffed!!\"");
            System.out.println("2 - \"How much gold do you demand Dragon?\"");
            System.out.println("3 - \"Where can I find gold?\"");
            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.QuestIntro);
            }
            switch (choice){
                case 1:
                    awaitInput("The Dragon is rather surprised by the audacity of your reply.");
                    singleInput("*That worked?*  You give the dragon a cheeky grin.");
                    gameOver("The dragon decides to quell your defiance by giving you the chomp.");
                    break;
                case 2:
                    awaitInput("\"Bring me 500 gold. \"");
                    singleInput("\"Aight.\"");

                    break;
                case 3:
                    awaitInput("\"Not my problem, you have three days.\"");
                    awaitInput("\"Use this signal when you have the gold.\"");
                    WorldState.getInstance().game.player.inventory.add(new DragonFlare("DragonFlare"));
                    System.out.println("You receive a Dragon Flare.");
                    WorldState.getInstance().game.setGameState(GameState.HomeMenu);
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    WorldState.getInstance().game.setGameState(GameState.QuestIntro);
            }
        }

    }

}
