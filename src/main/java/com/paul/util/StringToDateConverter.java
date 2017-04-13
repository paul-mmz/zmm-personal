/**
 * 
 */
package com.paul.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author hzzhouminmin
 *
 */
public class StringToDateConverter implements Converter<String, Date>{

	private String datePattern;
	
	/**
	 * @param datePattern
	 */
	public StringToDateConverter(String datePattern) {
		super();
		this.datePattern = datePattern;
	}

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Date convert(String source) {
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
			dateFormat.setLenient(false);
			return dateFormat.parse(source);
		}catch(Exception e){
			throw new IllegalArgumentException("Invalid date format. Please use this pattern: " + datePattern);
		}
	}
}
