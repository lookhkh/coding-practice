package codingtest;

import java.util.ArrayList;
import java.util.List;

public class 체육복 {
	public static void main(String[] args) {
		Solution333 sol = new Solution333();
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {3};
		
		sol.solution(n, lost, reserve);
	}
	
}

class Solution333 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        
        for(int i=1; i<=n; i++) {
        	list.add(i, 1);
        }
        
        for(int los : lost) {
        	list.set(los, 0);
        }
        
        for(int res : reserve) {
        	list.set(res, list.get(res)+1);
        }

        for(int i=1; i<=list.size()-1; i++) {
        	if(list.get(i)==0) {
        		System.out.println(i+" 번째 학생은 체육복이 없음");
        		
        		if(list.get(i-1)>=2) {
        			list.set(i-1, 1);
        			list.set(i, 1);
        		}else if(i+1<list.size()&&list.get(i+1)>=2) {
        			list.set(i+1, 1);
        			list.set(i, 1);
        		}
        	}
        }

        answer = (int)list.stream().filter(a->a>=1).count();
        System.out.println(answer);
           
        return answer;
    }
}
