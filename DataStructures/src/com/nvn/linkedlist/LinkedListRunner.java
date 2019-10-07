package com.nvn.linkedlist;

public class LinkedListRunner {

	public static void main(String[] args) {
		
		LinkedList list = new LinkedList();
		
		list.insert(6);
		list.insert(2);
		list.insert(8);
		list.insert(3);
		
		list.insertAtStart(9);
		
		list.insertAt(2, 1);
		list.show();
		
		
		java.util.LinkedList<Integer> l = new java.util.LinkedList<>();
		l.add(6);
		l.add(2);
		l.add(8);
		l.add(3);
		l.add(1);
		l.add(5);
		
		System.out.println(l);
		
		l.remove(0);
		System.out.println(l);
	 
	}
}
