package assets;


public class Adventure {
    Player player = new Player();
    public Adventure (){

    }



    public void adventureIntro(){
        new Intro().adventureIntro();
            WorldState.reset();
            Scene.awaitInput("Game reset");
    }






}
