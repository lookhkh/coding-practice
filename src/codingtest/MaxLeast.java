package codingtest;

public class MaxLeast {

	public static void main(String[] args) {
		Solution6 sol = new Solution6();
		System.out.println(sol.solution("-1 -2 -3 -4"));
	}
	
	
}

class Solution6 {
	public String solution(String s) {
	        String answer = "";
	        String[] array = s.split(" ");
	        int max = Integer.MIN_VALUE;
	        int least = Integer.MAX_VALUE;
	        
	        
	        for(String item : array) {
	        	int temp = Integer.valueOf(item);
	        	if(temp>max) {
	        		max = temp;
	        	}
	        	
	        	if(temp<least) {
	        		least = temp;
	        	}
	        }
	      	   answer = String.valueOf(least)+" "+String.valueOf(max);
	        
	        return answer;
	    
	}
}