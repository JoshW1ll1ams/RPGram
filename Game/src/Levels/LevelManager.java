package Levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import entitys.Collisions;
import entitys.LoadSave;
import main.Game;

public class LevelManager {
	

	private Game game;
	private BufferedImage[] levelSprite;
	
	
	public LevelManager(Game game)
	{
		this.game = game;
		importSprites(); // Call our import spites function
	}
	
	
	private void importSprites() {
		BufferedImage img = LoadSave.GetSprite(LoadSave.LevelSprite); // Here we load our level sprite from our Load Save that converts the input stream to buffered image 
		levelSprite = new BufferedImage[1025];
		int counter = 0;
		for(int i=0; i < 32; i++) // The top loop is for the length of the y axis on the sprite sheet
		{
			for(int j=0; j < 32; j++) // This loop is for the x axis of the sprite sheet
			{
				counter++;
				levelSprite[counter] = img.getSubimage(j*16, i*16, 16, 16);
			}
		}
	}


	static int[] map = Game.currentMap; // Set the default map 
	public void render(Graphics g)
	{
		int counter = 0; // Set a counter to track the mapping index
		int pos = 0; // Variable to track the current sub image 
		map = GetCurrentMap(); // Always pull the current map 

		for(int i=0; i < 16; i++)  // Iterate the y axis 
		{
			for(int j=0; j < 32; j++) // Iterate the x axis 
			{
				counter ++; // Add one to counter to keep track
				pos = map[counter]; // Pull the image at the counter index from our current map in the map class
				g.drawImage(levelSprite[pos], j*32, i*32, 32, 32, null); // Draw the image 
			}
		}

		
	}
	
	public void update()
	{
		
	}
	public int[] GetCurrentMap()
	{
		return this.map; // Return the current map
	}
	public static int[] SetCurrentMap(int[] map)
	{
		return LevelManager.map = map; // Set the current map to the map we pass into the setter function 
		//			LevelManager.SetCurrentMap(Maps.map2);    	USED TO CHANGE CURRENT MAP
	}
		
}
