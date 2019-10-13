package com.nvn.priorityqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class PriorityQueue<T extends Comparable<T>> {

	private int heapSize = 0;
	private int heapCapacity = 0;
	private List heap = null;
	private Map<T,TreeSet<Integer>> map = new HashMap<>();
	
	public PriorityQueue() {
		this(1);
	}

	public PriorityQueue(int size) {
		heap = new ArrayList<>(size);
	}
	
	//https://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
}
