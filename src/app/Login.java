package app;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;	

//This class contains procedure of logging in with credentials provided in credentials.txt file.
//It includes method to change username and password.

public class Login 
{

    private String username;
    private String password;

    public boolean run(String inputUsername, String inputPassword) 
    {
        try 
        {
            Scanner scan = new Scanner(new File("src/credentials.txt"));

            username = scan.nextLine();
            password = scan.nextLine();
            scan.close();
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        }
        
        if (inputUsername.equals(username) && inputPassword.equals(password)) 
        {
            return true;
        } 
        else 
        {
            return false;
        }
    }
    
    public void setUsername(String newUsername) 
    {
    	this.username = newUsername;
    	updateCredentials();
    }
    
    public void setPassword(String newPassword) 
    {
    	this.password = newPassword;
    	updateCredentials();
    }
    
    private void updateCredentials() 
    {
    	try 
    	{
			FileWriter writer = new FileWriter("src/credentials.txt");
			writer.write(username + "\n" + password);
			writer.close();
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}
    }
}





