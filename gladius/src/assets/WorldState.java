package assets;

public class WorldState {
    private static WorldState instance;

    boolean gameOver;

    int gold = 0;
    int karma = 0;
    boolean knowShopLovesKhan;
    boolean oweTheMob;
    boolean isTalosMad;

    boolean stoleFromLich;
    boolean lichQuest;
    boolean lichQuestSuccess;

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
