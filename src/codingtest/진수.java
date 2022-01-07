package codingtest;

public class Áø¼ö {
	
	public static void main(String[] args) {
		System.out.println(solution(78));
	}
	
	 public static int solution(int n) {
	        
	        String targetBi = Integer.toBinaryString(n);
	        int numOf1 =0;
	        
	        for(int i=0; i<targetBi.length(); i++) {
	        	if(targetBi.charAt(i)==49) {
	        		numOf1++;
	        	}
	        }

	        
	        while(true) {
	        	
	        	n++;
	        	String temp = Integer.toBinaryString(n);
	        	int tempNum = 0;
		        
		        for(int i=0; i<temp.length(); i++) {
		        	if(temp.charAt(i)==49) {
		        		tempNum++;
		        	}
		        }
		        
		        if(tempNum == numOf1) {
		        	return n;
		        }
	        }
	        
	        	    }
	 
	 
	
}
