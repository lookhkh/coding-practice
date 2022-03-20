package codingtest;

public class ¶¥µû¸Ô±â {

	public static void main(String[] args) {
		Solution123123123 sol = new Solution123123123();
		
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		
		sol.solution(land);
	}
}

class Solution123123123 {
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        
        for(int i=0; i<4; i++) {
        	dp[0][i] = land[0][i];
        }
        
        for(int i = 1; i<land.length; i++) {
        	dp[i][0] = Math.max(Math.max(dp[i-1][1], dp[i-1][2]), dp[i-1][3])+land[i][0];        	
        	dp[i][1] = Math.max(Math.max(dp[i-1][0], dp[i-1][2]), dp[i-1][3])+land[i][1];        	
        	dp[i][2] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][3])+land[i][2];        	
        	dp[i][3] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2])+land[i][3];        
        }
        
        for(int i=0; i<4; i++) {
        	answer = Math.max(answer, dp[land.length-1][i]);
        }
        
        
       return answer;
    }
}