package com.paul.compare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareConsistency {

	public static List<String> getAllPorperties(String xmlName) {

		ArrayList<String> allProperties = new ArrayList<>();
		BufferedReader bf = null;

		try {
			bf = new BufferedReader(new FileReader(xmlName));

			String line = null;
			while ((line = bf.readLine()) != null) {
				if (!line.contains("property") || !line.contains("column"))
					continue;

				Integer index = line.indexOf("property") + 8;
				Integer index1 = line.indexOf("\"", index + 1);
				Integer index2 = line.indexOf("\"", index1 + 1);

				String sb = line.substring(index1 + 1, index2);

				allProperties.add(sb.toString());
			}

			Collections.sort(allProperties);

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				bf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return allProperties;
	}

	public static void main(String[] args) {

		try {
			String analysedClazz = args[0];
			String xml = args[1];

			CompareConsistency compareConsistency = new CompareConsistency();

			Class<?> clazz1 = compareConsistency.getClass().getClassLoader().loadClass(analysedClazz);
			ArrayList<String> fieldList1 = new ArrayList<String>();
			CompareFields.getAllFields(clazz1, fieldList1);

			Collections.sort(fieldList1);

			List<String> allProperties = getAllPorperties(xml);

			System.out.println(
					clazz1.getName() + ":" + fieldList1.size() + ".........." + xml + ":" + allProperties.size()+"\n\n\n");

			CompareFields.formatPrint(fieldList1, allProperties, 30);

			System.out.println("\n\n\n");

			CompareFields.getDiff(fieldList1, allProperties, 30);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
