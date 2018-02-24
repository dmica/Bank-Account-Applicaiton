package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		
		/*
		Checking chkacc1 = new Checking("Tom Wilson", "464680754", 2000);
		
		Savings savacc1 = new Savings("Rich Lowe", "809348902", 3000);
		
		savacc1.compound();
		
		savacc1.showInfo();
		System.out.println("*******************");
		chkacc1.showInfo();
		*/

		//Read a CSV File then create new accounts based on that data
		String file = "C:\\Users\\dmitr\\Desktop\\Java Files\\NewBankAccounts.csv";
		List<String[]> newAccountHolders = utilities.CSV.read(file);
		for (String[] accountHolder: newAccountHolders) {
			//System.out.println("New Account");
			String name = accountHolder[0];
			String sSN = accountHolder[1];
			String accountType = accountHolder[2];
			double initDeposit = Double.parseDouble(accountHolder[3]);
			//System.out.println(name + " " + sSN + " " + accountType + " €" + initDeposit);
			if (accountType.equals("Savings")) {
				//System.out.println("Open a savings account");
				accounts.add(new Savings(name,sSN, initDeposit));
			}
			else if (accountType.equals("Checking")) {
				//System.out.println("Open a checking account");
				accounts.add(new Checking(name,sSN, initDeposit));
				
			}
			else {
				System.out.println("Eror reading account type");
			}		
		}
		
		for (Account acc : accounts) {
			System.out.println("\n****************");
			acc.showInfo();
			
		}
	}
	

}
