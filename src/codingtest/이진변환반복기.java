package test;

public class 이진변환반복기 {

	public static void main(String[] args) {
		Solution8 sol = new Solution8();
		String s = "01110";
		
		sol.solution(s);
		
	}
}

class Solution8 {
	
	int cntForRemoval = 0;
	
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int cnt = 0;
        
        while(!s.equals("1")) {
        	cnt++;
        	s=removeAllZeroFromSource(s);
        	s=convertToTwoBasedOnTheLength(s);
        }
        
        answer[0] = cnt;
        answer[1] = cntForRemoval;
        
        System.out.println(answer[0]+"   "+answer[1]);

        return answer;
    }

	private String convertToTwoBasedOnTheLength(String s) {
		int target = s.length();
		String result = Integer.toBinaryString(target);
		System.out.println(result);
		return result;
	}

	private String removeAllZeroFromSource(String s) {
		
		StringBuilder builder = new StringBuilder();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)!='0') {
				builder.append(s.charAt(i));
			}else {
				cntForRemoval++;
			}
		}
		
		return builder.toString();
	}
}
