package com.assignments.assignment5.models;

import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
//@JsonSubTypes({
//    @JsonSubTypes.Type(value = CheckingAccount.class, name = "CheckingAccount"),
//    @JsonSubTypes.Type(value = SavingsAccount.class, name = "SavingsAccount"),
//    @JsonSubTypes.Type(value = CDAccount.class, name = "CDAccount")}
//)
public abstract class BankAccount {

	int id;
	static int nextId = 1;
	
	@Min(value = 0, message = "Balance must be atleast zero")
	double balance;
	Date openedOn;
	
	@DecimalMin(value = "0.0", inclusive = false, message = "interest rate must be greater than zero")
	@DecimalMax(value = "1", inclusive = false, message = "interest rate must be less than one")
	double interestRate;
	
	public BankAccount() {
		this.balance = 0;
		this.openedOn = new Date(System.currentTimeMillis());
		this.interestRate = 0.1;
		this.id = nextId++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Date getOpenedOn() {
		return openedOn;
	}

	public void setOpenedOn(Date openedOn) {
		this.openedOn = openedOn;
	}

//	public double getInterestRate() {
//		return interestRate;
//	}
//
//	public void setInterestRate(double interestRate) {
//		this.interestRate = interestRate;
//	}
	
}
