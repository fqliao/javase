package bitSet;

import java.util.BitSet;

/**
 * @decription:素性筛法，利用位集
 * @version:1.0
 * @date: 2016年10月14日下午10:39:43
 * @author: lfq
 * 
 */
public class Test {

	public static void main(String[] args) {
		int n = 12;
		//创建位集
		BitSet b = new BitSet(n+1);
		int count = 0;
		int i;
		//初始化位集
		for(i = 2; i <= n; i++)
			b.set(i);
		i = 2;
		//素性筛法：只用筛sqrt(n)的作为起点的数
		while(i*i <= n)
		{
			if(b.get(i))
			{
				count++;//一部分起点素数
				int k = 2*i;
				while(k <= n)
				{
					b.clear(k);
					k += i;
				}
			}
			i++;
		}

		while(i <= n)
		{
			if(b.get(i)) count++;//筛出的一部分素数
			i++;
		}
		
		System.out.println("2-"+n+"之间的素数个数："+count);
		
	}

	
}
