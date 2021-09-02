package com.bridgelabz.algorithmprograms;

public class PrimeNumbers {

	public static void main(String[] args) {

		int lowerBound = 0;
		int upperBound = 1000;
		int flag;

		System.out.println("Prime numbers between "+lowerBound+" and "+upperBound+" are: ");
		
		for (int iterator = lowerBound; iterator <= upperBound; iterator++) {
			if (iterator == 1 || iterator == 0)
				continue;
			flag = 1;

			for (int jIterator = 2; jIterator <= iterator / 2; jIterator++) {
				
				if (iterator % jIterator == 0) {
					flag = 0;
					break;
				}
			}
			if (flag == 1)
				System.out.print(iterator + " ");
		}
	}
}