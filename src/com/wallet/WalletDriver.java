package com.wallet;

import java.util.Scanner;

import com.wallet.entity.Wallet;

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
public class WalletDriver {

	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);
		
		
		System.out.println("Please enter denominations and no. of notes for that denomination : ");
		int denominations = sca.nextInt();
		int[][] walletDenominations = new int[denominations][2];
		
		
		for(int i=0; i< denominations; i++)
		{
			System.out.println("\nPlease enter Denomination face value : ");
			walletDenominations[i][0] = sca.nextInt();
			System.out.println("\nPlease enter count of notes for this denomination ");
			walletDenominations[i][1] = sca.nextInt();
			
		}
		
		
		
//		int[][] walletDenominations = { {100,5},{50,7},{500,1}};
		
		Wallet wallet = new Wallet(walletDenominations);
		wallet.initializeWalletFields();
		
		System.out.println("\nPlease enter amount to Pay : ");
		int amountToPay = sca.nextInt();
//		int amountToPay = 740;
		
		wallet.checkPayment(amountToPay);
		
	}

}
