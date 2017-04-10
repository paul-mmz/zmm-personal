/**
 * 
 */
package com.paul.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.paul.spring.beans.Product;

/**
 * @author hzzhouminmin
 *
 */
@Service
public class ProductServiceImpl implements ProductService{

	private Map<String, Product> innerMap;

	public ProductServiceImpl() {
		innerMap = new HashMap<>();
	}
	
	/* (non-Javadoc)
	 * @see com.paul.service.ProductService#add(com.paul.spring.beans.Product)
	 */
	@Override
	public void add(String key, Product product) {
		innerMap.put(key, product);
	}

	/* (non-Javadoc)
	 * @see com.paul.service.ProductService#get(java.lang.String)
	 */
	@Override
	public Product get(String key) {
		return innerMap.get(key);
	}

}
