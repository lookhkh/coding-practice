package codingtest;

public class Kakao1 {
	public static void main(String[] args) {
		String test ="2three45sixseven";
		Solution.solution(test);
	}
}
class Solution{
	public static int solution(String s) {
        int answer = 0;
        String resultAn="";
        char[] table = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
        	if(48<=table[i]&&57>=table[i]) {
        		resultAn+=String.valueOf(table[i]);
        	}else {
        		res.append(table[i]);
        		if(res.toString().length()>=3) {
        			int result = contain(res.toString());
        			if(result>=0) {
        			resultAn+=String.valueOf(result);
        			res.setLength(0);
        			}
        		}
        	}
        }
        
        System.out.println(resultAn);
        
        return Integer.valueOf(resultAn);
    }
	
	public static int contain(String test) {
		switch (test) {
case "zero": {
		return 0;
			}
case "one": {
		return 1;
			}
case "two": {
	return 2;
	}
case "three": {
	
	return 3;
	}
case "four": {
	
	return 4;
	}
case "five": {
	
	return 5;
	}
case "six": {
	
	return 6;
	}
case "seven": {
	
	return 7;
	}
case "eight": {
	
	return 8;
	}
case "nine": {
	
	return 9;
	}	
default:{
			return -1;
		}
	}
}
}

