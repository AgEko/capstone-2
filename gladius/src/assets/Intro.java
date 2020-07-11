package assets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Intro {

    public  void adventureIntro(){
        introToQuest();
        responseToQuest();

    }
    private void introToQuest(){
        Utility.awaitInput("You're the resident adventurer the small assets.town of Kleinstadt.");
        Utility.awaitInput("Awaken to an explosion, as you run out side there's a massive dragon!");
        Utility.awaitInput("Dragon roars \"Humans I demand a tribute of gold! Agree or I shall burn this hovel into the earth.\"");
        Utility.awaitInput("\"Any questions?\"");
    }

    private void responseToQuest(){
        System.out.println("1 - \"Hey Dragon, Up yours!\"");
        System.out.println("2 - \"How much gold do you demand Dragon?\"");
        System.out.println("3 - \"Where can I find gold?\"");

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    Utility.awaitInput("The Dragon is rather surprised by the audacity of your reply.");
                    Utility.singleInput("*That worked?*  You give the dragon a cheeky grin.");
                    Utility.gameOver("The dragon decides to quell your defiance by giving you the chomp.");
                    break;
                case 2:
                    Utility.awaitInput("\"Bring me 500 gold. \"");
                    Utility.singleInput("\"Aight.\"");
                    responseToQuest();
                    break;
                case 3:
                    Utility.awaitInput("\"Not my problem, you have three days.\"");
                    Utility.awaitInput("\"Use this signal when you have the gold.\"");
                    System.out.println("You receive a Dragon Flare.");
                    //Todo: add dragonFlare
                    HomeMenu homeMenu = new HomeMenu();
                    homeMenu.menu();
                    //homeMenu();

                    break;
                default:
                    System.out.println("That is not a valid option.");
                    responseToQuest();
            }


        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            responseToQuest();
        }
    }

}
