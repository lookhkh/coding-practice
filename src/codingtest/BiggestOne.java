package codingtest;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BiggestOne {

	public static void main(String[] args) {
		int[] arrays = {3, 30, 34, 5, 9};
		solution(arrays);
	}
	
	 public static String solution(int[] numbers) {
	        String answer = "";
	        List<String> list = new ArrayList<>();

	        int i=0;
	        for(int num : numbers) {
	        	list.add(String.valueOf(num));
	        	i++;
	        }
	        list.sort(new Comparator<String>() {
	        	
	        	@Override
	        	public int compare(String o1, String o2) {
	        		// TODO Auto-generated method stub
	        		return 0;
	        	}
	        });
	        list.forEach(a->System.out.println(a));
	        
	        return answer;
	    }
}
