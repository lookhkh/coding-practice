package programmersLevel2;

public class ¾ç±Ã {

	public static void main(String[] args) {
		Solution0001 sol = new Solution0001();
		int n = 5;
		int[] info = {2,1,1,1,0,0,0,0,0,0,0};
		
		sol.solution(n, info);
	}
}

class Solution0001 {
    public int[] solution(int n, int[] info) {
        int[] answer = {};
        
        
        dfs(n, info, 0, 0, new boolean[info.length]);
        
        return answer;
    }

	private void dfs(int restOfArrows, int[] apachsInfo, int totalForApache, int totalForRyan, boolean[] ck) {
		StringBuilder builder = new StringBuilder();
		
		for(boolean c : ck) {
			builder.append(c);
		}
		
		System.out.println(restOfArrows+" "+builder.toString());
		
	
		
		if(restOfArrows==0) {
			System.out.println("ÀÜ¿© È­»ì : "+restOfArrows);

			int apache = 0;
			int ryan = 0;
			
			for(int i=0; i<ck.length; i++) {
				if(ck[i]) {
					ryan+=10-i;
				}else if(!ck[i] && apachsInfo[i]>0){
					apache+=10-i;
				}
			}
			
			if(ryan>apache) {
				System.out.println(apache+"   "+ ryan);
			}
			System.out.println(apache+"   "+ ryan);


			return;
		}
		
		for(int i=0; i<apachsInfo.length; i++) {
			if(!ck[i] && restOfArrows>=apachsInfo[i]+1) {
				System.out.println(i+" ¹øÂ°");
				ck[i] = true;
				dfs(restOfArrows -(apachsInfo[i]+1), apachsInfo, 0, 0, ck );
				//ck[i] = false;

				
			}
		}

		
	}
    
    
}