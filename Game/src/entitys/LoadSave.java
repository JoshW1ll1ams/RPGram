package entitys;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	
	public static final String PlayerSprite = "/Assasin-Black.png"; 
	public static final String EnemySprite = "/tileset.png"; 
	public static final String LevelSprite = "/tileset.png"; 
	public static final String ItemSprite = "/item.png"; 
	
	// Function to take in an input stream and return a buffered image 
	public static BufferedImage GetSprite(String FileName)
	{
		BufferedImage img = null;
		// Target my image as an input stream
		InputStream Input = LoadSave.class.getResourceAsStream(FileName);
		
		// Try and catch for our image
		try 
		{
		img = ImageIO.read(Input); // Set our image to read the input stream
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return img;
	}
}
