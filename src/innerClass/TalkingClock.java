package innerClass;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;

/**
 * 语音时钟：不用内部类和采用4种内部类实现
 * 内部类：仅有内部类可以私有
 * @author lfq
 *
 */
public class TalkingClock{
	private int interval;//时间间隔
	private static boolean beep;//开关
	

	/**
	 * 初始化时钟，间隔，开关都为参数
	 * @param interval
	 * @param beep
	 */
	public TalkingClock(int interval,boolean beep){
		this.interval = interval;
		this.beep = beep;
	}
	
	//1 不用内部类
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		Date now = new Date();
//		System.out.println("at the tone,the time is "+now);
//		if(beep){//内部类直接访问类的私有数据
//			Toolkit.getDefaultToolkit().beep();
//		}
//		
//	}
	
	//2 一般内部类
	class TimePrinter implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Date now = new Date();
			System.out.println("at the tone,the time is "+now);
			if(TalkingClock.this.beep){//内部类直接访问类的私有数据
				Toolkit.getDefaultToolkit().beep();
			}
			
		}	
	}
	
//	/**
//	 * 3 静态内部类
//	 * @author lfq
//	 *
//	 */
//	 public static class  TimePrinter implements ActionListener{
//		
//		public void actionPerformed(ActionEvent e){
//			Date now = new Date();
//			System.out.println("at the tone,the time is "+now);
//			if(beep){//内部类直接访问类的静态私有数据
//				Toolkit.getDefaultToolkit().beep();
//			}
//			
//		}
//	}
	
	public void start(){
		
		//4 局部内部类
//		class TimePrinter implements ActionListener{
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Date now = new Date();
//				System.out.println("at the tone,the time is "+now);
//				if(TalkingClock.this.beep){//内部类直接访问类的私有数据
//					Toolkit.getDefaultToolkit().beep();
//				}
//				
//			}	
//		}
		
		//5 匿名内部类 实现了接口的新对象
//		ActionListener listener = new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Date now = new Date();
//				System.out.println("At the tone,the time is "+now);
//				if(beep){
//					Toolkit.getDefaultToolkit().beep();
//				}	
//			}
//			
//		};//分号不能少
		
		ActionListener listener = new TimePrinter();
		Timer timer = new Timer(interval, listener);
//		Timer timer = new Timer(interval, this);
		timer.start();
	}	
	
}
