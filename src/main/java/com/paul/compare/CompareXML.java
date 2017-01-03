package com.paul.compare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareXML {

	public static List<String> getAllPorperties(String xmlName) {

		ArrayList<String> allProperties = new ArrayList<>();
		BufferedReader bf = null;

		try {
			bf = new BufferedReader(new FileReader(xmlName));

			String line = null;
			while ((line = bf.readLine()) != null) {
				if (!line.contains("property") || !line.contains("column"))
					continue;

				Integer index = line.indexOf("column") + 6;
				Integer index1 = line.indexOf("\"", index + 1);
				Integer index2 = line.indexOf("\"", index1 + 1);

				StringBuilder sb = new StringBuilder(line.substring(index1 + 1, index2));

				index = line.indexOf("property") + 8;
				index1 = line.indexOf("\"", index + 1);
				index2 = line.indexOf("\"", index1 + 1);

				sb.append(String.format("%" + (50 - sb.length()) + "s", " ") + line.substring(index1 + 1, index2));

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
		String xml1 = args[0];
		String xml2 = args[1];
		List<String> allProperties1 = getAllPorperties(xml1);
		List<String> allProperties2 = getAllPorperties(xml2);

		System.out.println(
				xml1 + ":" + allProperties1.size() + ".........." + xml2 + ":" + allProperties2.size() + "\n\n\n");

		CompareFields.formatPrint(allProperties1, allProperties2, 100);

		System.out.println("\n\n\n");

		CompareFields.getDiff(allProperties1, allProperties2, 100);

	}
}
