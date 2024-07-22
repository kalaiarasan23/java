package ex5_WaitAndNotify;

public class Ex1_WaitAndNotify {
	
	private static final Object lock =new Object();
	
	public static void main(String[] args) {
		Thread one = new Thread(
				() -> {
					try {
						one();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("print thread one");
				}
				);
		
//		Thread two = new Thread(
//				() -> {
//					try {
//						System.out.println("two thread is initiate");
//						Two();
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					System.out.println("print thread two");
//				}
//				);
		
		one.start();
//		two.start();
		
		
	}
	
	private static void one() throws InterruptedException
	{
		synchronized (lock) {
			System.out.println("hello from method one ....");
		    lock.wait();
		    System.out.println("one method ends...");
		}
	}
	private static void Two() throws InterruptedException
	{
		synchronized (lock) {
			System.out.println("hello from method two ....");
			lock.notify();
			System.out.println("two method ends...");
		}
	}

}
