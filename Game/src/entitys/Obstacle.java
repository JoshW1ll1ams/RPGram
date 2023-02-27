package entitys;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Obstacle extends entity{
	
	
	public Obstacle(float x, float y, String type) {
		super(x, y, type);
		startAnimations();
	}
	
		BufferedImage animation;

		
		public void update()
		{
		//  updatePostition();
		//	updateAnimation();
		}
		
		public void render(Graphics g)
		{
			startAnimations();
			int imageHeight = 64; 
			int imageWidth = 64;
			g.drawImage(animation, (int)x, (int)y, imageHeight, imageWidth, null);
		}

		private void startAnimations() 
		{
			BufferedImage img = LoadSave.GetSprite(LoadSave.EnemySprite); // Call our get sprite class and pass in our player
			animation = img.getSubimage(32, 32, 32, 32);
		}
}
