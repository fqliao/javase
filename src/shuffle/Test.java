package shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @decription:The program demonstrates the random shuffle and sort algorithms.
 * @version:1.0
 * @date: 2016年10月13日下午8:10:32
 * @author: lfq
 * 
 */
public class Test {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i <= 49; i++) {
			numbers.add(i);
		}
		//打乱元素顺序
		Collections.shuffle(numbers);
		//获取前五个元素
		List<Integer> subList = numbers.subList(0, 6);
		//对取出的元素排序,加入reverseOrder()参数是降序
		Collections.sort(subList,Collections.reverseOrder());
		
		System.out.println(subList);
		
	}

}
