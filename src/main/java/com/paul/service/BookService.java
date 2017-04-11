/**
 * 
 */
package com.paul.service;

import java.util.List;

import com.paul.domain.Book;
import com.paul.domain.Category;

/**
 * @author hzzhouminmin
 *
 */
public interface BookService {
	
	List<Category> getAllCategories();
	
	Category getCategory(Integer id);
	
	List<Book> getAllBooks();
	
	Book save(Book book);
	
	Book update(Book book);
	
	Book get(Long id);
	
	Long getNextId();
}
