package com.abdus.banking.thoughtworks;

import com.abdus.banking.thoughtworks.domain.Account;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AccountManagerTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AccountManagerTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AccountManagerTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
   public void testCreateAccount(String acctType) {
	   assertTrue( true );
   }
   
   public void testDeposit(double balance,String acctNo, Account acct) {
	   assertTrue( true );
   }
   
   public void testWithdrawal(double withdrawingAmt, String acctNo, Account acct) {
	   assertTrue( true );
   }
   
   public void testCheckBalance(String acctNo, Account acct) {
	   assertTrue( true );
   }
   
   public void testListTransaction(String acctNo, Account acct) {
	   assertTrue( true );
   }
    
}
