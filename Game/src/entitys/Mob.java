package entitys;

import static actions.Constant.Directions.getSpriteAmount;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Mob extends entity{
	
	private BufferedImage[] enemySprite;
	public Mob(float x, float y, String type, float health, float damage) {
		super(x, y, type, health, damage);
		startAnimations();
	}
	
		BufferedImage animation;

		
		public void update()
		{
		//  updatePostition();
		//	updateAnimation();
		}
		
		public boolean AliveCheck()
		{
			if(this.health <= 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
	
		public void render(Graphics g)
		{
			updateAnimation();
			int imageHeight = 64; 
			int imageWidth = 64;
			g.drawImage(enemySprite[120+animationCurrent], (int)x, (int)y, 32, 32, null);
		
		}
		
		private void startAnimations() 
		{
			BufferedImage img = LoadSave.GetSprite(LoadSave.LevelSprite); // Here we load our level sprite from our Load Save that converts the input stream to buffered image 
			enemySprite = new BufferedImage[1025];
			int counter = 0;
			for(int i=0; i < 32; i++) // The top loop is for the length of the y axis on the sprite sheet
			{
				for(int j=0; j < 32; j++) // This loop is for the x axis of the sprite sheet
				{
					counter++;
					enemySprite[counter] = img.getSubimage(j*16, i*16, 16, 16);
				}
			}
		}
		
		// This will keep track of how many frames have passed
		private int animationFrames;
		// This will keep track of currently displayed animation
		private int animationCurrent;
		// This will be how often the animation will update in frames
		private int animationSpeed = 20;
		
		private void updateAnimation() {
			
			animationFrames++; // Every frame this will increase by one 
			if(animationFrames >= animationSpeed) // We check for when the amount of frames is equal to our speed, this is the point we want to change the animation 
			{
				animationFrames = 0; // We reset the animation frames ready for the next loop
				animationCurrent++; // Increase the current animation, this will move up one in our array of images to the next image
				if(animationCurrent >= 8) // Here we check for when we get to the end of our image array using the length of each player action
				{												
					animationCurrent = 0; // If we do get to the end of the image array we set it back to 0 to restart the process
				}
			}
		}
}
