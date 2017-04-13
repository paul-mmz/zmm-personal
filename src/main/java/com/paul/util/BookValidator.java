/**
 * 
 */
package com.paul.util;

import java.util.Date;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.paul.domain.Book;

/**
 * @author hzzhouminmin
 *
 */
public class BookValidator implements Validator {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Book.class.isAssignableFrom(clazz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 * org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Book book = (Book) target;
		ValidationUtils.rejectIfEmpty(errors, "isbn", "no", "Please enter a book isbn");
		ValidationUtils.rejectIfEmpty(errors, "title", "no", "Please enter a book title");
		ValidationUtils.rejectIfEmpty(errors, "category.id", "no", "Please enter a book category");
		ValidationUtils.rejectIfEmpty(errors, "author", "no", "Please enter a book author");
		if (book.getPrice() == null || book.getPrice() <= 0.0f) {
			errors.rejectValue("price", "no", "Please enter a right book price");
		}
		if (book.getPublishDate() == null || book.getPublishDate().after(new Date())) {
			errors.rejectValue("publishDate", "no", "Please enter a right book publish date");
		}
	}

}
