package codingtest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Ä³½Ã {
	public static void main(String[] args) {
		Solution23142 sol = new Solution23142();
		int cacheSize = 0;
		String[] cities = 	{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		sol.solution(cacheSize, cities);
	}
}

class Solution23142 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LRU cache = new LRU(cacheSize);
        
        if(cacheSize>0) {
        for(String city : cities) {
        	
        	city = city.toLowerCase();
        	String cacheResult = cache.get(city);
        	
        	if(cacheResult.equals("")) {
        		answer+=5;
        		cache.insert(city);
        	}else {
        		answer+=1;
        	}
        
        }
        }else{
        	for(String city : cities) {
            	
        		answer+=5;

            
            }
        }
        
        System.out.println(answer);
        return answer;
    }
}

class LRU{
	
	private Map<String ,String> map = new HashMap<String, String>();
	private Queue<String> que = new LinkedList<String>();
	private int poolSize;
	
	public LRU(int poolSize) {
		this.poolSize = poolSize;
	}
	
	public int insert(String value) {
		if(map.containsKey(value)) {
			return -1;
		}else {
			if(poolSize>map.size()) {
				
			}else {
				while(poolSize<=map.size()) {
					evitLRU();
				}
			}
			
			map.put(value, value);
			que.add(value);
			return 1;
		}
	}
	
	private void evitLRU() {
		String result = que.poll();
		map.remove(result);
		
	}

	public int evit(String key) {
		if(map.containsKey(key)) {
			map.remove(key);
			return 1;
		}else {
			return -1;
		}
	}
	
	public String get(String key) {
		if(map.containsKey(key)) {
			que.remove(key);
			que.add(key);
			return map.get(key);
		}else {
			return "";
		}
	}
	
	
}
