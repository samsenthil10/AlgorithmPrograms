package com.bridgelabz.algorithmprograms;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

	public static void binarySearch(String listOfWords[], int startIndex, int endIndex, String key) {

		int middleIndex = (startIndex + endIndex) / 2;
		while (startIndex <= endIndex) {
			if (listOfWords[middleIndex].compareTo(key) < 0) {
				startIndex = middleIndex + 1;
			} else if (listOfWords[middleIndex].compareTo(key) == 0) {
				System.out.println("Given word : " + key + " is found at index: " + middleIndex);
				break;
			} else {
				endIndex = middleIndex - 1;
			}
			middleIndex = (startIndex + endIndex) / 2;
		}
		if (startIndex > endIndex) {
			System.out.println("Given word : " + key + " is not found");
		}

	}

	public static void main(String[] args) {
		System.out.print("Enter the list of words :");
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String listOfWords[] = string.toLowerCase().split(",");
		Arrays.sort(listOfWords);

		System.out.println("Sorted list of words:");
		for (String word : listOfWords) {
			System.out.print(word+" ");
		}
		System.out.print("\nEnter the key word to search: ");
		String key = scanner.nextLine();
		scanner.close();

		binarySearch(listOfWords, 0, (listOfWords.length) - 1, key);

	}
}