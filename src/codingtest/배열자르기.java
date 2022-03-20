package codingtest;

public class 배열자르기 {

	public static void main(String[] args) {
		int n = 4;
		int left = 2;
		int right = 5;
		Solution123123 sol = new Solution123123();
		
		sol.solution(n, left, right);
		
	}
}


class Solution123123 {
    public int[] solution(int n, long left, long right) {
        int[] answer = {};
        int[][] n2n = new int[n][n];
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		
        		if(i == j) {
        			n2n[i][j] = i+1;
    
        		}
        		
        		
        	}
        }
        
        StringBuilder builder = new StringBuilder();
        
        for(int[] a: n2n) {
        	for(int b : a) {
        		builder.append(b);
        	}
        	System.out.println(builder.toString());
        	builder = new StringBuilder();
        }
        
        
        return answer;
    }
}