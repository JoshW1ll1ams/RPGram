package main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Levels.LevelManager;
import Levels.Maps;
import entitys.Collisions;
import entitys.Mob;
import entitys.Player;
import entitys.QuestionScreen;
import entitys.entity;
import entitys.inventory;
import entitys.popUp;

// Implement the interface runnable to allow us to use multiple threads to avoid game lag
// With multiple threads we can run more than one task at once
public class Game implements Runnable{

	public static Window GameWindow;
	public static Panel GamePanel;
	private LevelManager levelManager;

	
	
	// Create out inventory 
	public static inventory playerInv = new inventory();
	
	public static QuestionScreen questions = new QuestionScreen();
	
	public final static int TileSize = 16; // Set the tile size for our game spites
	public final static float Scale = 2.0f; // This will be the value we multiply with our tile size to get the true size
	public final static int TotalTileWidth = 32; // Set the how many tiles we have on the x axis 
	public final static int TotalTileHeight = 16; // Set how many tiles we have on the y axis
	public final static int TrueTileSize = (int) (TileSize*Scale); // Here we multiply the scale with the tile size
	public final static int WindowWidth = TrueTileSize*TotalTileWidth; // Here we multiply true tile size with amount of tiles on the x axis to get true window width 
	public final static int WindowHeight = TrueTileSize*TotalTileHeight;// Here we multiply true tile size with amount of tiles on the y axis to get true window height 
	
	//Here we create our game loop thread
	public static Thread GameLoop;
	
	// Here we create an instance of our player class 
	public static Player player;
	
	

	public static int[] currentMap;
	
	public Game(int[] map)
	{

		this.currentMap = map;
		// Initialise game entities before anything else
		initialiseEntities();
		// Create a new instance of panel class that will be our main game panel
		GamePanel = new Panel(this);
		// Create a new instance of window class that will be our main game window 
		GameWindow = new Window(GamePanel);  
		// This makes sure the game panel is ready to receive inputs 
		GamePanel.requestFocus();
		// Add the inventory to our game panel
		GamePanel.add(playerInv);
		// Add the question panel to main screen
		GamePanel.add(questions);
		// Start our game loop function
		startGameLoop();
		
	}
	
	
	
	// Function to return the current tile the player is on
	public static int CurrentTile()
	{
		int currentX = 0;
		int currentY = 0;
		int counterX = 0;
		int counterY = 0;
		// Iterate the x axis 
		for(int i =1; i < 32; i++)
		{
			if(player.x+8 > counterX && player.x+8 < counterX+32) // Check which bounds the x is between in iterations of our tile width which is 32, add 8 to find the centre of our player not top left
			{
				currentX = i;
			}
			counterX += 32;
		}
		for(int i =1; i < 32; i++)
		{
			if(player.y+8 > counterY && player.y+8 < counterY+32) // Check which bounds the y is between in iterations of our tile height which is 32, add 8 to find the centre of our player not top left
			{
				currentY = i;
			}
			counterY += 32;
		}
		int currentTile = (32*currentY+currentX+1); // This formula takes the current x and y and returns the correct tile number
		return currentTile;
	}
	// Array list to hold mobs current on screen
	public static ArrayList<Mob> currentMobs = new ArrayList<Mob>();
	
	private void initialiseEntities() {

		levelManager = new LevelManager(this); // Here we initialise our level manager class
		player = new Player(1,100, "Player",100,1); 
	}
	
