package priorityQueue;

import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * PriorityQueue与TreeSet不同
 * 迭代不是按照排序顺序访问
 * 删除却是删掉剩余元素中优先级数最小的那个元素
 * @author lfq
 *
 */
public class Test {

	public static void main(String[] args) {
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<>();
		pq.add(new GregorianCalendar(1960,Calendar.DECEMBER,9));
		pq.add(new GregorianCalendar(1815,Calendar.DECEMBER,10));
		pq.add(new GregorianCalendar(1903,Calendar.DECEMBER,3));
		pq.add(new GregorianCalendar(1910,Calendar.JULY,22));
		
//		System.out.println("Iterating over elements...");
//		for(GregorianCalendar date : pq)
//		{
//			System.out.println(date.get(Calendar.YEAR));
//		}
//		
//		System.out.println("Removing elements...");
//		while(!pq.isEmpty())
//		{
//			System.out.println(pq.remove().get(Calendar.YEAR));
//		}
		PriorityQueue<GregorianCalendar> sortedByDay = new PriorityQueue<>(
				new Comparator<GregorianCalendar>() 
				{

					@Override
					public int compare(GregorianCalendar a,
							GregorianCalendar b) {
						return a.get(Calendar.DAY_OF_MONTH)-b.get(Calendar.DAY_OF_MONTH);
					}
					
				}
				);
		sortedByDay.addAll(pq);
		while(!sortedByDay.isEmpty())
		{
			System.out.println(sortedByDay.remove().get(Calendar.DAY_OF_MONTH));
		}
	}

}
