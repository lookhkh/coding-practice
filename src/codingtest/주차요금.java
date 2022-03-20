package test;

import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class 주차요금 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		int[] fees2 = {1, 461, 1, 10};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
		                    "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN",
		                    "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		
		String[] records2 = {"00:00 1234 IN"};
		
		Solution4 sol = new Solution4();
		
		sol.solution(fees, records);
	}
}


class Solution4 {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        SortedMap<String,SortedMap<String,String>> list = new TreeMap<String, SortedMap<String, String>>();
        
        for(String record: records) {
        	parseRecord(list, record);
        }
                
        answer = new int[list.size()];
        int cnt = 0;
        
        while(!list.isEmpty()) {
        	String key = list.firstKey();
            SortedMap<String, String> history = list.get(key);

        	if(!checkIfLastOneExist(history)) {
        		history.put("23:59", "OUT");
        	}
        	
        	System.out.println(history);
        	Iterator<String> itr =  history.keySet().iterator();
        	
        	String previousTime = "";
        	int wholePrice = 0 ;
        	int wholeTime = 0 ;
        	while(itr.hasNext()) {
        		String nextTime = itr.next();
        		String type = history.get(nextTime);
        		
        		if(type.equals("IN")) {
        			previousTime = nextTime;
        		}else {
        			wholeTime += getWholeTime(previousTime, nextTime);        			
        		}      		    		     
        	}
        	
			wholePrice+=generateMoneyFromTimebeing(wholeTime,fees);
			System.out.println(wholeTime);
			answer[cnt++]= wholePrice;
        	list.remove(key);
        }
        
        return answer;
    }

	private int generateMoneyFromTimebeing(int wholeTime, int[] fees) {
		int basicTime = fees[0];
		int basicMoney = fees[1];
		int perMinute = fees[2];
		int perPrice = fees[3];
		int finalPrice = 0;
		
		if(wholeTime<=basicTime) {
			return basicMoney;
		}else {
			System.out.println(wholeTime+"  "+basicTime+"  "+(wholeTime-perMinute)/perMinute);
			int middleOper = (wholeTime-basicTime)%perMinute ==0? (wholeTime-basicTime)/perMinute:(wholeTime-basicTime)/perMinute+1;
			finalPrice = basicMoney+middleOper*perPrice;
		}
		
		System.out.println(wholeTime+" "+finalPrice);
		
		
		return finalPrice;
	}

	private boolean checkIfLastOneExist(SortedMap<String, String> history) {
		
		int cntForIn = 0;
		int cntForOut = 0;
		
		Iterator<String> itr =  history.keySet().iterator();
		
		while(itr.hasNext()) {
			String nk = itr.next();
			if(history.get(nk).equals("IN")) cntForIn++;
			else cntForOut++;
			
		}
		
		
		return cntForIn==cntForOut?true:false;
	}

	private int getWholeTime(String previousTime, String nextTime) {
		
		String[] prv = previousTime.split(":");
		String[] next = nextTime.split(":");
		
		int minuteDif = (Integer.valueOf(next[0])*60+Integer.valueOf(next[1]))
						-(Integer.valueOf(prv[0])*60+Integer.valueOf(prv[1]));
		
		return minuteDif;
	}

	private void parseRecord(Map<String, SortedMap<String, String>> list, String record) {
		String[] data =  record.split(" ");
		
		String time = data[0];
		String number = data[1];
		String type = data[2];
		
		 	
		if(list.containsKey(number)) {
			
			SortedMap<String, String> history = list.get(number);
			history.put(time, type);
			list.put(number, history);
			
		}else {
			SortedMap<String, String> history = new TreeMap<String, String>();
			history.put(time, type);
			list.put(number, history);
		}
	}
}