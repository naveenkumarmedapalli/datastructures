package com.nvn.stack;

public class Stack {

	int capacity = 2;
	Object[] stack = new Object[capacity];
	int top = 0;

	public void push(Object data) {
		if (top == capacity) {
			expand();
		}
		stack[top] = data;
		top++;
	}

	private void expand() {
		capacity = capacity * 2;
		Object[] _stack = new Object[capacity];
		System.arraycopy(stack, 0, _stack, 0, stack.length);
		stack = _stack;
	}

	public Object pop() {
		shirnk();
		int _top = --top;
		Object o = stack[_top];
		stack[_top] = null;
		return o;
	}

	private void shirnk() {
		int length = size();
		if (length <= (capacity / 2) / 2) {
			capacity = capacity / 2;
			Object[] _stack = new Object[capacity];
			System.arraycopy(stack, 0, _stack, 0, length);
			stack = _stack;
		}
	}

	public Object peek() {
		int _top = top;
		return stack[--_top];

	}

	public void show() {
		for (Object o : stack) {
			if (o != null)
				System.out.print(o + " ");
		}
		System.out.println();
	}

	public int size() {
		return top;
	}

	public boolean isEmpty() {
		return size() <= 0;
	}
}
