package com.nvn.testscases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

	public static void main(String[] args) {
		ArrayList list = new ArrayList<>();
		
		CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList<>();
		
		
		copyOnWriteArrayList.add(5);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);
		
		
		ReentrantLock lock = new ReentrantLock();
		
		lock.lock();
		lock.unlock();
		Iterator iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			list.add(6);
		}
		

	}

}
