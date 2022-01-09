package codingtest;

public class Tournament {

	public static void main(String[] args) {
		Solution5 sol = new Solution5();
		int n = 8;
		int a = 4;
		int b = 7;
		
		System.out.println(sol.solution(n, a, b));
	}
	
	
}

class Solution5
{
    public int solution(int n, int a, int b)
    {
        int round = 1;
        
        if(b<a) {
        	int temp = a;
        	a = b;
        	b = temp;
        }
        
        int rountOfa = a%2==0?a/2:a/2+1;
        int rountOfb = b%2==0?b/2:b/2+1;
        
        while(n != 1) {
        	
        	
        	if(rountOfa == rountOfb ) {
        		break;
        	}
        	else {
        		n = n/2;
        		
        		rountOfa = rountOfa%2==0?rountOfa/2:rountOfa/2+1;
        		rountOfb = rountOfb%2==0?rountOfb/2:rountOfb/2+1;
        	
        		
        		round++;
        	}
        }
   
        
        
        return round;
    }
}
