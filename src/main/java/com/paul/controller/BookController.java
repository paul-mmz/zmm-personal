/**
 * 
 */
package com.paul.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	public String saveBook(@Valid @ModelAttribute Book book, HttpServletRequest request, BindingResult bindingResult,
			Model model) {
		BookValidator bookValidator = new BookValidator();
		bookValidator.validate(book, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", bookService.getAllCategories());
			return "bookAddForm";
		}

		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.save(book);

		List<MultipartFile> files = book.getFiles();

		if (files != null && files.size() > 0) {
			for (MultipartFile file : files) {
				try {
					String fileName = file.getOriginalFilename();
					File ff1 = new File(request.getServletContext().getRealPath("/files"));
					if(!ff1.exists()){
						ff1.mkdirs();
					}
					File ff2 = new File(ff1.getAbsolutePath(), fileName);
					if (!ff2.exists()) {
						ff2.createNewFile();
					}

					System.err.println(ff2.getAbsolutePath());
					file.transferTo(ff2);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.err.println("no file to add");
		}

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

		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", bookService.getAllCategories());
			return "bookEditForm";
		}

		Category category = bookService.getCategory(book.getCategory().getId());
		book.setCategory(category);
		bookService.update(book);
		return "redirect:/book_list";

	}
}
