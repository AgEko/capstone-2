package assets;

public class WorldState {
    public static WorldState instance;

    int gold = 0;
    int karma = 0;
    boolean shopLovesKhan;
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



}
