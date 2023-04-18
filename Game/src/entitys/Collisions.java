package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import Levels.Maps;
import main.Game;

public class Collisions {

	public static void update()
	{
		
		try {
			Game.player.CheckCollision();
		} catch (NullPointerException e) {
		    System.out.println("Player is null");
		}
		
		// Loop through the enemies to check if there touching the player
		for(int i =0; i < Game.currentMobs.size(); i++)
		{
			CheckEnemy(Game.currentMobs.get(i), Game.player);
		}
		
	}
	static Rectangle entity1 = new Rectangle();
	static Rectangle entity2 = new Rectangle();
	static Random rn = new Random();
	static int knockbackDistance = 5;
	
	// Create a function that checks if the player is touching enemy 
	public static void CheckEnemy(Mob mob, Player player)
	{
		// Pick a random direction to send the player if a mob is touching them
		int direction = 0 + rn.nextInt(4 -0 + 1);
		
		entity1 = new Rectangle((int)player.x+16,(int)player.y+16,Player.playerHeight-32,Player.playerWidth-32);
		entity2 = new Rectangle((int)mob.x, (int)mob.y,32,32);
		// If player contacts a mob entity and is attacking do damage 
		if(entity1.intersects(entity2) && player.playerAttacking)
		{
			mob.health -= player.damage;
		}
		// If player is touching enemy reduce health and move them around 
		if(entity1.intersects(entity2))
		{
			player.health -= mob.damage;
			if(direction == 0)player.x+=knockbackDistance;
			if(direction == 1)player.x-=knockbackDistance;
			if(direction == 2)player.y+=knockbackDistance;
			if(direction == 3)player.y-=knockbackDistance;
		}
	
	}
	
	// Function to check if player is touching a block and if they are move them away from it and don't let them go into it
	public static void TouchingBlock(int BlockType, Player player)
	{
		
		
		// For each loop to search a map for a specific block and check if our player is touching the block
		for (Integer i : Maps.GetBlock(Game.currentMap, BlockType)) 
		{

				int x = ((i - 1) % 32)*32;
				int y = ((i - 1) / 32)*32;
				float posX = Game.player.x;
				float posY = Game.player.y;
				// Create two rectangles one player position and one in the target blocks position 
			
				Rectangle r1 = new Rectangle((int)Game.player.x+16,(int)Game.player.y+16,(int)Player.playerHeight-32,(int)Player.playerWidth-32);
				Rectangle r2 = new Rectangle(x,y,32,32);
				// If they intersect at different positions affect them accordingly 
				if(r1.intersects(r2))
				{
					if(posX < x) Game.player.x = (float) (posX-0.5);
					if(posX > x) Game.player.x = (float) (posX+0.5);
					if(posY < y) Game.player.y = (float) (posY-0.5);
					if(posY > y) Game.player.y = (float) (posY+0.5);
				}
		}
	}
	// Function to check if enemy mob is touching a block and if they are move them away from it and don't let them go into it
	public static void TouchingBlock(int BlockType, Mob mob)
	{
		
		
		// For each loop to search a map for a specific block and check if our player is touching the block
		for (Integer i : Maps.GetBlock(Game.currentMap, BlockType)) 
		{

				int x = ((i - 1) % 32)*32;
				int y = ((i - 1) / 32)*32;
				float posX = mob.x;
				float posY = mob.y;
				// Create two rectangles one player position and one in the target blocks position 
				Rectangle r1 = new Rectangle((int)mob.x+16,(int)mob.y+16,32,32);
				Rectangle r2 = new Rectangle(x,y,32,32);
				// If they intersect at different positions affect them accordingly 
				if(r1.intersects(r2))
				{
					if(mob.movingDown == true)
					{
						mob.movingDown = false;
						mob.moving = false;
					}
					if(mob.movingUp == true)
					{
						mob.movingUp = false;
						mob.moving = false;
					}
					if(mob.movingLeft == true)
					{
						mob.movingLeft = false;
						mob.moving = false;
					}
					if(mob.movingRight == true)
					{
						mob.movingRight = false;
						mob.moving = false;
					}

					if(posX < x) mob.x = (float) (posX-0.5);
					if(posX > x) mob.x = (float) (posX+0.5);
					if(posY < y) mob.y = (float) (posY-0.5);
					if(posY > y) mob.y = (float) (posY+0.5);
				}
		}
	}

}
