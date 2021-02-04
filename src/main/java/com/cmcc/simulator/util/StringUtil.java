package com.cmcc.simulator.util;

public class StringUtil {

	public static String randomStr(int len) {
		if (len == 0) {
			return "";
		}
		int a = (int) (Math.random() * 3);
		if (a == 0) {
			return ((int) (Math.random() * 10)) + randomStr(len - 1);
		} else {
			return ((char) ((int) (Math.random() * 26) + 65)) + randomStr(len - 1);
		}
	}
	
//	public static void main(String[] args) {
//		System.out.println(randomStr(2));
//	}

}
