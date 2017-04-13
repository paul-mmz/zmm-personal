/**
 * 
 */
package com.paul.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

/**
 * @author hzzhouminmin
 *
 */
public class DateFormatter implements Formatter<Date> {

	private String datePattern;

	private SimpleDateFormat dateFormat;

	/**
	 * @param datePattern
	 */
	public DateFormatter(String datePattern) {
		super();
		this.datePattern = datePattern;
		this.dateFormat = new SimpleDateFormat(datePattern);
		this.dateFormat.setLenient(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.format.Printer#print(java.lang.Object,
	 * java.util.Locale)
	 */
	@Override
	public String print(Date object, Locale locale) {
		return dateFormat.format(object);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.format.Parser#parse(java.lang.String,
	 * java.util.Locale)
	 */
	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		try {
			return dateFormat.parse(text);
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format. Please use this pattern: " + datePattern);
		}
	}

}
