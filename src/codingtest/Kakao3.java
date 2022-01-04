package codingtest;

import java.util.ArrayList;
import java.util.List;

public class Kakao3 {
	
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		System.out.println(sol.solution("aabbaccc"));
		
	}
	
}

class Solution2 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if(s.length()==1) {
        	return 1;
        }
        
        for(int i=1; i<=s.length()/2; i++) {
        	List<String> list = new ArrayList<>();
        	int len = i;
        	int pointer = 0;
        	
        	while(true) {
        		if(pointer+len>s.length()) { 
        			list.add(s.substring(pointer, s.length()));
        			break;
        		}
        		String temp = s;
        		list.add(temp.substring(pointer, len+pointer));
        		pointer+=len;
        	}
        	System.out.println(i+"번째 시작");
        	list.forEach(a->System.out.println(a));
        	System.out.println(i+"번째 끝");

        	
        	StringBuilder temp = new StringBuilder();
        	int repeat = 1;
        	
        	for(int j=0; j<list.size(); j++) {

        		if(j+1<list.size()&&list.get(j).equals(list.get(j+1))) {
        			repeat++;
        		}else {
        			if(repeat ==1) {
            			temp.append(list.get(j));

        			}else {
            			temp.append(repeat+list.get(j));
        			}
        			repeat = 1;
        		}
        	}
               	answer = answer>temp.length()?temp.length():answer; 
               	System.out.println(temp.toString());
        }
        
        
        return answer;
    }
}
