package test;

public class ÇÇ·Îµµ {
	
	public static void main(String[] args) {
		Solution7 sol = new Solution7();
		int k = 80;
		int[][] dungenons = {{80,20},{50,40},{30,10}};
		
		sol.solution(k, dungenons);
	}
	
}
class Solution7 {
	
	int answer=  0;
	
    public int solution(int k, int[][] dungeons) {


        boolean[] ck = new boolean[dungeons.length];
        dfs(k,0,dungeons,ck);
        
        return this.answer;
    }
    
    public void dfs(int k, int cnt,int[][] dungenons, boolean[] ck) {
    	    	
    		for(int i=0; i<dungenons.length; i++) {
    			
    			if(!ck[i] && dungenons[i][0]<=k) {
    				ck[i] = true;
    				dfs(k-dungenons[i][1], cnt+1,dungenons,ck);
    				ck[i] = false;
    			}
    			
    		}
    		
    		System.out.println(cnt+"  "+k);
    	
    		answer =Math.max(answer, cnt);
    }
}