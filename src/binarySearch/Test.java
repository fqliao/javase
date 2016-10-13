package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @decription:列表的二分查找，对链表，也可以使用，只是自动转为线性查找，而不是二分查找，因为对链表二分查找效率更低
 * @version:1.0
 * @date: 2016年10月13日下午9:02:17
 * @author: lfq
 * 
 */
public class Test {

	public static void main(String[] args) {
		
		//初始化一个列表
		List<Integer> list = new ArrayList<>(Arrays.asList(1,3,2,5,4));
		System.out.println(list);
		
		//先对列表排序
		Collections.sort(list);
		System.out.println(list);
		
		//查找指定元素，找到>=0,否则<0 具体返回值可以用于将查找元素按顺序插入到列表中
		int element = 4;//分半测试 4，6 
		int index = Collections.binarySearch(list, element);
		if(index >= 0)
		{
			System.out.println("找到元素");
			list.add(index+1,element);
		}
		if(index < 0)
		{
			System.out.println("没有找到元素");
			list.add(-index-1,element);
		}
		System.out.println(list);
	}

	
}
