/**
 * 
 */
package com.paul.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paul.domain.Book;
import com.paul.domain.Category;
import com.paul.service.BookService;
import com.paul.util.BookValidator;

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
		book.setAuthor("paul");
		book.setTitle("jsp");
		model.addAttribute("book", book);
		return "bookAddForm";
	}
	
	@RequestMapping("/book_save")
	public String saveBook(@Valid @ModelAttribute Book book, BindingResult bindingResult, Model model){
		BookValidator bookValidator = new BookValidator();
		bookValidator.validate(book, bindingResult);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("categories", bookService.getAllCategories());
			return "bookAddForm";
		}
		
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
	public String updateBooks(@Valid @ModelAttribute Book book, BindingResult bindingResult, Model model) {
		BookValidator bookValidator = new BookValidator();
		bookValidator.validate(book, bindingResult);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("categories", bookService.getAllCategories());
			return "bookEditForm";
		}
		
		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.update(book);
		return "redirect:/book_list";
		
	}
}
