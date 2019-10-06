package com.nvn.stack;

public class StackRunner {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		System.out.println(stack.isEmpty());
		stack.push(6);
		System.out.println(stack.isEmpty());
		stack.pop();
		System.out.println(stack.isEmpty());
		stack.push(2);
		stack.push("nanveen");
		stack.push("9");
		
		
		System.out.println(stack.pop());
		
		stack.show();
		
		System.out.println(stack.size());

	}

}
