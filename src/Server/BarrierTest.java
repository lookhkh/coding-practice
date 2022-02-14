package Server;

public class BarrierTest {

	public static void main(String[] args) {
		int[][] board =  new int[5][5]; 
		BarrierImp barrier = new BarrierImp(board);
		barrier.start();
		
	}
}
