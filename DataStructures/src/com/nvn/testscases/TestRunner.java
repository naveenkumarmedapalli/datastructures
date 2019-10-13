package com.nvn.testscases;

public class TestRunner {

	final int num= 10;
	public void disp() {
		int num = 12;
		Runnable r = new Runnable() {
			final int num =15;
			@Override
			public void run() {
				int num = 20;
				System.out.println(this.num);
				
			}
		};
		r.run();
	}
	public static void main(String[] args) {
		
		new TestRunner().disp();
	}
}
