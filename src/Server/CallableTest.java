package Server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newFixedThreadPool(100);
		List<Future<Integer>> list = new ArrayList<>();
		
		Callable<Integer> test = new Callable<Integer>() {

	
			@Override
			public Integer call(){

				try {
					System.out.println(Thread.currentThread().getName()+" is current Thread");
					Thread.sleep(1000);
				}catch(InterruptedException e) {
					
				}
				return 1000;
			}
		};
		
		for(int i=0; i<5; i++) {
			System.out.println("hi");
			list.add(executor.submit(test));
		}
		
		int result = list.stream().map(a->{
			try {
				return a.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return 0;
		}).reduce((old,newVal)->old+newVal).get();

		System.out.println(result);
		
		executor.shutdown();
		System.out.println("³¡");
	}
}
