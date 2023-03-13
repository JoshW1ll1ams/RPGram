package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import Levels.Maps;
import main.Game;

public class Collisions {
	public static Rectangle r1 = new Rectangle();
	public static void update()
	{
		Game.player.CheckCollision();
		
		
		//System.out.println(Game.CurrentTile());
		
		for(int i =0; i < Game.currentMobs.size(); i++)
		{
			CheckEnemy(Game.currentMobs.get(i), Game.player);
		}
		
	}
	static Rectangle entity1 = new Rectangle();
	static Rectangle entity2 = new Rectangle();
	
	public static void CheckEnemy(Mob mob, Player player)
	{

		entity1 = new Rectangle((int)player.x+16,(int)player.y+16,player.playerHeight-32,player.playerWidth-32);
		entity2 = new Rectangle((int)mob.x, (int)mob.y,32,32);
		// If player contacts a mob entity and is attacking do damage 
		if(entity1.intersects(entity2) && player.playerAttacking)
		{
			mob.health -= player.damage;
		}
	}
	public static void TouchingBlock(int BlockType, Player player)
	{
		
		
		// For each loop to search a map for a specific block and check if our player is touching the block
		for (Integer i : Maps.GetBlock(Maps.map12, BlockType)) 
		{

				int x = ((i - 1) % 32)*32;
				int y = ((i - 1) / 32)*32;
				float posX = Game.player.x;
				float posY = Game.player.y;
				// Create two rectangles one player position and one in the target blocks position 
				r1 = new Rectangle((int)Game.player.x+16,(int)Game.player.y+16,(int)Game.player.playerHeight-32,(int)Game.player.playerWidth-32);
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

}
