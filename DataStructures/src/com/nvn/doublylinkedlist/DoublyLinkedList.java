/**
 * A doubly linked list implementation.
 *
 * @author Naveen, naveenkumarmedapalli@gmail.com
 */
package com.nvn.doublylinkedlist;

public class DoublyLinkedList {

	private Node head;
	private Node tail;
	private int size;

	public void insert(int data) {
		Node node = new Node();
		node.data = data;
		node.prev = null;
		node.next = null;

		if (head == null) {
			head = tail = node;
		} else {
			node.prev = tail;
			tail.next = node;
			tail = tail.next;
		}
		size++;
	}

	public void show() {
		Node n = head;
		while (n != null) {
			System.out.print(n.data + " --> ");
			n = n.next;
		}
		System.out.println("null");
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		Node n = head;
		while (n != null) {
			Node temp = n.next;
			n.prev = n.next = null;
			n.data = 0;
			n = temp;
		}
		head = tail = n = null;
		size = 0;
	}

	public void insertAtStart(int data) {
		Node node = new Node();
		node.data = data;
		node.prev = null;
		node.next = null;
		if (head == null) {
			head = node;
		} else {
			head.prev = node;
			node.next = head;
			head = node;
			size++;
		}
	}

	public int peekFirst() {
		if (isEmpty())
			throw new RuntimeException(
					"You idot..without inserting element into list how you will get data..? Please insert elememt into list ");
		return head.data;
	}

	public int peekLast() {
		if (isEmpty())
			throw new RuntimeException("Empty list");
		return tail.data;
	}
	

}
