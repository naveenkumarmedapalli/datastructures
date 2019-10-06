package com.nvn.queue;

public class Queue {

	int front;
	int rear;
	int size;
	
	int[] queue = new int[5];

	public void enQueue(int data) {
		
		queue[rear] = data;
		rear = (rear+1) % 5;
		size ++;
	}

	public int deQueue() {
		int data = queue[front];
		front  = (front+1) % 5;
		size --;
		return data;
	}
	
	public void show() {
		for(int i=0;i<size;i++) {
			System.out.print(queue[(i+front)%5]+" ");
		}
		System.out.println();
		
//		for(int i=0;i<5;i++) {
//			System.out.print(queue[i]+" ");
//		}
		System.out.println();
	}
	public int size() {
		return size;
	}
}
