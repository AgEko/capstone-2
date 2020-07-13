package assets.scenes.Town;

import assets.GameState;
import assets.Scene;
import assets.WorldState;
import assets.items.Hammer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop extends Scene{

    public void interaction(){
        int choice = -1;

        if (!WorldState.getInstance().isInShop()){
            awaitInput("As you enter the Shopkeep greets you with a hearty \"Welcome, feel free to browse!\"");
            WorldState.getInstance().setInShop(true);
        }

            System.out.println("0 - Leave" +
                    "\n1 - Ask for a donation." +
                    "\n2 - Steal from the register." +
                    "\n3 - (50 gold) Buy a Warhammer." +
                    "\n4 - (15 gold) Buy a Torch.");
            if (WorldState.getInstance().isOnLichQuest()){
                System.out.println("5 -  Talk to the Shopkeep about trading with the Lich.");
            }

            try {
                Scanner a = new Scanner(System.in);
                choice = a.nextInt();
            } catch (InputMismatchException e){
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Shop);
            }
            switch (choice){
                case 0:
                    WorldState.getInstance().setInShop(false);
                    WorldState.getInstance().game.setGameState(GameState.TownMenu);
                    break;
                case 1:
                    if (!WorldState.getInstance().isTookDonationShop()){
                        awaitInput("\"If it means that we will still have a town by day's end, I'm in.\"");
                        awaitInput("He gives you 45 gold.");
                        WorldState.getInstance().addGold(45);
                        WorldState.getInstance().setTookDonationShop(true);
                    } else {
                        awaitInput("You already took a donation!");
                    }
                    WorldState.getInstance().game.setGameState(GameState.Shop);
                    break;
                case 2:
                    if (!WorldState.getInstance().isKnowShopLovesKhanway()){
                        awaitInput("You fail to find an opening to make a grab at the cash. The shopkeep is on his game like white on rice.");
                    } else if (!WorldState.getInstance().isStoleFromShop() && WorldState.getInstance().isKnowShopLovesKhanway()){
                        awaitInput("\"You distract the Shopkeep by telling him presidential candidate Khanway Vest is campaigning outside.\"");
                        awaitInput("He excitedly runs outside and you safely empty the till.");
                        awaitInput("You net 100 ez gold");
                        WorldState.getInstance().addGold(100);
                        WorldState.getInstance().setStoleFromShop(true);
                        WorldState.getInstance().subtractKarma(1);
                    } else {
                        awaitInput("You already took an unwilling donation! You scoundrel!");
                    }
                    WorldState.getInstance().game.setGameState(GameState.Shop);
                    break;
                case 3:
                    if (WorldState.getInstance().getGold() > 50){
                        WorldState.getInstance().game.player.getInventory().add(new Hammer("Warhammer"));
                        awaitInput("You buy a Warhammer for 50 gold. Oof! It's heavy!");
                        WorldState.getInstance().subtractGold(50);
                    } else {
                        awaitInput("You don't have enough gold.");
                    }
                    WorldState.getInstance().game.setGameState(GameState.Shop);
                    break;
                case 4:
                    if (WorldState.getInstance().getGold() > 15){
                        WorldState.getInstance().game.player.getInventory().add(new Hammer("Torch"));
                        awaitInput("You buy a Torch for 15 gold. This is sure to light any dark passageways!");
                        WorldState.getInstance().subtractGold(15);
                    } else {
                        awaitInput("You don't have enough gold.");
                    }
                    WorldState.getInstance().game.setGameState(GameState.Shop);
                    break;
                case 5:
                    if (WorldState.getInstance().isOnLichQuest()){
                        awaitInput("Talk to the shopkeep about trading with the Lich");
                        awaitInput("\"Woah that's quite a tale. I'm willing to trade, but we are going to have to do it out in the open. I won't risk my caravans going into that dungeon.\"");
                        awaitInput("You can report your success to the Lich now!");
                        WorldState.getInstance().setLichQuestSuccess(true);
                    } else {
                        awaitInput("That is not a valid option.");
                    }
                    WorldState.getInstance().game.setGameState(GameState.Shop);
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    WorldState.getInstance().game.setGameState(GameState.Shop);
            }
    }

}
