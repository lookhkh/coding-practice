package test;

public class ��ųƮ�� {

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
        					System.out.println("�������� ��ų, ù ��° ��ų�� ������ "+skill.charAt(0));
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
        					
        					System.out.println(prev+"   "+ skilNum+"   "+"�������� ��ų");
        					flag = false;
        					break;
        				}

        			}
        		}

        	}
        	
        	if(!flag) {
    			System.out.println("�������� ��ų Ʈ��. �ƿ�"+ tree);
    		}else {
    			System.out.println("������ ��ųƮ�� "+ tree);
    			answer++;
    		}
        	
        	flag = true;
        	prev = -1;
        }
        
        System.out.println(answer);
        
        return answer;
    }
}
