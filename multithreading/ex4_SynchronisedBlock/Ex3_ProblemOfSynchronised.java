package ex4_SynchronisedBlock;

public class Ex3_ProblemOfSynchronised {
private static int count1 =0;
private static int count2 =0;
	
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
		
		// here the count value is 18000 some thing
		// but we need 20000
		System.out.println("the value of count1 is "+count1);
		System.out.println("the value of count2 is "+count2);
	}
	
	private synchronized static void increment1() {
		count1++;
	}
	
	private synchronized static void increment2() {
		count2++;
	}
}
