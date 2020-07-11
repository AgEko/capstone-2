package assets.town;

import assets.Scene;
import assets.WorldState;

public class Noble extends Scene {

    public void interaction(){
        if (!WorldState.getInstance().isAtNoble()){
            awaitInput("You approach ");
        }
    }
}
