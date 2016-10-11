package map;

import java.util.HashMap;
import java.util.Map;

import javaBean.Employee;

public class Test {

	public static void main(String[] args) {
		Map<String,Employee> staff = new HashMap<>();
		staff.put("1", new Employee("A"));
		staff.put("2", new Employee("B"));
		staff.put("3", new Employee("C"));
		staff.put("4", new Employee("D"));
		
		System.out.println(staff);
		
		staff.remove("4");
		
		staff.replace("3", new Employee("E"));
		
		System.out.println(staff.get("2"));
		
		for (Map.Entry<String, Employee> entry: staff.entrySet()) 
		{
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("key="+key+", value="+value);
		}
		
	}

}
