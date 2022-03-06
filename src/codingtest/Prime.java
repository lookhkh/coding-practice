package codingtest;

import java.util.HashSet;
import java.util.Set;

public class Prime {

	public static void main(String[] args) {
		Solution2323 sol = new Solution2323();
		String numbers = "17";
		
		sol.solution(numbers);
	}
}

class Solution2323 {
    
	Set<String> list = new HashSet(); 
    
	
	public int solution(String numbers) {
        int answer = 0;

        dfs("",numbers);
        
        for(String ele : list) {
        	if(isPrime(Integer.valueOf(ele))) {
        		answer++;
        	}
        }
        
        System.out.println(answer);
        return answer;
    }
    
    public void dfs(String comb, String others) {
    	

    	// 1. ���� ������ set�� �߰��Ѵ�. 
    	if (!comb.equals("")) {
    		System.out.println(comb+" ------- "+others);// 2. ���� ���� �� �� ���� ���� ���ο� ������ �����. 
    		list.add(comb);
    	}	
    		
    	for (int i = 0; i < others.length(); i++) {
    		dfs(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
    	}
    
    }
    
    public boolean isPrime(int num) {  
    	if (num == 0 || num == 1) return false;  
    	int lim = (int)Math.sqrt(num);  
    	for (int i = 2; i <= lim; i++) if (num % i == 0) return false; return true; }
    }

