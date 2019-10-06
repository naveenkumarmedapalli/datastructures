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
	 
	}
}
