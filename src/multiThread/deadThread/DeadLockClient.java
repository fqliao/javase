package multiThread.deadThread;
/**
 * @decription:死锁
 * @version:1.0
 * @date: 2016年10月24日下午5:11:08
 * @author: lfq
 * 
 */
public class DeadLockClient {  
  
    public static void main(String args[])  
    {  
        Thread t1=new Thread(new Dead(true));  
        Thread t2=new Thread(new Dead(false));  
        t1.start();  
        t2.start();  
    }  
} 