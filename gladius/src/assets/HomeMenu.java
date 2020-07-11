package assets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeMenu {

    public void menu(){
        homeMenu();




    }




    public void homeMenu(){
        if (!WorldState.getInstance().isHasBeenToHomeMenu()){
            WorldState.getInstance().setHasBeenToHomeMenu(true);
            Utility.awaitInput("The town mayor comes to your house and asks you to collect the Dragon's fee.");
            Utility.awaitInput("You have a few options as to where you want to gather gold from.");
            System.out.println("1 - Try to fundraise from townsfolk for the money." +
                    "\n 2 - You grab your sword and shield and head off to the nearest dungeon to scavenge for some loot." +
                    "\n 3 - Summon the dragon with the dragon flare." +
                    "\n 4 - Check your current gold." +
                    "\n 5 - Check your collected items.");
            homeMenuAction();
        } else{
            System.out.println("1 -  Go to town." +
                    "\n 2 -  Go to the dungeon." +
                    "\n 3 - Summon the dragon with the dragon flare." +
                    "\n 4 - Check your current gold." +
                    "\n 5 - Check your collected items.");
            homeMenuAction();
        }
    }

    private void homeMenuAction(){
        try{
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    Town town = new Town();
                    town.townMenu();
                    break;
                case 2:
                    //todo goto dungeon(S?)
                    break;
                case 3:
                    //todo Dragon Event class
                    break;
                case 4:
                    Utility.awaitInput("You have " + WorldState.getInstance().getGold() + " gold.");
                    homeMenu();
                    break;
                case 5:
                    //todo Reach player, display inventory array in for loop
                    break;

                default:
                    System.out.println("That is not a valid option.");
                    homeMenu();
            }


        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            homeMenu();
        }
    }

}
