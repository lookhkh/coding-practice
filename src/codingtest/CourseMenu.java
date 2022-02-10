package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CourseMenu {

	public static void main(String[] args) {
		Solution7 sol = new Solution7();
		String[] orders = {"XYZ", "XWY", "WXA"};
		int[] course = {2,3,4};
		
		sol.solution(orders, course);
	}
	
	
}

class Solution7 {
	
	 public String[] solution(String[] orders, int[] course) {
	        String[] answer = {};
	        List<String> temp = new ArrayList<>();
	        Map<String, Integer> score = new HashMap<>();
	        
	        
	        
	        for(String order : orders) {
	        	char[] StringtoChar = order.toCharArray();
	            Arrays.sort(StringtoChar);
	            order = new String(StringtoChar);
	            
	        	boolean[] check = new boolean[order.length()];
	        	dfs(0,order,check,temp);
	    
	        }
	        
	        temp = temp.stream().filter(item -> !item.isBlank()&&item.length()>=2).sorted().collect(Collectors.toList());
	        
	        for(String target : temp) {
	        	if(score.containsKey(target)) {
	        		score.put(target, score.get(target)+1);
	        	}else {
	        		score.put(target, 1);
	        	}
	        }
	        
        	List<String> tempResult = new ArrayList<>();

        	
	        for(int num:course) {
	        	int maximum = 0;
	        	
	        	
	        	List<String> numKey = score.keySet().stream().filter(key->key.length() == num).collect(Collectors.toList());
	        	
	        	for(String key: numKey) {
	        		if(score.get(key)>=maximum) {
	        			maximum = score.get(key);
	        		}
	        	}
	        	
	        	for(String key : numKey) {
	        		if(score.get(key)==maximum && score.get(key)>1) {
	        			tempResult.add(key);
	        		}
	        	}	        	
	        }
	        
	        tempResult.sort(null);
	        tempResult.forEach(a->System.out.println(a));

	        answer = new String[tempResult.size()];
	        
	        for(int i=0; i<tempResult.size(); i++) {
	        	answer[i] = tempResult.get(i);
	        }
	        
	        
	        return answer;
	    }
	 
	 private void dfs(int L,String order, boolean[] ch, List<String> tempResult) {
		 if(L == order.length()) {
			 StringBuilder builder = new StringBuilder();
			 for(int i=0; i<ch.length; i++) {
				 if(ch[i]) {
					 builder.append(order.charAt(i));
				 }
			 }
			 
			 tempResult.add(builder.toString());

			 return;
		 }else {
			 ch[L] = true;
			 dfs(L+1, order, ch,tempResult);
			 ch[L] = false;
			 dfs(L+1,order,ch, tempResult);
		 }
	 }

}

