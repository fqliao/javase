package HashtableAndVector;

import java.util.*;
import java.util.Map.Entry;

/**
 * @decription:
 * HashMap和Hashtable都实现了Map接口，但决定用哪一个之前先要弄清楚它们之间的分别。
 * 主要的区别有：线程安全性，同步(synchronization)，以及速度。
 * 如果对同步性或与遗留代码的兼容性没有任何要求，则使用HashMap
 * 需要完全的线程安全的时候使用Hashtable，而如果你使用Java 5或以上的话，使用ConcurrentHashMap
 * @version:1.0
 * @date: 2016年10月14日上午11:14:25
 * @author: lfq
 * 
 */
public class HashtableTest {

	public static void main(String[] args) {
		//将Hashtable换为HashMap测试
//		Map<Integer, String> hashtable = new Hashtable<>();
		
		//子类只是调用覆盖父类的方法，用多态最好，若是要调用子类特有的方法，父类没有，那么多态就用不上
		//Hashtable的枚举访问接口是Hashtable特有的，Map接口中没有，因此要用枚举访问，就不能用多态
		Hashtable<Integer, String> hashtable = new Hashtable<>();
		
		hashtable.put(1, "a");
		hashtable.put(2, "b");
		hashtable.put(3, "c");
		hashtable.put(4, "e");
		hashtable.put(5, "f");
		
		System.out.println(hashtable);
		hashtable.remove(3);
		hashtable.replace(2, "d");
		System.out.println(hashtable);
		System.out.println(hashtable.get(2));
		
		//1 通过entrySet访问
		System.out.println("-------------");
		Set<Entry<Integer, String>> entrySet = hashtable.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.println("key="+entry.getKey()+" value="+entry.getValue());
		}
		//2 通过get方法访问
		System.out.println("-------------");
		Set<Integer> keySet = hashtable.keySet();
		for (Integer key : keySet) {
			System.out.println("key="+key+" value="+hashtable.get(key));
		}
		//3 通过Iterator访问
		System.out.println("-------------");
		Iterator<Integer> iterator = keySet.iterator();
		while(iterator.hasNext())
		{
			Integer key = iterator.next();//注意不能连续调用，先保存key的一个变量中
			System.out.println("key="+key+" value="+hashtable.get(key));
		}
		
		//4 以上三种都访问方式与HashMap相同，枚举访问方式是Hashtable旧的访问方式，特有的，HashMap中没有
		System.out.println("-------------");
		Enumeration<Integer> keys = hashtable.keys();
		while(keys.hasMoreElements())
		{
			Integer key = keys.nextElement();
			System.out.println("key="+key+" value="+hashtable.get(key));
		}
		Enumeration<String> values = hashtable.elements();
		while (values.hasMoreElements()) 
		{
			String value =  values.nextElement();
			System.out.print(value+" ");
			
		}
		
		
		
	}

}
