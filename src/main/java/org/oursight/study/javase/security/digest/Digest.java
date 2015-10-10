package org.oursight.study.javase.security.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {

	public static String digest(String origin, String algorithm) {
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e.getMessage());
		}

		byte[] bytes = digest.digest(origin.getBytes());
		return byteArrayToHex(bytes);

	}

	public static String byteArrayToHex(byte[] byteArray) {
		// 首先初始化一个字符数组，用来存放每个16进制字符
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
		char[] resultCharArray = new char[byteArray.length * 2];

		// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}

		// 字符数组组合成字符串返回
		return new String(resultCharArray);

	}
	
	public static void main(String[] args) {
		String origin = "1111";
	    System.out.println("MD5: "+ digest(origin,"MD5"));
	    System.out.println("SHA: "+ digest(origin,"SHA"));
	    System.out.println("SHA-256: "+ digest(origin,"SHA-256"));
	    System.out.println("SHA-384: "+ digest(origin,"SHA-384"));
	    System.out.println("SHA-512: "+ digest(origin,"SHA-512"));
    }

}
