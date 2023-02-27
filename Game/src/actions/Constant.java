package actions;
import static entitys.Player.*;
public class Constant {
	public static class Directions
	{
		// These are all the indexes of which section of the sprite sheet to use for each movement type
		public static final int idle = 1;
		public static final int left = 6;
		public static final int up = 4;
		public static final int right = 2;
		public static final int down = 0;

		
		
		
		public static int getSpriteAmount(int PlayerAction)
		{
			switch(PlayerAction)
			{
			case left:
				return 5 + playerAttackingAdd; // If player is attacking this number will be added to extend the range of the animation to invlove the attacking sprites
			case up:
				return 5 + playerAttackingAdd;
			case right:
				return 5 + playerAttackingAdd;
			case down:
				return 5 + playerAttackingAdd;
			case idle:
				return 2 + playerAttackingAdd;
			default:
				return 5;
			}
		}
	}
	

}
