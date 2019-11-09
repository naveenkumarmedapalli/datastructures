package com.nvn.serialization.inheritance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AnimalP2C implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int legs = 4;
	int tail = 1;
	String barking = "barking";

	public static void main(String[] args) {

		try {
			FileOutputStream fos = new FileOutputStream("G:\\serializblefiles\\dog.txt");

			try {
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				Dog serdog = new Dog();

				oos.writeObject(serdog);

				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream("G:\\serializblefiles\\dog.txt");

			try {
				ObjectInputStream ois = new ObjectInputStream(fis);

				try {
					Dog desdog = (Dog) ois.readObject();

					System.out.println(desdog.legs + ":::" + desdog.barking);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class Dog extends AnimalP2C{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8252482170680822755L;
	String barking = " bow bow";

}