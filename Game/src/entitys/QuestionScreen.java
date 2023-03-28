package entitys;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import inputs.menuButton;

public class QuestionScreen extends JPanel{
	
	String questionString;
	String awnser1String;
	String awnser2String;
	String awnser3String;
	String awnser4String;
	static String correctAwnser;
	

	
	// Here we use a JLabel to display the question, we utilise its in built HTML formatting so if the question is larger than panel width it goes to a new line
	
	
	
	
	public QuestionScreen()
	{
		GenerateQuestion();
		JLabel question = new JLabel("<html><p>"+questionString+"</p></html>");
		QuestionButton questionAButton = new QuestionButton("<html><p>"+awnser1String+"</p></html>",20,100,"A");
		QuestionButton questionBButton = new QuestionButton("<html><p>"+awnser2String+"</p></html>",20,175,"B");
		QuestionButton questionCButton = new QuestionButton("<html><p>"+awnser3String+"</p></html>",20,250,"C");
		QuestionButton questionDButton = new QuestionButton("<html><p>"+awnser4String+"</p></html>",20,325,"D");
		
		question.setLocation(20,-150);
		question.setSize(450,400);
		question.setFont(new Font("Arial Black", Font.PLAIN, 20));
		this.add(question);
		
		this.add(questionAButton);
		this.add(questionBButton);
		this.add(questionCButton);
		this.add(questionDButton);
		
		
		
		this.setBackground(Color.GRAY);
		this.setLocation(250, 40);
		this.setSize(500, 400);
		this.setLayout(null); 
		this.setVisible(false);
	}
	

	
	String[][] questions = {
		    {"What is the main feature of Java programming language?","A. High-performance execution","B. Dynamic typing","C. Platform independence","D. Optional semicolons","C"},
		    {"What is the correct way to declare a variable in Java?","A. var x = 5;","B. int x = 5;","C. float x = 5.0;","D. boolean x = true;","B"},
		    {"What is the difference between a class and an object in Java?","A. A class is a blueprint for an object, while an object is an instance of a class.","B. A class is a specific type of object, while an object is a collection of classes.","C. A class is a collection of objects, while an object is a blueprint for a class.","D. There is no difference between a class and an object.","A"},
		    {"Which Java keyword is used to create a new instance of a class?","A. new","B. create","C. instantiate","D. construct","A"},
		    {"Which Java access modifier allows a variable or method to be accessed only within its own class?","A. private","B. protected","C. public","D. default","A"},
		    {"What is the correct syntax for a for loop in Java?","A. for (int i = 0; i < 10; i++) { }","B. for (i = 0; i < 10; i++) { }","C. for (int i < 10; i++) { }","D. for (int i = 0; i < 10; )","A"},
		    {"What is the output of the following Java code? int x = 5; System.out.println(x++);","A. 5","B. 6","C. Compiler error","D. Runtime error","A"},
		    {"What is the purpose of the Java keyword static?","A. It is used to define a class that cannot be instantiated.","B. It is used to define a variable or method that belongs to the class itself, rather than to instances of the class.","C. It is used to define a method that can be overridden by a subclass.","D. It is used to define a variable or method that can be accessed from outside the class.","B"},
		    {"What is the difference between a checked and an unchecked exception in Java?","A. A checked exception is a type of exception that must be caught or declared in the method signature, while an unchecked exception is not.","B. An unchecked exception is a type of exception that must be caught or declared in the method signature, while a checked exception is not.","C. A checked exception is a type of exception that can be thrown from any method, while an unchecked exception can only be thrown from the main method.","D. There is no difference between a checked and an unchecked exception in Java.","A"}
		};

	int QuestionNum = 0;
	String [] Currentquestion = questions[QuestionNum];
	
	public void GenerateQuestion() 
	{
		questionString = Currentquestion[0];
		awnser1String = Currentquestion[1];
		awnser2String = Currentquestion[2];
		awnser3String = Currentquestion[3];
		awnser4String = Currentquestion[4];
		correctAwnser = Currentquestion[5];
	}

}
