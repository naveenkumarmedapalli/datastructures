package com.nvn.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student {

	public static void main(String[] args) {

		try {

			/*
			 * on which order we have serialized on the same order need to deserialized.
			 */
			System.out.println("serialization starting....");
			FileOutputStream fileOutputStream = new FileOutputStream("G:\\serializblefiles\\mymarks.txt");

			Marks marks = new Marks();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(marks);

			objectOutputStream.close();
			System.out.println("serialization ending....");

			System.out.println("deserialization starting....");
			FileInputStream fileInputStream = new FileInputStream("G:\\serializblefiles\\mymarks.txt");

			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			Marks mymarks = (Marks) objectInputStream.readObject();

			System.out.println(mymarks);
			objectInputStream.close();
			System.out.println("deserialization ending....");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class Marks implements Serializable {
	/*
	 * if you are not implemented this with Serializable Interface you will get
	 * NotSerialzable Exception will get
	 * 
	 * if you are not specified serialVersionUID then JVM will generate this id.
	 * based on this serialVersionUID, while deserialising it will check this object
	 * belongs to this class or not
	 * 
	 */
	private static final long serialVersionUID = -2670991590692797763L;
	transient int maths = 99;
	int physics = 80;
	int chemistry = 70;

	@Override
	public String toString() {
		return "Marks [maths=" + maths + ", physics=" + physics + ", chemistry=" + chemistry + "]";
	}
}
