package com.paul.hash;

import org.apache.commons.codec.digest.DigestUtils;

public class md5hash {

	public static void hashPush() {
		String account = "account" + "sltest1094@163.com";
		String app_key = "app_key" + "88b960d60bd74684940a65bea408462e";
		String chatStatus = "chatStatus" + "0";
		String content = "content" + "再推一次，没有客服前缀+4";
		String sign_method = "sign_method" + "md5";
		String timestamp = "timestamp" + "2017-01-06 20:21:30";
		String type = "type" + "4";
		String url = "url"
				+ "http://www.kaola.com/custom/redirectH5.html?target=http%3A%2F%2Fim2.gm.163.com%2Fkaolaapp.action%3Fcode%3D123";
		String v = "v" + "1.0";

		String secretKey = "99a76459ef304fd0b08c8711c5f5988d";

		StringBuilder sb = new StringBuilder();
		sb = sb.append(secretKey).append(account).append(app_key).append(chatStatus).append(content).append(sign_method)
				.append(timestamp).append(type).append(url).append(v).append(secretKey);

		String hashBefore = sb.toString();

		String hashAfter = null;

		hashAfter = DigestUtils.md5Hex(hashBefore);

		System.out.println(hashAfter);

		System.out.println(hashAfter.toUpperCase());

	}

	public static void hashQueue() {
		String app_key = "app_key" + "88b960d60bd74684940a65bea408462e";
		String sign_method = "sign_method" + "md5";
		String timestamp = "timestamp" + "2017-01-06 12:27:30";
		String v = "v" + "1.0";

		String secretKey = "99a76459ef304fd0b08c8711c5f5988d";

		StringBuilder content = new StringBuilder("{\"users\":[{\"no\":1,\"account\":\"sltest1094@163.com\"}]}");

		StringBuilder sb = new StringBuilder();
		sb = sb.append(secretKey).append(app_key).append(sign_method).append(timestamp).append(v).append(secretKey);

		String hashBefore = sb.toString();

		String hashAfter = null;

		hashAfter = DigestUtils.md5Hex(hashBefore);

		System.out.println(hashAfter);

		System.out.println(hashAfter.toUpperCase());
	}
	
	public static void hashOff(){
		String account = "account" + "sltest1094@163.com";
		String app_key = "app_key" + "88b960d60bd74684940a65bea408462e";
		String sign_method = "sign_method" + "md5";
		String timestamp = "timestamp" + "2017-01-06 20:22:30";
		String v = "v" + "1.0";

		String secretKey = "99a76459ef304fd0b08c8711c5f5988d";

		StringBuilder sb = new StringBuilder();
		sb = sb.append(secretKey).append(account).append(app_key).append(sign_method).append(timestamp).append(v).append(secretKey);

		String hashBefore = sb.toString();

		String hashAfter = null;

		hashAfter = DigestUtils.md5Hex(hashBefore);

		System.out.println(hashAfter);

		System.out.println(hashAfter.toUpperCase());
	}

	public static void main(String[] args) {
		hashPush();
		hashQueue();
		hashOff();
	}
}
