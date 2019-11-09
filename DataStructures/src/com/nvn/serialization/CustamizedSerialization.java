package com.nvn.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CustamizedSerialization {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileOutputStream fileOutputStream = new FileOutputStream("G:\\serializblefiles\\mail.txt");

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		MailInfo seinfo = new MailInfo();
		System.out.println(seinfo);
		objectOutputStream.writeObject(seinfo);
		objectOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream("G:\\serializblefiles\\mail.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		MailInfo deseinfo = (MailInfo) objectInputStream.readObject();
		System.out.println(deseinfo);
		objectInputStream.close();
	}

}

class MailInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5125784945428104825L;
	String domain = "gmail";
	String mailid = "naveenkumarmedapalli@gmail.com";
	transient String password = "worksmart";
	
	/**
	 * The writeObject(ObjectOutputStream objectOutputStream) is the call back method.
	 *  when objectOutputStream.writeObject(seinfo) method called at the time the below method is defined then its called.
	 * */  
	private void writeObject(ObjectOutputStream objectOutputStream) throws Exception {
		System.out.println("call back method is calling...");
		objectOutputStream.defaultWriteObject();
		char[] passwordarray = this.password.toCharArray();
		StringBuffer encryptedpassword = new StringBuffer();
		for (char ch : passwordarray) {
			encryptedpassword.append(ch + "#6#7#");
		}
		objectOutputStream.writeObject(encryptedpassword.toString());
	}

	private void readObject(ObjectInputStream objectInputStream) throws Exception {
		objectInputStream.defaultReadObject();
		String encryptedpassword = (String) objectInputStream.readObject();
		String[] passwordarr = encryptedpassword.split("#6#7#");

		StringBuffer passwordb = new StringBuffer();
		for (String s : passwordarr) {
			passwordb.append(s);
		}

		password = passwordb.toString();
		System.out.println("original password ::: " + password);
	}

	@Override
	public String toString() {
		return "MailInfo [domain=" + domain + ", mailid=" + mailid + ", password=" + password + "]";
	}

}
