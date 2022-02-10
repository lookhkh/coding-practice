package codingtest;

import java.util.ArrayList;
import java.util.List;

public class N {

	public static void main(String[] args) {
		Solution22 sol = new Solution22();
		
		System.out.println(sol.test(8,16,2,1));
		System.out.println("16Áø¹ý "+Integer.toHexString(30));
		
		System.out.println(sol.translateNumToN(8, 9));
	}
	
	
}

class Solution22 {

    public String test(int n, int t, int m, int p) {
    	int nextNum = 0;
    	int cnt = 1;
    	List<Character> numList = new ArrayList<>();
    	String nextValeu;
    	
    	while(numList.size()<t) {
    		
    		nextValeu = translateNumToN(n,nextNum);
    		
    		for(int i=0; i<nextValeu.length(); i++) {
    			if(cnt==p) {
    				if(numList.size()<t) {
    					numList.add(nextValeu.charAt(i));
    				}else {
    					break;
    				}
    					}
    			
    			if(cnt>=m) {
        			cnt = 1;
        		}else {
        			cnt++;
        		}    		
    		}
    		
    		nextNum++;
    		
    	}
   
    	
    	return numList.stream()
    			.map(a->String.valueOf(a))
    			.reduce((old,newVal)->old+newVal)
    			.get();
    	

    }
    
    public String translateNumToN(int n, int target) {
    	String[] list = {"A","B","C","D","E","F"};
    	if(target<n) {
    		if(n>10&&target>=10) {
    			return list[target%10];
    		}
    		return  String.valueOf(target);
    	}
    	return translateNumToN(n, target/n)+String.valueOf(target%n);
    }
}