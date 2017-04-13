/**
 * 
 */
package com.paul.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

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
	
	@Size(min=3, max =30)
	private String title;
	
	private Category category;
	
	@Size(min=2, max =20)
	private String author;
	
	@Max(100)
	private Float price = 0.0f;
	
	@Past
	private Date publishDate;
	
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
}
