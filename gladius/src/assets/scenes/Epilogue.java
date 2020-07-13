package assets.scenes;

import assets.Scene;
import assets.WorldState;

public class Epilogue extends Scene {

    public void interaction(){

        awaitInput("You saved Kleinstadt from the dragon's wrath! The townspeople rejoice! " +
                "\nYou retire back to your home for a well deserved nap!");



        if(WorldState.getInstance().isOweTheMob()){
            awaitInput("The Crime Boss calls in the favor you owe him to unseat the Noble Lord for ownership of the assets.scenes. " +
                    "After a few shady deals he eventually becomes the new Lord.");
            awaitInput("To your bewilderment, the Crime boss actually brings much prosperity to Kleinstadt. A booming economy and a strict yet fair judicial system.");
            awaitInput("Oh! He also hit the sweet spot on the Laffer curve; Netting him the most in taxes while still allowing the free market to grow like a weed. Good job Crime Boss! Crime Boss 2020!");
            System.out.println(" === = === ");
        }

        if (!WorldState.getInstance().isDeadDragon() && WorldState.getInstance().isDragonGF()){
            awaitInput("You're now going steady with Lirastrasza the Dragon. Who woulda thunk it? Dating a dragon!");
            awaitInput("You go on many adventures and bring home loads of gold and gems to added to Lirastrasza's dragon horde.");
            awaitInput("*Some* of the gold might be extorted from other towns, but hey. Our town is just peachy!");
        }

        if (WorldState.getInstance().isDeadDragon() && WorldState.getInstance().isDragonSoloKill()){
            awaitInput("After slaying the dragon solo, you turn into a bit of a celebrity at the adventures' guild." +
                    "You can charge top coin for your services and go on many harrowing adventures." +
                    "You will be remembered for quite some time, Dragon Slayer.");
        }

        if (WorldState.getInstance().isDeadDragon() &&!WorldState.getInstance().isDragonSoloKill() && !WorldState.getInstance().isLazyDragonKill()){
            awaitInput("You did your part to kill the dragon, working with the people of Kleinstadt you found strength in working together." +
                    "Having killed a dragon the people of Kleinstadt become hardy and fearless." +
                    "Kleinstadt becomes a great city focused on centralizing the Adventuring guilds and bringing peace throughout the land.");
            }

        if(WorldState.getInstance().isDeadDragon() && WorldState.getInstance().isLazyDragonKill()){
            awaitInput("Although you were instrumental in getting the dragon in position to be slain." +
                    "The people of Kleinstadt don't quite see it this way, they are upset at your lack of action during the fight with the dragon as many of the men died during the ambush." +
                    "You continue life as a cunning and crafty adventurer, not interested in risking your life your life for every random contract. " +
                    "Your skill and wit keeps continues to keep you safe on many future adventures.");
        }


        if(WorldState.getInstance().isStoleFromLich()){
            awaitInput("Having stolen from the Lich Thel'zan a band of skeletons led by Mr.Boneregard arrive outside Kleinstadt. " +
                    "Mr.Boneregard annouces your crimes against the Lich. He demands the townsfolk had you over to meet justice at his hands.");
            if(WorldState.getInstance().getKarma() > -3){
                awaitInput("The townspeople of Kleinstadt side with you and tell Mr.Boneregard to get stuffed." +
                        "Mr.Boneregard remembering his Lich'es command to not start a war with the humans. Decided that you are not worth the cost." +
                        "The Skeletons retreat and you live in peace with the people of Kleinstadt.");
            } else {
                awaitInput(" The people of Kleinstadt don't find you to be a very honorable guy and decide to hand you over to the Lich'es minions.");
                if(WorldState.getInstance().isDragonGF()){
                    awaitInput("You tell Lirastrasza about the Lich'es demands and she snorts her disapproval at the attempt on your life." +
                            "Lirastrasza takes flight and launches a fireball at the skeletons who scatter, many perishing in the dragon's flame, the others screeching as they retreat." +
                            "You give Lirastrasza a peck on the cheek, \"Thanks Boo.\"." +
                            "" +
                            "Having been betrayed by the townsfolk fold you decide to live as a roving bandito with Lirastrasza stealing gold and amassing the biggest dragon horde of all time." +
                            "Your skills in espionage in human settlements make finding lucrative marks easy. You and Lirastrasza go down as the most infamous duo in history.");
                } else {
                    awaitInput("The townsfolk hand you over the Mr. Boneregard. Who drags you back to the Crypt." +
                            "Thel'zan sucks your soul out and make you into a haunting geist. You are unable to interact or speak with the carnal plane.." +
                            "You are tethered to the entrance of the Crypt as a deterrence to those who would seek harm on the dungeon's inhabitants." +
                            "The skeletons make fun of you for the rest of eternity as you slowly devolve into madness.");
                }
            }
        }

        if(WorldState.getInstance().isLichQuestComplete()){
            awaitInput("The shopkeep sends out a heavily armed caravan to cautiously trade with the Lich." +
                    "The trades prove fruitful for both parties involved. The shopkeep relaxes the heavy guard on his caravans." +
                    "With the Lich keeping the bandits clear from the trading routes, all trade in the area experiences a boom in prosperity and safety." +
                    "The Lich is able to continue his research in peace while his minions moonlight as security forces for the region.");
        }

        awaitInput("The town of Kleinstadt is saved. You have successfully completed this campaign!");

        if(WorldState.getInstance().isStoleFromLich() && WorldState.getInstance().getKarma() > 3 && !WorldState.getInstance().isDragonGF()){
            System.out.println("Sucks you died anyway, Don't be a jerk next time!");
        }
    }
}

