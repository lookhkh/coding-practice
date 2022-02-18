package codingtest;

public class 행렬테두리회전 {
	public static void main(String[] args) {
		Solution222 sol = new Solution222();
		int rows = 100;
		int columns = 97;
		int[][] queries = {{1,1,100,97}};//,{3,3,6,6},{5,1,6,3}};
		for(int i : sol.solution(rows, columns, queries)) {
			System.out.println(i+" is ");
		};
	}
}

class Solution222 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] lim = makeLim(rows, columns);
        int cnt = 1;
        
        for(int[] query : queries) {
        		int r1 = query[0]-1;
        		int l1 = query[1]-1;
        		int r2 = query[2]-1;
        		int l2 = query[3]-1;
        		
        		

        		int[][] clone = deepCloneLim(lim);
        		
        		int min = Integer.MAX_VALUE;
        		
        		for(int i=r2; i>r1; i--) {
        			
        			lim[i-1][l1] = clone[i][l1];
        			min = Math.min(lim[i-1][l1],min);
        		}
        		
        		for(int i=l2; i>l1; i--) {
        			lim[r2][i-1] = clone[r2][i];
        			min = Math.min(lim[r2][i-1],min);

        		}
        		
        		
        		for(int i=r1; i<r2; i++) {
        			lim[i+1][l2] = clone[i][l2];
        			min = Math.min(lim[i+1][l2],min);

        		}     
        		
        		for(int i=l1; i<l2; i++) {
        			lim[r1][i+1] = clone[r1][i];
        			min = Math.min(lim[r1][i+1],min);

        		}
        		
              	answer[cnt-1] = min;
        	cnt++;
        }
        
        
        return answer;
    }

	private int[][] deepCloneLim(int[][] lim) {
		int[][] clone = new int[lim.length][lim[0].length];
		
		for(int i=0; i<lim.length; i++) {
			for(int j=0; j<lim[0].length; j++) {
				clone[i][j] = lim[i][j];
			}
		}
	
		return clone;
	}

	private void showElemenets(int[][] lim) {
		for(int i=0; i<lim.length; i++) {
			StringBuilder builder = new StringBuilder();
        	for(int j=0; j<lim[0].length; j++) {
        		builder.append(lim[i][j]);
        	}
        }
	}

	private int[][] makeLim(int rows, int columns) {
		int cnt = 0;
        
        int[][] lim = new int[rows][columns];
        
        for(int i=0; i<rows; i++) {
        	for(int j=0; j<columns; j++) {
        		lim[i][j] = ++cnt;
        	}
        }
		return lim;
	}
}