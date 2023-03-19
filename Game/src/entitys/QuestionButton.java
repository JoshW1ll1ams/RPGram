package entitys;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
        	}
        	else
        	{
        		System.out.println("Incorrect");
        	}
        }
    }
}
