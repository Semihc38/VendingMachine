package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Inventory {
	private TreeMap<String, HashMap<Item, Integer>> inventory = new TreeMap<>();
	private static final Integer MAX_STOCK = 5;
	
	public Inventory() throws FileNotFoundException {
		this.restock();
	}
	
	//					GET ITEM METHOD
	public Item getItem(String slot) {
		HashMap<Item, Integer> items= inventory.get(slot);
		Set<Item> itemSet = items.keySet();
		Item currentItem = null;
		
		for(Item anItem : itemSet) {
			currentItem =  anItem;
		}
		return currentItem;
	}
	
	//                  GET STOCK METHOD
	public int getStock(String slot) {
		HashMap<Item, Integer> items= inventory.get(slot);
		Set<Item> itemSet = items.keySet();
		Integer itemStock = 0;
		
		for(Item anItem : itemSet) {
			itemStock = items.get(anItem);
		}
		return itemStock;
	}
	
	//					IS SOLD OUT METHOD
	public boolean isSoldOut(String slot) {
		return this.getStock(slot) == 0;
	}
	
	//					RESTOCK METHOD
	public void restock() throws FileNotFoundException {
		File restockFile = new File("vendingmachine.csv");
		Scanner stock = new Scanner(restockFile);
		
		String line;
		HashMap<Item, Integer> items;
		
		while(stock.hasNextLine()) {
			items = new HashMap<>();
			
			line = stock.nextLine();
			String[] splitLine = line.split("\\|");
			
			Double price = Double.parseDouble(splitLine[2]);
			
			Item itemForSale = new Item(splitLine[1], price, splitLine[3]);
			
			items.clear(); 							// Clear map so previous items don't get placed in wrong slot
			items.put(itemForSale, MAX_STOCK);
			
			inventory.put(splitLine[0], items);
		}
		System.out.println("VENDING MACHINE HAS BEEN RESTOCKED \n");
		stock.close();
	}
	
	//                 DISPLAY ITEMS METHOD
	public void displayItems() throws IOException {
		BufferedReader restockFile = new BufferedReader(
				new FileReader("vendingmachine.csv"));
		String line;
		Integer itemStock = 0;
		while((line=restockFile.readLine())!=null) {
			itemStock = this.getStock(line.substring(0, 2));
			
			line = line.replace("Chip", "") + itemStock;
			line = line.replace("Drink", "");
			line = line.replace("Candy", "");
			line = line.replace("Gum", "");
			System.out.println(line);
		}
		restockFile.close();
	}
	
	//				DECREMENT STOCK METHOD
	public void decrementStock(String slot) {
		HashMap<Item, Integer> items= inventory.get(slot);
		if(!this.isSoldOut(slot)) {
			items.put(this.getItem(slot), this.getStock(slot) - 1);
		}
	}
	
	//				IS VALID SLOT METHOD
	public boolean isValidSlot(String slot) {
		boolean isValid = inventory.containsKey(slot);
//		}
		return isValid;
	}
	
	
	public Set<String> getSlots() {
		Set<String> slots = inventory.keySet();
		return slots;
	}
	
	public Integer getMaxStock() {
		return MAX_STOCK;
	}
}
