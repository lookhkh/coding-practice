package codingtest;

public class DFS {

	static long[] memoization;
	
	public static void main(String[] args) {
		int[] list = {1,2,3,4,5};
		boolean[] ch = new boolean[list.length];
		int[] result = new int[5];
		
		
		memoization = new long[10];
		long current = System.nanoTime();
		long result1 = factorial(10);
		long end = System.nanoTime() - current;
		System.out.println(result1+" is result");
		System.out.println("총 소요시간 "+end);
		
		current = System.nanoTime();
		long result2 = factorial(10);
		end = System.nanoTime() - current;
		System.out.println(result2+" is result");
		System.out.println("총 소요시간 "+end);
	}
	
	
	private static long factorial(int n) {
		
		if(n == 1) {
			return 1;
		}else {
			return memoization[n-1] = n*factorial(n-1);
		}
	}
	
	private static void permutation(int L,int[] n, boolean[] check, int[] result) {
		
		if(L == 5) {
			System.out.println("끝에 도달 "+L);
			
			for(int i=0; i<result.length; i++) {
				System.out.println(result[i]);
			}
			
			return;
		}else {
			for(int i=0; i<n.length; i++) {
				if(check[i]) continue;
				check[i] = true;
				result[L] = n[i];
				permutation(L+1,n,check,result);
				check[i] = false;
			}
		}
		
	}
}
