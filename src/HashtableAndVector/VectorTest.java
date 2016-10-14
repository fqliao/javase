package HashtableAndVector;

import java.util.*;

/**
 * @decription:ArrayList与Vector用法的异同
 * @version:1.0
 * @date: 2016年10月14日上午10:55:58
 * @author: lfq
 * 
 */
public class VectorTest {

	public static void main(String[] args) {
		//换为ArrayList测试 1，2，3一样
//		List<Integer> vector = new ArrayList<>();
		Vector<Integer> vector = new Vector<>();
		vector.addAll(Arrays.asList(1,2,3));
		System.out.println(vector);
		
		//1 get方法访问，随机访问
		System.out.println("-------------");
		for (int i = 0; i < vector.size(); i++) 
		{
			System.out.print(vector.get(i)+" ");
		}
		
		//2 iterator访问
		System.out.println("\n-------------");
		Iterator<Integer> iterator = vector.iterator();
		while(iterator.hasNext())
		{
			System.out.print(iterator.next()+" ");
		}
		
		//3 以上访问方式与ArrayList一样，枚举方式访问是Vector旧的访问方式，不是List接口的
		System.out.println("\n-------------");
		Enumeration<Integer> elements = vector.elements();
		while(elements.hasMoreElements())
		{
			System.out.print(elements.nextElement()+" ");
		}
	}

}
