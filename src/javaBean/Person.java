package javaBean;

public abstract class Person {
	protected String name;
	
	public Person(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public abstract String getDescription();
	
}
