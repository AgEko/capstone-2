package assets;

public class WorldState {
    private static WorldState instance;


    private boolean gameOver;

    private boolean hasBeenToHomeMenu;

    private boolean hasBlackjack;

    private boolean stoleFromBaker;
    private boolean stoleFromShop;
    private boolean stoleFromTanner;
    private boolean stoleFromNoble;
    private boolean stoleFromBarkeep;
    private boolean stoleFromDrunk;
    private boolean stoleFromTemple;

    private boolean isInBakery;
    private boolean isInTannery;
    private boolean isInShop;
    private boolean isAtNoble;
    private boolean isInTavern;
    private boolean isAtCrimeBoss;
    private boolean isInTemple;

    private boolean tookDonationBaker;
    private boolean tookDonationTanner;
    private boolean tookDonationShop;
    private boolean tookDonationTemple;


    private int gold = 0;
    private int karma = 0;
    private boolean knowShopLovesKhanway;
    private boolean oweTheMob;
    private boolean isTalosMad;

    private boolean metBoneregard;
    private boolean stoleFromLich;
    private boolean isOnLichQuest;
    private boolean lichQuestSuccess;
    private boolean visitedCrypt;

    private boolean ambush;
    private boolean drunkDragon;
    private boolean dragonGF;
    private boolean deadDragon;
    private boolean dragonSoloKill;
    private boolean lazyDragonKill;

    public Game game;


    public static WorldState getInstance(){
        if (instance == null){
            instance = new WorldState();
        }
        return instance;
    }

    public static void reset(){
        instance = new WorldState();
    }

    public static void isSessionTerminated(boolean quit){
        for (int i = 0; i < 10; i++){
            try {
                quit = true;
            } catch (Exception e){
                System.out.println("No more backing up!");
            }
        }

//        if (quit && WorldState.getInstance().isGameOver()){
//            return true;
//        }
//        return false;
    }

