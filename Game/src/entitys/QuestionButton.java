package entitys;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.Game;
import main.mainClass;

public class QuestionButton extends JButton implements ActionListener{
	
	String text;
	String function;
	String questionNUm;

    public QuestionButton(String text, int POSX, int POSY, String questionNUm) {
        
    	this.questionNUm = questionNUm;
    	this.text = text;
        this.addActionListener(this);
        this.setSize(450, 50);
        this.setText(text);
        this.setLocation(POSX, POSY);
        this.setBackground(Color.RED);
        this.setBorder(null);
        this.setFocusPainted(false);
        this.setVisible(true);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
        	if(this.questionNUm == QuestionScreen.correctAwnser)
        	{
        		System.out.println("Correct");
    			Game.player.dead = false;
    			Game.player.canMove = true;
    			Game.questions.setVisible(false);	
    			Game.player.health = 500;
    			Game.GamePanel.requestFocus();
    			popUp Correct = new popUp("Correct, Health set to 500",Color.green,1);
        	}
        	else
        	{
        		System.out.println("Correct");
    			Game.player.dead = false;
    			Game.player.canMove = true;
    			Game.questions.setVisible(false);	
    			Game.player.health = 200;
    			Game.GamePanel.requestFocus();
    			popUp inCorrect = new popUp("Incorrect, Health set to 200",Color.red,1);
        	}
       
        }
    }
}
