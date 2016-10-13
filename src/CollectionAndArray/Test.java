package CollectionAndArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 * @decription:求两个整型数组的交集
 * 技术：
 * 1 数组与集合的互转
 * 2 集合的求交集
 * 3 自动装箱和拆箱
 * 4 集合泛型参数的考虑
 * @version:1.0
 * @date: 2016年10月13日下午3:54:35
 * @author: lfq
 * 
 */
public class Test {

	public static void main(String[] args) {
		//两个整型数组
		int[] a = {1,2,3,5,8,9};
		int[] b = {2,3,4,9};
		int[] result = intersection(a,b);
		System.out.println(Arrays.toString(result));
	}

	private static int[] intersection(int[] a,int[] b) {
		
		//将int数组转为Set集合
		Set<Integer> aSet = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			aSet.add(a[i]);
		}
		Set<Integer> bSet = new HashSet<>();
		for (int i = 0; i < b.length; i++) {
			bSet.add(b[i]);
		}
		
		//创建保持交集的集合
		HashSet<Integer> result = new HashSet<>(aSet);
		
		//求aSet与bSet的集合 交集保存在result集合中 返回结果是aSet是否真包含bSet，真包含返回true，否则false
		result.retainAll(bSet);
				
		//将交集集合转为Integer数组保存
		Integer[] resultInteger = result.toArray(new Integer[result.size()]);
		
		//将Integer数组转为int[]数组保存
		int[] resultInt = new int[resultInteger.length];
		for (int i = 0; i < resultInt.length; i++) 
		{
			resultInt[i] = resultInteger[i];
		}
		
		return resultInt;
		
	}
	
}
