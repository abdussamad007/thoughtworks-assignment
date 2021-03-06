package com.abdus.banking.thoughtworks.service;

import com.abdus.banking.thoughtworks.domain.Account;
import com.abdus.banking.thoughtworks.exceptions.InvalidAccountNoException;
import com.abdus.banking.thoughtworks.exceptions.InvalidTransactionException;

/**
 * 
 * @author abdus
 *
 */
public interface IAccoutService {

	void deposit(double balance,String acctNo, Account acct) throws InvalidTransactionException;
	
	public void withdrawal(double balance,String acctNo, Account acct) throws  InvalidTransactionException;
	
	public void checkBalance(String acctNo, Account acct) throws InvalidAccountNoException;
	
	public void listTransaction(String acctNo, Account acct) throws  Exception;
	
	
		
}
