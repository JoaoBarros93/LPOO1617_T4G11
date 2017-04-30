# LPOO1617_T4G11

Team Member:

up201505735 - Gil Dinis Magalhães Teixeira - up201505735@fe.up.pt

Project Theme

  A Tron-like Game.

Architecture Design
  -Class diagram:
  ![class diagram](https://cloud.githubusercontent.com/assets/25747690/25568221/f44eb60e-2df5-11e7-8cf8-a5ea4fc81650.png)
  
 
  -Game’s state diagram:
  ![Game state diagram](https://cloud.githubusercontent.com/assets/25747690/25568216/f44a3b7e-2df5-11e7-8dbe-46633a28d1e1.png)

Expected Design Patterns to use on your application
  -Singleton for the Game Class.
  -Strategy to implement several bots AI.

GUI Design
  -Identification/Listing of the main functionalities, present on the GUI.
  	-Choose Game Settings:
	  	-Number of Bots: 0-3;
		  -Choose Bot’s AI:
			  - Random;
			  - Wall-hugging;
			  - Enemy Avoidance;
        - Most Open Destination;

  	-SinglePlayer vs Bots;
	  -Multiplayer; 

GUI mock-ups.
  - Main Menu.
  ![Main Menu GUI](https://cloud.githubusercontent.com/assets/25747690/25568219/f44b9de8-2df5-11e7-820f-ee0e7dbcd7dc.png)

  -	Gameplay.
  ![GamePlay GUI](https://cloud.githubusercontent.com/assets/25747690/25568220/f44d693e-2df5-11e7-90bc-8579e9b1d2ed.png)

  - Multiplayer Menu.
  ![MultiPlayer GUI](https://cloud.githubusercontent.com/assets/25747690/25568217/f44b3bdc-2df5-11e7-8187-8334ee8be03c.png) 

  -	Options Menu.
  ![Options GUI](https://cloud.githubusercontent.com/assets/25747690/25568218/f44b4640-2df5-11e7-825f-7ce353e2fb42.png)

 

Test Design
  Listing of the expected final test cases.
    - Test if player goes against a Wall, the player loses.
    - Test if player goes against its own tail, the player loses.
    - Test if player goes against bot’s tail, the player loses.
    - Test if bot goes against player’s tail, the player wins.
    - Test AI: Random, Wall-Hugging, Enemy Avoidance, Most Open Destination.
