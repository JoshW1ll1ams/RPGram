package inputs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import Levels.Maps;
import entitys.Player;
import main.Game;

import main.mainClass;
import main.mainMenu;

public class menuButton extends JButton implements ActionListener {

	String function;
	int MobNum;
    public menuButton(String text,int sizeX,int sizeY, int POSX,int POSY, String color, String function, int MobNum) {
     

        this.addActionListener(this);
        this.setSize(sizeX, sizeY);
        this.setText(text);
        this.setLocation(POSX, POSY);
        this.setBackground(Color.decode(color));
        this.setBorder(null);
        this.setFocusPainted(false);
        this.function = function;
        this.setVisible(true);
        this.MobNum = MobNum;

    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
        	if(this.function == "Level")
        	{
        		Game.player.health = 500;
        		Game.player.resetMovement();
        		mainClass.menu.setVisible(false);
        		Game.GameWindow.setVisible(true);
        		Game.GamePanel.setVisible(true);
        		// Remove all menu items when user clicks level button  
        		Maps.mobs(this.MobNum);
        		Game.initialiseMobs();
        		Game.GameWindow.requestFocus();
        		Game.GamePanel.requestFocus();
        	}
        	if(this.function == "Exit")
        	{
        		System.exit(0);	
        	}
        	if(this.function == "Menu")
        	{
        		Game.GameWindow.setVisible(false);
        		Game.currentMobs.clear();
        		mainClass.menu.setVisible(true);
        		
        	}
          
        }
    }

}