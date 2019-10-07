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

	public int removeFirst() {
		if (isEmpty())
			throw new RuntimeException("Empty list");
		int data = head.data;
		head = head.next;
		head.prev = null;
		--size;
		if (isEmpty())
			tail = null;
		return data;
	}

	public int removeLast() {
		if (isEmpty())
			throw new RuntimeException("Empty list");
		int data = tail.data;
		tail = tail.prev;
		tail.next = null;
		--size;
		return data;
	}

	// private Node remove(Node node) {return new Node();}
	public void removeAt(int index) {

		if (index < 0 || index > size)
			throw new IllegalArgumentException();
		int i = 0;
		Node n;
		if (index < size / 2) {
			n = head;
			while (i != index) {
				n = n.next;
				i++;
			}
		} else {
			n = tail;
			while (i != index) {
				n = n.prev;
				i--;
			}
		}

		remove(n);

	}

	private int remove(Node n) {
		if (n.prev == null)
			return removeFirst();
		if (n.next == null)
			return removeLast();

		n.next.prev = n.prev;
		n.prev.next = n.next;

		int data = n.data;
		n.prev = n.next = n = null;
		--size;
		return data;
	}

	public int index(Object o) {
		int index = 0;
		Node n = head;
		if (o != null) {
			while (n != null) {
				o.equals(n.data);
				n = n.next;
				index++;
			}
			return index;
		}
		return -1;

	}

}
