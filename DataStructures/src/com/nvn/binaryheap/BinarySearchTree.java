package com.nvn.binaryheap;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Map;

public class BinarySearchTree {

	public static void main(String... args) {

		Map<String, String> scores = new HashMap<>();
		scores.put("naveen", "100");
		scores.put(new String("naveen"), "100");
		
		System.out.println(scores);
	
		IdentityHashMap<String, String> ihm = new IdentityHashMap<>();
//		
		ihm.put("naveen", "1");
		ihm.put(new String("naveen"), "2");
		ihm.put("naveen", "1666");
		System.out.println(ihm);
		//int i = System.identityHashCode(1);
		System.out.println(ihm);
	}
}
