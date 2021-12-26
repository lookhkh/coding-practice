package dataStructure;

import java.util.LinkedList;
import java.util.List;

public class LinkedListImp {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(null);
		
	}
	
	class Node<E>{
		
		private int data;
		private Node<E> next;
		public Node(int data, Node<E> next) {
			super();
			this.data = data;
			this.next = next;
		}
		
		public Node<E> getNext() {
			return next;
		}
		public void setNext(Node<E> next) {
			this.next = next;
		}

		
		
	}
	
}
