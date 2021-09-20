package com.wallet.entity;

import com.sort.util.InsertionSortUtil;

/**
 * Real World Wallet where Denomination and no of Notes of that Denominations are given by user.
 * Application tells minimum number of notes to make the payment.
 * 
 * If exact payment cannot be done then it tells minimum notes + Change to ask for.
 * Works well but maybe inefficient code.
 * 
 * @author fullstack8
 *
 */
public class Wallet {
	private int[][] staticWallet;// 1) Denomination and 2)count of notes
	private int currentBalance;

	public Wallet(int[][] walletDenominations) {
		this.staticWallet = walletDenominations;
	}

	public void initializeWalletFields() {
		sortWalletDenominations();

		setWalletCurrentBalance();

	}

	private void sortWalletDenominations() {

		InsertionSortUtil.insertionSort(staticWallet);
	}

	private void setWalletCurrentBalance() {

		for (int i = 0; i < staticWallet.length; i++) {
			currentBalance = currentBalance + (staticWallet[i][0] * staticWallet[i][1]);
		}

		System.out.println("\nCurrent Balance - " + currentBalance);
	}

	public void checkPayment(int amountToPay) {
		// 1) If Amount> Bal or Negative then Payment cannot be done
		boolean paymentPossible = currentBalance > amountToPay || amountToPay < 0;

		StringBuilder payStmt = new StringBuilder("Payment to be done as follows: ");

		if (!paymentPossible) {
			System.out.println("Payment not possible currentBalance - " + currentBalance
					+ "\n Required Amount to Pay : " + amountToPay);
			return;
		} else {

			int tempAmount = amountToPay;

			for (int i = 0; (i < staticWallet.length && tempAmount > 0); i++) {
				// Find Quotient and check if quotient is greater than available notes

				// If amount to pay is less than the denomination then append msg and break to
				// Print for PAY
				if (tempAmount < staticWallet[i][0]) {
					payStmt.append("\nDenomination : " + staticWallet[i][0] + " : 1");
					tempAmount = tempAmount - staticWallet[i][0]; // 1 note of this denomination + any balances to ask
																	// for
					break;// Exit iteration as full or additional payment can be done
				}

				// IF TEMPAMT IS > CURRENT DENOMINATION CALC QUOTIENT
				int quotient = tempAmount / staticWallet[i][0];

				// 3 CASES
				// 1) If Quotient is 0 then 1 note of this denomination and ASK for change
				if (quotient == 0) {
					payStmt.append("\nDenomination : " + staticWallet[i][0] + " : 1");
					tempAmount = tempAmount - staticWallet[i][0]; // 1 note of this denomination + any balances to ask
																	// for
				}
				// 2) QUOTIENT IS >= NO OF NOTES OF THIS DENOMINATION
				else if (quotient >= staticWallet[i][1]) {
					tempAmount = tempAmount - (staticWallet[i][0] * staticWallet[i][1]);
					payStmt.append("\nDenomination : " + staticWallet[i][0] + " : " + staticWallet[i][1]); // ALL NOTES
																											// OF THIS
																											// DENO
				}
				// 3) QUOTIENT < NOTES OF THIS DENO
				else if (quotient < staticWallet[i][1]) {
					tempAmount = tempAmount - (staticWallet[i][0] * quotient);

					// FINAL GAURD CONDITION TO MINIMIZE NO. OF NOTES UNLESS LOWER DENOMINATION
					// MAKES EXACT PAYMENT
					if (i < (staticWallet.length - 1) && (tempAmount / staticWallet[i + 1][0] > staticWallet[i + 1][0])
							&& tempAmount % staticWallet[i + 1][0] != 0) {
						// As lower donomination is not giving exact payment then
						// We will pay from 1 more of current denomination
						payStmt.append(
								"\n\nGAURD CONDITION TO MINIMIZE NO. OF NOTES (APPLIED WHEN LOWER DENOMINATION DOES NOT MAKE EXACT PAYMENT) ");
						payStmt.append("\nDenomination " + staticWallet[i][0] + " : " + (quotient + 1));
						tempAmount = tempAmount - staticWallet[i][0];
						break; // tempAmt now negative

					}
					payStmt.append("\nDenomination " + staticWallet[i][0] + " : " + quotient);

				}

			}

			if (tempAmount == 0) {
				System.out.println("\n\nExact Payment can be done as follows: ");
				System.out.println(payStmt);
			} else if (tempAmount < 0) {
				System.out.println("\n\nAdditional amount paid. Ask for change - " + Math.abs(tempAmount));
				System.out.println(payStmt);
			}

		}

	}

}
