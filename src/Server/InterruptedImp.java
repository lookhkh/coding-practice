package Server;

public class InterruptedImp {

	static class TestInterruption implements Runnable{
		
		private volatile boolean interrupted;
		
		public TestInterruption() {
			this.interrupted = false;
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void run() {
			
			while(!Thread.currentThread().isInterrupted()) {
				try {
					Thread.sleep(100);
					System.out.println("진행중");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("interrupted ");

		}
		
		public synchronized void interruptFlag() {
			System.out.println("hi 플래그 체인지");
			this.interrupted = !this.interrupted;
		}
	}
	
	public static void main(String[] args){
		TestInterruption test = new TestInterruption();
		Thread te = new Thread(test);
		
		te.start();
		try {
		Thread.sleep(1000);
		System.out.println("hi");
		}catch(InterruptedException e) {
			System.out.println("bye");
			te.interrupt();
		}finally {
			te.interrupt();
		}
		
	}
}
