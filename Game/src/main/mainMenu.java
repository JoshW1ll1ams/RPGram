package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

import inputs.mouseInputs;

public class mainMenu extends JFrame{
	private Game game;
	private mouseInputs mouse;
	
	JPanel menupanel = new JPanel();
	
	public mainMenu()
	{			
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);

		setPanelSize();	
		menupanel.setLayout(null);
		this.add(menupanel);
		this.pack();
		this.setVisible(true);
	}
	
	// Function to set the sizing of our game panel
	private void setPanelSize()
	{
		// Here we set the dimensions of our JPanel 
		Dimension size = new Dimension(Game.WindowWidth,Game.WindowHeight); // Here we use our games width and height we calculate using the tiles on the x and y axis
		menupanel.setPreferredSize(size);
		menupanel.setBackground(Color.darkGray);
	}
	
}
