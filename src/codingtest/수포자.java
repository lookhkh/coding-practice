package codingtest;

import java.util.ArrayList;
import java.util.List;

public class ¼öÆ÷ÀÚ {
	public static void main(String[] args) {
		Solution232334 sol = new Solution232334();
		int[] answers = {1,3,2,4,2};
		sol.solution(answers);
		
	}
}
class Solution232334 {
    public List<Integer> solution(int[] answers) {
        List<Integer> answer = new ArrayList();
        
        int[] first = {1,2,3,4,5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        

        int[] result = {0,0,0};
        
        int max = 0;
        
        for(int i=0; i<answers.length; i++) {
        	
        	if(first[i%first.length] == answers[i]) result[0]=result[0]+1;
        	if(second[i%second.length] == answers[i]) result[1]=result[1]+1;
        	if(third[i%third.length] == answers[i]) result[2]=result[2]+1;
        }
                
        for(int za : result) {
        	max = Math.max(za, max);
        }

        for(int i=0; i<result.length; i++) {
        	if(result[i]==max) {
        		answer.add(i+1);
        	}
        }
        
        return answer;
    }
}
