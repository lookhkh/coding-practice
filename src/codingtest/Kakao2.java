package codingtest;

import java.util.ArrayList;
import java.util.List;

public class Kakao2 {
	
		public static void main(String[] args) {
			int[] arg = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};	
			List<List<Object>> board = generateBoard();
			solution1(arg,"left");
	   
		}
		
		 public static String solution1(int[] numbers, String hand) {
		        String answer = "";
				List<List<Object>> board = generateBoard();
				int[] left = {3,0}; //처음 왼손 위치
				int[] right = {3,2}; //처음 오른손 위치
				int[] current;
								
				for(int num : numbers) {
					for(int i=0; i<board.size(); i++) {
						if(board.get(i).contains(num)) {
							
							int y = board.get(i).indexOf(num);
							current = new int[] {i,y};
							
							if(num==1 || num == 4 || num ==7) {
								left = current;
								answer+="L";
								
							}else if(num!=0&&num%3==0) {
								right = current;
								answer+="R";
								
							}else {
								double leftDistance = getDis(left[0],left[1],current[0],current[1]);
								double rightDistance = getDis(right[0],right[1],current[0],current[1]);
								if(leftDistance<rightDistance) {
									left = current;
									answer+="L";

								}else if(leftDistance>rightDistance) {
									right = current;
									answer+="R";
								}else {
									if(hand.equals("right")) {
										right = current;
										answer+="R";

									}else {
										left = current;
										answer+="L";

									}
								}
					
							}
							
							
						}
					}
				}
				
		        return answer;
		    }

		private static List<List<Object>> generateBoard() {
			List<List<Object>> board = new ArrayList<>();
			List<Object> temp = new ArrayList<>();
	        
	        for(int i=1; i<=9; i++) {
	        	temp.add(i);
	        	if(i%3==0) {
	        		board.add(temp);
	        		temp = new ArrayList<>();
	        	}
	        }
	        
	        temp = new ArrayList<>();
	        temp.add("*");
	        temp.add(0);
	        temp.add("#");
	        
	        board.add(temp);
	        
	        return board;
		}
		
		private static double getDis(int x, int y, int x1, int y1) {
			return Math.ceil(Math.sqrt(Math.pow(Math.abs(x1-x), 2) + Math.pow(Math.abs(y1-y), 2)));
			}
		}


