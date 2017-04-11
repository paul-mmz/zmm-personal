/**
 * 
 */
package com.paul.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.categories.Categories;
import org.springframework.stereotype.Service;

import com.paul.domain.Book;
import com.paul.domain.Category;

/**
 * @author hzzhouminmin
 *
 */
@Service
public class BookServiceImpl implements BookService{

	private List<Category> categories;
	
	private List<Book> books;
	

	public BookServiceImpl() {
		categories = new ArrayList<>();
		categories.add(new Category(1, "c1"));
		categories.add(new Category(2, "c2"));
		categories.add(new Category(3, "c3"));
		
		books = new ArrayList<>();
		books.add(new Book(1L, "100", "jsp", categories.get(0), "paul"));
		books.add(new Book(2L, "200", "web", categories.get(1), "qaul"));
		books.add(new Book(3L, "300", "php", categories.get(2), "raul"));
	}
	
	/* (non-Javadoc)
	 * @see com.paul.service.BookService#getAllCategories()
	 */
	@Override
	public List<Category> getAllCategories() {
		return categories;
	}

	/* (non-Javadoc)
	 * @see com.paul.service.BookService#getCategory(java.lang.Integer)
	 */
	@Override
	public Category getCategory(Integer id) {
		for(Category c : categories){
			if(c.getId() == id)
				return c;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.paul.service.BookService#getAllBooks()
	 */
	@Override
	public List<Book> getAllBooks() {
		return books;
	}

	/* (non-Javadoc)
	 * @see com.paul.service.BookService#save(com.paul.domain.Book)
	 */
	@Override
	public Book save(Book book) {
		book.setId(getNextId());
		books.add(book);
		return book;
	}

	/* (non-Javadoc)
	 * @see com.paul.service.BookService#update(com.paul.domain.Book)
	 */
	@Override
	public Book update(Book book) {
		int size = books.size();
		for(int i=0;i<size;++i) {
			Book b = books.get(i);
			if(b.getId() == book.getId()){
				books.set(i, book);
				return book;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.paul.service.BookService#get(java.lang.Long)
	 */
	@Override
	public Book get(Long id) {
		for(Book b : books){
			if(b.getId() == id)
				return b;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.paul.service.BookService#getNextId()
	 */
	@Override
	public Long getNextId() {
		Long id = 0L;
		for(Book b: books){
			Long bid = b.getId();
			if(bid > id) {
				id = bid;
			}
		}
		return id+1;
	}

}
