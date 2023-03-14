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

import Levels.Maps;
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
		
		// Create a button for each level and pass in the corresponding map
		menuButton level1 = new menuButton("Level 1",200,50,400,25,"#d9c389","Level",Maps.level1);
		menuButton level2 = new menuButton("Level 2",200,50,400,100,"#d9c389","Level",Maps.level2);
		menuButton level3 = new menuButton("Level 3",200,50,400,175,"#d9c389","Level",Maps.level1);
		menuButton level4 = new menuButton("Level 4",200,50,400,250,"#d9c389","Level",Maps.level1);
		menuButton level5 = new menuButton("Level 5",200,50,400,325,"#d9c389","Level",Maps.level1);
		menuButton level6 = new menuButton("Level 6",200,50,400,400,"#d9c389","Level",Maps.level1);
		menuButton exitGame = new menuButton("Exit Game",200,30,400,465,"#f1350d","Exit",Maps.levelnull);
		menupanel.add(level1);
		menupanel.add(level2);
		menupanel.add(level3);
		menupanel.add(level4);
		menupanel.add(level5);
		menupanel.add(level6);
		menupanel.add(exitGame);
		// Here I import my background image for the main menu 
		BufferedImage img = LoadSave.GetSprite(LoadSave.Background);
        JLabel imageIcon = new JLabel(new ImageIcon(img));
        imageIcon.setSize(Game.WindowWidth,Game.WindowHeight);
        imageIcon.setLocation(0, 0);
        menupanel.add(imageIcon);
		
		
	}
	

	 
	

}
