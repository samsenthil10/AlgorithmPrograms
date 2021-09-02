package com.bridgelabz.algorithmprograms;

import java.util.Scanner;

public class PermutationsOfString {

	public static String[] permutationsFromIteration;
	public static String[] permutationsFromRecursion;
	public static int arrayIndex=0;
	public static int possiblePermutationCount(String input) {

		int possiblePermutations = 1;
		for(int iterator = 2; iterator <= input.length(); iterator++) {
			possiblePermutations = possiblePermutations*iterator;
		}
		return possiblePermutations;
	}

	public static String[] iterativeSolution(String input) {
		
		String[] iterativePermutations = new String[possiblePermutationCount(input)];
		char[] singlePermutation = new char[input.length()]; 
		for(int iterator = 0; iterator < possiblePermutationCount(input); iterator++ ) {
			StringBuilder stringBuilder = new StringBuilder(input);
			int index=0;
			int indexSelector = iterator;
			for(int divisor = input.length(); divisor >=1; divisor-- ) {
				int quotient = indexSelector/divisor;
				int remainder = indexSelector%divisor;
				singlePermutation[index] = stringBuilder.charAt(remainder);
				index++;
				stringBuilder.deleteCharAt(remainder);
				indexSelector = quotient;
			}
			iterativePermutations[iterator]=String.valueOf(singlePermutation);
		}
		
		return iterativePermutations;
		
	}
	
	public static void recursiveSolution(String possible, String chosen) {
		if(possible.length() == 0) {
			permutationsFromRecursion[arrayIndex]=chosen;
			arrayIndex++;
		}
		else {
			for(int iterator = 0; iterator<possible.length(); iterator++) {
				char temporary = possible.charAt(iterator);
				String possibleLeftPart = possible.substring(0, iterator);
				String possibleRightPart = possible.substring(iterator+1);
				String combined = possibleLeftPart + possibleRightPart;
				recursiveSolution(combined, chosen+temporary);
			}
		}
	}
	
	public static void printPermutations(String[] input,int length) {
		for(int index = 0; index < input.length; index++) {
			System.out.println(input[index]);
		}
	}
	
	public static boolean checkEqualPermutations(String[] permutationsFromIteration, String[] permutationsFromRecursion) {
		boolean flag = true;
		for(int index = 0;index < permutationsFromIteration.length;index++) {
			if(!permutationsFromIteration[index].equalsIgnoreCase(permutationsFromRecursion[index])) {
				flag = false;
			}
		}
		return flag;
	}
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your word:");
		String input = scanner.nextLine();
		scanner.close();
		permutationsFromIteration = iterativeSolution(input);
		permutationsFromRecursion = new String[possiblePermutationCount(input)];
		recursiveSolution(input, "");
		printPermutations(permutationsFromIteration, input.length());
		System.out.println();
		printPermutations(permutationsFromRecursion, input.length());
		System.out.println();
		if(!checkEqualPermutations(permutationsFromIteration, permutationsFromRecursion)) {
			System.out.println("Permutations Don't Match");
		}
		else if(checkEqualPermutations(permutationsFromIteration, permutationsFromRecursion)) {
			System.out.println("Permutations Match");
		}
	}
}
