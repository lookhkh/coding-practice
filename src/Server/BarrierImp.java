package Server;

import java.util.concurrent.CyclicBarrier;

public class BarrierImp {

	private final CyclicBarrier barrier;
	private final int[][] board;
	private final Worker[] workers;
	
	public BarrierImp(int[][] board) {
		
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		System.out.println(availableProcessors+" is avaliable processors");
		
		this.board = board;
		this.barrier = new CyclicBarrier(availableProcessors);
		
		this.workers = new Worker[availableProcessors];
		
		for(int i=0; i< availableProcessors; i++) {
			System.out.println(i+"번째 스레드");
			workers[i] = new Worker(this.board, i, this.barrier);
		}
	}
	
	public void start() {
		for(int i=0; i<workers.length; i++) {
			new Thread(workers[i]).start();
		}
	}
	
	static class Worker implements Runnable{
		private final int[][] board;
		private final int num;
		private final CyclicBarrier barrier;
		
		public Worker(int[][] board, int num, CyclicBarrier barrier) {
			this.board = board;
			this.num = num;
			this.barrier = barrier;
		}
		
		@Override
		public void run() {
			int cnt = Runtime.getRuntime().availableProcessors();
			int maxX= board.length/cnt;
			
			System.out.println(cnt+" "+maxX+" ");
			
			for(int i = num; i<maxX;  i++) {
				System.out.println("실행중");
				board[i][i] = num;
			}
			
			try {
				barrier.await();
			}catch(Exception e) {
				return;
			}
			
		}
	}
	
}


