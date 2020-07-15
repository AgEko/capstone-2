package assets.scenes.Town;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Tavern extends Scene {

    public void interaction(){
        int choice = -1;

        if(!WorldState.getInstance().isInTavern()){
            awaitInput("You enter the Tavern. The barkeep nods at you and continues his conversation with another patron.");
            WorldState.getInstance().setInTavern(true);
        }

        System.out.println("0 - Leave" +
                "\n1 - Ask the barkeep for a donation." +
                "\n2 - Steal from the tavern register." +
                "\n3 - Order a drink from the barkeep for 5 gold." +
                "\n4 - Talk to the Town Drunk.");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Tavern);
        }
        switch (choice){
            case 0:
                WorldState.getInstance().setInTavern(false);
                awaitInput("You exit the tavern.");
                WorldState.getInstance().game.setGameState(GameState.TownMenu);
                break;
            case 1:
                awaitInput("\"Nah, if this heap burns down it'd be a blessing.\"");
                WorldState.getInstance().game.setGameState(GameState.Tavern);
                break;
            case 2:
                awaitInput("As you reach your arm into the register a large, beefy hand clamps down on your forearm.");
                awaitInput("\"You're a damned fool thinkin'  I don't get my share of thieves in here.\" The Barkeep gives you a right beating and takes half your gold for his trouble.");
                WorldState.getInstance().divideGold(2);
                WorldState.getInstance().subtractKarma(1);
                WorldState.getInstance().game.setGameState(GameState.TownMenu);
                break;
            case 3:
                if(WorldState.getInstance().getGold() > 5){
                    awaitInput("You order a drink, you're pretty sure it might just be lighter fluid.");
                    awaitInput("The barkeep rants at you, \"If that damn shopkeep keeps talkin about how that Khanway Vest is going to \"Make dragons dead again\" I'm gonna slug him. Lot of help that bastard has done for us recently.\"");
                    WorldState.getInstance().subtractGold(5);
                    WorldState.getInstance().setKnowShopLovesKhanway(true);
                } else {
                    awaitInput("\"If you're lookin for free drink, go talk to that drunk. This ain't a charity.\"");
                }
                WorldState.getInstance().game.setGameState(GameState.Tavern);
                break;
            case 4:
                awaitInput("You can smell him before you reach him, you approach the town drunk.");
                WorldState.getInstance().game.setGameState(GameState.Tavern_Drunk);
                break;

            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Tavern);
        }

    }

}
