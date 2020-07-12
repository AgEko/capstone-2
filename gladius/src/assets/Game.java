package assets;

import assets.scenes.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private GameState gameState;
    public Player player;
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        this.player = new Player();
    }

    public void startGame() {
        System.out.println("Select an option");
        System.out.println("======");
        System.out.println("0 - Exit Game.");
        System.out.println("1 - Start Game.");
        int choice = -1;

        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That is not an option");
            startGame();
        }
        switch (choice) {
            case 0:
                break;
            case 1:
                setGameState(GameState.QuestIntro);
                break;
            default:
                System.out.println("That is not an option");
                startGame();
        }
    }

    private void handleGameState(){
        switch (gameState) {
            case Adventure:
                break;
            case GameIntro:
                new Game().startGame();
                break;
            case QuestIntro:
                new Intro().introToQuest();
                break;
            case HomeMenu:
                new HomeMenu().homeMenu();
                break;
            case TownMenu:
                new Town().townMenu();
                break;
            case Baker:
                new Baker().interaction();
                break;
            case Shop:
                new Shop().interaction();
                break;
            case Tanner:
                new Tanner().interaction();
                break;
            case Noble:
                new Noble().interaction();
                break;
            case Tavern:
                new Tavern().interaction();
                break;
            case Tavern_Drunk:
                new Tavern_Drunk().interaction();
                break;
            case Tavern_Drunk_Buy:
                new Tavern_Drunk_Buy().interaction();
                break;
            case Tavern_Drunk_Steal:
                new Tavern_Drunk_Steal().interaction();
                break;

        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        handleGameState();
    }
}
