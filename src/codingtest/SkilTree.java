package codingtest;

import java.util.ArrayList;
import java.util.List;

public class SkilTree {

	public static void main(String[] args) {
		Solution444 sol = new Solution444();
		String skil = "CBD";
		String[] trees = {"BACDE", "CBADF", "AECB", "BDA"};
		
		sol.solution(skil, trees);
	}
	
	
}


class Solution444 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<Integer> arr = new ArrayList<>();
        boolean flag = true;
        
        for(int i=0; i<skill_trees.length; i++) {
        	String tree = skill_trees[i];
        	for(int j=0; j<skill.length(); j++) {
        		if(tree.indexOf(skill.charAt(j))>=0) {
        			System.out.println(i+"번째 값 추가 :"+tree.charAt(j));
            		arr.add(tree.indexOf(tree.charAt(j)));
        		}
        	}
        	
        	for(int z=0; z<arr.size()-1; z++) {
        		System.out.println(arr);
        		if(arr.get(z)>=arr.get(z+1)) {
        			flag=false;
        		}
        	}
        	
        	if(flag) answer++;
        	
        	for(int a : arr) {
        		System.out.println(i+" 번째 값 : "+a);
        	}
        	arr = new ArrayList<>();
        	flag = true;
        }
        
        System.out.println(answer);
        return answer;
    }
}