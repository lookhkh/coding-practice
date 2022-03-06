package codingtest;

public class 가장작은지갑 {
 
	public static void main(String[] args) {
		Solutionaa sol = new Solutionaa();
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		sol.solution(sizes);
	}
}

class Solutionaa {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = Integer.MIN_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        
        for(int[] size : sizes) {
        	if(size[0]<size[1]) {
        		convert(size);
        	}
        	maxWidth = Math.max(maxWidth, size[0]);
        	maxHeight = Math.max(maxHeight, size[1]);
        }
     
        return maxWidth*maxHeight;
    }
    
    public void convert(int[] target) {
    	int[] res = new int[2];
    	
    	res[0] = target[1];
    	res[1] = target[0];
    	
    	target[0] = res[0];
    	target[1] = res[1];
    	
    }
}


