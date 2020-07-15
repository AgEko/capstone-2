<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* I need to create a text-based adventure. With ASCII gui if time permits.
* Follow requirements in readme
*
<h2>
    2. Planning the Solution
</h2>

* The story will be: 
* Intro -> while(!dead){adventureNav} -> Epilogue.
* Need a World State to remember what the player has done
* Inventory for player object
* A way to display the player's inventory

<h2>
    3. Executing the Plan
</h2>

* Story! This will tell me exactly what im going to need on the codeSide.
* Story complete. Req.: 
* WorldState to hold universal data and Epilogue decisions.
* GameState: To know of our current menu location. - (State Machine pattern)
* awaitInput(): To slow the text down for ux
*
<h2>
    4. Reflection / Refactor
</h2>

* Visualizing the architecture for the game whats the most difficult for starting the project.Story took the most time, but architecture i needed help on.
     - A pattern (State Machine) Helped organize my locations and menus. Avoided heavy recursion during gameplay.
    - Every menu is re-created when the player visits the location or inputs an invalid action.  
* My WorldState holds some info that is not used in other places, this can be refactored to lighten up the workload on WorldState.
* I would need a WorldState that remembers the last state the game was in.
* Game is functional now. With time i would like to make a gui: That would need a character object for the player ro interact with. Also playerController.
*
