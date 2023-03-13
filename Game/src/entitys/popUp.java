package entitys;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import main.Game;

public class popUp extends JLabel{
	String item;
	String color;
	public popUp(String item,String color)
	{
		this.item  = item;
		this.color = color;
		this.setText(item+ " added to inventory");
		this.setForeground(Color.decode(color));
		this.setFont(new Font("Arial Black", Font.PLAIN, 20));
		this.setLocation(330, 350);
		this.setSize(600,200);
		Game.GamePanel.add(this);
		// Call our timer function and pass in our popUp
		Timer(this);
	}
	
	
	public void Timer(popUp pop)
	{
		  Timer timer = new Timer();
		    
		    TimerTask task = new TimerTask()
		    {
				@Override
				// This is the code that will run once our task is complete
				public void run() {
					// After 3 seconds set label to invisible
					pop.setVisible(false);
					//pop.remove(pop);
					
				}
		    	
		    };
		    // This links the timer and the timer task, and triggers the run after 3 seconds
			timer.schedule(task,3000);
				
	}
}
