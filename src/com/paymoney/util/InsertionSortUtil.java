package com.paymoney.util;

/**
 * Insertion sort is the best for SMALL ARRAYS sorting
 * 
 * @author fullstack8
 *
 */
public class InsertionSortUtil {

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

//	public static void main(String[] args) {
//
//		float[] arr = { 5, 7, (float) 5.2};//, 4, 9, 6, 4, 7, 3 
//
//		System.out.println(Arrays.toString(arr));
//
//		insertionSort(arr);
//
//		System.out.println(Arrays.toString(arr));
//
//	}

}
