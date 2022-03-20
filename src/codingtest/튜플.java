package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Æ©ÇÃ {

	public static void main(String[] args) {
		Solution11 sol = new Solution11();
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		String s1 = "{{1,2,3},{2,1},{1,2,4,3},{2}}"	;
		String s2 = "{{123}}";
		String s3 = "{{4,2,3},{3},{2,3,4,1},{2,3}}"	;
		String s4 = "{{20,111},{111}}";
		sol.solution(s4);
	}
}

class Solution11 {
    public List<Integer> solution(String s) {

        s = preProcessString(s);
           
        List<String> list= new ArrayList<String>();
        pareseString(s, list);
        
        list.sort(new Comparator<String>() {
        	public int compare(String o1, String o2) {
				return o1.length()>o2.length()?1:-1;
			}});
        
        List<Integer> result = generateTuple(list);
       
        return result;
    }

	private List<Integer> generateTuple(List<String> list) {
		List<Integer> result = new ArrayList<Integer>();

        
        for(String a : list) {
    		if(a.startsWith(",")) a= a.substring(1);

        	String[] temp = a.split(",");
        	
        	for(String t : temp) {
        		if(!result.contains(Integer.valueOf(t))) result.add(Integer.valueOf(t));
        	}
        }
		return result;
	}

	private String preProcessString(String s) {
		s= s.substring(1);        
        s= s.substring(0,s.length()-1);
		return s;
	}

	private void pareseString(String s, List<String> list) {
		
		String temp = "";
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i)=='{') {
        		//temp+=s.charAt(i);
        	}else if(s.charAt(i)=='}') {
        		//temp+=s.charAt(i);\
        		list.add(temp);
        		temp = "";
        	}else {
        		temp+=s.charAt(i);
        	}
        }
	}
}