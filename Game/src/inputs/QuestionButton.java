package inputs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import entitys.popUp;
import main.Game;
import main.mainClass;

public class QuestionButton extends JButton implements ActionListener{
	
	String text;
	String function;
	String questionNum;

    public QuestionButton(String text, int POSX, int POSY, String questionNum) {
        
    	this.questionNum = questionNum;
    	this.text = text;
        this.addActionListener(this);
        this.setSize(450, 50);
        this.setText(text);
        this.setLocation(POSX, POSY);
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(null);
        this.setFocusPainted(false);
        this.setVisible(true);

    }
    // This function will handle the event of the button been clicked 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this) {
        	if(this.questionNum == QuestionScreen.correctAwnser)
        	{
        		Game.questions.setVisible(false);	
        		
        		if(QuestionScreen.CurrentQuestionNum == 8)
        		{
        			QuestionScreen.CurrentQuestionNum = 0;
        		}
        		else
        		{
        			QuestionScreen.CurrentQuestionNum +=1;  
        		}
        		
        		QuestionScreen.GenerateQuestion();
    			Game.player.dead = false;
    			Game.player.canMove = true;	
    			Game.player.health = 500;
    			Game.GamePanel.requestFocus();
    			popUp Correct = new popUp("Correct, Health set to 500",Color.green,1);
        	}
        	
        	else
        	{
        		Game.questions.setVisible(false);	
        		
        		if(QuestionScreen.CurrentQuestionNum == 8)
        		{
        			QuestionScreen.CurrentQuestionNum = 0;
        		}
        		else
        		{
        			QuestionScreen.CurrentQuestionNum +=1;  
        		}
        		
        		QuestionScreen.GenerateQuestion();
    			Game.player.dead = false;
    			Game.player.canMove = true;
    			Game.player.health = 200;
    			Game.GamePanel.requestFocus();
    			popUp inCorrect = new popUp("Incorrect, Health set to 200",Color.red,1);
        	}
       
        }
    }
}
