package entitys;

import main.Game;

public class Collisions {

	public static void update()
	{
		Game.player.CheckCollision(Game.obstacle);
	}
}
