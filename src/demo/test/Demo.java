package demo.test;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Demo {
	
	public static void main(String args[]) throws NoSuchAlgorithmException
	{
		KeyGenerator gen = KeyGenerator.getInstance("AES");
        gen.init(256);
        /* 128-bit AES */
        SecretKey secret = gen.generateKey();
        String appKey = Base64.getEncoder().encodeToString(secret.getEncoded());
        System.out.println(appKey.length());
	}
}
