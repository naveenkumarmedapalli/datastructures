package com.nvn.doublylinkedlist;

public class DoublyLinkedListRunner {

	public static void main(String[] args) {
		
		DoublyLinkedList list =new DoublyLinkedList();
		
		System.out.println(list.isEmpty());
		list.insert(6);
		System.out.println(list.isEmpty());
		list.insert(2);
		list.insert(8);
		System.out.println(list.peekFirst());
		list.insertAtStart(9);
		list.insertAtStart(11);
		list.show();
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		
		list.clear();
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		
		
		
	}
	
	
}
