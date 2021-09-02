package com.bridgelabz.algorithmprograms;

import java.util.Arrays;
import java.util.Scanner;
public class AnagramDetection {
	
	public static boolean checkIfAnagrams(String string1,String string2) {
		
		if(string1.length()!=string2.length()) {
			return false;
		}
		char string1Characters[] = string1.toCharArray();
		char string2Characters[] = string2.toCharArray();
		Arrays.sort(string1Characters);
		Arrays.sort(string2Characters);
		for(int index=0;index<string1.length();index++) {
			if(string1Characters[index]!=string2Characters[index]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter two words: ");
		String string1=scanner.nextLine();
		String string2= scanner.nextLine();	
		scanner.close();
		boolean result=checkIfAnagrams(string1,string2);
		if(result==true) {
			System.out.println("Given strings: "+string1+" and "+string2+ " are anagrams");
		}
		else {
			System.out.println("Given strings: "+string1+" and "+string2+ " are not anagrams");
		}	
	}
}