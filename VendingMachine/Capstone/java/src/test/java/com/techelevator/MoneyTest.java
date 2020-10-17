package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyTest {

	@Test
	public void return_change_test() {
		Money bills = new Money();
		bills.addMoney(10);
		bills.subtractMoney(3.05);
		bills.subtractMoney(3.05);
		assertEquals(3.90, bills.getCurrentMoney(), 0.00);
		bills.returnChange();
		assertEquals(0.00, bills.getCurrentMoney(), 0.00);
	}

}
