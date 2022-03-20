package codingtest;

import java.util.Arrays;

public class 구명보트 {

	public static void main(String[] args) {
		Solution33333 sol = new Solution33333();
		int[] people = {70, 80, 50}	;
		int limit = 100;
		
		sol.solution(people, limit);
	}
}

class Solution33333 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        
        while(left <= right) {
        	//System.out.println(left+" "+people[left]+" "+right+" "+people[right] );
        	if(people[left]+people[right]<= limit) {
        		left++;
        		right--;
        		answer++;
        	}else {
        		right--;
        		answer++;
        	}
        	
        	
        }

        System.out.println(answer);
        return answer;
    }
}