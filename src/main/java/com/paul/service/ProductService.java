/**
 * 
 */
package com.paul.service;

import com.paul.spring.beans.Product;

/**
 * @author hzzhouminmin
 *
 */
public interface ProductService {
	
	public void add(String key, Product product);
	
	public Product get(String key);
}
