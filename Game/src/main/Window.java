package main;


import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

// Create class called window and make it extend JFrame
public class Window extends JFrame{
	

	public  Window(Panel panel)
	{
		//frame = new JFrame();
		// Set the window to exit program on close
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		// Stop the window been resized
		this.setResizable(false);
		// Add our game panel to our game window
		this.add(panel);
		// Tell the JFrame to pack its contents inside, in this case it will be our game panel
		this.pack();
		// Set the window to visible last to avoid visual errors
		this.setVisible(true);
		// Add window focus listener to account for user exiting the game window 
		this.addWindowFocusListener(new WindowFocusListener() {

			@Override
			public void windowGainedFocus(WindowEvent e) {
				
			}

			@Override
			public void windowLostFocus(WindowEvent e) {
				panel.getGame().focusLost();

			}

		});
	}
}
