package codingtest;

public class Rectangle {

	public static void main(String[] args) {
		Solution234 sol = new Solution234();
		
		int w = 8;
		int h = 12;
		
		System.out.println(sol.solution(w, h));
	}
}

class Solution234 {
    public long solution(int w, int h) {
        long answer = 1;
        long convertedW = (long)w;
        long convertedH = (long)h;
        
        
        answer =  w+h-(getGCD(convertedW,convertedH));
        
        
        return convertedW*convertedH-answer;
    }

	private long getGCD(long w, long h) {
		
		long big = Math.max(w, h);
		long small  = Math.min(w, h);
		
		int gcd = 0;
		
		for(int i=1; i<=small; i++) {
			if(small%i==0 && big%i==0) {
				gcd = i;
			}
		}
		return gcd;
	}

	
}