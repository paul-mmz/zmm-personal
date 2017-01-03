package com.paul.compare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class CompareDiffDBFields {

	public static void compareDBFields(String dbName1, String dbName2) {

		Set<String> allFields1 = new HashSet<>();
		Set<String> allFields2 = new HashSet<>();
		BufferedReader bf1 = null;
		BufferedReader bf2 = null;

		try {
			bf1 = new BufferedReader(new FileReader(dbName1));
			bf2 = new BufferedReader(new FileReader(dbName2));
			
			String temp = null;
			
			while((temp = bf1.readLine()) != null){
				allFields1.add(temp);
			}
			
			while((temp = bf2.readLine()) != null){
				allFields2.add(temp);
			}
			
			for(String f : allFields1){
				if(allFields2.contains(f))
					System.out.println(f);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		} finally {
			try {
				bf1.close();
				bf2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		String DBName1 = args[0];
		String DBName2 = args[1];
		String DBName3 = args[2];
		
		System.out.println("**********"+DBName1+"   和         "+DBName2+"比较结果***********");
		compareDBFields(DBName1,DBName2);
		System.out.println("\n\n\n\n**********"+DBName1+"   和         "+DBName3+"比较结果***********\n\n\n\n");
		compareDBFields(DBName1,DBName3);
		System.out.println("\n\n\n\n**********"+DBName1+"   和         "+DBName3+"比较结果***********");
		compareDBFields(DBName2,DBName3);
	}
}
