package codingtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class æ–√‡ {

	public static void main(String[] args) {
		Solution00 sol = new Solution00();
		String a1 = "KAKAO";
		String a2 = "TOBEORNOTTOBEORTOBEORNOT";
		
		sol.solution(a2);
	}
}

class Solution00 {
    public List<Integer> solution(String msg) {
        List<Integer> answer = new ArrayList();
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        
        initMapAndList(map, list);
        
        
        
        StringBuilder target = new StringBuilder();
        for(int i=0; i<msg.length(); i++) {
        	 target.append(String.valueOf(msg.charAt(i)));
        	 String tempResult = target.toString();
        	 
        	 if(map.containsKey(tempResult)) {
        		 System.out.println(tempResult+" is listed on the map");
        	 }else {
        		 System.out.println(tempResult+" is not listed");
        		 map.put(tempResult, list.size()+1);
        		 list.add(list.size()+1);
        		 answer.add(map.get(tempResult.subSequence(0, tempResult.length()-1)));
        		 target.delete(0, target.length()-1);           	
        	 }
        	 
        	 if(i == msg.length()-1) {
        		 answer.add(map.get(target.toString()));
        	 }
        	 
        }
        System.out.println(answer);
        
        
        return answer;
    }

	private void initMapAndList(Map<String, Integer> map, List<Integer> list) {
		for(int i = 65; i<=90; i++) {
        	String temp = String.valueOf((char)i);
        	int idx = i%65+1;

        	list.add(idx);
        	map.put(temp, idx);
        	
        }
	}
}