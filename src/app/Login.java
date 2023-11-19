package app;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;	

/**
 * The Login class manages user authentication and account-related functionalities.
 * It includes methods for logging in, creating an account, and changing username/password.
 */

public class Login 
{
    private String username;
    private String password;
    
    // Default tasks to be created when a new account is registered.
    private String[] DEFAULTTASKS = {"Eat", "Sleep", "Code"};

    /**
     * Authenticates the user with provided username and password.
     *
     * @param inputUsername The username input by the user for authentication.
     * @param inputPassword The password input by the user for authentication.
     * @return True if the provided credentials match, False otherwise.
     */
    
    public boolean run(String inputUsername, String inputPassword) 
    {
        try 
        {
            Scanner scan = new Scanner(new File("./DataStorage/credentials_" + inputUsername + ".txt"));

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
    

    /**
     * Creates a new account with provided username and password.
     * Initializes the account with default tasks.
     *
     * @param username The username for the new account.
     * @param password The password for the new account.
     */
    public void createAccount(String username, String password)
    {
		try 
		{
			FileWriter writerCredentials = new FileWriter(new File("./DataStorage/credentials_" + username + ".txt"));
			writerCredentials.write(username + "\n" + password);
			writerCredentials.close();
			
			FileWriter writerToDo = new FileWriter(new File("./DataStorage/todo_save_" + username + ".txt"));
			for (String task : DEFAULTTASKS)
			{
				writerToDo.write(task + "\n");
			}
			writerToDo.close();
			
			FileWriter writerFinished = new FileWriter(new File("./DataStorage/finished_save_" + username + ".txt"));
			writerFinished.write("Create account");
			writerFinished.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
    }
    
    /**
     * Changes the username and updates credentials in the credentials file.
     *
     * @param newUsername The new username to set.
     */
    
    public void setUsername(String newUsername) 
    {
    	this.username = newUsername;
    	updateCredentials();
    }
    
    public String getUsername() 
    {
    	return this.username;
    }
    
    /**
     * Changes the password and updates credentials in the credentials file.
     *
     * @param newPassword The new password to set.
     */
    public void setPassword(String newPassword) 
    {
    	this.password = newPassword;
    	updateCredentials();
    }
    
    public String getPassword()
    {
    	return this.password;
    }
    
    /**
     * Updates credentials stored in the credentials file.
     */
    private void updateCredentials() 
    {
    	try 
    	{
			FileWriter writer = new FileWriter(new File("./DataStorage/credentials_" + username + ".txt"));
			writer.write(username + "\n" + password);
			writer.close();
		} 
    	catch (IOException e) 
    	{
			e.printStackTrace();
		}
    }
}





