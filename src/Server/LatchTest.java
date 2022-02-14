package Server;

public class LatchTest {

	public static void main(String[] args) throws InterruptedException {
		LatchImpl latch = new LatchImpl();
		long result = latch.timeTasks(5, new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName()+" is the Thread Name for current");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		System.out.println(result);
	}
}
