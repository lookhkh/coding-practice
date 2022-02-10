package codingtest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class UnCompleted {
	
	public static void main(String[] args) {
		Solution33 sol = new Solution33();
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		
		System.out.println(sol.solution(participant, completion));
	}
}

class Solution33 {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map=
        Arrays
        	.stream(participant)
        	.collect(Collectors.toMap(key->key, key->1, (old,newVal)->old+1, ()->new HashMap<>()));
        	
        for(String eachCompletion : completion) {
        	map.computeIfPresent(eachCompletion, (oldKey,oldValue)->--oldValue);
        }
        
        return map.entrySet()
        		.stream()
        		.filter(item->item.getValue()>0)
        		.map(item->item.getKey())
        		.findFirst()
        		.get();
        
    }

	private void listsAllElementsOfArgumentArray(String[] participant) {
		for(String element : participant) {
			System.out.println(element);
		}
		
	}
}