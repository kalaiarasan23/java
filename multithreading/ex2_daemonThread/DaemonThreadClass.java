package daemonThread;

public class DaemonThreadClass {

	public static void main(String[] args) {
		
		Thread daemonThread = new Thread(new DaemonHelper());
		Thread userThread = new Thread(new UserThreadhelper());
		daemonThread.setDaemon(true); 
		
		daemonThread.start();
		userThread.start();
	}
}

	class DaemonHelper implements Runnable {
		@Override
		public void run() {
			int count =0;
			while(count < 500) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count++;
				System.out.println("Deamon Thread running ");
			}
		}
	}
	
	class UserThreadhelper implements Runnable {
		@Override
		public void run() {
			int c=0;
			while(c<2){
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("user add "+c);
				c++;
			}
				System.out.println("User Thread running ");
		}
	}
