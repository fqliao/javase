package javaBean;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;


public class Employee extends Person{
	
	private Date hireDay;
	private double salary;
	
	public Employee(String name)
	{
		super(name);
		this.salary = 0.0;
		this.hireDay = new Date();
	}
	public Employee(String name,double salary,int year,int month,int day) {
		super(name);
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year,month-1,day);
		this.hireDay = calendar.getTime();
	}
	
	public Date getHireDay()
	{
		return this.hireDay;
	}
	
	public double getSalary()
	{
		return this.salary;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent /100;
		salary += raise;
	}
	
	public boolean equals(Object otherObject)
	{
		if(this == otherObject) return true;
		if(otherObject == null) return false;
		if(this.getClass() != otherObject.getClass()) return false;
		Employee other = (Employee)otherObject;
		return Objects.equals(this.name, other.name) && this.salary == other.salary
				&& Objects.equals(this.hireDay, other.hireDay);
	}
	
	public int hashCode()
	{
		return Objects.hash(this.name,this.salary,this.hireDay);
	}
	
	public String toString()
	{
		return "[name="+this.name+", salary="+this.salary+"]";
	}
	
	@Override
	public String getDescription() {
		return String.format("The employee with a salary of $%.2f", this.salary);
	}
	
}
