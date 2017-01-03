package com.paul.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderTest {
	
	public static void main(String[] args) {
		ServiceLoader<Search> search = ServiceLoader.load(Search.class);
		
		Iterator<Search> iter = search.iterator();
		
		Search s = null;
		
		while(iter.hasNext()){
			s =iter.next();
			s.search();
		}
	}

}
