package com.bridgelabz.algorithmprograms;

import java.util.Scanner;

public class InsertionSort {

	public static String[] insertionSort(String listOfWords[]) {

		for(int index=0;index<listOfWords.length;index++) {
			String wordToCheck=listOfWords[index];
			int indexToCheck=index-1;
			while(indexToCheck>=0 && listOfWords[indexToCheck].compareTo(wordToCheck)>0) {
				listOfWords[indexToCheck+1]=listOfWords[indexToCheck];
				indexToCheck--;
			}
			listOfWords[indexToCheck+1]=wordToCheck;
		}
		return listOfWords;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter list of words:");
		String string=scanner.nextLine();
		String listOfWords[] = string.toLowerCase().split(" ");
		System.out.print("Before insertion sort: ");
		for(int index=0;index<listOfWords.length;index++) {
			System.out.print(listOfWords[index]+" ");
		}
		System.out.println();
		listOfWords=insertionSort(listOfWords);
		System.out.print("After insertion sort: ");
		for(int index=0;index<listOfWords.length;index++) {
			System.out.print(listOfWords[index]+" ");
		}
		scanner.close();
	}
}