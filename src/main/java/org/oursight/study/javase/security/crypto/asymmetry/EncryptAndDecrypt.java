package org.oursight.study.javase.security.crypto.asymmetry;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import org.oursight.study.javase.security.SecurityUtil;

public class EncryptAndDecrypt {

	public static final String KEY_ALGORITHM = "RSA";
	public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

	private static final String PUBLIC_KEY = "RSAPublicKey";
	private static final String PRIVATE_KEY = "RSAPrivateKey";

	public static void main(String[] args) throws Exception {
		String plainText = "11111111";

		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		// SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
		keyGen.initialize(1024);
		// Create public and private Key
		KeyPair keyPair = keyGen.generateKeyPair();
		PublicKey publicKey = keyPair.getPublic();
		PrivateKey privateKey = keyPair.getPrivate();

		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] resultBytes = cipher.doFinal(plainText.getBytes());
		String result = SecurityUtil.byteArrayToHex(resultBytes);
		System.out.println("encrypted result: " + result);
		
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		byte[] decryptedResult = cipher.doFinal(resultBytes);
		System.out.println("decrypted result: " + new String(decryptedResult));
		
	}

}
