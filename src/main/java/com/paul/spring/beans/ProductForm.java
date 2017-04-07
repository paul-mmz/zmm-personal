/**
 * 
 */
package com.paul.spring.beans;

import java.io.Serializable;

/**
 * @author hzzhouminmin
 *
 */
public class ProductForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2878164052363415610L;

	private String name = null;

	private String number = null;

	private String category = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
