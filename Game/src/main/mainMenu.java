package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entitys.LoadSave;
import inputs.menuButton;
import inputs.mouseInputs;

public class mainMenu extends JFrame{
	private Game game;
	private mouseInputs mouse;
	
	JPanel menupanel = new JPanel();
	
	public mainMenu()
	{			

		
		
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);

		createPanel();	
		
		this.add(menupanel);
		

		this.pack();
		this.setVisible(true);
	}
	
	// Function to set the sizing of our game panel
	private void createPanel()
	{
		// Here we set the dimensions of our JPanel 
		Dimension size = new Dimension(Game.WindowWidth,Game.WindowHeight); // Here we use our games width and height we calculate using the tiles on the x and y axis
		menupanel.setPreferredSize(size);
		menupanel.setBackground(Color.darkGray);
		menupanel.setLayout(null);
		
		
		menuButton startGame = new menuButton("Start Game",200,50,400,150,"#d9c389","Start");
		menuButton exitGame = new menuButton("Exit Game",200,50,400,250,"#d9c389","Exit");
		menupanel.add(startGame);
		menupanel.add(exitGame);
		// Here I import my background image for the main menu 
		BufferedImage img = LoadSave.GetSprite(LoadSave.Background);
        JLabel imageIcon = new JLabel(new ImageIcon(img));
        imageIcon.setSize(Game.WindowWidth,Game.WindowHeight);
        imageIcon.setLocation(0, 0);
        menupanel.add(imageIcon);
		
		
	}
	

	 
	

}
