package com.sort.util;

import java.util.Arrays;

/**
 * Insertion sort is the best for SMALL ARRAYS sorting
 * 
 * @author fullstack8
 *
 */
public class InsertionSortUtil {

	/**
	 * Sort 1 D array of Targets for PayMoney in ascending order.
	 * @param array
	 */
	public static void insertionSort(float array[]) {
		System.out.println("\n\n====INSERTION SORT FOR SMALL ARRAYS=====");
		int n = array.length;
		int forCount = 0, whileCount = 0;
		for (int j = 1; j < n; j++) {
			float key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
//				System.out.println("whileCount - " + ++whileCount + " - " + Arrays.toString(array));

			}
			array[i + 1] = key;
//			System.out.println("forCount - " + ++forCount + " - " + Arrays.toString(array));

		}
	}

	/**
	 * Sort 2D array of Currency Denominations in Descending order
	 * @param array
	 */
	public static void insertionSort(int array[][]) {
		System.out.println("\n\n====INSERTION SORT FOR SMALL ARRAYS=====");
		int n = array.length;
		int forCount = 0, whileCount = 0;
		for (int j = 1; j < n; j++) {
			int[] key = array[j];

			int i = j - 1;
			while ((i > -1) && (array[i][0] < key[0])) {
				array[i + 1] = array[i];
				i--;
//				System.out.println("whileCount - " + ++whileCount + " - " + Arrays.toString(array[i + 1]));

			}
			array[i + 1] = key;
//			System.out.println("forCount - " + ++forCount + " - " + Arrays.toString(array[i + 1]));

		}
	}

//	public static void main(String[] args) {
//
////		float[] arr = { 5, 7, (float) 5.2};//, 4, 9, 6, 4, 7, 3 
////
////		System.out.println(Arrays.toString(arr));
////
////		insertionSort(arr);
////
////		System.out.println(Arrays.toString(arr) + "\n\n");
//
//		int[][] twoDArray = new int[3][2];
//		
//		int deno = 100;
//		int count = 4;
//		
//		for(int i =0; i< twoDArray.length; i++)
//		{
//			twoDArray[i][0] = deno++;
//			twoDArray[i][1] = count++;
//			System.out.println(Arrays.toString(twoDArray[i]));
//		}
//		
//		
//		
//		insertionSort(twoDArray);
//		
//		for(int i =0; i< twoDArray.length; i++)
//		{
//			System.out.println(Arrays.toString(twoDArray[i]));
//		}
//	}

}
