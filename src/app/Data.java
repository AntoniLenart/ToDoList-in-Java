package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.DefaultListModel;

public class Data 
{
	private String[] toDoList;
	private String[] finishedList;
	
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
	        // Save todo tasks.
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
} 

