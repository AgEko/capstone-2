package assets.scenes.Dungeon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

public class Dungeon_Visited extends Scene {

    public void interaction(){

        if(WorldState.getInstance().isStoleFromLich()){
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Visited_StoleGold);
        } else if (!WorldState.getInstance().isOnLichQuest()){
            WorldState.getInstance().game.setGameState(GameState.Dungeon_Lich);
        } else {
            lichQuestStatus();
        }

    }

    private void lichQuestStatus(){
        awaitInput("Mr.Boneregard greets you. \"Welcome friend, do you bring good news?\"");
        if (!WorldState.getInstance().isLichQuestComplete()){
            if(!WorldState.getInstance().isLichQuestSuccess()){
                singleInput("Not just yet.");
                awaitInput("\"Very well, please return when you succeed establishing trade for us.\"");
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
            } else {
                singleInput(" You inform Mr. Bonereguard with the details of the arrangement that the shopkeep proposed.");
                awaitInput("\"Outstanding work. Here is payment for your assistance adventurer. You have our gratitude.\"");
                awaitInput("You leave counting your gold. 400 big ones! Noice!");
                WorldState.getInstance().addGold(400);
                WorldState.getInstance().setLichQuestComplete(true);
                WorldState.getInstance().addKarma(1);
                WorldState.getInstance().game.setGameState(GameState.Dungeon);
            }
        } else {
            awaitInput("Mr. Boneregard greets you. \"Thank you for your assistance, we have no need for your services at this time.\"");
            awaitInput("You leave the dungeon.");
            WorldState.getInstance().game.setGameState(GameState.Dungeon);
        }

    }



}
