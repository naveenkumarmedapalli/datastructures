package com.nvn.linkedlist;

public class LinkedLst {
	public static void main(String[] args) {
		_LinkedList ll = new _LinkedList();
		ll.add(10);
		ll.add(2);
		ll.add("naveen");
		ll.add('a');
		ll.add(6);
		ll.add("kumar");
		ll.addFirst(6);
		ll.addLast(6);
		ll.add(5, 88);
		ll.show();
		System.out.println();
		System.out.println(ll.remove(5));
		System.out.println();

		ll.show();

	}
}

class _Node {
	Object data;
	_Node next;
}

class _LinkedList {

	_Node head;
	int size;

	public void show() {
		_Node n = head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}

	}

	public boolean add(Object data) {

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
		return true;
	}

	public boolean add(int index, Object data) {
		_Node node = new _Node();
		node.data = data;
		if (index == 0) {
			addFirst(data);
		} else {
			_Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next = node;
		}
		size++;
		return true;
	}

	public boolean addFirst(Object data) {
		_Node node = new _Node();
		node.data = data;
		node.next = head;
		head = node;
		size++;
		return true;
	}

	public boolean addLast(Object data) {
		return add(data);
	}

	public Object remove() {
		_Node n = head;
		Object o = n.data;
		n.data = null;
		head = n.next;
		n.next = null;
		return o;
	}

	public Object remove(int index) {
		Object o = null;
		if (index == 0)
			return remove();
		else {
			_Node n = head;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			_Node n1 = n.next;
			n.next = n1.next;
			o = n1.data;
			n1 = null;
		}
		return o;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void clear() {
		_Node n = head;
		while (n != null) {
			_Node temp = n.next;
			n.data = null;
			n.next = null;
			n = temp;
		}
		head = n = null;
		size = 0;
	}

}
