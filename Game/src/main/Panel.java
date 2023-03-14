package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

import Levels.Maps;
import entitys.inventory;
import inputs.keyInputs;
import inputs.menuButton;
import inputs.mouseInputs;

//Create class called panel and make it extend JPanel
public class Panel extends JPanel{
	
	// Create mouse input object so we can use the same object for both the mouse listener and motion listener
	private mouseInputs mouse;

	private Game game;

	public Panel(Game game)
	{

		menuButton mainMenuButton = new menuButton("Main menu",100,20,5,5,"#f1350d","Menu",Maps.levelnull);
		this.setLayout(null); 
		this.add(mainMenuButton);
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
	
	

	// This is automatically called every frame
	public void paintComponent(Graphics g)
	{
		// Calls super class of JPanel(JComponent)
		// Ensures the paint method of superclass is done before we add more images
		super.paintComponent(g);
		game.render(g);
		
	}

	// Create a getter for my game object as this class is where it was initialised 
	public Game getGame()
	{
		return game;
	}


	
	
	
}