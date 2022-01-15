package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class NLeastCommonMultiple {


	public static void main(String[] args) {
		int[] arr = {1,2,3};
		Soluituojn2 sol = new Soluituojn2();
		System.out.println(sol.solution(arr));
	}
}
	
	
	class Soluituojn2{
	 public int solution(int[] arr) {
	       	Map<String, Integer> counter = new HashMap<>();
	        Map<String, Integer> tempCounter;
	       	int answer = 1;

	        for(int item:arr) {
	        	String result = makeLCM(item);
	        	List<String> tempArr = Arrays.asList(result.split("x"));	
        		tempCounter = new HashMap<>();
	        	
	        	for(String target : tempArr) {
	        		if(tempCounter.containsKey(target)) {
	        			tempCounter.put(target, tempCounter.get(target)+1);
	        		}else {
	        			tempCounter.put(target, 1);
	        		}
	        	}
	        	
	        	
	        	Iterator<String> keySet = tempCounter.keySet().iterator();
	        	while(keySet.hasNext()) {
	        		String nextKey = keySet.next();
	        		if(counter.containsKey(nextKey)) {
	        			if(tempCounter.get(nextKey)>counter.get(nextKey)) {
	        				counter.put(nextKey, tempCounter.get(nextKey));
	        			}
	        		}else {
	        			counter.put(nextKey, tempCounter.get(nextKey));
	        		}
	        	}
	        }
	        
	        	
	        Iterator<String> keySet = counter.keySet().iterator();
	        while(keySet.hasNext()) {
	        	String key = keySet.next();
	        	int target =Integer.valueOf(key);
	        	int repeat = counter.get(key);
	        	answer *= (int)Math.pow(target, repeat);
	        }

	        return answer;
	    }
	 
	 public String makeLCM(int item) {
		 StringBuilder sb = new StringBuilder();
		 int min = 2;
		 int least = min;
		 
		 if(item==1) {
			 return "1";
		 }
		 
		 while(item>1) {
			 if(item%least!=0) {
				 least++;
			 }else {
				 sb.append(least);
				 sb.append("x");
				 item /= least;
				 least = min;
				 
			 }
		 }
		 
		 return sb.toString().substring(0,sb.length()-1);

	 }
	}
	 
