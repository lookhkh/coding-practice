package codingtest;

import java.util.Arrays;

public class Book {

	public static void main(String[] args) {
		String[] books = {"123","12","1235","567","88"};
		System.out.println(solution(books));
	}
	
	public static boolean solution(String[] book) {
        Arrays.sort(book);
        
        for(int i=0; i<book.length-1; i++) {
        	String target = book[i];
        	String next = book[i+1];
        	
        	if(!(target.length()>next.length())) {
        		int targetHash = target.hashCode();
        		int nextHash = next.substring(0, target.length()).hashCode();
        		
        		if(targetHash == nextHash) {
        			return false;
        		}
        		
        	}
        }
        
        return true;
    }
}
