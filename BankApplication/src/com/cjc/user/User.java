package com.cjc.user;

import java.util.Scanner;
import com.cjc.model.Account;
import com.cjc.utility.Operation;

public class User {
	public static Scanner sc;
	Account account = new Account();
	static Operation operation = new Operation();

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String s;
		do {
			System.out.println(" '\u263A','\u263A','\u263A'     WELCOME IN SBI  BANK PROJECT  '\u263A','\u263A','\u263A' ");
			System.out.println("1.CREATE ACCOUNT ");
			System.out.println("2.DISPLAY  PERSONAL DETAILS ");
			System.out.println("3.DEPOSITE MONEY ");
			System.out.println("4.WITHDRAW MONEY ");
			System.out.println("5.BALANCE ENQUIRY ");
			System.out.println("ENTER YOUR CHOICE .....");
			int no = sc.nextInt();
			switch (no) {
			case 1:
				operation.createAccount();
				break;
			case 2:
				operation.accountDetails();
				break;

			case 3:
				operation.depositeMoney();
				break;
			case 4:
				operation.withdrawMoney();
				break;

			case 5:
				operation.balanceDetails();
				break;

			default:
				System.out.println("Plaese Select Proper Choice ");
			}
			System.out.println("If You Want To Continue Please Enter Y or N");
			s = sc.next();
		} while (s.equals("YES") || s.equals("yes") || s.equals("y") || s.equals("Y"));
	}
}
