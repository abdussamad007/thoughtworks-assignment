package com.abdus.banking.thoughtworks.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import com.abdus.banking.thoughtworks.domain.Account;
import com.abdus.banking.thoughtworks.domain.Transaction;
import com.abdus.banking.thoughtworks.exceptions.InvalidAccountNoException;
import com.abdus.banking.thoughtworks.exceptions.InvalidTransactionException;

public class AccoutService implements IAccoutService{
	 ReentrantLock reentrantlock = new ReentrantLock();

	public void deposit(double balance,String acctNo, Account acct) throws InvalidTransactionException{
		
		reentrantlock.lock();
		
		Transaction trn = new Transaction();
		
		try
        { 
			double currentBal = acct.getAcctBal();
			double updatedBalance = currentBal + balance;
			
			trn.setTrnAmt(balance);
			long trnRefNo = System.currentTimeMillis();
			trn.setTrnRefNo(trnRefNo);
			trn.setTrnTime(new Timestamp(trnRefNo));
			trn.setTrnType(acct.getAcctType());
			trn.setAcctNo(acctNo);
			acct.setAcctBal(updatedBalance);
			acct.addTransaction(trn);
			
        } 
        catch(Exception e) 
        { 
            throw new InvalidTransactionException(trn.toString());
        } 
        finally
        { 
            reentrantlock.unlock(); 
        }
		
	}


	@Override
	public void withdrawal(double withdrawingAmt, String acctNo, Account acct) throws InvalidTransactionException {

		
		reentrantlock.lock();
		
		Transaction trn = new Transaction();
		
		try
        { 
			double currentBal = acct.getAcctBal();
			double updatedBalance = currentBal - withdrawingAmt;
			
			trn.setTrnAmt(withdrawingAmt);
			long trnRefNo = System.currentTimeMillis();
			trn.setTrnRefNo(trnRefNo);
			trn.setTrnTime(new Timestamp(trnRefNo));
			trn.setTrnType(acct.getAcctType());
			trn.setAcctNo(acctNo);
			acct.setAcctBal(updatedBalance);
			acct.addTransaction(trn);
			
        } 
        catch(Exception e) 
        { 
            throw new InvalidTransactionException(trn.toString());
        } 
        finally
        { 
            reentrantlock.unlock(); 
        }
		
	
		
	}


	public String listTransactions(String acctNo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void checkBalance(String acctNo, Account acct) throws InvalidAccountNoException {
		
		reentrantlock.lock();
		
		try
        { 
			double currentBal = acct.getAcctBal();
			
			System.out.println( "Current Balance for account No " + acctNo + " is " + currentBal);
        }
		catch(Exception e) 
        { 
            throw new InvalidAccountNoException("Exception to fetch balance for account " + acctNo);
        } 
        finally
        { 
            reentrantlock.unlock(); 
        }
	
		
	}


	@Override
	public void listTransaction(String acctNo, Account acct) throws Exception {
		
		reentrantlock.lock();
		
		try
        { 
			List<Transaction> transactionList= acct.getTransactionList();
			
			System.out.println( "----Transcation list for  " + acctNo + " is -----" );
			for (Transaction transaction : transactionList) {
				System.out.println(transaction.toString());
				
			}
        }
		catch(Exception e) 
        { 
            throw new InvalidAccountNoException("Exception to fetch balance for account " + acctNo);
        } 
        finally
        { 
            reentrantlock.unlock(); 
        }
		
	}


}
