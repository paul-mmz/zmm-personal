package com.paul.map;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		CategoryFilterView c1 = new CategoryFilterView();
		c1.setCategoryId(11);
		c1.setCategoryName("ssss");
		
		CategoryFilterView c2 = new CategoryFilterView();
		c2.setCategoryId(11);
		c2.setCategoryName("ssss");
		
		Map<CategoryFilterView, Integer> map = new HashMap<>();
		map.put(c1, 11);
		map.put(c2, 22);
		System.out.println(map);
		System.out.println(map.size());
		
		Map<Long, Integer> mmm = new HashMap<>();
		mmm.put(1L, 111);
		System.out.println(mmm);
		mmm.put(1L, 222);
		System.out.println(mmm);
		
		System.out.println(mmm.size());
	}
}
