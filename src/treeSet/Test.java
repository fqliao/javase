package treeSet;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {

	public static void main(String[] args) {
		//默认数据的排序
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("Toaster",1234));
		parts.add(new Item("Widget",4562));
		parts.add(new Item("Modem",9912));
		System.out.println(parts);
		
		//创建新排序规则
		SortedSet<Item> sortedByDes = new TreeSet<>(
				new Comparator<Item>(){

					@Override
					public int compare(Item a, Item b) {
						String aDes = a.getDescription();
						String bDes = b.getDescription();
						return aDes.compareTo(bDes);
					}
					
				}
				);
		sortedByDes.addAll(parts);
		System.out.println(sortedByDes);
	}
	
}
