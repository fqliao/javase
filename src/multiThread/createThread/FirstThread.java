package multiThread.createThread;

/**
 * @decription:
 * 1 显示创建2个线程，加上主线程，共有3个线程
 * 2 主线程不是由run方法确定的，而是有main方法确定的-main方法体代码主线程的线程执行体
 * 3 Thread.currentThread():Thread的静态方法，返回当前正在执行的线程对象
 *   setName(String),getName():设置和获得线程的名字,默认主线程的名字为main,用户启动的线程名依次为Thread-0,Thread-1...
 * 4 因为程序每次创建线程对象时都要创建FirstThread对象，因此Thread-0和Thread-1不能共享类的数据
 *   可知使用继承Thread类的方法创建线程类，多个线程之间无法共享线程类的数据
 * @version:1.0
 * @date: 2016年10月18日下午2:59:19
 * @author: lfq
 * 
 */
public class FirstThread extends Thread{
	
	private int i = 0;
	//不会要求必须重写，但重写run方法可以开启一个顺序流程单元，线程
	@Override
	public void run() {
		for (; i < 100; i++) {
			//当继承线程类，只用直接调用线程类的方法，如getName,获得线程的名字
			System.out.println(getName()+" "+i);
		}
	}
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) 
		{
			//由于main方法是static方法，因此不能使用this方法，即当前实例方法
			//可以调用Thread的静态方法currentThread获得当前线程
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i == 20)
			{	
				//创建两个线程并启动
				new FirstThread().start();
				new FirstThread().start();
			}
		}

	}
	
}
