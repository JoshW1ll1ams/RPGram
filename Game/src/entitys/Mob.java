package entitys;



import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import main.Game;

public class Mob extends entity{
	
		private BufferedImage[] enemySprite;
		private String LootType;
		
		public Mob(float x, float y, String type, float health, float damage, String LootType) 
		{
			super(x, y, type, health, damage);
			this.LootType = LootType;
			startAnimations();
		}
	
		BufferedImage animation;
		public void update() 
		{
			updatePostition();
		}
		
		public double speed = 0.3;
		int direction = 0;
		int distance = 0;
		Boolean moving = false;
		Boolean movingDown = false;
		Boolean movingUp = false;
		Boolean movingLeft = false;
		Boolean movingRight = false;
		
		private void updatePostition() {
	
			if(!moving)
			{
				Random rn = new Random();
				direction = 0 + rn.nextInt(3 - 0 + 1);
				distance = 0 + rn.nextInt(400 - 0 + 1);
				moving = true;
			}
			
			
			if(direction == 0)
			{
				movingDown = true;
			}
			if(direction == 1)
			{
				movingUp = true;
			}
			if(direction == 2)
			{
				movingLeft = true;
			}
			if(direction == 3)
			{
				movingRight = true;
			}
	

			
			// If mob hits the right edge
			if(this.x >= (Game.WindowWidth -32) - distance && movingRight)
			{
				movingRight = false;
				moving = false;
			}
			// If the mob hits the left edge 
			if(this.x <= 0 + distance && movingLeft)
			{
				movingLeft = false;
				moving = false;
			}
			// If mob hits the bottom edge
			if(this.y >= (Game.WindowHeight -32) - distance && movingDown)
			{
				movingDown = false;
				moving = false;
			}
			// If the mob hits the top edge 
			if(this.y <= 0 + distance && movingUp)
			{
				movingUp = false;
				moving = false;
			}
			
			
			if(movingDown)
			{
				this.y += speed;
			}
			if(movingUp)
			{
				this.y -= speed;
			}
			if(movingRight)
			{
				this.x += speed;
			}
			if(movingLeft)
			{
				this.x -= speed;
			}
		}

		
		
		Boolean dead = false;
		public boolean AliveCheck()
		{

			if(this.health <= 0)
			{
				if(dead == false)
				{
					 AddLoot();
				dead = true;
				}
				
				return false;
			}
			else
			{
				return true;
			}
		}
		
		public void AddLoot()
		{
			if(inventory.inv.size() <= 0)
			{
				inventory.inv.add(new item(LootType,1));
				return;
			}
			else
			{
				for(int i=0;i < inventory.inv.size();i++)
				{
					if(inventory.inv.get(i).name == this.LootType)
					{
						inventory.inv.get(i).amount +=1;
						return;
					}
				}
				inventory.inv.add(new item(LootType,1));
			}
		}
		
		public void render(Graphics g)
		{
			updateAnimation();

			int imageHeight = 64; 
			int imageWidth = 64;
			if(AliveCheck() == true) // Only render enemy if alive
			{
				g.drawImage(enemySprite[120+animationCurrent], (int)x, (int)y, 32, 32, null);
			}	
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
