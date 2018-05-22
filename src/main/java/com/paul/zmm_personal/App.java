package com.paul.zmm_personal;

import com.paul.util.DateUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {

	public static final BigDecimal cc = new BigDecimal(3);

	private Boolean b;

	public Boolean getB() {
		return b;
	}

	public void setB(Boolean b) {
		this.b = b;
	}

	public static void main(String[] args) {

//		Long today = Long.parseLong(DateUtils.format(System.currentTimeMillis(), DateUtils.format6));
//		System.out.println(today);
//
//		String statisticsDay = String.valueOf(today - 1);
//		Date startTime = DateUtils.parse(statisticsDay + "000000");
//		Date endTime = DateUtils.parse(statisticsDay + "235959");
//		System.out.println(startTime.getTime());
//		System.out.println(endTime.getTime());
//
//		System.out.println(startTime.toInstant());

		App app = new App();
		if (app.getB() != null) {
			System.out.println("buweikong");
		} else {
			System.out.println("lwjeflj");
		}
		System.out.println(app.getB());
	}

}
