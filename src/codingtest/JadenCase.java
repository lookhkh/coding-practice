package codingtest;

import java.util.Arrays;
import java.util.List;

public class JadenCase {

	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		System.out.println(sol.solution("3people  unFollowed me"));
	}
	
	
}

class Solution3 {
    public String solution(String s) {
     
    	String answer = "";
    	int pointer = 0;
    	
    	if(s.length()==1) {
    		return s.toUpperCase();
    	}
    	
    	String[] array = s.split(" ");
    
    	if(s.startsWith(" ")) {
    		array[1] = " "+array[1];
    		pointer = 1;
    	}
    	
    	for(int i=pointer; i<array.length; i++) {
    		if(array[i].charAt(0)>=97&&array[i].charAt(0)<=122) {
    			array[i] = array[i].substring(0,1).toUpperCase()+array[i].substring(1,array[i].length()).toLowerCase();
    		}
    			
    		answer+=array[i]+" ";
    	}
    
    	return answer.substring(0,answer.length()-1);
    	
    }
}
