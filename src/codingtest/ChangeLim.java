package codingtest;

import java.util.ArrayList;
import java.util.List;

public class ChangeLim {
	
	public static void main(String[] args) {
		Solution12949 sol = new Solution12949();
		int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr2 = {{5, 4},{2, 4},{3, 1}};
		int[][] result = sol.solution(arr1, arr2);
		
		
		
	}

}

class Solution12949 {
	  public int[][] solution(int[][] arr1, int[][] arr2) {
	        int[][] answer = new int[arr1.length][arr2[0].length];
	        
	        for(int i=0; i<arr1.length; i++) {
	        	for(int j=0; j<arr2[0].length; j++) {
	        		int temp = 0;
	        		for(int k=0; k<arr2.length; k++) {
	        			temp+= arr1[i][k]*arr2[k][j];
	        		}
	        		answer[i][j] = temp;
	        	}
	        }
	        
	        return answer;
	    }
}