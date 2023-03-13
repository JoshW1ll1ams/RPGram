package inputs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import main.Game;
import main.mainClass;
import main.mainMenu;

public class menuButton extends JButton implements ActionListener {

	String function;

    public menuButton(String text,int sizeX,int sizeY, int POSX,int POSY, String color, String function) {
     
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

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
        	if(this.function == "Start")
        	{
        		mainClass.menu.removeAll();
        		Game game = new Game();
        		System.out.println("Hello");
        	}
        	if(this.function == "Exit")
        	{
        		System.exit(0);
        	}
          
        }
    }

}