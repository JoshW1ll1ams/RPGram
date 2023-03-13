package inputs;




import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entitys.inventory;
import main.Game;
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

	// Variable to hold weather inventory is on screen
	Boolean inventoryOnScreen = false;
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
		case KeyEvent.VK_I:
			// If I pressed and inventory on screen set it to invisible 
			if(inventoryOnScreen == true)
			{
				Game.playerInv.setVisible(false);
				inventoryOnScreen = false;
			}
			// If I pressed and inventory not on screen set it to visible 
			else
			{
				Game.playerInv.setVisible(true);
				Game.playerInv.update();
				inventoryOnScreen = true;
			}
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
		}
		
	}

}
