package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class 자카드 {

	
	
	public static void main(String[] args) {
		Solution2223 sol = new Solution2223();
		String str1 = "aabbc";
		String str2 = "abbde";
		
		int answer =sol.solution(str1, str2);
	
}
}

     // 두 집합이 공집합일 경우, 자카드 1
	
	class Solution2223 {

		Map<String, Integer> set1Map;
		Map<String, Integer> set2Map;
		
	    public int solution(String str1, String str2) {
	        int answer = 0;
	        
	        str1 = str1.toLowerCase();
	        str2 = str2.toLowerCase();
	        
	        List<String> set1 = makeSetWith2Char(str1);
	        List<String> set2 = makeSetWith2Char(str2);
	        
	        set1Map = countHowMany(set1);
	        set2Map = countHowMany(set2);

	        
	        List<String> sum= 합집합(set1, set2,set1Map,set2Map);
	        List<String> common = 교집합(set1, set2,set1Map,set2Map);
	        
	        if(sum.size()==0 && common.size()==0) {
	        	answer = 65536;
	        }else {
		        float 자카드 = ((float)common.size()/(float)sum.size());
		        
		        answer = (int) (자카드*65536);
		        	        
		       
		     }
			return answer;
	    }

		public List<String> 교집합(List<String> set1, List<String> set2, Map<String, Integer> set1Map2, Map<String, Integer> set2Map2) {
			List<String> temp = new ArrayList<>();
			List<String> result = new ArrayList<>();
			

			temp.addAll(set1);
			temp.retainAll(set2);
			List<String> duplicatedEleNo = new ArrayList(new HashSet<String>(temp));
			
			for(int i=0; i<duplicatedEleNo.size(); i++) {
				int cntFor1 = set1Map.get(duplicatedEleNo.get(i));
				int cntFor2 = set2Map.get(duplicatedEleNo.get(i));

				int cnt = cntFor1<=cntFor2?cntFor1:cntFor2;
				
				for(int j=0; j<cnt; j++) {
					System.out.println(duplicatedEleNo.get(i));
					result.add(duplicatedEleNo.get(i));
				}
			}
			
					
			return result;
			
		}

		public List<String> 합집합(List<String> set1, List<String> set2, Map<String, Integer> set1Map2, Map<String, Integer> set2Map2) {

			List<String> copyOfSet1 = deepCopy(set1);
			List<String> copyOfSet2 = deepCopy(set2);

			
			List<String> sum = new ArrayList<>();

			copyOfSet1.addAll(copyOfSet2);
			
			Iterator<String> allSet = new HashSet<String>(copyOfSet1).iterator();
			
			while(allSet.hasNext()) {
				String target = allSet.next();
				int cnt = set1Map2.getOrDefault(target,0)>=set2Map2.getOrDefault(target,0)
							?set1Map2.get(target):set2Map2.get(target);
				
				for(int i=0; i<cnt; i++) {
					sum.add(target);
				}
			}
			
			return sum;
		}

		private <T> List<T> deepCopy(List<T> set2) {

			return new ArrayList<>(set2);
		}

		private Map<String, Integer> countHowMany(List<String> set1) {
			Map<String, Integer> mapOfSet1 = new HashMap<>();
			
			for(int i=0; i<set1.size(); i++) {
				String target = set1.get(i);
				if(!mapOfSet1.containsKey(target)) {
					mapOfSet1.put(target, 1);
				}else {
					mapOfSet1.put(target, mapOfSet1.get(target)+1);
				}
			}
			return mapOfSet1;
		}

		private List<String> makeSetWith2Char(String str1) {
			
						
			char[] chars = str1.toCharArray();

			List<String> tempList = new ArrayList<>();
			String tempStr = "";
			int pointer = 0;

			
			while(pointer<str1.length()-1) {

				for(int i=pointer; i<=pointer+1; i++) {
					tempStr+=chars[i];
					}
				
				if(getType(tempStr)) {
					tempList.add(tempStr);
				}				
				tempStr="";
					
				pointer+=1;
			}
			
			return tempList;
		}
		
		private boolean getType(String word) {
	        return Pattern.matches("^[a-zA-Z]*$", word);
	    }


	}


