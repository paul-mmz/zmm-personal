package com.paul.compare;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareFields {

	public static void getAllFields(Class<?> analysedClass, ArrayList<String> fieldList) {
		Field[] allFields = analysedClass.getDeclaredFields();

		Class<?> parentClazz = analysedClass.getSuperclass();
		
		if(parentClazz != null){
			getAllFields(parentClazz, fieldList);
		}
		
		for (Field f : allFields) {
			Class<?> fieldClass = f.getType();

			if (fieldClass.getSimpleName().endsWith("List") || f.getName().equals("serialVersionUID")) {
				continue;
			}

			if (fieldClass.getSimpleName().endsWith("DTO")) {
				getAllFields(fieldClass, fieldList);
			} else {
				String fieldName = f.getName();
				fieldList.add(fieldName);
			}
		}
	}

	public static void formatPrint(List<String> list1, List<String> list2, Integer interval) {

		String space = String.format("%" + interval + "s", " ");

		Integer size1 = list1.size();
		Integer size2 = list2.size();

		List<String> longerList = null;
		Integer longerSize = 0;

		List<String> shorterList = null;
		Integer shorterSize = 0;

		if (size1 < size2) {
			shorterList = list1;
			shorterSize = size1;
			longerList = list2;
			longerSize = size2;
		} else {
			shorterList = list2;
			shorterSize = size2;
			longerList = list1;
			longerSize = size1;
		}

		for (int i = 0; i < shorterSize; ++i) {
			System.out.println(shorterList.get(i) + space.substring(0, interval - shorterList.get(i).length())
					+ longerList.get(i));
		}

		for (int i = shorterSize; i < longerSize; ++i) {
			System.out.println(space + longerList.get(i));
		}
	}

	public static void getDiff(List<String> list1, List<String> list2, Integer interval) {

		Integer size1 = list1.size();
		Integer size2 = list2.size();

		List<String> longerList = null;
		Integer longerSize = 0;

		List<String> shorterList = null;
		Integer shorterSize = 0;

		if (size1 < size2) {
			shorterList = list1;
			shorterSize = size1;
			longerList = list2;
			longerSize = size2;
		} else {
			shorterList = list2;
			shorterSize = size2;
			longerList = list1;
			longerSize = size1;
		}

		List<String> commons = new ArrayList<>();
		for (int i = 0; i < longerSize; ++i) {
			if (shorterList.contains(longerList.get(i)))
				commons.add(longerList.get(i));
		}

		longerList.removeAll(commons);
		shorterList.removeAll(commons);

		formatPrint(shorterList, longerList, interval);

	}

	public static void main(String[] args) {

		try {
			String analysedClass1 = args[0];
			String analysedClass2 = args[1];

			CompareFields compareFields = new CompareFields();

			Class<?> clazz1 = compareFields.getClass().getClassLoader().loadClass(analysedClass1);
			ArrayList<String> fieldList1 = new ArrayList<String>();
			getAllFields(clazz1, fieldList1);
			Collections.sort(fieldList1);

			Class<?> clazz2 = compareFields.getClass().getClassLoader().loadClass(analysedClass2);
			ArrayList<String> fieldList2 = new ArrayList<String>();
			getAllFields(clazz2, fieldList2);
			Collections.sort(fieldList2);

			System.out.println(clazz1.getName() + ":" + fieldList1.size() + ".........." + clazz2.getName() + ":"
					+ fieldList2.size() + "\n");

			formatPrint(fieldList1, fieldList2, 40);

			System.out.println("\n\n\n");

			getDiff(fieldList1, fieldList2, 40);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
}
