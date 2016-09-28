package proxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class Client {

	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		for (int i = 0; i < elements.length; i++) {
			Integer value = i+1;
			TraceHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
			elements[i] = proxy;
		}
		Integer key = new Random().nextInt(elements.length)+1;
		//寻找key
		int result = Arrays.binarySearch(elements, key);
		if(result >=0){
			System.out.println(elements[result]);
		}

	}

}
