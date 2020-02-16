package com.abdus.banking.thoughtworks.domain;
/**
 * 
 * @author abdus
 *
 */

import java.util.ArrayList;
import java.util.List;

public class Account {
	
  private String acctType;
  private String acctNo;
  private double acctBal;
  private List<Transaction>  transactionList;
  
   public Account(String acctType, String acctNo) {
	super();
	this.acctType = acctType;
	this.acctNo = acctNo;
	this.acctBal = 0.00;
	this.transactionList = new ArrayList<Transaction>();
}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public List<Transaction> getTransactionList() {
		return transactionList;
	}
	public void addTransaction(Transaction transaction) {
		transactionList.add(transaction);
	}
	public double getAcctBal() {
		return acctBal;
	}
	public void setAcctBal(double acctBal) {
		this.acctBal = acctBal;
	}
	  
  
  
}
