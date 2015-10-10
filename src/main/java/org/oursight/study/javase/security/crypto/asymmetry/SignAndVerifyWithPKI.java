package org.oursight.study.javase.security.crypto.asymmetry;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

/**
 * The illustration code of using java pki infrastrature to sign and verify.
 * @author yaonengjun
 *
 */
public class SignAndVerifyWithPKI {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, Exception {
//		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
		
//		SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		keyGen.initialize(1024);
		
		// Create public and private Key
		KeyPair keyPair = keyGen.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();
		System.out.println("publicKey: " + publicKey);
		System.out.println("privateKey: " + privateKey);
		System.out.println();
		
		// create a signature 
		Signature signature = Signature.getInstance("SHA1withDSA");
		signature.initSign(privateKey);
		byte[] signedBytes = signature.sign();
//		String signedString = SecurityUtil.byteArrayToHex(signedBytes);
		String signedString = new String(signedBytes);
		System.out.println("signedString: " + signedString); // 不可读字符
		System.out.println();
		
		// verify the signature
		signature.initVerify(publicKey);
		boolean isValid = signature.verify(signedBytes);
		System.out.println("isValid: " + isValid);
		System.out.println();
    }

}
