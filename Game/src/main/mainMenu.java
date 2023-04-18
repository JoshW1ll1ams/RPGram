package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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
	
	static menuButton level1;
	static menuButton level2;
	static menuButton level3;
	static menuButton level4;
	static menuButton level5;
	static menuButton level6;
	
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
		level1 = new menuButton("Level 1",200,50,400,25,"#d9c389","Level",1);
		level2 = new menuButton("Level 2",200,50,400,100,"#d9c389","Level",2);
		level3 = new menuButton("Level 3",200,50,400,175,"#d9c389","Level",3);
		level4 = new menuButton("Level 4",200,50,400,250,"#d9c389","Level",4);
		level5 = new menuButton("Level 5",200,50,400,325,"#d9c389","Level",5);
		level6 = new menuButton("Level 6",200,50,400,400,"#d9c389","Level",6);
		level2.setEnabled(false);
		level3.setEnabled(false);
		level4.setEnabled(false);
		level5.setEnabled(false);
		level6.setEnabled(false);
		
		menuButton exitGame = new menuButton("Exit Game",200,30,400,465,"#f1350d","Exit",-1);
		menupanel.add(level1);
		menupanel.add(level2);
		menupanel.add(level3);
		menupanel.add(level4);
		menupanel.add(level5);
		menupanel.add(level6);
		menupanel.add(exitGame);
		

		BufferedImage instructionsImg = LoadSave.GetSprite(LoadSave.Unlock);
        JLabel instructionsImgIcon = new JLabel(new ImageIcon(instructionsImg));
        instructionsImgIcon.setSize(350,202);
        instructionsImgIcon.setLocation(20, 100);
        menupanel.add(instructionsImgIcon);

		// Here I import my background image for the main menu 
		BufferedImage backGroundImg = LoadSave.GetSprite(LoadSave.Background);
        JLabel backGroundImgIcon = new JLabel(new ImageIcon(backGroundImg));
        backGroundImgIcon.setSize(Game.WindowWidth,Game.WindowHeight);
        backGroundImgIcon.setLocation(0, 0);
        menupanel.add(backGroundImgIcon);
        
	}
	


}
