package assets.town;

import assets.Town;
import assets.Utility;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Shop {

    public void interaction(){
        if (!WorldState.getInstance().isInShop()){
            Utility.awaitInput("As you enter the Shopkeep greets you with a hearty \"Welcome, feel free to browse!\"");
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
            int choice = a.nextInt();

            switch (choice){
                case 0:
                    WorldState.getInstance().setInShop(false);
                    Town town = new Town();
                    town.townMenu();
                    break;
                case 1:
                    if (!WorldState.getInstance().isTookDonationShop()){
                        Utility.awaitInput("\"If it means that we will still have a town by day's end, I'm in.\"");
                        Utility.awaitInput("He gives you 45 gold.");
                        WorldState.getInstance().addGold(45);
                        WorldState.getInstance().setTookDonationShop(true);
                        interaction();
                    } else {
                        Utility.awaitInput("You already took a donation!");
                        interaction();
                    }
                    break;
                case 2:
                    if (!WorldState.getInstance().isKnowShopLovesKhanway()){
                        Utility.awaitInput("You fail to find an opening to make a grab at the cash. The shopkeep is on his game like white on rice.");
                        interaction();
                    } else if (!WorldState.getInstance().isStoleFromShop() && WorldState.getInstance().isKnowShopLovesKhanway()){
                        Utility.awaitInput("\"You distract the Shopkeep by telling him presidential candidate Khanway Vest is campaigning outside.\"");
                        Utility.awaitInput("He excitedly runs outside and you safely empty the till.");
                        Utility.awaitInput("You net 100 ez gold");
                        WorldState.getInstance().addGold(100);
                        WorldState.getInstance().setStoleFromShop(true);
                        WorldState.getInstance().subtractKarma(1);
                        interaction();
                    } else {
                        Utility.awaitInput("You already took an unwilling donation! You scoundrel!");
                        interaction();
                    }
                    break;
                case 3:
                    if (WorldState.getInstance().getGold() > 50){
                        Utility.awaitInput("You buy a Warhammer for 50 gold. Oof! It's heavy!");
                        WorldState.getInstance().subtractGold(50);
                        interaction();
                    } else {
                        Utility.awaitInput("You don't have enough gold.");
                        interaction();
                    }
                    break;
                case 4:
                    if (WorldState.getInstance().getGold() > 15){
                        Utility.awaitInput("You buy a Torch for 15 gold. This is sure to light any dark passageways!");
                        WorldState.getInstance().subtractGold(15);
                        interaction();
                    } else {
                        Utility.awaitInput("You don't have enough gold.");
                        interaction();
                    }
                    break;
                case 5:
                    if (WorldState.getInstance().isOnLichQuest()){
                        Utility.awaitInput("Talk to the shopkeep about trading with the Lich");
                        Utility.awaitInput("\"Woah that's quite a tale. I'm willing to trade, but we are going to have to do it out in the open. I won't risk my caravans going into that dungeon.\"");
                        Utility.awaitInput("You can report your success to the Lich now!");
                        WorldState.getInstance().setLichQuestSuccess(true);
                    } else {
                        Utility.awaitInput("That is not a valid option.");
                        interaction();
                    }
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    interaction();
            }
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            interaction();
        }
    }
}
