package inputs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Levels.Maps;
import main.Game;
import main.mainClass;
import main.mainMenu;

public class menuButton extends JButton implements ActionListener {

	String function;
	int[] map;
    public menuButton(String text,int sizeX,int sizeY, int POSX,int POSY, String color, String function, int[] map) {
     
    	this.map = map;
        this.addActionListener(this);
        this.setSize(sizeX, sizeY);
        this.setText(text);
        this.setLocation(POSX, POSY);
        this.setBackground(Color.decode(color));
        this.setBorder(null);
        this.setFocusPainted(false);
        this.function = function;
        this.setVisible(true);

    }
    Game game;
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
        	if(this.function == "Level")
        	{
        		game = null;
        		// Remove all menu items when user clicks level button
        		mainClass.menu.dispose();
        		// Create new instance of a game and pass in the correct map
        		game = new Game(this.map);
        		
        	}
        	if(this.function == "Exit")
        	{
        		System.exit(0);	
        	}
        	if(this.function == "Menu")
        	{
        		mainClass.menu = new mainMenu();
        		Game.GameWindow.dispose();
        		
        	}
          
        }
    }

}