package assets;


public class Adventure {
    Game game;
    Player player = new Player();

    public Adventure (Game game){
        this.game = game;
    }



    public void startAdventure(){
        Intro intro = new Intro();
        intro.adventureIntro();
        System.out.println("You lost you wet sock, suck it up.");
        if (WorldState.getInstance().isGameOver()){
            WorldState.reset();
            Utility.awaitInput();
            startAdventure();
        }
        //load assents
        //narration
    }






}
