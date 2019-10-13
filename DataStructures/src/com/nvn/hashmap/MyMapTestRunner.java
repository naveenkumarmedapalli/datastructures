package com.nvn.hashmap;

import java.util.HashMap;

public class MyMapTestRunner {

	public static void main(String[] args) {
		
		MyMap<String,String> m = new MyMap<>();
		m.put("naveen", "9492139550naveen");
		m.put("www", "9492139550www");
		m.put("eee", "9492139550eee");
		m.put("tttt", "9492139550tttt");
		m.put("rrrr", "9492139550rrrr");
		
//		m.show();
//		System.out.println(m.get("naveen"));
//		System.out.println(m.get("www"));
//		System.out.println(m.get("eee"));
//		System.out.println(m.get("tttt"));
//		System.out.println(m.get("rrrr"));
		System.out.println(m.size());
		
//		System.out.println(m.containsKey("rrrr"));
		
		System.out.println(m.remove("www"));
		System.out.println(m.size);
		m.show();
		System.out.println(m.containsKey("www"));
		
		HashMap mm = new HashMap<>();
		
		System.out.println(mm.remove("qq"));;
	}

}
