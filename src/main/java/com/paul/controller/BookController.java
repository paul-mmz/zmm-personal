/**
 * 
 */
package com.paul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

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

	public String inputBook(Model model) {
		List<Category> categories = bookService.getAllCategories();
		return "bookAddForm";
	}
}
