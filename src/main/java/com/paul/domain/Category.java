/**
 * 
 */
package com.paul.domain;

import java.io.Serializable;

/**
 * @author hzzhouminmin
 *
 */
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 925814993208822555L;
	
	private Integer id;
	
	private String name;
	
	/**
	 * @param id
	 * @param name
	 */
	public Category(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
