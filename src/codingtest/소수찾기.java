package codingtest;

public class 소수찾기 {

	public static void main(String[] args) {
		Solution23126 sol = new Solution23126();
		
		String numbers = "172";
		sol.solution(numbers);
	}
}

class Solution23126 {
    public int solution(String numbers) {
        int answer = 0;
        char[] source = numbers.toCharArray();
        
        dfs("",source, new boolean[numbers.length()],source.length);
        
         return answer;
    }
    
    public void dfs(String target,char[] source, boolean[] check, int targetLength) {
    	
    
    	if(target.length() >= targetLength ) {
    		
    		
        	System.out.println("==============");
        	System.out.println(target);
        	for(boolean a : check) {
        		System.out.println(a);
        	}
        	System.out.println("target length "+targetLength);
    		System.out.println(target+" is final");

        	System.out.println(")))))))))))))))))))");
        	
    		return;
    	}
    	  
    	for(int i=0; i<source.length; i++) {
    		if(!check[i]) {
    			check[i] = true;
    			dfs(target+source[i],source, check,targetLength);

    		}else {
    			check[i] = false;
    			dfs(target+source[i],source, check,targetLength);
    		}
    	}

        
    }
    
    
   
}
