package dataStructure;

import java.util.Comparator;

public class Stack<T> {
	
	public static void main(String[] args) {
	
		try {
		Stack<Integer> stack = new Stack<>(5);
		System.out.println(stack.push(2));
		System.out.println(stack.push(5));
		System.out.println(stack.indexOf(5));

		}catch(IllegalStateException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private int capacity;
	private int pointer;
	private T[] table;
	
	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		this.capacity=capacity;
		this.pointer = 0;
		table = (T[])new Object[capacity];
	}
	/**
	 * push 후 포인터 값 리턴
	 * return pointer
	 */
	public synchronized int push(T t) throws IllegalStateException {
		if(this.pointer>this.capacity-1) throw new IllegalStateException("out of stack");
		table[pointer] = t;
		return this.pointer++;
	}
	
	public synchronized T pop() throws IllegalStateException {
		
		if(pointer<=0) throw new IllegalStateException("stack is empty");
		--pointer;
		T target = table[pointer];
		table[pointer] = null;
		return target;
	}
	
	public synchronized int indexOf(T t) {
		for(int i=0; i<table.length; i++) {
			if(t.equals(table[i])) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	
}
