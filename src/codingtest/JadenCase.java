package codingtest;

public class JadenCase {

	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		System.out.println(sol.solution(" as 3people unFolLowed me"));
	}
	
	
}

class Solution3 {
    public String solution(String s) {
        String answer = "";
        
        if(s.length()==1) {
        	return s.toUpperCase();
        }
              
        String[] arrays = s.split(" ");
        
        
        for(String item : arrays) {
        	System.out.println(item);
        	if(item.equals("")) {
        		continue;
        	}
        	answer+=item.substring(0, 1).toUpperCase()+item.substring(1, item.length()).toLowerCase()+" ";
        }
        
        return answer.substring(0, answer.length()-1);
    }
}
