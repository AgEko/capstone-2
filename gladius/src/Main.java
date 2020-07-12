import assets.Game;
import assets.GameState;
import assets.WorldState;

public class Main {

    public static void main(String[] args) {
        Game newGame = new Game();
        WorldState.getInstance().game = newGame;
        WorldState.getInstance().game.setGameState(GameState.GameIntro);
    }



}


