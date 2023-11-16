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
    
    private String[] DEFAULTTASKS = {"Eat", "Sleep", "Code"};

    public boolean run(String inputUsername, String inputPassword) 
    {
        try 
        {
            Scanner scan = new Scanner(new File("src/DataStorage/credentials_" + inputUsername + ".txt"));

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
    
    //Create account method. Create default task list.
    public void createAccount(String username, String password)
    {
		try 
		{
			FileWriter writerCredentials = new FileWriter(new File("src/DataStorage/credentials_" + username + ".txt"));
			writerCredentials.write(username + "\n" + password);
			writerCredentials.close();
			
			FileWriter writerToDo = new FileWriter(new File("src/DataStorage/todo_save_" + username + ".txt"));
			for (String task : DEFAULTTASKS)
			{
				writerToDo.write(task + "\n");
			}
			writerToDo.close();
			
			FileWriter writerFinished = new FileWriter(new File("src/DataStorage/finished_save_" + username + ".txt"));
			writerFinished.write("Create account");
			writerFinished.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    }
    
    //Username methods.
    public void setUsername(String newUsername) 
    {
    	this.username = newUsername;
    	updateCredentials();
    }
    
    public String getUsername() 
    {
    	return this.username;
    }
    
    //Password methods.
    public void setPassword(String newPassword) 
    {
    	this.password = newPassword;
    	updateCredentials();
    }
    
    public String getPassword()
    {
    	return this.password;
    }
    
    //This method overwrites credentials stored in credentials.txt file.
    private void updateCredentials() 
    {
    	try 
    	{
			FileWriter writer = new FileWriter(new File("src/DataStorage/credentials_" + username + ".txt"));
			writer.write(username + "\n" + password);
			writer.close();
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}
    }
}





