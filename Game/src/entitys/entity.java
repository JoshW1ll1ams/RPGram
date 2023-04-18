package entitys;

import main.Game;

// This class will be base class for the player and enemies, we will make is abstract so only objects of subclasses can be made
public abstract class entity {
	// X and Y float will be the entity x and y position on the screen 
	public float x;
	public float y;
	// Health will be the amount of health points the entity has
	public float health;
	// Damage will be the amount of damage the entity does to other entity's 
	public double damage;
	protected String type;
	// w and h will be the height and width of entity's 
	protected float w = 32;
	protected float h = 32;
	public entity(float x, float y, String type, float health, double damage)
	{
		this.x = x;
		this.y = y;
		this.type = type;
		this.health = health;
		this.damage = damage;
	}

}


