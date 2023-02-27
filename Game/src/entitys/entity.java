package entitys;

import main.Game;

// This class will be base class for the player and enemies, we will make is abstract so only objects of subclasses can be made
public abstract class entity {
	protected float x;
	protected float y;
	public entity(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

}


