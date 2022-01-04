package codingtest;

import java.util.Stack;

public class Pair {
	
	public static void main(String[] args) {
		Solution4 sol = new Solution4();
		System.out.println(sol.solution("baabaa"));
	}
	
	
}

class Solution4
{
    public int solution(String s)
    {
        Stack<Object> stack = new Stack<>();
        
        for(char item : s.toCharArray()) {
        	if(stack.isEmpty()) {
        		stack.push(item);
        	}else {
        		if(stack.peek().equals(item)) {
        			stack.pop();
        		}else {
        			stack.push(item);
        		}
        	}
        }
        
        
        
        return stack.isEmpty()?1:0;
    }
}
