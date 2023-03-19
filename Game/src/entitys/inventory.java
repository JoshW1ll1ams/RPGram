package entitys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class inventory extends JPanel {
	GridLayout grid = new GridLayout(6,3);
	

	static ArrayList<item> inv = new ArrayList<item>();
	
	// Create a constructor for the inventory 
	public inventory()
	{
		startAnimations();
		this.setBackground(Color.GRAY);
		this.setLocation(400, 40);
		this.setSize(200, 400);
		this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		grid.setHgap(5); // set horizontal gap to 10 pixels
		grid.setVgap(5); // set vertical gap to 10 pixels
		this.setLayout(grid); 
		//Slots();
		this.setVisible(false);
	}
	
	
	
	// Here we have variables and functions to loop though my items image sprite to pick out 3 loot types
	static BufferedImage[][] InventoryIcons;
	static BufferedImage redLoot;
	static BufferedImage blueLoot;
	static BufferedImage greenLoot;
	private void startAnimations() 
	{
		BufferedImage img = LoadSave.GetSprite(LoadSave.ItemSprite); // Call our get sprite class and pass in our player
		InventoryIcons = new BufferedImage[8][16]; // I want to pull a total of 8 animations from my sprite sheet, each including 5 images
		
		for (int i =0; i <InventoryIcons.length; i++) // Here we iterate through each animation 
		{
			for(int n =0; n <InventoryIcons[i].length; n++) // Here we iterate through each animations sub images 
			{
				// Here we iterate though the image array each time going one sub image to the right 
				InventoryIcons[i][n] = img.getSubimage(n*16, i*16, 16, 16);
			}
		}
		redLoot = InventoryIcons[0][4];
		greenLoot = InventoryIcons[0][9];
		blueLoot = InventoryIcons[0][12];
	}
	
	public void update()
	{
		Slots();
	}
	

	
	// Create the 18 slots to hold items and propagate them with icons if the player has them in the inventory
	public void Slots() {
	    this.removeAll();
	    for(int i = 0; i < 18; i++) {
	        JPanel slot = new JPanel();
	        slot.setBackground(Color.BLACK);

	        BufferedImage lootColor = null;
	        if(inv.size() > i) 
	        {
	        	
	        	// Set the loot colour to the relevant colour type
	        	if(inv.get(i).name.equals("Red Gem")) lootColor = redLoot;
	        	if(inv.get(i).name.equals("Green Gem")) lootColor = greenLoot;
	        	if(inv.get(i).name.equals("Blue Gem")) lootColor = blueLoot;
	        	
	        	// Create new label that is the string of the amount of the item we have
	        	JLabel label = new JLabel(String.valueOf(inv.get(i).amount));
	        	label.setForeground(Color.WHITE); 
	        	
	        	
	        	// Create new image from our buffered image
	            Image newimg = lootColor.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
	            JLabel imageIcon = new JLabel(new ImageIcon(newimg));
	            
	            GridBagLayout gridBagLayout = new GridBagLayout();
	            slot.setLayout(gridBagLayout);

	            // Set constraints for the image icon label 
	            GridBagConstraints imageConstraints = new GridBagConstraints();
	            imageConstraints.gridx = 0;
	            imageConstraints.gridy = 0;
	            slot.add(imageIcon, imageConstraints);

	            // Set constraints for the amount label
	            GridBagConstraints labelConstraints = new GridBagConstraints();
	            labelConstraints.gridx = 0;
	            labelConstraints.gridy = 1;
	            slot.add(label, labelConstraints);
	        }
	        this.add(slot);
	    }
	}

	
	
	
	
	
	public static void render(Graphics g)
	{

	}
}



