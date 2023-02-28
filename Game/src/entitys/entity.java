package entitys;

import main.Game;

// This class will be base class for the player and enemies, we will make is abstract so only objects of subclasses can be made
public abstract class entity {
	public float x;
	public float y;
	protected String type;
	protected float w = 32;
	protected float h = 32;
	public entity(float x, float y, String type)
	{
		this.x = x;
		this.y = y;
		this.type = type;
	}

}


