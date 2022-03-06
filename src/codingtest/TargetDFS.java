package codingtest;

public class TargetDFS {

	public static void main(String[] args) {
		Solution2342 sol = new Solution2342();
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		
		sol.solution(numbers, target);
	}
}

class Solution2342 {
	
	int cnt = 0;
	
	public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,0,0,target);
        System.out.println(cnt);
        
        
        return answer;
    }
	
	
	public void dfs(int[] numbers, int pointer, int sum, int target) {
		if(pointer >= numbers.length) {
			if(sum == target) {
				System.out.println("¤·¤»");
				this.cnt++;
			}
			//System.out.println("¸®ÀıÆ® : "+sum);
			
			return;
		}else {
			
			
			
			sum += numbers[pointer];
			dfs(numbers, pointer+1, sum,target);
			sum -= numbers[pointer]*2;
			dfs(numbers, pointer+1,sum,target);
		}
	}
}



