package test;

public class 게임2x2 {
	
	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		int m = 6;
		int n = 6;
		String[] board= {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		
		
		sol.solution(m, n, board);
	}
}

class Solution5 {
    public int solution(int m, int n, String[] board) {
    	int answer = 0;
    	boolean[][] map = new boolean[board.length][board[0].length()];
        while(true) {
        
            
        	
	        for(int i=0; i<board.length; i++) {
	        	for(int j=0; j<board[i].length(); j++) {
	        		System.out.println(i+" row "+j+" col "+ board[i].charAt(j));
	        		boolean[] q = checkIfQuaterIsDestroyable(board, i, j, map);      
	        		for(boolean ans : q) {
	        			System.out.println(ans);
	        		}
	        		System.out.println(i+" row "+j+" col "+ board[i].charAt(j));	        		
	        	}
	        }
    		answer += destroyBlock(board, i,j, q);
	        //rearrangeBoard(board);
	        
	        if(answer == 0) {
	        	break;
	        }
        }
        
        return answer;
    }

	private boolean[] checkIfQuaterIsDestroyable(String[] board, int i, int j, boolean[][] map) {
			boolean[] result = new boolean[4];
			char target = board[i].charAt(j);
		
		//1방향
			if(i-1<board.length && i-1>=0 && j-1>=0 &&j-1< board[i].length()) {
				result[0] = target==board[i].charAt(j-1)
							&& target==board[i-1].charAt(j)
							&& target==board[i-1].charAt(j-1);
				
				if(result[0]) {
					map[i][j] = true;
					map[i][j-1] = true;
					map[i-1][j] = true;
					map[i-1][j-1] = true;
				}
				
			}
		//2방향
			if(i-1<board.length && i-1>=0 && j+1>=0 &&j+1< board[i].length()) {
				result[1] = target == board[i].charAt(j+1)
						 && target == board[i-1].charAt(j)
						 && target == board[i-1].charAt(j+1);
				
				if(result[1]) {
					map[i][j] = true;
					map[i][j+1] = true;
					map[i-1][j] = true;
					map[i-1][j+1] = true;
				}
			}
		//3방향
			if(i+1<board.length && i+1>=0 && j+1>=0 &&j+1< board[i].length()) {
				result[2] = target == board[i].charAt(j+1)
						 && target == board[i+1].charAt(j)
						 && target == board[i+1].charAt(j+1);
				
				if(result[2]) {
					map[i][j] = true;
					map[i][j+1] = true;
					map[i-1][j] = true;
					map[i-1][j+1] = true;
				}
			}
		//4방향
			if(i+1<board.length && i+1>=0 && j-1>=0 &&j-1< board[i].length()) {
				result[3] = target == board[i].charAt(j-1)
						 && target == board[i+1].charAt(j-1)
						 && target == board[i+1].charAt(j);
			}
			
			
			
		
		//2방향
		//3방향
		//4방향

		return result;
	}
}