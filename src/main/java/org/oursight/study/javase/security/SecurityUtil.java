package org.oursight.study.javase.security;

public class SecurityUtil {

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

	// private static final char[] DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
	// 'f' };
	//
	// public final static String bytesToHex(byte[] byteArray) {
	// char[] out = new char[byteArray.length * 2];
	// int off = 0;
	// for (int i = 0, j = 0; i < byteArray.length; i++) {
	// int a = byteArray[off++];
	//
	// out[j++] = DIGITS[(a >>> 4) & 0X0F];
	// out[j++] = DIGITS[a & 0X0F];
	// }
	// return (new String(out));
	// }
	//
	// public static byte[] hexToBytes(String str) {
	// if (str == null) {
	// return null;
	// }
	// char[] data = str.toCharArray();
	// int len = data.length;
	//
	// if ((len & 0x01) != 0) {
	// throw new RuntimeException("Odd number of characters!");
	// }
	//
	// byte[] out = new byte[len >> 1];
	//
	// // two characters form the hex value.
	// for (int i = 0, j = 0; j < len; i++) {
	// int f = toDigit(data[j], j) << 4;
	// j++;
	// f = f | toDigit(data[j], j);
	// j++;
	// out[i] = (byte) (f & 0xFF);
	// }
	//
	// return out;
	// }
	//
	// private static int toDigit(char ch, int index) {
	// int digit = Character.digit(ch, 16);
	// if (digit == -1) {
	// throw new RuntimeException("Illegal hexadecimal charcter " + ch + " at index " + index);
	// }
	// return digit;
	// }
	//
	// public static void main(String[] args) {
	// String s = "111111111111111";
	// String hex = bytesToHex(s.getBytes());
	// byte[] bytes = hexToBytes(hex);
	// System.out.println(bytes.equals(s.getBytes()));
	// }

}
