package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import main.Panel;

public class mouseInputs implements MouseListener, MouseMotionListener {

	// Import our panel from the panel class
	private Panel panel;

	// Create a constructor for our key inputs to change a value within the panel class
	public mouseInputs(Panel panel)
	{
		this.panel = panel;
	}

	@Override
	public void mouseDragged(MouseEvent e) {

		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Here we call our panel set position method and alter it based on our mouses X and Y 
		//panel.setPos(e.getX(),e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		panel.getGame().getPlayer().setAttack(true); // Set player attacking to true if mouse is pressed down 
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		panel.getGame().getPlayer().setAttack(false); // Set player attacking to false once mouse is released
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}

}
