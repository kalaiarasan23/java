package joinMethod;

public class JoinMethodExample {

	public static void main(String[] args) throws InterruptedException {
		// Anonimous inner class or lamda expressation
		Thread one = new Thread(() -> {
			for(int i=0 ; i < 5 ; i++) {
				System.out.println("Thread 1 : "+ i);
			} 
		});
		
		Thread two = new Thread(() -> {
			for(int i=0 ; i< 25 ; i++) {
				System.out.println("Thread 2 : "+ i);
			} 
		});
		
		two.start();
		one.start();
		two.join();
//		one.join();
		System.out.println("main thread over");
		
	}

}
