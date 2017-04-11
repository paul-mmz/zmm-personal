/**
 * 
 */
package com.paul.domain;

import java.io.Serializable;

/**
 * @author hzzhouminmin
 *
 */
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1781148448217113695L;
	
	private Long id;
	
	private String isbn;
	
	private String title;
	
	private Category category;
	
	private String author;
	
	public Book() {
		super();
	}

	/**
	 * @param id
	 * @param isbn
	 * @param title
	 * @param category
	 * @param author
	 */
	public Book(Long id, String isbn, String title, Category category, String author) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.category = category;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
}
