package app;

public class Task 
{
	private String name;
	private boolean finished;
	
	public Task(String name)
	{
		this.name = name;
		finished = false;
	}
	
	public String getName() 
	{
		return this.name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public boolean getFinished() 
	{
		return this.finished;
	}
	
	public void setFinished(boolean finished) 
	{
		this.finished = finished;
	}
}
