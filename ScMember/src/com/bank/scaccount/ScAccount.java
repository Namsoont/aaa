package com.bank.scaccount;
/*
SCACCOUNT_ID NOT NULL VARCHAR2(20) 
SCMEMBER_ID           VARCHAR2(20) 
BALANCE               NUMBER       
CREDATE               DATE   
 */

import java.sql.Date;

public class ScAccount {

	private String scaccountId;
	private String scmemberId;
	private int balance;
	private Date credate;
	
	
	public String getScaccountId() {
		return scaccountId;
	}
	public void setScaccountId(String scaccountId) {
		this.scaccountId = scaccountId;
	}
	public String getScmemberId() {
		return scmemberId;
	}
	public void setScmemberId(String scmemberId) {
		this.scmemberId = scmemberId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}
	
	
	

}
