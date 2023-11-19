package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.DefaultListModel;


/**
 * The Data class manages the saving and loading of tasks for the application.
 * It saves tasks to and loads tasks from text files.
 */

public class Data 
{
	private String[] toDoList;
	private String[] finishedList;
	
	//This method saves tasks to config files (todo_save and finished_save.txt). 
	
	/**
     * Saves tasks to configuration files for ToDo and Finished lists.
     *
     * @param toDoModel     DefaultListModel representing tasks in the ToDo list.
     * @param finishedModel DefaultListModel representing tasks in the Finished list.
     * @param username      The username to create separate task files for different users.
     */
	
	public void saveTasks(DefaultListModel<String> toDoModel, DefaultListModel<String> finishedModel, String username) 
	{
	    toDoList = new String[toDoModel.getSize()];
	    finishedList = new String[finishedModel.getSize()];

	    for (int i = 0; i < toDoModel.getSize(); i++) 
	    {
	        toDoList[i] = toDoModel.elementAt(i);
	    }

	    for (int i = 0; i < finishedModel.getSize(); i++) 
	    {
	        finishedList[i] = finishedModel.elementAt(i);
	    }

	    try 
	    {
	        // Save to-do tasks.
	        FileWriter writerToDo = new FileWriter(new File("./DataStorage/todo_save_" + username + ".txt"));
	        BufferedWriter bufferedWriterToDo = new BufferedWriter(writerToDo);
	        
	        for (String task : toDoList) 
	        {
	            bufferedWriterToDo.write(task);
	            bufferedWriterToDo.newLine(); 
	        }
	        bufferedWriterToDo.close();

	        // Save finished tasks.
	        FileWriter writerFinished = new FileWriter(new File("./DataStorage/finished_save_" + username + ".txt"));
	        BufferedWriter bufferedWriterFinished = new BufferedWriter(writerFinished);
	        
	        for (String task : finishedList) 
	        {
	            bufferedWriterFinished.write(task);
	            bufferedWriterFinished.newLine(); 
	        }
	        bufferedWriterFinished.close();
	    } 
	    catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	}
	
	//This method loads tasks using scanner and returns array of length 2
	//with toDoModel([0]) and finishedModel([1])
	
    /**
     * Loads tasks from saved text files and returns them as DefaultListModel arrays.
     *
     * @param username The username to load tasks specific to that user.
     * @return An array containing DefaultListModel for ToDo and Finished tasks.
     */
	
	@SuppressWarnings("unchecked")
	public DefaultListModel<String>[] loadTasks(String username)
	{
		DefaultListModel<String> toDoListModel = new DefaultListModel<>();
        DefaultListModel<String> finishedListModel = new DefaultListModel<>();
        
		Scanner scanner;
		try {
			scanner = new Scanner(new File("./DataStorage/todo_save_" + username + ".txt"));

			int index = 0;
			while (scanner.hasNextLine())
				{
					toDoListModel.add(index, scanner.nextLine());
					index++;
				}	
			scanner.close();
			
			scanner = new Scanner(new File("./DataStorage/finished_save_" + username + ".txt"));
			index = 0;
			while (scanner.hasNextLine())
				{
					finishedListModel.add(index, scanner.nextLine());
					index++;
				}	
			scanner.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		@SuppressWarnings("rawtypes")
		DefaultListModel[] array = {toDoListModel, finishedListModel};	
		return array;
	}
} 

