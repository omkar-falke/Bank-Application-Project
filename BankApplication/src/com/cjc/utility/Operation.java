package com.cjc.utility;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cjc.model.Account;
import com.cjc.service.RBI;

public class Operation implements RBI {
	Scanner sc = new Scanner(System.in);
	Account account = new Account();
	Account []acc=new Account[2];
	double total = 0, temp = 0;
	int limit=0;

	public static boolean isMobile(String s) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}
	public static boolean isEmailid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isAdharNo(String s) {
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{11}");
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	
	@Override
	public void createAccount() {
		while (limit < acc.length) {
			Account ac = new Account();
			System.out.println("Enter Your First Name");
			ac.setfName(sc.next());

			System.out.println("Enter Your Last Name");
			ac.setlName(sc.next());

			System.out.println(" Enter Your Address : ");
			ac.setAddress(sc.next());

			System.out.println(" Enter Your Mobile Number : ");
			String mobile = sc.next();
			ac.setMobileNo(mobile);
			if (isMobile(mobile)) {

			} else {
				System.out.println(" Invalid Mobile Number Please Check Once .");
			}

			System.out.println(" Enter PAN Details : ");
			ac.setPanNo(sc.next());

			System.out.println("Enter Your Aadhar No");
			String aadhar = sc.next();
			ac.setAadharNo(aadhar);

//			if (isAdharNo(aadhar)) {
//
//			} else {
//				System.out.println(" Please Check Your Adhar No It Must Be 12 Number");
//			}

			System.out.println(" Enter Your Email Id ");
			String email = sc.next();
			ac.setEmailId(email);

			if (isEmailid(email)) {

			} else {
				System.out.println(" Please Check Your Email Id ");
				System.exit(0);
			}

//			System.out.println(" Enter Account No : ");
			ac.setAccountNo(sc.hashCode());

			System.out.println(" Enter Balance Amount : ");
			double balance = sc.nextDouble();
			if (balance >= 500) {
				ac.setBalance(balance);
			} else {
				System.out.println(" Balance must be Above 500 RS. ");
				System.exit(0);
			}

			System.out.println(" Enter Your User Name");
			String userName = sc.next();
			ac.setUserName(userName);

			System.out.println(" Enter Your Password ");
			String uPassword = sc.next();
			ac.setPassword(uPassword);
			System.out.println("Hi,"+" "+ac.getfName()+" "+" Your Account is Created ");
			
			acc[limit]=ac;
			++limit;
		}
	}		

	@Override
	public void accountDetails() {
		System.out.println(" Enter Your User Name ");
		String user = sc.next();
		System.out.println("Enter Your Password ");
		String password = sc.next();
		for (limit = 0; limit < acc.length; limit++) {
			if (user.equals(acc[limit].getUserName()) && password.equals(acc[limit].getPassword())) {
				System.out.println("**************PERSONAL DETAILS ************* ");
				System.out.println("Your First Name" + "\t        : " + acc[limit].getfName());
				System.out.println("Your Last Name " + "\t        : " + acc[limit].getlName());
				System.out.println("Your Personal Address " + "\t: " + acc[limit].getAddress());
				System.out.println("Your Mobile No" + "\t         : " + acc[limit].getMobileNo());
				System.out.println("Your Bank PAN Details" + "\t: " + acc[limit].getPanNo());
				System.out.println("Your Aadhar No" + "\t      : " + acc[limit].getAadharNo());
				System.out.println("Your Email Id" + "\t        : " + acc[limit].getEmailId());
				System.out.println("Your Bank Account No" + "\t: " +"SBI"+ acc[limit].getAccountNo());
				System.out.println("Your Bank Balance" + "\t: " + acc[limit].getBalance());
				System.out.println("Your User Name " + "\t        : " + acc[limit].getUserName());
				System.out.println("Your User Password" + "\t: " + acc[limit].getPassword());
				System.out.println("***************************************************");
			}
			else
			{
				System.out.println("Invalid User Name Or Password !");
			}
		}
	}

	@Override
	public void balanceDetails() {
		System.out.println(" Enter Your User Name");
		String user=sc.next();
		System.out.println("Enter Your Password ");
		String pwd=sc.next();
		
		for(limit=0;limit<acc.length;limit++)
		{
			if(acc[limit].getUserName().equals(user) && acc[limit].getPassword().equals(pwd))
			{
				System.out.println("Hi"+" "+acc[limit].getfName()+" "+" Your Balance Amount " + acc[limit].getBalance());
			}
			else
			{
				System.out.println("Invalid User or Password !");
			}
			break;
		}
	}

	@Override
	public void depositeMoney() {
		System.out.println(" Enter Your User Name");
		String user = sc.next();
		System.out.println("Enter Your Password ");
		String pwd = sc.next();

		for (limit = 0; limit < acc.length; limit++) {
			if (acc[limit].getUserName().equals(user) && acc[limit].getPassword().equals(pwd)) {
				System.out.println(" Enter Amount To Be Deposited.");
				double amount = sc.nextDouble();
				if (amount > 0) {
					total = amount + acc[limit].getBalance();
					acc[limit].setBalance(total);
					System.out.println(" Your Money Succesfully Deposited. please Check Balance");

				} else {
					System.out.println("You Can't Deposite Money ");
				}
			}
			else {
				System.out.println(" Invalid User Name Or Password !");
			}
		}
	}

	@Override
	public void withdrawMoney() {

		System.out.println(" Enter Your User Name");
		String user = sc.next();
		System.out.println("Enter Your Password ");
		String pwd = sc.next();

		for (limit = 0; limit < acc.length; limit++) {
			if (acc[limit].getUserName().equals(user) && acc[limit].getPassword().equals(pwd)) {
				System.out.println("Enter Money For Withdraw.!");
				double money = sc.nextDouble();

				if (money > 0) {
					temp = acc[limit].getBalance() - money;
					if (temp > 500) {
						acc[limit].setBalance(temp);
						System.out.println("Money Withdraw Succesfully !");
					} else {
						System.out.println("Minimum Balance Should be 500..");
					}
				} else {
					System.out.println(" Balance Should be Positive");
				}
			}
			else
			{
				System.out.println(" Invalid User Name Or Password !.");
			}
		}
	}
}
