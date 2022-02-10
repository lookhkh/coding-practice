package codingInterview;

public class Chapter1 {
	
	public static void main(String[] args) {
		int test = 5;
		System.out.println(Integer.toBinaryString(test));
		System.out.println(test);
		System.out.println(Integer.toBinaryString(~test));
		System.out.println(~test);
		System.out.println(Integer.toBinaryString(~test+1));
		System.out.println(0^test&1);
	}
}
