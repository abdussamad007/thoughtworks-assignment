package com.abdus.banking.thoughtworks.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

import com.abdus.banking.thoughtworks.domain.Account;
import com.abdus.banking.thoughtworks.exceptions.InvalidAccountNoException;
import com.abdus.banking.thoughtworks.exceptions.InvalidTransactionException;

public class AccountManager implements IAccountManager{
	
	ReentrantLock reentrantlock = new ReentrantLock();

	public void validateTranscation() throws InvalidTransactionException {
		// TODO Auto-generated method stub
		
	}

	public Account createAccount(String acctType) {
		// TODO Auto-generated method stub
		
		Account newAcctNo = null;
		
		if(acctType.equalsIgnoreCase("S")) {
			long uniqueId = generateId();
			String acctNo = "3"+uniqueId;
			
			newAcctNo = new Account(acctType, acctNo);
		}else {
			long uniqueId = generateId();
			String acctNo = "4"+uniqueId;
			
			newAcctNo = new Account(acctType, acctNo);
		}
		return newAcctNo;
	}
	
	
	private long generateId() {
		  ThreadLocalRandom random = ThreadLocalRandom.current();
		  return random.nextLong(10_000_000_000L, 100_000_000_000L);
		}


	public void deposit(double balance,String acctNo, Account acct) throws  InvalidTransactionException{
		
		reentrantlock.lock();
		try
        { 
		// TODO Auto-generated method stub
		//validate if balance is +ve 
		if(balance>0) {
				new AccoutService().deposit(balance,acctNo,acct);
		}else {
			throw new InvalidTransactionException("Invalid balance. Balance musty be > 0 or positive value " + balance);
		}
		
        } 
        catch(Exception e) 
        { 
            throw new InvalidTransactionException(e.toString());
        } 
        finally
        { 
            reentrantlock.unlock(); 
        }
		
		
	}

	@Override
	public void withdrawal(double withdrawingAmt, String acctNo, Account acct) throws InvalidTransactionException {
		
		reentrantlock.lock();
		try
        {
		
		// TODO Auto-generated method stub
		 double currentBal = acct.getAcctBal();
		 if(withdrawingAmt <= 0 ) {
			 throw new InvalidTransactionException("Invalid balance. Balance musty be > 0 or positive value " + withdrawingAmt);
		 } else if(withdrawingAmt > currentBal) {
			 throw new InvalidTransactionException("Insufficient Balance " + withdrawingAmt);
		 }
		 else {
			 new AccoutService().withdrawal(withdrawingAmt,acctNo,acct);
		 }
		 
        } 
        catch(Exception e) 
        { 
            throw new InvalidTransactionException(e.toString());
        } 
        finally
        { 
            reentrantlock.unlock(); 
        }
		
	}

	@Override
	public void checkBalance(String acctNo, Account acct) throws InvalidAccountNoException {
		// TODO Auto-generated method stub
		
		if(acct == null) {			
			throw new InvalidAccountNoException("Invalid Account Number " + acctNo);
		}else {
			 new AccoutService().checkBalance(acctNo, acct);
		}
		
	}

	@Override
	public void listTransaction(String acctNo, Account acct) throws Exception {
		if(acct == null) {			
			throw new InvalidAccountNoException("Invalid Account Number " + acctNo);
		}else {
			 new AccoutService().listTransaction(acctNo, acct);
		}
		
	}
	

}
