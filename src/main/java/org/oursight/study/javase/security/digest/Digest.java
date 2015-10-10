package org.oursight.study.javase.security.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.oursight.study.javase.security.SecurityUtil;

public class Digest {

	public static String digest(String algorithm, String origin) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}

		byte[] bytes = digest.digest(origin.getBytes());
		return SecurityUtil.byteArrayToHex(bytes);

	}
	

	public static String digest(String algorithm, String... origin) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}

		for (int i = 0; i < origin.length; i++) {
	        String string = origin[i];
	        digest.update(string.getBytes());
        }
		byte[] bytes = digest.digest();
		return SecurityUtil.byteArrayToHex(bytes);

	}


	
	public static void main(String[] args) {
		String origin = "1111";
	    System.out.println("MD5: "+ digest("MD5",origin));
	    System.out.println("MD5: "+ digest("MD5","11","11")); //二者的签名是一样的
//	    System.out.println("SHA: "+ digest("SHA",origin));
//	    System.out.println("SHA-256: "+ digest("SHA-256",origin));
//	    System.out.println("SHA-384: "+ digest("SHA-384",origin));
//	    System.out.println("SHA-512: "+ digest("SHA-512",origin));
	    
    }

}
