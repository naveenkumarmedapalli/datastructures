package com.nvn.serialization.inheritance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AnimalC2P {
	int legs = 4;
	int tail = 1;
	String barking = "barking";
	
	// if parent class is inherited from chaild class and child class is serializable then must need no-arg constructor.
	// either user defained no-arg constructor or compiler generated no-arg constructor
	//other wise you will get InValidClsaaException
	public AnimalC2P() {
		
		
	}


	public static void main(String[] args) {

		try {
			FileOutputStream fos = new FileOutputStream("G:\\serializblefiles\\dogc.txt");

			try {
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				DogC serdog = new DogC();

				serdog.legs = 6;
				serdog.tail = 2;

				/*
				 * if parent class is not serializable then default values are stored in a file.
				 * again while deserializing through the instance control flow parent class
				 * values are assigned back to deserilized Object
				 */

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
			FileInputStream fis = new FileInputStream("G:\\serializblefiles\\dogc.txt");

			try {
				ObjectInputStream ois = new ObjectInputStream(fis);

				try {
					DogC desdog = (DogC) ois.readObject();

					System.out.println(desdog.legs + ":::" + desdog.tail + " :::: " + desdog.barking);
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

class DogC extends AnimalC2P implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3062724816504022856L;

	String barking = "bow meam";
}
