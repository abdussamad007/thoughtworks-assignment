package com.abdus.banking.thoughtworks;

import java.util.HashMap;

import com.abdus.banking.thoughtworks.domain.Account;
import com.abdus.banking.thoughtworks.exceptions.InvalidAccountNoException;
import com.abdus.banking.thoughtworks.exceptions.InvalidTransactionException;
import com.abdus.banking.thoughtworks.service.AccountManager;

public class Run {
public static void main(String[] args) {
	System.out.println("HI");


	
	HashMap<String, Account> accountMaster = new HashMap<>();
	
	Account account1 = new AccountManager().createAccount("S");
	String acct1 = account1.getAcctNo();
	System.out.println("Account1:" + acct1);
	accountMaster.put(acct1, account1);
	
	Account account2 = new AccountManager().createAccount("S");
	String acct2 = account2.getAcctNo();
	System.out.println("Account2:" + acct2);
	accountMaster.put(acct2, account2);
	try {
		
	//Add Balance1
	new AccountManager().deposit(100,acct1,account1);    	
	//Add Balance2
	new AccountManager().deposit(250.25,acct1,account1);
	//Add Balance3
	new AccountManager().deposit(350,acct1,account1);
	
	//Withdrawal for account1
	new AccountManager().withdrawal(100,acct1,account1);
	//Balance check
	new AccountManager().checkBalance(acct1, accountMaster.get(acct1));
	
	new AccountManager().listTransaction(acct1, accountMaster.get(acct1));
	
	/*************************************************************/
	//Add Balance1
	new AccountManager().deposit(100,acct2,account2);    	
	//Add Balance2
	new AccountManager().deposit(250.25,acct2,account2);
	//Add Balance3
	new AccountManager().deposit(350,acct2,account2);
	
	//Withdrawal for account2
	new AccountManager().withdrawal(50,acct2,account2);
	
	//Balance check
	new AccountManager().checkBalance(acct2, accountMaster.get(acct2));
	
	new AccountManager().listTransaction(acct2, accountMaster.get(acct2));
	   	
	} catch(InvalidTransactionException invalidTrnExp) {
		invalidTrnExp.printStackTrace();
	}
	catch(InvalidAccountNoException invalidAcctNoExp) {
		invalidAcctNoExp.printStackTrace();
	}catch(Exception ex) {
		ex.printStackTrace();
	}
   


}
}
