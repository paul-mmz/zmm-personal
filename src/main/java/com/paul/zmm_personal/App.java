package com.paul.zmm_personal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class App {

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
