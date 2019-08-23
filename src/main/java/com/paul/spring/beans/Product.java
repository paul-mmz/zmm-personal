package com.paul.spring.beans;

import java.io.Serializable;
import java.util.Calendar;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065060760434774926L;

	private String name = null;

	private Long number = null;

	private String category = null;

	private Calendar calendar = null;

	private static Product product = null;

	private Kitty kitty;

	public Product() {

	}

	public Product(String name, Long number, String category) {
		this.name = name;
		this.number = number;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public static Product getInstance() {
		if (product == null) {
			synchronized (Product.class) {
				if (product == null) {
					product = new Product();
				}
			}
		}
		return product;
	}

	public static void destory() {
		System.out.println("produce destoryed!");
	}

	public Kitty getKitty() {
		return kitty;
	}

	public void setKitty(Kitty kitty) {
		this.kitty = kitty;
	}
}
