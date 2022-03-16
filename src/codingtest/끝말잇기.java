package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class 끝말잇기 {
	
	public static void main(String[] args) {
		Solution6 sol = new Solution6();
		int n = 2;
		String[] words ={"hello", "one", "even", "never", "now", "world", "draw"};
		
		sol.solution(n, words);
		
	}
}

class Solution6 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        boolean result = false;
        Map<Integer, Integer> cntPerPerson = new HashMap();
        Map<Integer, List<String>> wordList = new HashMap();
        
        for(int i=0; i<words.length; i++) {
        	cntPerPerson.put(i%n, cntPerPerson.getOrDefault(i%n, 0)+1);
        	List<String> list = wordList.getOrDefault(i%n, new ArrayList<String>());
        	

        	if(checkIfSpokenPrevious(words[i], wordList)) {
        		answer[0] = i%n;
        		answer[1] = cntPerPerson.get(answer[0]);
        		result = true;
        		break;
        	}
        	
        	if(i>0&&!words[i].startsWith(words[i-1].substring(words[i-1].length()-1))) {
        		answer[0] = i%n;
        		answer[1] = cntPerPerson.get(answer[0]);
        		result = true;
        		break;
        	}
        	
        	
        	
        	list.add(words[i]);
        	wordList.put(i%n, list);
        	
        }
        
        if(result) {
        	answer[0] = answer[0]+1;
        }else {
        	
        }
        System.out.println(answer[0]+"   "+answer[1]);
        
        return answer;
    }

	private boolean checkIfSpokenPrevious(String string, Map<Integer, List<String>> wordList) {
		
		Iterator<Integer> itr =  wordList.keySet().iterator();
		
		while(itr.hasNext()) {
			int nextKey = itr.next();
			
			List<String> words = wordList.get(nextKey);
			
			if(words.contains(string)) {
				System.out.println("이전에 한 번 불림");
				return true;
			}
			
		}
		
		
		return false;
	}

	
}