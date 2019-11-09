package com.nvn.markerinerface;

public class TestRunner {

	public static void main(String[] args) {
		
		Myclass myobj = new Myclass();
		
		if(myobj instanceof Myinterface) {
			myobj.show();
		}else {
			System.out.println("you don't have a previliges..");
		}

	}

}
class Myclass implements Myinterface{
	
	void show () {
		System.out.println("Yes you have access previlege to this method ...");
	}
}
