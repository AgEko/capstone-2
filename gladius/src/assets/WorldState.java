package assets;

public class WorldState {
    private static WorldState instance;

    boolean gameOver;

    boolean hasBeenToHomeMenu;

    boolean stoleFromBaker;
    boolean stoleFromShop;
    boolean stoleFromTanner;
    boolean stoleFromNoble;
    boolean stoleFromBarkeep;
    boolean stoleFromDrunk;
    boolean stoleFromTemple;

    boolean isInBakery;
    boolean isInTannery;
    boolean isInShop;
    boolean isAtNoble;
    boolean isInTavern;
    boolean isInTemple;

    boolean tookDonationBaker;
    boolean tookDonationTanner;
    boolean tookDonationShop;


    int gold = 0;
    int karma = 0;
    boolean knowShopLovesKhanway;
    boolean oweTheMob;
    boolean isTalosMad;

    boolean stoleFromLich;
    boolean isOnLichQuest;
    boolean lichQuestSuccess;
    boolean visitedCrypt;

    boolean ambush;
    boolean drunkDragon;
    boolean dragonGF;
    boolean deadDragon;
    boolean dragonSoloKill;
    boolean lazyDragonKill;



    public static WorldState getInstance(){
        if (instance == null){
            instance = new WorldState();
        }
        return instance;
    }

    public static void reset(){
        instance = new WorldState();
    }



}
