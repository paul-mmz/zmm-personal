package com.paul.zmm_personal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.netease.haitao.core.util.encrypt.DBEncryptUtil;

public class App {
	private static final String BATCHQUERY_FREQUENCY_CHECK_KEY_PREFIX = "batchQuery_frequency-";

	public static void main(String[] args) {
		System.out.println("Hello World");

		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);

		Date date = new Date();
		System.out.println(date.toString());

		Calendar c = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		System.out.println(format.format(date));

		String key = BATCHQUERY_FREQUENCY_CHECK_KEY_PREFIX + format.format(new Date());
		System.out.println(key);

		System.out.println("hah");
		System.out.println(DBEncryptUtil.decrypt("a#{160329_ee865e037d6476a97a89c010009cda3c"));
		System.out.println(DBEncryptUtil.encrypt("13606636350"));
		System.out.println(DBEncryptUtil.genMD5withSalt("13606636350"));
		
		System.out.println(DBEncryptUtil.encrypt("15105197523"));
		System.out.println(DBEncryptUtil.genMD5withSalt("15105197523"));
	}

}
