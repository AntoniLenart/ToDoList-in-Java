package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.DefaultListModel;

public class Data 
{
	private String[] toDoList;
	private String[] finishedList;
	
	//This method saves tasks to config files (todo_save and finished_save.txt). 
	public void saveTasks(DefaultListModel<String> toDoModel, DefaultListModel<String> finishedModel) 
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
	        FileWriter writerToDo = new FileWriter("src/DataStorage/todo_save.txt");
	        BufferedWriter bufferedWriterToDo = new BufferedWriter(writerToDo);
	        
	        for (String task : toDoList) 
	        {
	            bufferedWriterToDo.write(task);
	            bufferedWriterToDo.newLine(); 
	        }
	        bufferedWriterToDo.close();

	        // Save finished tasks.
	        FileWriter writerFinished = new FileWriter("src/DataStorage/finished_save.txt");
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
	@SuppressWarnings("unchecked")
	public DefaultListModel<String>[] loadTasks(String Username)
	{
		DefaultListModel<String> toDoListModel = new DefaultListModel<>();
        DefaultListModel<String> finishedListModel = new DefaultListModel<>();
        
		Scanner scanner;
		try {
			scanner = new Scanner(new File("src/DataStorage/todo_save.txt"));

			int index = 0;
			while (scanner.hasNextLine())
				{
					toDoListModel.add(index, scanner.nextLine());
					index++;
				}	
			scanner.close();
			
			scanner = new Scanner(new File("src/DataStorage/finished_save.txt"));
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

