package codingtest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CourseMenu {

	public static void main(String[] args) {
		Solution7 sol = new Solution7();
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		sol.solution(orders, course);
	}
	
	
}

class Solution7 {
	
	static boolean[] check;
	static HashMap<String, Integer> map = new HashMap<>();
    static String[] answer;
    static int[] results;
    
    public String[] solution(String[] orders, int[] course) {
        answer = new String[course.length];
        results = new int[course.length];
        check = new boolean[orders[0].length()];
       
       dfs(orders[0], 2, "",0);  		    		
      
        
        
      
        
        return answer;
    }
    
    private void dfs(String orders, int level, String result,int idx) {
    	    	
    	if(idx==orders.length()) {
    		for(int i=0; i<check.length; i++) {
    			if(check[i]==true) {
    				result+=orders.charAt(i);
    			}    			
    		}
    		System.out.println("°á°ú : "+result);
    		System.out.println(idx);

			
				if(map.containsKey(result)) {
					map.put(result, map.get(result)+1);
				}else {
					map.put(result, 1);
				}
				
			return;
    	}else if(idx>orders.length()) {
    		return;
    	}
    	
    	check[idx] = true;
    	result+=orders.charAt(idx);
    	dfs(orders,level,result,idx+1);
    	check[idx] = false;
    	result = result.substring(0, result.lastIndexOf(orders.charAt(idx))-1);
    	System.out.println(result);
    	dfs(orders,level,result,idx+1);	
    	}
}

