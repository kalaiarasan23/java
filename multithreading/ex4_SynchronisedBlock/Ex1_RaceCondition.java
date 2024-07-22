package ex4_SynchronisedBlock;

public class Ex1_RaceCondition {
	private static int count =0;
	
	public static void main(String[] args) {
		Thread one = new Thread( 
				() -> {
					for(int i=0;i<10000;i++)
						count++;
				}
			);
		Thread two = new Thread( 
				() -> {
					for(int i=0;i<10000;i++)
						count++;
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
		System.out.println("the value od count is "+count);
		
	}
		
}
