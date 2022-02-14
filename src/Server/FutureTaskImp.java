package Server;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskImp {

	private static final FutureTask<Integer> future = new FutureTask<Integer>(new Callable<Integer>() {
		@Override
		public Integer call() throws Exception {
			
			Thread.sleep(1000);
			System.out.println("≤Ù!!!");
			return 10000;
			}
	});
	
	public static void main(String[] args){
		System.out.println("Ω√¿€");
		//System.out.println(future.get());
		System.out.println("≥°");
	}
	
	
}