	public static void  initialiseMobs()
	{
		// For loop to spawn random amount of enemy's in to the game 
		Random rn = new Random();
		// Spawn 4 to 9 red enemies 
		int numberEnemys = Maps.numberMobs[0] + rn.nextInt(Maps.numberMobs[1] - Maps.numberMobs[0] + 1);
		for(int i =0; i< numberEnemys; i++)
		{
			// Loop though the length and spawn enemy's in at random position
			int x = 0 + rn.nextInt(WindowWidth - 0 + 1);
			int y = 0 + rn.nextInt(WindowHeight - 0 + 1);
			currentMobs.add(new Mob(x,y, "Red Enemy", 200,0.1,"Red Gem"));
		}	
		for(int i =0; i< numberEnemys; i++)
		{
			// Loop though the length and spawn enemy's in at random position
			int x = 0 + rn.nextInt(WindowWidth - 0 + 1);
			int y = 0 + rn.nextInt(WindowHeight - 0 + 1);
			currentMobs.add(new Mob(x,y, "Green Enemy", 200,0.1,"Green Gem"));
		}	
		for(int i =0; i< numberEnemys; i++)
		{
			// Loop though the length and spawn enemy's in at random position
			int x = 0 + rn.nextInt(WindowWidth - 0 + 1);
			int y = 0 + rn.nextInt(WindowHeight - 0 + 1);
			currentMobs.add(new Mob(x,y, "Blue Enemy", 200,0.1,"Blue Gem"));
		}	
		
	}
	private void startGameLoop()
	{
		// Here we assign our game loop to a new thread
		GameLoop = new Thread(this);
		// We then start our game loop thread
		GameLoop.start();
	}
	
	// Here we create a constant variable to set our games max FPS
	private final int setFPS = 120; 
	// Here we create constant variable to set the games updates per second
	private final int setUPS = 200; 
	
	public void Update()
	{
		
		Collisions.update();
		player.update(); // Here we call the update function in our player class
		levelManager.update(); // Here we call the update function in our level manager class
		// Here we loop though all mobs and update there logic 
		for(int i =0; i < currentMobs.size(); i++)
		{
			currentMobs.get(i).update();
			currentMobs.get(i).CheckCollision();
		}
	}
	public void render(Graphics g)
	{
		levelManager.render(g); // Here we call the render graphics from our level manager class
		player.render(g); // Here we call the render graphics form our player class
		// Loop through our mobs array to render them all every frame
		for(int i =0; i < currentMobs.size(); i++)
		{
			currentMobs.get(i).render(g);
		}
		inventory.render(g);
	}

	@Override
	public void run() {
		
		
		// Here we get the time per frame to work out the FPS
		// We divide the set FPS by nano seconds
		double timePerFrame = 1000000000.0 / setFPS;
		int fps = 0;
		long previousCheck = System.currentTimeMillis(); 
		
		// Here we get the time per update 
		double timePerUpdate = 1000000000.0 / setUPS;
		long lastUpdate = System.nanoTime();
		int update = 0;
		
		double UpdateTick = 0;
		double UpdateRender = 0;
		
		// Main Game Loop
		// I will track both FPS and UPS
		// FPS will track the frames and visual rendering of the game and keep it at a steady level to avoid visual lag 
		// UPS will track the updates per second, this will handle the speed at which the game logic is updated
		while(true)
		{
			long currentTime = System.nanoTime();
			
			UpdateTick += (currentTime - lastUpdate) / timePerUpdate; // Update tick will be 1 or more when duration since last update is more than time per up date
			UpdateRender += (currentTime - lastUpdate) / timePerFrame; // Update frames will be 1 or more when duration since last frame so visuals will be smooth
			lastUpdate = currentTime; // We set the last update to current time so we have it saved for the next iteration 
			
			if(UpdateTick >=1)
			{
				Update(); // Call our update method that runs all the game loop logic functions
				update++;
				UpdateTick--; // We take away 1 from update tick, this way any remaining time will be stored and used for the next update to avoid lag
			}
			
			if(UpdateRender >= 1)
			{
				GamePanel.repaint(); // Repaint the scene so it updates the visual render of the game
				fps++; // Increase FPS counter
				UpdateRender--;  // We take away 1 from update frame render, this way any remaining time will be stored and used for the next update to visual lag 
			}
			// Here we check if one second has passed since last FPS check we do a new FPS check and save the new FPS as previous check
			if(System.currentTimeMillis() - previousCheck >= 1000)
			{
				previousCheck = System.currentTimeMillis();
				//System.out.println("FPS: "+fps);
				//System.out.println("UPS: "+update);
				fps = 0;
				update = 0;
			}
		}
		
	}
	// Creating a getter for my player as this is the class where it is initialised 
	public Player getPlayer()
	{
		return player;
	}
	// Function to execute if the game window is clicked out of
	public void focusLost() {
		player.resetMovement();
		
	}
}
 