package test;

public class Á¦ÀÌµç {

	public static void main(String[] args) {
		Solution10 sol = new Solution10();
		
		String s = "3people  unFollowed me";
		String s1 = " adgagd 3eagdag ";
		sol.solution(s);
		
		
	}
}

//        	if(firLetter>=48 && firLetter<=57) {


class Solution10 {
    public String solution(String s) {
        String answer = "";
        
        System.out.println(" ".charAt(0)==32);
        
        boolean flag = false;
        String firstLetter = "";
        for(int i=0; i<s.length(); i++) {
        	
        	if(!flag) {
        		firstLetter = String.valueOf(s.charAt(i));
        		if(s.charAt(i)>=48 && s.charAt(i) <= 57) {
        			answer+=firstLetter;
        		}else {
        			if(s.charAt(i)==32) {
        				answer+=s.charAt(i);
        				flag = false;
        			}else {
        				
        				
        				
        			}
        		}
        	}
        	
        	flag = true;
        	
        	
        	
        }


        
        return answer;
    }
}
