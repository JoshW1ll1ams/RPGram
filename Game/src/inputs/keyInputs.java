package inputs;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Levels.LevelManager; 
import Levels.Maps;
import entitys.Player;

import static actions.Constant.Directions.*;

import main.Panel;
// Implement key listener interface 
public class keyInputs implements KeyListener{
	
	// Import our panel from the panel class
	private Panel panel;
	// Create a constructor for our key inputs to change a value within the panel class
	public keyInputs(Panel panel)
	{
		this.panel = panel;
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W:
			panel.getGame().getPlayer().setUp(true); // Set moving up to true 
			break; 
		case KeyEvent.VK_A:
			panel.getGame().getPlayer().setLeft(true); // Set moving left to true 
			break; 
		case KeyEvent.VK_S:
			panel.getGame().getPlayer().setDown(true); // Set moving down to true 
			break; 
		case KeyEvent.VK_D:
			panel.getGame().getPlayer().setRight(true); // Set moving right to true 
			break; 
		case KeyEvent.VK_SHIFT:
			panel.getGame().getPlayer().setSpeed(1);
			break;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {

		switch(e.getKeyCode())
		{
		case KeyEvent.VK_W:
			panel.getGame().getPlayer().setUp(false); // Set moving up to false
			break; 
		case KeyEvent.VK_A:
			panel.getGame().getPlayer().setLeft(false); // Set moving left to false
			break; 
		case KeyEvent.VK_S:
			panel.getGame().getPlayer().setDown(false); // Set moving down to false
			break; 
		case KeyEvent.VK_D:
			panel.getGame().getPlayer().setRight(false); // Set moving right to false
			break; 
		case KeyEvent.VK_SHIFT:
			panel.getGame().getPlayer().setSpeed(0.5f);
			break;
		}
		
	}

}
