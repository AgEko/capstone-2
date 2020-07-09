<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* I would like an ASCII-style game
* 
<> Tell a story
[]plot
    Mage Thief. Stealin gold to impress a dragon lady (She a gold digger like most dragons)
    Mage Thief. Stealin stuff to pay off a due to a (boss) to save (loved one).
    Mage Thief. JUST LEIK STEALIN'
    -
    Pay off dragon to save your village.
    Turns of dragon is a lady. 
    Dragon thinks you're kinda cute (Pfft). Fight her now. || Try and go on a date with the dragon.
        Talk to other adventurers in town to set up an ambush for the dragon. 
    Steal stuff to go on a date with a dragon lady, she yelll as a waiter... yikes. 
    
    
    
[]atmosphere
    Low-Fantasy {
        magic(aether.transDimensional magic).(Not great on the offensive(needs set up), great for warding and charge items) and stuff but no furries. Maybe squats. Clockwork || Steam Tech.
    }
        
[]characters
    - Lich Thel'zad

<>Exploration
[]mapBoards

[] Navigation maps <World, local>
[]Easter eggs!

<>Battles
[] Different enemies AI
    -Balancing
    -Fun(nah)

<Items, spells>
[]LOOT
[] Upgrades
[] Inventory (lb. limit? if (inventory.lbs > .limit) encumbered? would need real-time runtime)
[] Shop

Mage thief? Utility game. 
Stealin stuff to get enough gold to impress a dragon lady?
Gettinig enought gold together to get close to a dragon, so you can save someone()

* Is combat in overworld? or a new menu?
*
*
<h2>
    2. Planning the Solution
</h2>
* Gameboard [map.location(s)]
[] Id for graphics
[] Bool for (Solid)


* Character 
[ ] Controller
[ ] Inventory
[ ] Use cases for utility spells
* 
Interactions with dynamic and Solid objects
    position (x, y)
    velocity (x, y)
    Solid v Solid
    Solid v Dynamic
    =
    OnInteractions
    isFriendly? 
*
Inheritance structure
[]Map
    < Tiles
    
[]Dynamic(Super Class) 
    < Creature
        << Player ()
        << NPC
            <<< Mob
    < Interaction
        << Teleport(Move location)
        << Signpost/Hidden spot (Display some info)
*
*
*
*
<h2>
    3. Executing the Plan
</h2>
* [ ] Make an interactable JFrame (Keys or mouse)
* [ ] Make a 'playerCharacter'(@) that can move freely in the worldmap.
*       
*
*
*
*
*
<h2>
    4. Reflection / Refactor
</h2>
*
*
*
*
*
*
*
*