package com.nvn.queue;

public class QueueRunner {
	public static void main(String[] args) {
		
		Queue queue = new Queue();
		
		queue.enQueue(6);
		queue.enQueue(2);
		queue.enQueue(0);
		queue.enQueue(3);
		
		queue.deQueue();
		queue.deQueue();
		
		queue.enQueue(1);
		queue.enQueue(5);
		queue.enQueue(9);
		
		
		
		queue.show();
		
		System.out.println(queue.size());
	}
}
