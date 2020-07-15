package assets.scenes.Dragon;

import assets.GameState;
import assets.Scene;
import assets.WorldState;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ambush_Event_BetrayAmbush extends Scene {

    public void interaction(){
        int choice = -1;

        if(!WorldState.getInstance().isAmbushBetrayal()){
            awaitInput("You decide that Lirastrasza isn't so bad and decide to take arms against the ambushers.");
            awaitInput("Dodging flame blasts and striking down the ambushers you and the Dragon defeat the ambush!");
            awaitInput("As the smoke clears Lirastrasza eyes you suspiciously. She demands: \"What is the meaning of this?\"");
            WorldState.getInstance().subtractKarma(5);
            WorldState.getInstance().setAmbushBetrayal(true);
        }


        System.out.println("1 - Explain about your part in the ambush and apologize." +
                "\n2 - Lie to her: You asked them not to attack." +
                "\n3 - Play dumb");
        try {
            Scanner a = new Scanner(System.in);
            choice = a.nextInt();
        } catch (InputMismatchException e){
            System.out.println("That is not a valid option.");
            WorldState.getInstance().game.setGameState(GameState.Ambush_Event_BetrayAmbush);
        }
        switch (choice){
            case 1:
                awaitInput("\"I apologize for their actions Lirastrasza. They were only to intervene if I was in trouble.\"");
                awaitInput("Furious she steams, \"An insurance policy? You mean to kill me then if things did not go in your favor.\"");
                awaitInput("\"Humans cannot be trusted.\"");
                gameOver("She leaps upon you and tears you in half with her powerful claws.");
                break;
            case 2:
                awaitInput("\"I pleaded with them not to attack, they would not listen.\" your heart races as to lie to the dragon.");
                awaitInput("\"Humans will always kill a dragon amongst for glory or out of fear. Give me the 400 gold I request and I will go.\"");
                if (WorldState.getInstance().getGold() > 400){
                    awaitInput("You give the dragon 400 gold and she departs. The town is preserved for now.");
                    WorldState.getInstance().game.setGameState(GameState.Epilogue);
                }
                singleInput("\"Ooh ah... yeah about the gold... i'm a little short.\" you stammer.");
                awaitInput("Then I shall rend it from your bones!");
                gameOver("Rend it from your bones she did, who knew there was gold in there, but yep you are most assuredly dead.");
                break;
            case 3:
                awaitInput("You try to bluff the dragon, \"I had no idea, Lirastrasza.\"");
                awaitInput("\"A likely story mortal.\" she bares dagger sized fangs at you. ");
                awaitInput("Give me twice what I demand and I may spare your town.");
                if (WorldState.getInstance().getGold() > 805){
                    awaitInput("You give the dragon 805 gold and she departs. The town is preserved for now.");
                    WorldState.getInstance().game.setGameState(GameState.Epilogue);
                    if(WorldState.getInstance().isTalosMad()){
                        talosInfluenceOnDragon();
                    }
                }
                singleInput("You protest her outrage's demand\"What?! I don't have that kind of money!\" ");
                awaitInput("Then I shall rend it from your very bones!");
                gameOver("Rend it from your bones she did, who knew there was gold in there, but yep you are most assuredly dead.");
                break;
            default:
                System.out.println("That is not a valid option.");
                WorldState.getInstance().game.setGameState(GameState.Ambush_Event_BetrayAmbush);
        }
    }

    private void talosInfluenceOnDragon(){
        awaitInput("Your mind is flooded with whispers from the evil deity Talos. \"\"");
        awaitInput("\"He lies to you Lira... Do not show weakness to this, lesser race. You, are a dragon. To rule is your right.\"");
        singleInput("You clan out an ear, \"Uh, did you hear that?\"");
        awaitInput("Your question is quickly answered as the Dragon's murderous aura overwhelms you");
        awaitInput("The beast rends you with such ferocity that... then she... Oh the humanity! Tis' is far too gruesome to describe.");
        gameOver("But yep... You are dead indeed. No question about that. Guess stealing from the Temple wasn't worth it. Oof!");
    }

}
