package programmersLevel2;

public class 모음사전 {

	public static void main(String[] args) {
		Solution33333 sol = new Solution33333();
		sol.solution("a");
	}
}

class Solution33333 {
    public int solution(String word) {
        int answer = 0;
        String[] list = {"A","E","I","O","U"};
        permutation(list, new String[5], 0, 5);
        
        return answer;
    }
    
    private void permutation(String[] list, String[] out, int depth, int target) {
    	
    	if(depth <= target) {
    		StringBuilder builder = new StringBuilder();
    		for(String o : out) {
    			builder.append(o);
    		}
    		
    		System.out.println(builder.toString());
    		
    		return;
    	}else {
    		
    		for(int i=0; i<list.length; i++) {
    			out[depth] = list[i];
    			permutation(list, out, depth+1, target);
    		}
    		
    		
    	}
    	
    	
    }


	
}
