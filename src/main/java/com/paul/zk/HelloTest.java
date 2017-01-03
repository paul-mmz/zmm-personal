package com.paul.zk;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class HelloTest {

	private Integer field1;

	private Long field2;

	private List<String> field3;

	private ArrayList<String> field4;

	private LinkedList<String> field5;

	public static void main(String[] args) {

		List<String> ss = new ArrayList<String>();

		ss = null;
		/*
		 * ss.add("hello"); ss.add("the"); ss.add("world");
		 */

		List<String> sss = new ArrayList<String>();
		for (String s : ss) {
			System.out.println(s == null);
			sss.add(s.toUpperCase());
		}
		System.out.println(sss);
	}
}
