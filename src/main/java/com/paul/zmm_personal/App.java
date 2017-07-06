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
	}

}
