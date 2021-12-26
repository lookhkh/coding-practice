package dataStructure;

/*
 * 
 * 최근 검색 5개만 남기는
 * 링버퍼 만들기
 * 
 * */
public class Queue {

	
	public static void main(String[] args) {
		Queue que = new Queue(15);
		for(int i=0; i<100; i++) {
			que.enque(i+" 번째");
		}
		
		String[] history = que.showLast5SearchHistory();
		for(String his:history) {
			System.out.println(his);
		}
	}
	
	private int capacity;
	private int pointer;
	private String[] table;
	
	public Queue(int capacity) {
		super();
		this.pointer=0;
		this.capacity = capacity;
		table = new String[capacity];
	}
	
	public String enque(String element) {
		table[(pointer++)%capacity] = element;
		
		return element;
	}
	
	public String[] showLast5SearchHistory() {
		return table;
	}
}
