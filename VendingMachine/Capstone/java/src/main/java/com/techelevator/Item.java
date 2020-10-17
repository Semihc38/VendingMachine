package com.techelevator;

public class Item {
	private String name;
	private double price;
	String itemType;
	
	public Item(String name, double price, String type) {
		this.name = name;
		this.price = price;
		itemType = type;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	public String getDispenseMessage() {
		String dispenseMessage = "";
		switch(this.itemType) {
			case "Chip":
				dispenseMessage = "Crunch Crunch, Yum!";
				break;
			case "Candy":
				dispenseMessage = "Munch Munch, Yum!";
				break;
			case "Drink":
				dispenseMessage = "Glug Glug, Yum!";
				break;
			case "Gum":
				dispenseMessage = "Chew Chew, Yum!";
				break;
		}
		return dispenseMessage;
	}
	
	@Override
	public String toString() {
		return this.name + " - $" + this.price;
	}
}
