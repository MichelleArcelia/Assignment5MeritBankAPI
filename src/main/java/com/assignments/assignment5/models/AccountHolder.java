package com.assignments.assignment5.models;

import java.util.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AccountHolder {
	int id;
	static int nextId = 1;
	
	@NotNull(message = "First Name can not be null")
	@NotBlank(message = "First Name can not be blank")
	String firstName;

	String middleName;
	@NotNull(message = "Last Name can not be null")
	@NotBlank(message = "Last Name can not be blank")
	String lastName;
	@NotNull(message = "SSN can not be null")
	@NotBlank(message = "SSN can not be blank")
	String SSN;
	
	List<CheckingAccount> checkingAccounts = new ArrayList<CheckingAccount>();
	List<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
	List<CDAccount> cdAccounts = new ArrayList<CDAccount>();
	
	
	public AccountHolder() {
		this.firstName = "";
		this.middleName = "";
		this.lastName = "";
		this.SSN = "";
		this.id = nextId ++;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public BankAccount addCheckingAccount(CheckingAccount checkingAccount) {
		checkingAccounts.add(checkingAccount);
		return checkingAccount;
	}
	
	public List<CheckingAccount> getCheckingAccounts() {
		return checkingAccounts;		
	}
	
	public BankAccount addSavingsAccount(SavingsAccount savingsAccount){
		savingsAccounts.add(savingsAccount);
		return savingsAccount;
	}
	
	public List<SavingsAccount> getSavingsAccounts(){
		return savingsAccounts;
	}
	
	public BankAccount addCDAccount(CDAccount cdAccount){
		cdAccounts.add(cdAccount);
		return cdAccount;
	}
	
	public List<CDAccount> getCDAccounts(){
		return cdAccounts;
	}
	
	public int getNumberOfCheckingAccounts() {
		return checkingAccounts.size();
	}
	
	public double getCheckingBalance() {
		double totalBalance = 0;
		for (BankAccount ca : checkingAccounts) {
			totalBalance = totalBalance + ca.getBalance();
		}
		return totalBalance;
	}
	
	public int getNumberOfSavingsAccounts() {
		return savingsAccounts.size();
	}
	
	public double getSavingsBalance() {
		double totalBalance = 0;
		for (BankAccount sa : savingsAccounts) {
			totalBalance = totalBalance + sa.getBalance();
		}
		return totalBalance;
	}
	
	public int getNumberOfCDAccounts() {
		return cdAccounts.size();
	}
	
	public double getCdbalance() {
		double totalBalance = 0;
		for (BankAccount cda : cdAccounts) {
			totalBalance = totalBalance + cda.getBalance();
		}
		return totalBalance;
	}
	
	public double getCombinedBalance() {
		double totalBalance = 0;
		for (BankAccount ca : checkingAccounts) {
			totalBalance = totalBalance + ca.getBalance();
		}
		for (BankAccount sa : savingsAccounts) {
			totalBalance = totalBalance + sa.getBalance();
		}
		for (BankAccount cda : cdAccounts) {
			totalBalance = totalBalance + cda.getBalance();
		}
		return totalBalance;
	}

}