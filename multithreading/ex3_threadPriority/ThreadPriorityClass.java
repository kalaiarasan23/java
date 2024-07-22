package ex3_threadPriority;

public class ThreadPriorityClass {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		// norm_priority
		System.out.println(Thread.currentThread().getPriority());
//		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		System.out.println(Thread.currentThread().getPriority());
		
		Thread one = new Thread(
				() -> { System.out.println("Thread one is printed"); }
		);
		
		one.setPriority(Thread.MIN_PRIORITY);
		one.start();
		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.currentThread().getPriority());
	}
}
