package multiThread.synchronizedThread;

public class SaleThread implements Runnable{
	private int saleNums;//买票数量
	
	public SaleThread(int saleNums) {
		super();
		this.saleNums = saleNums;
	}

	@Override
	public void run() {
		SaleTicket.sale(saleNums);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
