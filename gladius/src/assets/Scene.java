package assets;

import assets.items.Item;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class Scene {

    protected static void awaitInput(String a) {
        System.out.println(a);
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
    }

    //Todo GET OFF MY LAWN MONSTER
    protected static void singleInput(String a) {
        System.out.println("1 - " + a);

        try {
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("");
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    singleInput(a);
            }
        } catch (InputMismatchException e) {
            System.out.println("That is not a valid option.");
            singleInput(a);
        }
    }

    protected static void gameOver(String a){
        Scene.awaitInput(a);

        System.out.println("As you die you never learn the fate of what happens to your town. Don't do that thing you did that get dead next time.");
        WorldState.getInstance().setGameOver(true);
//        WorldState.reset();
        WorldState.getInstance().game.setGameState(GameState.GameIntro);

    }

    protected static boolean objectExists(List<Item> objectList, Class classType){
        for (Object object : objectList){
            if (object.getClass() == classType){
                return true;
            }
        }
        return false;
    }



















//            try {
//        Scanner a = new Scanner(System.in);
//        int choice = a.nextInt();
//
//        switch (choice){
//            case 1:
//                break;
//            case 2:
//                break;
//            case 3:
//                break;
//            case 4:
//                break;
//            case 5:
//                break;
//            case 6:
//                break;
//            case 7:
//                break;
//            case 8:
//                break;
//            default:
//        }
//
//    } catch (InputMismatchException e){
//        System.out.println("That is not a valid option.");
//        townMenu();
//    }


}
