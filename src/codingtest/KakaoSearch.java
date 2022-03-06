package codingtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class KakaoSearch {
	public static void main(String[] args) {
		Solution22323 sol = new Solution22323();
		String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};	
		String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
	
		sol.solution(info, query);
	}
}	

class Solution22323 {
	
	String LAN = "lan";
	String POS = "position";
	String EXP = "exp";
	String FAVOR = "favor";
	String RESULT = "result";
	
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];


        List<Map<String,String>> list = new ArrayList<>();
        
        for(String i : info) {
            Map<String, String> userInfo = generateUserInfo(i);
            list.add(userInfo);
        }
        
        UserPool pool = new UserPool(list);

        
        int cnt =0;
        
        for(String q : query) {
          answer[cnt] =  pool.search(q);
          ++cnt;
        }

        
        return answer;
    }

	private Map<String, String> generateUserInfo(String string) {
		Map<String, String> userInfo = new HashMap<String,String>();
		String[] infomation = string.split(" ");
			userInfo.put(LAN, infomation[0]);
			userInfo.put(POS, infomation[1]);
			userInfo.put(EXP, infomation[2]);
			userInfo.put(FAVOR, infomation[3]);
			userInfo.put(RESULT, infomation[4]);
			
		return userInfo;

	}
	
	class UserPool{
		List<Map<String,String>> list;
		
		public UserPool(List<Map<String,String>> list) {
			this.list = list;
		}
		
		public int search(String query) {
			int cnt = 0;
			boolean tempResult = true;
			Map<String,String> parsedQ = parese(query);
			
			
			for(Map<String,String> item : list) {
				Iterator<String> keySet = parsedQ.keySet().iterator();

				while(keySet.hasNext()){
					String comparedKey = keySet.next();
					
					String resultOfQ = parsedQ.get(comparedKey);
					String resultOfI = item.get(comparedKey);

					if(!resultOfQ.equals("-")) {
						if(comparedKey.equals(RESULT)) {
							if(Integer.valueOf(resultOfI)<Integer.valueOf(resultOfQ)) {
								tempResult = false;
								break;
							}
						}else {
							if(!resultOfQ.equals(resultOfI)) {
								tempResult = false;
								break;
							}
						}
					}
					
				}
				if(tempResult) {
					cnt++;
				}
					
				tempResult = true;
			}
			
		
			return cnt;
			
		}

		private Map<String,String> parese(String query) {
			
			String[] temp = query.replace("and", "").replace("  ", " ").split(" ");
			Map<String, String> queryObj = new HashMap<String,String>();
			
			queryObj.put(LAN, temp[0]);
			queryObj.put(POS, temp[1]);
			queryObj.put(EXP, temp[2]);
			queryObj.put(FAVOR, temp[3]);
			queryObj.put(RESULT, temp[4]);			
			
			return queryObj;
		}
	}
}
