package com.abdus.banking.thoughtworks.domain;

import java.sql.Timestamp;

/**
 * 
 * @author abdus
 *
 */
public class Transaction {
	
	private String trnType; //'C or D'
	private double trnAmt;
	private long trnRefNo; // derived from transaction timestamp
	private Timestamp trnTime;
	private String acctNo;
	
	public String getTrnType() {
		return trnType;
	}
	public void setTrnType(String trnType) {
		this.trnType = trnType;
	}
	public double getTrnAmt() {
		return trnAmt;
	}
	public void setTrnAmt(double trnAmt) {
		this.trnAmt = trnAmt;
	}
	public long getTrnRefNo() {
		return trnRefNo;
	}
	public void setTrnRefNo(long trnRefNo) {
		this.trnRefNo = trnRefNo;
	}
	public Timestamp getTrnTime() {
		return trnTime;
	}
	public void setTrnTime(Timestamp trnTime) {
		this.trnTime = trnTime;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	@Override
	public String toString() {
		return "Transaction [trnType=" + trnType + ", trnAmt=" + trnAmt + ", trnRefNo=" + trnRefNo + ", trnTime="
				+ trnTime + ", acctNo=" + acctNo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(trnAmt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (trnRefNo ^ (trnRefNo >>> 32));
		result = prime * result + ((trnTime == null) ? 0 : trnTime.hashCode());
		result = prime * result + ((trnType == null) ? 0 : trnType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (acctNo == null) {
			if (other.acctNo != null)
				return false;
		} else if (!acctNo.equals(other.acctNo))
			return false;
		if (Double.doubleToLongBits(trnAmt) != Double.doubleToLongBits(other.trnAmt))
			return false;
		if (trnRefNo != other.trnRefNo)
			return false;
		if (trnTime == null) {
			if (other.trnTime != null)
				return false;
		} else if (!trnTime.equals(other.trnTime))
			return false;
		if (trnType == null) {
			if (other.trnType != null)
				return false;
		} else if (!trnType.equals(other.trnType))
			return false;
		return true;
	}
	
	
	
}
