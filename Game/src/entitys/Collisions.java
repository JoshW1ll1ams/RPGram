package entitys;

import java.util.ArrayList;

import Levels.Maps;
import main.Game;

public class Collisions {

	public static void update()
	{
		Game.player.CheckCollision();
		//System.out.println(Game.CurrentTile());
		
		
	}
	public static void TouchingBlock(int BlockType, Player player)
	{
		// For each loop to search a map for a specific block and check if our player is touching the block
		for (Integer i : Maps.GetBlock(Maps.map1, BlockType)) 
		{
			int x = ((i - 1) % 32)*32;
			int y = ((i - 1) / 32)*32;
			//System.out.println("Box x "+x+" Box Y "+y +" Player x"+Game.player.x+ " Player y"+Game.player.y);
			
			if(Game.player.x+16 < (x + 32) && ((Game.player.x+8) + 32) > x && Game.player.y+16 < (y + 32) && (32 + (Game.player.y+16)) > y)
			 {
				  if(player.x < x)
				  {
					  player.x -= 1;
				  }
				  if(player.x > x)
				  {
					  player.x += 1;
				  }
				  if(player.y < y)
				  {
					  player.y -= 1;
				  }
				  if(player.y > y)
				  {
					  player.y += 1;
				  }
			 }
		}
	}
}
