package com.nvn.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Extranalization {

	
	public static void main(String[] args) {
		try {

			/*
			 * on which order we have serialized on the same order need to deserialized.
			 */
			System.out.println("serialization starting....");
			FileOutputStream fileOutputStream = new FileOutputStream("G:\\serializblefiles\\extmarks.txt");

			Account account = new Account();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(account);

			objectOutputStream.close();
			System.out.println("serialization ending....");

			System.out.println("deserialization starting....");
			FileInputStream fileInputStream = new FileInputStream("G:\\serializblefiles\\extmarks.txt");

			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			Account desaccount = (Account) objectInputStream.readObject();

			System.out.println(desaccount);
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

class Account implements Externalizable {
	
	String accountid = "12345987";
	String name = "naveen";
	String pannumber = "BMPPM0880A";
	
	// for Extranalization default construcor is mandatory
		public Account() {

		}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(accountid);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		accountid = (String)in.readObject();
	}
}