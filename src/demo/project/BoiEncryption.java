package demo.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

public class BoiEncryption {

	public static void main(String[] args) {
		String file_path = "\\\\192.168.1.250\\ict_share\\KSBCL\\KSBCL\\Accounting\\KTBL\\KNEFTTEST";
		boolean flag=false;
	    if (file_path == null || ("").equals(file_path)) {
	    	System.out.println("Incorrect file path");
		}
		    
	    try {
	    	File aesFile = new File(file_path+".TXTE");
	    	
	    	String key = "BoI!@#$4";
	    	int length = key.length();
	    	if ((length > 16) && (length != 16)) {
	    		key = key.substring(0, 15);
	    	}
	    	if ((length < 16) && (length != 16)) {
	    		for (int i = 0; i < 16 - length; i++) {
	    			key = key + "0";
	    		}
	    	}
	    	SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
	    	
	    	Cipher encrypt = Cipher.getInstance("AES/ECB/PKCS5Padding", "SunJCE");
	    	encrypt.init(Cipher.ENCRYPT_MODE, secretKey);
	    	try
	    	{
	    		FileInputStream fis = new FileInputStream(file_path+".txt");
	    		CipherInputStream cis = new CipherInputStream(fis, encrypt);
	    		
		        FileOutputStream fos = new FileOutputStream(aesFile);
		        byte[] b = new byte[8];
		        int i = cis.read(b);
		        while (i != -1) {
		          fos.write(b, 0, i);
		          i = cis.read(b);
		        }
		        fos.flush();
		        fos.close();
		        cis.close();
		        fis.close();
		        System.out.println("File encrypted Please Find the file: " + file_path);
		        flag =true;
	    	} catch (IOException err) {
		        System.out.println("Cannot open file!");
		        err.printStackTrace();
	    	}
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}

}
