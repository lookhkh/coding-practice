package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ÈÄº¸Å° {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		String[][] rel = {
						  {"100","ryan","music","2"},
						  {"200","apeach","math","2"},
						  {"300","tube","computer","3"},
						  {"400","con","computer","4"},
						  {"500","muzi","music","3"},
						  {"600","apeach","music","2"}
						 };
	
		sol.solution(rel);
	}
}

class Solution3 {
    public int solution(String[][] relation) {
        Map<String, Map<String,Integer>> map = new HashMap<String, Map<String, Integer>>();
        
        
        
        for(String[] rows : relation) {
        	 Map<String, List<String>> result = generateKey(rows);
        	 List<String> keys = result.get("key");
        	 List<String> data = result.get("data");
        	 
        	 for(int i=0; i<keys.size(); i++) {
        		 Map<String,Integer> temp = new HashMap<String, Integer>();
        		 Map<String,Integer> target = map.getOrDefault(keys.get(i),temp);
        		 
        		 if(target.containsKey(data.get(i))) {
        			 target.put(data.get(i), target.get(data.get(i))+1);
        		 }else {
        			 target.put(data.get(i), 1);
        		 }
        		map.put(keys.get(i), target);
        	 }
        }
        
        System.out.println(map);
        
        
       Iterator<String> itr = map.keySet().iterator();
       
       List<String> inValidKey = new ArrayList<String>();
       
       while(itr.hasNext()) {
    	   String key = itr.next();
    	   Map<String,Integer> nextMap = map.get(key);
    	   Iterator<String> nextItr =  map.get(key).keySet().iterator();
    	   boolean flag = true;
    	   while(nextItr.hasNext()) {
        	   String nextKey = nextItr.next();
        	   if(nextMap.get(nextKey)>1) {
        		   flag = false;
        	   }
    	   }
    	   
    	  if(!flag) inValidKey.add(key);
       }
       
       for(String in:inValidKey) {
    	   map.remove(in);
       }
               
       List<String> finalArr = new ArrayList<String>(map.keySet());
       List<String> ans = new ArrayList<String>();
       finalArr.sort(null);

       String tempTarget = finalArr.get(0);
       ans.add(tempTarget);
       for(String fi : finalArr) {
    	   if(!fi.startsWith(tempTarget)) {
    		   tempTarget = fi;
    		   ans.add(fi);
    	   }
       }
       
        return ans.size();
    }
    
    public Map<String, List<String>> generateKey(String[] data) {
    	List<String> result = new ArrayList<String>();
    	List<String> keys = new ArrayList<String>();
    	dfs("","",result, data,new String[]{"id","name","major","grade"}, new boolean[data.length],0,keys);
    	
    	Map<String, List<String>> finalr = new HashMap<String, List<String>>();
    	finalr.put("key", keys);
    	finalr.put("data", result);
    	
    	return finalr;
    }
    
    public void dfs(String target,String keys,List<String> result, String[] data,String[] list, boolean[] ck, int cnt, List<String> keyList) {
    	if(cnt == data.length) {
    		if(target.length()>0) {
    			result.add(target);
    			keyList.add(keys);
    		}
    	}else {
    		
    		ck[cnt] = true;
    		dfs(target+data[cnt],keys+list[cnt],result,data,list,ck,cnt+1,keyList);
    		ck[cnt] = false;
    		dfs(target,keys,result,data,list,ck,cnt+1,keyList);  		
    	}
    }
}