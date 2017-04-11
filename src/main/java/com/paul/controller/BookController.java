/**
 * 
 */
package com.paul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paul.domain.Book;
import com.paul.domain.Category;
import com.paul.service.BookService;

/**
 * @author hzzhouminmin
 *
 */
@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping("/book_input")
	public String inputBook(Model model) {
		List<Category> categories = bookService.getAllCategories();
		model.addAttribute("categories", categories);
		Book book = new Book();
		book.setId(100L);
		book.setAuthor("paul");
		book.setTitle("jsp");
		model.addAttribute("book", book);
		return "bookAddForm";
	}
	
	@RequestMapping("/book_save")
	public String saveBook(@ModelAttribute Book book){
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.save(book);
		return "redirect:/book_list";
	}
	
	@RequestMapping("/book_list")
	public String listBooks(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "bookList";
	}
	
	@RequestMapping("/book_edit/{id}")
	public String editBook(Model model, @PathVariable Long id) {
		List<Category> categories = bookService.getAllCategories();
		model.addAttribute("categories", categories);
		Book book = bookService.get(id);
		model.addAttribute("book", book);
		return "bookEditForm";
	}
	
	@RequestMapping("/book_update")
	public String updateBooks(@ModelAttribute Book book) {
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.update(book);
		return "redirect:/book_list";
		
	}
}
