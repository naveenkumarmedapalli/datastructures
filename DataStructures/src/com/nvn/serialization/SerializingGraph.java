package com.nvn.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializingGraph {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileOutputStream fileOutputStream = new FileOutputStream("G:\\serializblefiles\\mail.txt");

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		A a = new A();
		objectOutputStream.writeObject(a);
		objectOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream("G:\\serializblefiles\\mail.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

		A deser_a = (A) objectInputStream.readObject();
		System.out.println(deser_a);
		objectInputStream.close();

	}

}

class A implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4377975115793493762L;
	B b = new B();

	@Override
	public String toString() {
		return "A [b=" + b + "]";
	}

}

class B implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6611958463437727461L;
	/**
	 * 
	 */

	C c = new C();

	@Override
	public String toString() {
		return "B [c=" + c + "]";
	}

}

class C implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2873679241961488837L;
	String name = "naveenkumarmedapalli@gmail.com";

	@Override
	public String toString() {
		return "C [name=" + name + "]";
	}

}