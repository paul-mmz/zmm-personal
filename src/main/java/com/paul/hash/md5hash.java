package com.paul.hash;

import org.apache.commons.codec.digest.DigestUtils;

public class md5hash {
	public static void main(String[] args) {
		String before = "jcksldsl";
		String after1;
		String after2;

		after1 = DigestUtils.md5Hex(before);
		after2 = DigestUtils.md5Hex(before);
		System.out.println(after1 + ", " + after2);
		System.out.println(after1.equals(after2));

	}
}
