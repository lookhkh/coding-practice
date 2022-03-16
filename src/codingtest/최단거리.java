package test;

import java.util.LinkedList;
import java.util.Queue;

public class 최단거리 {

	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		int[][] ar = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		int[][] ar2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		System.out.println(sol.solution(ar));
	}
}

class Solution2 {
    public int solution(int[][] maps) {
        int answer = 0;
        
        System.out.println(bfs(maps,new boolean[maps.length][maps[0].length]));
        
        
        return answer;
    }
    
    public int bfs(int[][] maps,boolean[][] visit) {
    	
    	 int[] dx = {-1,0,0,1};
    	 int[] dy = {0,1,-1,0};
    	
    	Queue<int[]> que = new LinkedList();
    	que.add(new int[] {0,0,1});
    	visit[0][0] = true;
    	int cnt = 0;
    	
    	while(!que.isEmpty()) {
    		int[] current = que.poll();
    		//System.out.println(current[0]+"  "+current[1]+"  "+current[2]);

    		if(current[0]==maps.length-1 && current[1]==maps[0].length-1) return current[2];
    		 for(int i = 0; i<4;i++){
                 int nx = current[0] + dx[i];
                 int ny = current[1] + dy[i];

                 if(nx>=0 && ny>=0 && nx<maps.length && ny<maps[0].length){
                     if(maps[nx][ny]==1 &&!visit[nx][ny]){
                         visit[nx][ny] = true;
                         que.offer(new int[] {nx,ny,current[2]+1});
                     }
                 }
             }
    		
    	}
    	
    	return -1;
    }
}