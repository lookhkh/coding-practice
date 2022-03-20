package test;

public class 스킬트리 {

	public static void main(String[] args) {
		Solution9 sol = new Solution9();
		
		String skil = "CBD";
		String[] tree = {"BACDE", "CBADF", "AECB", "BDA"};
		
		sol.solution(skil, tree);
	}
}

class Solution9 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        
        int prev = -1;
        
        for(String tree : skill_trees) {
        	System.out.println(tree);
        	boolean flag = true;
        	for(int i=0; i <tree.length(); i++) {
        		char eachSkil = tree.charAt(i);
        		
        		if(skill.contains(String.valueOf(eachSkil))) {
        			if(prev == -1) {
        				int firstSkillNum = skill.indexOf(String.valueOf(eachSkil));
        				
        				if(firstSkillNum!=0) {
        					System.out.println("부적절한 스킬, 첫 번째 스킬은 무조건 "+skill.charAt(0));
        					flag = false;
        					break;
        				}else {
        					prev = firstSkillNum;
        				}
        			}else {
        				
        				int skilNum =  skill.indexOf(String.valueOf(eachSkil));
        				
        				if(skilNum - prev == 1) {
        					
        					prev = skilNum;
        				}else {
        					
        					System.out.println(prev+"   "+ skilNum+"   "+"부적절한 스킬");
        					flag = false;
        					break;
        				}

        			}
        		}

        	}
        	
        	if(!flag) {
    			System.out.println("부적절한 스킬 트리. 아웃"+ tree);
    		}else {
    			System.out.println("적절한 스킬트리 "+ tree);
    			answer++;
    		}
        	
        	flag = true;
        	prev = -1;
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
