package app;

import java.io.File;
import windowBuilder.views.*;

public class Main 
{
	public static void main(String[] args) 
	{
		//Create DataStorage directory, when running application first time.
		if (!new File("./DataStorage").exists())
		{
			new File("./DataStorage").mkdirs();
		}
		
		//Run app.
		LoginGUI frame = new LoginGUI();
		frame.setVisible(true);
	}
}
