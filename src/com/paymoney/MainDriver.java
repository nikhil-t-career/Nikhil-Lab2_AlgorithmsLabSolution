package com.paymoney;

import java.util.Scanner;

import com.paymoney.entity.Transactions;
import com.sort.util.InsertionSortUtil;

/**
 * Real World LArge Transaction data is usually present in CSV files. Reading from CSV file on Directory.
 *  
 * @author fullstack8
 *
 */
public class MainDriver {

	public static String PATH_TRANSACTIONS_CSV = "./resources/Transactions.csv";///Nikhil-Lab2_AlgorithmsLabSolution/resources/Transactions.csv
	
	//CRORES of Transactions with 2 Arrays TransactionIds and Amounts. Index is co-relation
	public static Transactions transactions = new Transactions();
	public static float[] targetAmounts;
	
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Transactions Data Procesing!!!");
		System.out.println("\nPlease place the CSV Transactions file in resources directory.\nFilename - Transactions.csv File with 2 columns \n1)TransactionId \n2)Amount");
		
		
		//LOAD DATA and INIT Arrays for further processing
		readCsvFileAndCreateTransactionsArray();
		
		Scanner sca = new Scanner(System.in);
		System.out.print("\nPlease enter number of Targets for today - ");
		int targets = sca.nextInt();
		
		targetAmounts = new float[targets];
		
		for(int i = 0;  i < targets ; i++)
		{
			System.out.print("\nPlease enter Target amount " + (i+1) + " - ");
			targetAmounts[i] = sca.nextFloat();
		}
		
		sortTargetAmounts(targetAmounts);
		
		//PROCESS Transaction data for TARGET Amount
		printTransactionIdsOfTargetAchievement();	
		
	}

	

	private static void sortTargetAmounts(float[] targetAmounts) {
		InsertionSortUtil.insertionSort(targetAmounts);
	}



	private static void readCsvFileAndCreateTransactionsArray() {
		
		Transactions.readCsvFileAndInitializeTransactionsArray(transactions, PATH_TRANSACTIONS_CSV);
		
	}
	
	private static void printTransactionIdsOfTargetAchievement() {
		
		Transactions.processDataForTargets(transactions, targetAmounts);
	}

}

//OUTPUT
//Welcome to Transactions Data Procesing!!!
//
//Please place the CSV Transactions file in resources directory.
//Filename - Transactions.csv File with 2 columns 
//1)TransactionId 
//2)Amount
//ROW - [T1, 101]
//ROW - [T2, 102]
//ROW - [T3, 105]
//ROW - [T4, 106]
//ROW - [T5, 107]
//ROW - [T6, 108]
//ROW - [T7, 96]
//ROW - [T8, 97]
//ROW - [T9, 98]
//ROW - [T10, 99]
//ROW - [T11, 100]
//ROW - [T12, 101]
//ROW - [T13, 102]
//ROW - [T14, 103]
//ROW - [T15, 104]
//ROW - [T16, 105]
//ROW - [T17, 106]
//
//Please enter number of Targets for today - 4
//
//Please enter Target amount 1 - 500
//
//Please enter Target amount 2 - 200
//
//Please enter Target amount 3 - 201
//
//Please enter Target amount 4 - 25000
//
//
//====INSERTION SORT FOR SMALL ARRAYS=====
//
//
//Target Met or Not !!!
//TARGET MET for 200.0 at transaction index - 3, TransactionId - T3, Transaction Amount - 105.0
//TARGET MET for 201.0 at transaction index - 3, TransactionId - T3, Transaction Amount - 105.0
//TARGET MET for 500.0 at transaction index - 6, TransactionId - T6, Transaction Amount - 108.0
//Target Not Met for Amount - 25000.0

