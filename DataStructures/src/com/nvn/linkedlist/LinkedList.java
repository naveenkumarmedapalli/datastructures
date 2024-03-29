/**
 * A doubly linked list implementation.
 *
 * @author Naveen, naveenkumarmedapalli@gmail.com
 */
package com.nvn.linkedlist;

public class LinkedList {

	_Node head;
	int size;

	public void insert(int data) {

		_Node node = new _Node();

		node.data = data;
		node.next = null;

		if (head == null) {
			head = node;
		} else {
			_Node n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
		}
		size++;
	}

	public void show() {

		_Node n = head;

		while (n.next != null) {
			System.out.println(n.data);
			n = n.next;
		}

		System.out.println(n.data);
	}

	public void insertAtStart(int data) {

		_Node node = new _Node();
		node.data = data;
		node.next = null;
		node.next = head;
		head = node;
		size++;
	}

	public void insertAt(int index, int data) {

		_Node node = new _Node();
		node.data = data;
		node.next = null;
		if (index == 0) {
			insertAtStart(data);
		} else {
			_Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
		size++;
	}

	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			_Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			_Node n1 = n.next;
			n.next = n1.next;
			n1 = null;
		}
		--size;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		_Node n = head;
		while (n != null) {
			_Node temp = n.next;
			n.next = null;
			n.data = 0;
			n = temp;
		}
		head = n = null;
		size = 0;
	}

}

class Node {
	int data;
	_Node next;
}