package entitys;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import main.Game;

// Player class extends entity class
public class Player extends entity{

	public static int playerHeight;
	public static int playerWidth;
	
	private BufferedImage[][] animations;
	public Player(float x, float y, String type, float health, float damage) {
		super(x, y, type, health, damage);
		startAnimations();
	}
	
	public void update()
	{
		CheckAlive();
		updatePostition();
		updateAnimation();
	}
	public void render(Graphics g)
	{
		playerHeight = 64; 
		playerWidth= 64;
		// Use draw image on the target image to draw it to the screen
		// We then specify its position, in this case it will be my x and y delta
		// We then specify the width and height of the image with our variables 
		g.drawImage(animations[playerAction][animationCurrent], (int)x, (int)y, playerHeight, playerWidth, null);
	}

	private boolean leftMoving;
	private boolean upMoving;
	private boolean rightMoving;
	private boolean downMoving;
	boolean playerAttacking;

	

	 final static int idle = 1;
	 final static int left = 6;
	 final static int up = 4;
	 final static int right = 2;
	 final static int down = 0;

		public static int getSpriteAmount(int PlayerAction)
		{
			switch(PlayerAction)
			{
			case idle:
				return 2 + playerAttackingAdd;
			default:
				return 5 + playerAttackingAdd;
			}
		}
	private int playerAction = idle; 
	
	// This will keep track of how many frames have passed
	private int animationFrames;
	// This will keep track of currently displayed animation
	private int animationCurrent;
	// This will be how often the animation will update in frames
	private int animationSpeed = 20;
	
	// Function to update our animation continuously 
	private void updateAnimation() {

		animationFrames++; // Every frame this will increase by one 
		if(animationFrames >= animationSpeed) // We check for when the amount of frames is equal to our speed, this is the point we want to change the animation 
		{
			animationFrames = 0; // We reset the animation frames ready for the next loop
			animationCurrent++; // Increase the current animation, this will move up one in our array of images to the next image
			if(animationCurrent >= getSpriteAmount(playerAction)) // Here we check for when we get to the end of our image array using the length of each player action
			{												
				animationCurrent = 0; // If we do get to the end of the image array we set it back to 0 to restart the process
			}
		}
	}

		
	// Variable to keep track of if player is moving
	private boolean playerMoving = false;

	
	private float playerSpeed = 0.5f;
	public static int playerAttackingAdd;
	public static Boolean canMove = true;
	private void updatePostition() {
		
		playerMoving = false;
		playerAttackingAdd = 0;
		animationSpeed = 40;
		
		if(playerAttacking)
		{
			playerAttackingAdd = 3;  // Set player action animation to attacking if attacking is set to true
			animationSpeed = 20;
		}
		if(canMove)
		{
			if(leftMoving && !rightMoving && x > -20) // only move if player isn't -20 pixels out of game bounds
			{
				x -= playerSpeed;
				playerMoving = true;
				animationSpeed = 20;
				playerAction = left;
			}
			else if (rightMoving && !leftMoving && x < (Game.WindowWidth-40)) // check game window width to stop player leaving bounds
			{
				x += playerSpeed;
				playerMoving = true;
				animationSpeed = 20;
				playerAction = right;
			}
			
			if(upMoving && !downMoving && y > -15) // only move if player isn't -15 pixels out of game bounds
			{
				y -= playerSpeed;
				playerMoving = true;
				animationSpeed = 20;
				playerAction = up;
			}
			else if (downMoving && !upMoving && y < (Game.WindowHeight-45)) // check game window height to stop player leaving bounds
			{
				y += playerSpeed;
				playerMoving = true;
				animationSpeed = 20;
				playerAction = down;
			}
		}
	}
	private void startAnimations() 
	{
		BufferedImage img = LoadSave.GetSprite(LoadSave.PlayerSprite); // Call our get sprite class and pass in our player
		animations = new BufferedImage[8][8]; // I want to pull a total of 8 animations from my sprite sheet, each including 5 images
		
		for (int i =0; i <animations.length; i++) // Here we iterate through each animation 
		{
			for(int n =0; n <animations[i].length; n++) // Here we iterate through each animations sub images 
			{
				// Here we iterate though the image array each time going one sub image to the right 
				animations[i][n] = img.getSubimage(n*32, i*32, 32, 32);
			}
		}
	}

	// Function to reset movement if player clicks out of screen 
	public void resetMovement() {
		leftMoving = false;
		upMoving = false;
		rightMoving = false;
		downMoving = false;
		playerAttacking = false;
		
	}

	public void CheckCollision()
	{
		Collisions.TouchingBlock(0, this); // Call our touching block and pass in the block type we want to make sure we collide with 
	}
	
	Boolean dead = false;

	public void CheckAlive()
	{
		if(this.health <= 0 && dead==false)
		{
			dead = true;
			Game.questions.setVisible(true);	
			this.canMove = false;
		}
	}
	
	// Getters and setters for the movement 
	public void setAttack(boolean attacking) {
		this.playerAttacking = attacking;
	}
	
	
	public boolean isLeft() {
		return leftMoving;
	}

	public void setLeft(boolean left) {
		this.leftMoving = left;
	}

	public boolean isUp() {
		return upMoving;
	}

	public void setUp(boolean up) {
		this.upMoving = up;
	}

	public boolean isRight() {
		return rightMoving;
	}

	public void setRight(boolean right) {
		this.rightMoving = right;
	}

	public boolean isDown() {
		return downMoving;
	}

	public void setDown(boolean down) {
		this.downMoving = down;
	}




	
}
