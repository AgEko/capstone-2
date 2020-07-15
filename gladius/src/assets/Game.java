package assets;

import assets.scenes.Dragon.*;
import assets.scenes.Dungeon.*;
import assets.scenes.Epilogue;
import assets.scenes.Town.*;

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
        System.out.println("============================");
        System.out.println("===     Dragon's Due     ===");
        System.out.println("============================");
        System.out.println("===     0 - Exit Game    ===");
        System.out.println("===     1 - Start Game   ===");
        System.out.println("============================");
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
            case Epilogue:
                new Epilogue().interaction();

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
            case CrimeBoss:
                new CrimeBoss().interaction();
                break;
            case CrimeBoss_Buy:
                new CrimeBoss_Buy().interaction();
                break;
            case CrimeBoss_DonationReply:
                new CrimeBoss_DonationReply().interaction();
                break;
            case Temple:
                new Temple().interaction();
                break;

            case Dungeon:
                new Dungeon().interaction();
                break;
            case Dungeon_Entrance:
                new Dungeon_Entrance().interaction();
                break;
            case Dungeon_Lich:
                new Dungeon_Lich().interaction();
                break;
            case Dungeon_Apology:
                new Dungeon_Apology().interaction();
                break;
            case Dungeon_KeepStabbing:
                new Dungeon_KeepStabbing().interaction();
                break;
            case Dungeon_BoneregardChat:
                new Dungeon_BoneregardChat().interaction();
                break;
            case Dungeon_BoneregardInsult:
                new Dungeon_BoneregardInsult().interaction();
                break;
            case Dungeon_Lich_QuestV1:
                new Dungeon_Lich_QuestV1().interaction();
                break;
            case Dungeon_Lich_QuestV2:
                new Dungeon_Lich_QuestV2().interaction();
                break;
            case Dungeon_Lich_Attack:
                new Dungeon_Lich_Attack().interaction();
                break;
            case Dungeon_Lich_Attack_HolyWater:
                new Dungeon_Lich_Attack_HolyWater().interaction();
                break;
            case Dungeon_Visited:
                new Dungeon_Visited().interaction();
                break;
            case Dungeon_Visited_StoleGold:
                new Dungeon_Visited_StoleGold().interaction();
                break;
            case Dungeon_Visited_StoleGold_Attack:
                new Dungeon_Visited_StoleGold_Attack().interaction();
                break;
            case Dragon_Event:
                new Dragon_Event().interaction();
                break;
            case Dragon_KindaCute:
                new Dragon_KindaCute().interaction();
                break;
            case Dragon_Date:
                new Dragon_Date().interaction();
                break;
            case Dragon_Date_Pre:
                new Dragon_Date_Pre().interaction();
                break;
            case Dragon_Date_AttackOnDragon:
                new Dragon_Date_AttackOnDragon();
                break;
            case Ambush_Event:
                new Ambush_Event().interaction();
                break;
            case Ambush_Event_BetrayAmbush:
                new Ambush_Event_BetrayAmbush().interaction();
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        handleGameState();
    }
}
