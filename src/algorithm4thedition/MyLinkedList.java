package algorithm4thedition;

import java.util.Iterator;

public class MyLinkedList {
	Node first = null;
	int N = 0;
	int pos = 0;

	private class Node {
		int item;
		Node next;
		public Node(int i) {
			item = i;
		}
	}

	public void insertFirst(int a) {
		Node oldfirst = first;
		first = new Node(a);
		first.next = oldfirst;
		N++;
	}

	public Node extractFirst() {
		Node temp = first;
		first = first.next;
		N--;
		return temp;

	}

	public void insert(int index, int item) {
		if (index == 0) {
			insertFirst(item);
		}

		Node current = first;
		Node early = first;
		while (pos < index - 1) {
			current = current.next;
			early = early.next;
			pos++;
		}
		current = current.next;

		Node temp = new Node(item);
		early.next = temp;
		temp.next = current;
		N++;
		pos = 0;

	}

	public void insert(int item) {
		if (N == 0) {
			insertFirst(item);
			return;
		}
		Node current = first;
		while (pos < N - 1) {
			current = current.next;
			pos++;
		}
		Node temp = new Node(item);
		current.next = temp;
		N++;
		pos = 0;

	}

	public Node extract() {
		if (N == 0)
			return null;
		Node current = first;
		while (pos < N - 1) {
			current = current.next;
			pos++;
		}
		current.next = null;
		pos = 0;
		N--;
		return current;

	}

	public Node extract(int index) {
		if (index == 0)
			return extractFirst();
		Node current = first;
		Node early = first;
		while (pos < index - 1) {
			current = current.next;
			early = early.next;
			pos++;
		}
		current = current.next;
		early.next = current.next;
		N--;
		pos = 0;
		return current;
	}

	public void display() {
		for (Node x = first; x != null; x = x.next) {
			System.out.println(x.item);
		}
	}
	
	public Iterator iterator(){
		return new ListIterator();
		
	}
	private class ListIterator implements Iterator{
		private Node current=first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			
			return current!=null;
		}

		@Override
		public Object next() {
			// TODO Auto-generated method stub
			int item=current.item;
			current=current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
		
	}

	public static void main(String[] args) {
		MyLinkedList on = new MyLinkedList();
		on.insert(1);
		on.insert(2);
		on.insert(3);
		on.insert(4);
		on.extract(1);
		on.display();
	}
}
