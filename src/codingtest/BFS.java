package codingtest;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
		public static void main(String[] args) {
	
		int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
		boolean[] visited = new boolean[9];
		
		System.out.println(bfs(1, graph, visited));
		
		}
		
		static String bfs(int start, int[][] graph, boolean[] visited) {
			
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(start);
		
		visited[start] = true;
		
		while(!q.isEmpty()) {
			
			int next = q.poll();
			sb.append(" "+next+" is next");
			
			for(int i=0; i<graph[next].length; i++) {
				int temp = graph[next][i];
				System.out.println(temp+" temp");
				
				if(!visited[temp]) {
					System.out.println(temp+" is not yet visited");
					q.add(temp);
					visited[temp] = true;
				}else {
					System.out.println(temp+" is already visited");
				}
				
			}
			
		}
		
		System.out.println(sb.toString());
		return "hi";
		
			}

}
