package codingtest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	
	static List<LinkedList<Integer>> list = new ArrayList();
	static boolean[] ch = new boolean[5];

	public static void main(String[] args) {
	
		int[][] info = {{0,1},{0,2},{0,3},{1,0},{1,2},{1,4},{2,3},{3,1},{3,4}};
		
		
		for(int i=0; i<5; i++) {
			list.add(new LinkedList<Integer>());
		}
		
		for(int[] edge : info) {
			list.get(edge[0]).add(edge[1]);
		}
	
	
		ch[0] = true;
		dfs(0);
		
	}
	
	
	public static void dfs(int start) {
		if(start == 4) {
			System.out.println("hi");
			return;
		}else {
			
			
			for(int i=0; i<list.size(); i++) {
				if(!ch[i]) {
					LinkedList<Integer> temp = list.get(i);
					for(int j=0; j<temp.size(); j++) {
						int tempNum = temp.get(j);
						System.out.println(i+"는 연결되어 있음 ==>"+tempNum);
						if(!ch[tempNum]) {
							ch[tempNum] = true;
							dfs(tempNum);
							ch[tempNum] = false;
						}
					}
				}
				
				
				
			}
			
		}
	}
	
	
}
