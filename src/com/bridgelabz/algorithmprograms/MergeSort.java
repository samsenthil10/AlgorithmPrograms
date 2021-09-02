package com.bridgelabz.algorithmprograms;

import java.util.Scanner;

public class MergeSort {
	public static void merge(String listOfWords[], int leftIndex, int middleIndex, int rightIndex) {

		int leftSubarraySize = middleIndex - leftIndex + 1;
		int rightSubarraySize = rightIndex - middleIndex;

		String leftSubArray[] = new String[leftSubarraySize];
		String rightSubArray[] = new String[rightSubarraySize];

		for (int index = 0; index < leftSubarraySize; index++) {
			leftSubArray[index] = listOfWords[index + leftIndex];
		}
		for (int index = 0; index < rightSubarraySize; index++) {
			rightSubArray[index] = listOfWords[index + middleIndex + 1];
		}

		int index1 = 0, index2 = 0;
		int index3 = leftIndex;

		while (index1 < leftSubarraySize && index2 < rightSubarraySize) {
			if (leftSubArray[index1].compareTo(rightSubArray[index2]) < 0) {
				listOfWords[index3] = leftSubArray[index1];
				index1++;
			} 
			else {
				listOfWords[index3] = rightSubArray[index2];
				index2++;
			}
			index3++;
		}

		while (index1 < leftSubarraySize) {
			listOfWords[index3] = leftSubArray[index1];
			index3++;
			index1++;
		}

		while (index2 < rightSubarraySize) {
			listOfWords[index3] = rightSubArray[index2];
			index3++;
			index2++;
		}
	}

	public static void mergeSort(String listOfWords[], int leftIndex, int rightIndex) {

		if (leftIndex < rightIndex) {
			int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
			mergeSort(listOfWords, leftIndex, middleIndex);
			mergeSort(listOfWords, middleIndex + 1, rightIndex);
			merge(listOfWords, leftIndex, middleIndex, rightIndex);
		}
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter list of words to perform merge sort:");

		String string = scanner.nextLine();
		scanner.close();
		String listOfWords[] = string.toLowerCase().split(" ");
		System.out.print("List of words before merge sort: ");
		for (int index = 0; index < listOfWords.length; index++) {
			System.out.print(listOfWords[index] + " ");
		}
		System.out.println();
		mergeSort(listOfWords, 0, listOfWords.length - 1);
		System.out.print("List of words after merge sort: ");
		for (int index = 0; index < listOfWords.length; index++) {
			System.out.print(listOfWords[index] + " ");
		}
	}
}