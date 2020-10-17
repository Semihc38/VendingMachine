package com.techelevator;

public class Money {
	private double currentMoney;
	
	public Money() {
		this.currentMoney = 0.00;
	}
	
	public double getCurrentMoney() {
		return currentMoney;
	}
	
	public double addMoney(int addedMoney) {
		if(isValidBill(addedMoney)) {
			currentMoney += (double)addedMoney;
		}
		setRoundedMoney();
		return currentMoney;
	}
	
	public double subtractMoney(double itemCost) {
		currentMoney -= itemCost;
		setRoundedMoney();
		return currentMoney;
	}
	
	public boolean hasEnoughMoney(double itemCost) {
		if(itemCost <= currentMoney) {
			return true;
		}
		return false;
	}
	
	private boolean isValidBill(int addedMoney) {
		switch(addedMoney) {
			case 1:
				return true;
			case 2:
				return true;
			case 5:
				return true;
			case 10:
				return true;
		}
		System.out.println("Bill submitted was not valid.\n"
				+ "Please try again with a valid bill type \n");
		return false;
	}
	
	private void setRoundedMoney() {
		/* 
		 * currentMoney = 255.8234
		 * Math.round(25582.34) / 100.00
		 * 25582 / 100.00
		 * 255.82
		 */
		currentMoney = Math.round(currentMoney * 100.00) / 100.00;
	}
	
	private double getRoundedMoney() {
		return Math.round(currentMoney * 100.00) / 100.00;
	}
	
	public void returnChange() {
		this.setRoundedMoney();
		int nickels = 0;
		int quarters = 0;
		int dimes = 0;
		while(this.getRoundedMoney() - .25 >= 0) {
			quarters++;
			currentMoney = this.getRoundedMoney() - .25;
		}
		while(this.getRoundedMoney() - .10 >= 0) {
			dimes++;
			currentMoney = this.getRoundedMoney() - .10;
		}
		while(this.getRoundedMoney() - .05 >= 0) {
			nickels++;
			currentMoney = this.getRoundedMoney() - .05;
		}
		System.out.println("\nYour change: ");
		System.out.println("Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels);
	}
}