    public static void setInstance(WorldState instance) {
        WorldState.instance = instance;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isHasBeenToHomeMenu() {
        return hasBeenToHomeMenu;
    }

    public void setHasBeenToHomeMenu(boolean hasBeenToHomeMenu) {
        this.hasBeenToHomeMenu = hasBeenToHomeMenu;
    }

    public boolean isStoleFromBaker() {
        return stoleFromBaker;
    }

    public void setStoleFromBaker(boolean stoleFromBaker) {
        this.stoleFromBaker = stoleFromBaker;
    }

    public boolean isStoleFromShop() {
        return stoleFromShop;
    }

    public void setStoleFromShop(boolean stoleFromShop) {
        this.stoleFromShop = stoleFromShop;
    }

    public boolean isStoleFromTanner() {
        return stoleFromTanner;
    }

    public void setStoleFromTanner(boolean stoleFromTanner) {
        this.stoleFromTanner = stoleFromTanner;
    }

    public boolean isStoleFromNoble() {
        return stoleFromNoble;
    }

    public void setStoleFromNoble(boolean stoleFromNoble) {
        this.stoleFromNoble = stoleFromNoble;
    }

    public boolean isStoleFromBarkeep() {
        return stoleFromBarkeep;
    }

    public void setStoleFromBarkeep(boolean stoleFromBarkeep) {
        this.stoleFromBarkeep = stoleFromBarkeep;
    }

    public boolean isStoleFromDrunk() {
        return stoleFromDrunk;
    }

    public void setStoleFromDrunk(boolean stoleFromDrunk) {
        this.stoleFromDrunk = stoleFromDrunk;
    }

    public boolean isStoleFromTemple() {
        return stoleFromTemple;
    }

    public void setStoleFromTemple(boolean stoleFromTemple) {
        this.stoleFromTemple = stoleFromTemple;
    }

    public boolean isInBakery() {
        return isInBakery;
    }

    public void setInBakery(boolean inBakery) {
        isInBakery = inBakery;
    }

    public boolean isInTannery() {
        return isInTannery;
    }

    public void setInTannery(boolean inTannery) {
        isInTannery = inTannery;
    }

    public boolean isInShop() {
        return isInShop;
    }

    public void setInShop(boolean inShop) {
        isInShop = inShop;
    }

    public boolean isAtNoble() {
        return isAtNoble;
    }

    public void setAtNoble(boolean atNoble) {
        isAtNoble = atNoble;
    }

    public boolean isInTavern() {
        return isInTavern;
    }

    public void setInTavern(boolean inTavern) {
        isInTavern = inTavern;
    }

    public boolean isInTemple() {
        return isInTemple;
    }

    public void setInTemple(boolean inTemple) {
        isInTemple = inTemple;
    }

    public boolean isTookDonationBaker() {
        return tookDonationBaker;
    }

    public void setTookDonationBaker(boolean tookDonationBaker) {
        this.tookDonationBaker = tookDonationBaker;
    }

    public boolean isTookDonationTanner() {
        return tookDonationTanner;
    }

    public void setTookDonationTanner(boolean tookDonationTanner) {
        this.tookDonationTanner = tookDonationTanner;
    }

    public boolean isTookDonationShop() {
        return tookDonationShop;
    }

    public void setTookDonationShop(boolean tookDonationShop) {
        this.tookDonationShop = tookDonationShop;
    }

    public int getGold() {
        return gold;
    }
    public void addGold(int gold) {
        this.gold += gold;
    }
    public void subtractGold(int gold) {
        this.gold -= gold;
    }
    public void divideGold(int gold){
        this.gold /= gold;
    }

    public int getKarma() {
        return karma;
    }
    public void addKarma(int karma) {
        this.karma += karma;
    }
    public void subtractKarma(int karma) {
        this.karma -= karma;
    }

    public boolean isKnowShopLovesKhanway() {
        return knowShopLovesKhanway;
    }

    public void setKnowShopLovesKhanway(boolean knowShopLovesKhanway) {
        this.knowShopLovesKhanway = knowShopLovesKhanway;
    }

    public boolean isOweTheMob() {
        return oweTheMob;
    }

    public void setOweTheMob(boolean oweTheMob) {
        this.oweTheMob = oweTheMob;
    }

    public boolean isTalosMad() {
        return isTalosMad;
    }

    public void setTalosMad(boolean talosMad) {
        isTalosMad = talosMad;
    }

    public boolean isStoleFromLich() {
        return stoleFromLich;
    }

    public void setStoleFromLich(boolean stoleFromLich) {
        this.stoleFromLich = stoleFromLich;
    }

    public boolean isOnLichQuest() {
        return isOnLichQuest;
    }

    public void setOnLichQuest(boolean onLichQuest) {
        isOnLichQuest = onLichQuest;
    }

    public boolean isLichQuestSuccess() {
        return lichQuestSuccess;
    }

    public void setLichQuestSuccess(boolean lichQuestSuccess) {
        this.lichQuestSuccess = lichQuestSuccess;
    }

    public boolean isVisitedCrypt() {
        return visitedCrypt;
    }

    public void setVisitedCrypt(boolean visitedCrypt) {
        this.visitedCrypt = visitedCrypt;
    }

    public boolean isAmbush() {
        return ambush;
    }

    public void setAmbush(boolean ambush) {
        this.ambush = ambush;
    }

    public boolean isDrunkDragon() {
        return drunkDragon;
    }

    public void setDrunkDragon(boolean drunkDragon) {
        this.drunkDragon = drunkDragon;
    }

    public boolean isDragonGF() {
        return dragonGF;
    }

    public void setDragonGF(boolean dragonGF) {
        this.dragonGF = dragonGF;
    }

    public boolean isDeadDragon() {
        return deadDragon;
    }

    public void setDeadDragon(boolean deadDragon) {
        this.deadDragon = deadDragon;
    }

    public boolean isDragonSoloKill() {
        return dragonSoloKill;
    }

    public void setDragonSoloKill(boolean dragonSoloKill) {
        this.dragonSoloKill = dragonSoloKill;
    }

    public boolean isLazyDragonKill() {
        return lazyDragonKill;
    }

    public void setLazyDragonKill(boolean lazyDragonKill) {
        this.lazyDragonKill = lazyDragonKill;
    }

    public boolean isHasBlackjack() {
        return hasBlackjack;
    }

    public void setHasBlackjack(boolean hasBlackjack) {
        this.hasBlackjack = hasBlackjack;
    }

    public boolean isAtCrimeBoss() {
        return isAtCrimeBoss;
    }

    public void setAtCrimeBoss(boolean atCrimeBoss) {
        isAtCrimeBoss = atCrimeBoss;
    }

    public boolean isTookDonationTemple() {
        return tookDonationTemple;
    }

    public void setTookDonationTemple(boolean tookDonationTemple) {
        this.tookDonationTemple = tookDonationTemple;
    }

    public boolean isMetBoneregard() {
        return metBoneregard;
    }

    public void setMetBoneregard(boolean metBoneregard) {
        this.metBoneregard = metBoneregard;
    }
}
