package com.paymoney.entity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing a Transaction. In Real world Transaction Id and Amount must be present.
 * 
 * @author fullstack8
 *
 */
public class Transactions {

	// INT index is their co-relation
	private List<String> transactionIds = new ArrayList<>();
	private List<Float> amounts = new ArrayList<>();

	public static void readCsvFileAndInitializeTransactionsArray(Transactions transactions,
			String PATH_TRANSACTIONS_CSV) {

		FileReader fr;
		BufferedReader br;
		int index = 0;
		try {
			fr = new FileReader(new File(PATH_TRANSACTIONS_CSV));
			br = new BufferedReader(fr);
			String line;
			try {
				br.readLine(); // Skip First Line

				while ((line = br.readLine()) != null) {

					String[] transactionDetail = line.split(",");
					transactions.transactionIds.add(transactionDetail[0]);
					transactions.amounts.add(Float.valueOf(transactionDetail[1]));
					System.out.println("ROW - " + Arrays.toString(transactionDetail));

				}

			} catch (IOException e) {
				e.printStackTrace();
			} //
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void processDataForTargets(Transactions transactions, float[] targetAmounts) {

		// Now sum all elements iteratively and check for each target achieved or not
		// Check counter acts as index for Targets that are met
		// So unmet targets are the only ones compared.
		System.out.println("\n\nTarget Met or Not !!!");

		int checkIndex = 0, i = 0;
		float sum = 0;

		while (checkIndex < targetAmounts.length && i < transactions.amounts.size()) {

			// As SUM becomes greater than target Print message for Target Met
			if (targetAmounts[checkIndex] <= sum) {

				System.out.println("TARGET MET for " + targetAmounts[checkIndex] + " at transaction index - " + (i + 1)
						+ ", TransactionId - " + transactions.transactionIds.get(i) + ", Transaction Amount - "
						+ transactions.amounts.get(i));

				checkIndex++;

//				System.out.println("CONTINUE");
				continue;// THIS WORKS - Skip below SUM and go to check if next target amounts are also met with current Transaction.
			}

			// Now iteratively sum and check if target met
			sum = sum + transactions.amounts.get(i);
			i++;
		}

//		for those amounts where Target is not met
		while (checkIndex < targetAmounts.length) {
			System.out.println("Target Not Met for Amount - " + targetAmounts[checkIndex++]);
		}

	}

}
