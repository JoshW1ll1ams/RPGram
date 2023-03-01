package main;
import static actions.Constant.Directions.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.keyInputs;
import inputs.mouseInputs;

//Create class called panel and make it extend JPanel
public class Panel extends JPanel{
	
	// Create mouse input object so we can use the same object for both the mouse listener and motion listener
	private mouseInputs mouse;

	private Game game;
	
	public Panel(Game game)
	{
		// Initialise our mouse listener class and call the panel constructor in the listener class
		mouse = new mouseInputs(this);
		this.game = game;
		// Add a key listener from keyInputs class and call the panel constructor in the listener class
		addKeyListener(new keyInputs(this));	
		// Add mouse listener from mouse input class, checks for clicked, pressed and released
		addMouseListener(mouse);	
		// Add mouse motion listener from mouse input class, checks for moved and drag
		addMouseMotionListener(mouse);	
		// Call our set panel size function
		setPanelSize();

	}
	// Function to set the sizing of our game panel
	private void setPanelSize()
	{
		// Here we set the dimensions of our JPanel 
		Dimension size = new Dimension(Game.WindowWidth,Game.WindowHeight); // Here we use our games width and height we calculate using the tiles on the x and y axis
		setPreferredSize(size);
		setBackground(Color.darkGray);
	}
	
	
	// Function to update the game, anything to do with logic will be called in this function
	public void UpdateGame() {
	}
	
	// This is automatically called every frame
	public void paintComponent(Graphics g)
	{
		// Calls super class of JPanel(JComponent)
		// Ensures the paint method of superclass is done before we add more images
		super.paintComponent(g);
		game.render(g);
		
		   g.setColor(new Color(255, 255, 255, 80));
		   g.fillRect((int)Game.player.x+16,(int)Game.player.y+16,(int)Game.player.playerHeight-32,(int)Game.player.playerWidth-32);
	}

	// Create a getter for my game object as this class is where it was initialised 
	public Game getGame()
	{
		return game;
	}


	
	
	
}