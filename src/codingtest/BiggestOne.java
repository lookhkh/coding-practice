package codingtest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BiggestOne {

	public static void main(String[] args) {
		int[] arrays = {1000,100,10,1};
		System.out.println(solution(arrays));
		
	}
	
	 public static String solution(int[] numbers) {
	        String answer = "";
	        List<String> list = new ArrayList<>();

	        for(int num : numbers) {
	        	list.add(String.valueOf(num));
	        }
	        list.sort(new Comparator<String>() {
	        	
	        	@Override
	        	public int compare(String o1, String o2) {
	        		
	        		int dif = Math.abs(o1.length()-o2.length());
	        		
	        		if(o1.length()<o2.length()) {
	        			o1 += o1.substring(o1.length()-1,o1.length()).repeat(dif);
	        		}else if(o1.length()>o2.length()){
	        			o2 += o2.substring(o2.length()-1,o2.length()).repeat(dif);
	        		}
	        		
	        		for(int i=0; i<o1.length(); i++) {
	        			if(o1.charAt(i)>o2.charAt(i)) {
	        				return -1;
	        			}else if(o1.charAt(i)<o2.charAt(i)){
	        				return 1;
	        			}else {
	        				continue;
	        			}
	        		}

	        		return 1;
	        	}
	        });
	        
	        for(int i=0; i<list.size(); i++) {
	        	answer+=list.get(i);
	        }

	        
	        return answer;
	    }
}
