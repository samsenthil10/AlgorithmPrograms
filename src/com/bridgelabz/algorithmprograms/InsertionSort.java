package com.bridgelabz.algorithmprograms;

import java.util.Scanner;

public class InsertionSort {
	
	public static <E extends Comparable<E>> void insertionSort(E listOfWords[]) {

		for (int index = 0; index < listOfWords.length; index++) {
			E wordToCheck = listOfWords[index];
			int indexToCheck = index - 1;

			while (indexToCheck >= 0 && listOfWords[indexToCheck].compareTo(wordToCheck) > 0) {
				listOfWords[indexToCheck + 1] = listOfWords[indexToCheck];
				indexToCheck--;
			}

			listOfWords[indexToCheck + 1] = wordToCheck;

		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter list of words to perform insertion sort: ");
		String string = scanner.nextLine();
		String listOfWords[] = string.toLowerCase().split(" ");
		System.out.print("Before insertion sort , the words are: ");
		for (int index = 0; index < listOfWords.length; index++) {
			System.out.print(listOfWords[index] + " ");
		}
		System.out.println();
		insertionSort(listOfWords);
		System.out.print("After insertion sort , the words are: ");

		for (int index = 0; index < listOfWords.length; index++) {
			System.out.print(listOfWords[index] + " ");
		}

		System.out.print("\nEnter number of elements: ");
		int size = scanner.nextInt();
		System.out.print("Enter "+size+" numbers to perform insertion sort: ");

		Integer arrayOfNumbers[] = new Integer[size];

		for (int index = 0; index < size; index++) {
			arrayOfNumbers[index] = scanner.nextInt();
		}
		System.out.print("Before insertion sort , the numbers are: ");

		for (int index = 0; index < arrayOfNumbers.length; index++) {
			System.out.print(arrayOfNumbers[index] + " ");
		}
		System.out.println();
		insertionSort(arrayOfNumbers);
		System.out.print("After insertion sort , the numbers are: ");

		for (int index = 0; index < arrayOfNumbers.length; index++) {
			System.out.print(arrayOfNumbers[index] + " ");
		}
		scanner.close();

	}
}