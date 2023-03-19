package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
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
	private keyInputs key;

	private Game game;
	JLabel playerHealth = new JLabel();
	public Panel(Game game)
	{

		menuButton mainMenuButton = new menuButton("Main menu",100,20,5,5,"#f1350d","Menu",-1);
		
		playerHealth.setLocation(350,0);
		playerHealth.setSize(350,50);
		playerHealth.setFont(new Font("Arial", Font.PLAIN, 35));
		playerHealth.setForeground(Color.WHITE);
		playerHealth.setVisible(true);
		

        
		this.setLayout(null);
		this.add(playerHealth);
		this.add(mainMenuButton);
		this.requestFocusInWindow();
		// Initialise our mouse listener class and call the panel constructor in the listener class
		mouse = new mouseInputs(this);
		key = new keyInputs(this);
		this.game = game;
		// Add a key listener from keyInputs class and call the panel constructor in the listener class
		addKeyListener(key);	
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
		// Set text of player health to current player health and convert the health from float to a double with math ceiling of 1
		playerHealth.setText("Player Health: "+Double.toString(Math.ceil(Game.player.health / 1)));
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