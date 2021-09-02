package com.bridgelabz.algorithmprograms;

import java.util.*;

public class AnagramAndPalindrome {

	public static void checkAnagramsAndPalindrome(ArrayList<Integer> listOfPrime) {

		for (int index1 = 0; index1 < listOfPrime.size(); index1++) {
			for (int index2 = index1; index2 < listOfPrime.size(); index2++) {
				boolean isAnagram = true;

				String string1 = String.valueOf(listOfPrime.get(index1));

				String string2 = String.valueOf(listOfPrime.get(index2));

				if (string1.length() != string2.length()) {
					isAnagram = false;
				}

				char string1Characters[] = string1.toCharArray();
				char string2Characters[] = string2.toCharArray();

				Arrays.sort(string1Characters);
				Arrays.sort(string2Characters);

				for (int index = 0; index < string1.length(); index++) {
					if (string1Characters[index] != string2Characters[index]) {
						isAnagram = false;
					}

				}
				if (isAnagram == true && string1.equals(string2) == false) {

					System.out.println(string1 + " and " + string2 + " are anagrams for each other");

					StringBuilder stringBuilder1=new StringBuilder(string1);
					StringBuilder stringBuilder2=new StringBuilder(string2);
					if(stringBuilder1.toString().equalsIgnoreCase(stringBuilder1.reverse().toString())) {
						System.out.println("Given number " + string1 + " is palindrome");
					}
					if(stringBuilder2.toString().equalsIgnoreCase(stringBuilder2.reverse().toString())) {
						System.out.println("Given number " + string2 + " is palindrome");
					}		
				}
			}
		}
	}

	public static void main(String[] args) {
		
		int lowerRange = 0;
		int upperRange = 1000;
		ArrayList<Integer> listOfPrime = PrimeNumbers.findPrimeNumbers(lowerRange, upperRange);
		checkAnagramsAndPalindrome(listOfPrime);
	}
}