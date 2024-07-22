package ex4_SynchronisedBlock;

public class Ex4_SolutionBySynchronizedBlock {
private static int count1 =0;
private static int count2 =0;
private static final Object lock1 =new Object();	
private static final Object lock2 =new Object();

	public static void main(String[] args) {
		Thread one = new Thread( 
				() -> {
					for(int i=0;i<10000;i++)
						increment1();
				}
			);
		Thread two = new Thread( 
				() -> {
					for(int i=0;i<10000;i++)
						increment2();
				}
			);
		one.start();
		two.start();
		
		try {
			one.join();
			two.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("the value of count1 is "+count1);
		System.out.println("the value of count2 is "+count2);
	}
	
	private  static void increment1() {
		synchronized(lock1)
		{
			count1++;
		}
	}
	
	private synchronized static void increment2() {
		synchronized(lock2)
		{
			count2++;
		}
	}
}
