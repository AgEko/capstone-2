package assets;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Town {




    public void townMenu(){
        Utility.awaitInput("There are a few people in town who may be willing to donate.");
        System.out.println("1 - Go to the Baker." +
                "\n2 - Go to  the General Shop" +
                "\n3 - Go to  the Tanner" +
                "\n4 - Go to the Noble Lord of the town" +
                "\n5 - Go to  the Tavern" +
                "\n6 - Go to the Local Crime Boss" +
                "\n7 - Go to the at the Temple" +
                "\n8 - Go Home");
        townMenuAction();

    }

    public void townMenuAction(){
        try {
            Scanner a = new Scanner(System.in);
            int choice = a.nextInt();

            switch (choice){
                case 1:
                    Utility.awaitInput("You head to the baker.");
                    interactionBaker();
                    break;
                case 2:
                    Utility.awaitInput("You head to the General Shop.");
                    interactionShop();
                    break;
                case 3:

                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
            }

        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            townMenu();
        }
    }

    public void interactionBaker(){
        if (!WorldState.getInstance().isInBakery){
            Utility.awaitInput("You enter the bakery and see the Baker pounding on some cake.");
            WorldState.getInstance().isInBakery = true;
        }
        System.out.println("0 - Leave" +
                "\n1 - Ask for a donation." +
                "\n2 - Steal from the register.");
        try {
            Scanner a = new Scanner(System.in);
            int choice = a.nextInt();

            switch (choice){
                case 0:
                    WorldState.getInstance().isInBakery = false;
                    townMenu();
                    break;
                case 1:
                    if (!WorldState.getInstance().tookDonationBaker){
                        Utility.awaitInput("\"Sure thing, it ain't much but here's what I can spare. \"");
                        Utility.awaitInput("He gives you 15 gold.");
                        WorldState.getInstance().gold += 15;
                        WorldState.getInstance().tookDonationBaker = true;
                        interactionBaker();
                    } else {
                        Utility.awaitInput("You already took a donation!");
                        interactionBaker();
                    }
                    break;
                case 2:
                    if (!WorldState.getInstance().stoleFromBaker){
                        Utility.awaitInput("You distract the Baker by pointing behind him. \"Look! an orc kissing a mermaid!\"");
                        Utility.awaitInput("You reach into the register and make off with the dough. *hur hur*" +
                                "\nYou grabbed 30 gold." +
                                "\nYou call the Baker a weirdo for looking.");
                        WorldState.getInstance().gold += 30;
                        WorldState.getInstance().stoleFromBaker = true;
                        interactionBaker();
                    }else {
                        Utility.awaitInput("You already stole from here!");
                        interactionBaker();
                    }
                    break;
                default:
                    System.out.println("That is not a valid option.");
                    interactionBaker();
            }

        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            interactionBaker();
        }
    }

    public void interactionShop(){
        if (!WorldState.getInstance().isInShop){
            Utility.awaitInput("As you enter the Shopkeep greets you with a hearty \"Welcome, feel free to browse!\"");
            WorldState.getInstance().isInShop = true;
        }
        System.out.println("0 - Leave" +
                "\n1 - Ask for a donation." +
                "\n2 - Steal from the register." +
                "\n3 - (50 gold) Buy a Warhammer." +
                "\n4 - (15 gold) Buy a Torch.");
        if (WorldState.getInstance().isOnLichQuest){
            System.out.println("5 -  Talk to the Shopkeep about trading with the Lich.");
        }

        try {
        Scanner a = new Scanner(System.in);
        int choice = a.nextInt();

        switch (choice){
            case 0:
                WorldState.getInstance().isInShop = false;
                townMenu();
                break;
            case 1:
                if (!WorldState.getInstance().tookDonationShop){
                    Utility.awaitInput("\"If it means that we will still have a town by day's end, I'm in.\"");
                    Utility.awaitInput("He gives you 45 gold.");
                    WorldState.getInstance().gold += 45;
                    WorldState.getInstance().tookDonationShop = true;
                    interactionShop();
                } else {
                    Utility.awaitInput("You already took a donation!");
                    interactionShop();
                }
                break;
            case 2:
                if (!WorldState.getInstance().knowShopLovesKhanway){
                    Utility.awaitInput("You fail to find an opening to make a grab at the cash. The shopkeep is on his game like white on rice.");
                    interactionShop();
                } else if (!WorldState.getInstance().stoleFromShop && WorldState.getInstance().knowShopLovesKhanway){
                    Utility.awaitInput("\"You distract the Shopkeep by telling him presidential candidate Khanway Vest is campaigning outside.\"");
                    Utility.awaitInput("He excitedly runs outside and you safely empty the till.");
                    Utility.awaitInput("You net 100 ez gold");
                    WorldState.getInstance().gold += 100;
                    WorldState.getInstance().stoleFromShop = true;
                    interactionShop();
                } else {
                    Utility.awaitInput("You already took an unwilling donation! You scoundrel!");
                    interactionShop();
                }
                break;
            case 3:
                if (WorldState.getInstance().gold > 50){
                    Utility.awaitInput("You buy a Warhammer for 50 gold. Oof! It's heavy!");
                    WorldState.getInstance().gold -= 50;
                    interactionShop();
                } else {
                    Utility.awaitInput("You don't have enough gold.");
                    interactionShop();
                }
                break;
            case 4:
                if (WorldState.getInstance().gold > 15){
                    Utility.awaitInput("You buy a Torch for 15 gold. This is sure to light any dark passageways!");
                    WorldState.getInstance().gold -= 15;
                    interactionShop();
                } else {
                    Utility.awaitInput("You don't have enough gold.");
                    interactionShop();
                }
                break;
            case 5:
                if (WorldState.getInstance().isOnLichQuest){
                    Utility.awaitInput("Talk to the shopkeep about trading with the Lich");
                    Utility.awaitInput("\"Woah that's quite a tale. I'm willing to trade, but we are going to have to do it out in the open. I won't risk my caravans going into that dungeon.\"");
                    Utility.awaitInput("You can report your success to the Lich now!");
                    WorldState.getInstance().lichQuestSuccess = true;
                } else {
                    Utility.awaitInput("That is not a valid option.");
                    interactionShop();
                }
                break;
            default:
                System.out.println("That is not a valid option.");
                interactionShop();
            }
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            interactionShop();
        }
    }

    public void interactionTanner(){
        if(!WorldState.getInstance().isInTannery){
            Utility.awaitInput("You enter the Tannery. The Tanner greets you but remains focused on his work.");
            WorldState.getInstance().isInBakery = true;
        }
        System.out.println("0 - Leave" +
                "\n1 - Ask for a donation" +
                "\n2 - Rob the Tanner");

        try {
        Scanner a = new Scanner(System.in);
        int choice = a.nextInt();

        switch (choice){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            default:
        }

    } catch (InputMismatchException e){
        System.out.println("That is not a valid option.");
        townMenu();
    }
    }

}
