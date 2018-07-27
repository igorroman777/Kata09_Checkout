package com.roman.pricing;

import java.util.HashMap;
import java.util.Map;

import org.jeasy.rules.api.Rules;

public class CheckOut {
	private final PricingEngine pricingEngine = new PricingEngine();
	private final Map<String, Item> items = new HashMap<>();

	public void initializeRule(Rules rules) {
		pricingEngine.initialize(rules);
	}

	public void scan(String scannedValue) {
		Item scannedItem = new Item(scannedValue);
		Item item = items.get(scannedItem.getValue());
		if (item == null) {
			scannedItem.setQuantity(1);
			items.put(scannedValue, scannedItem);
		} else {
			Integer quantity = item.getQuantity();
			item.setQuantity(++quantity);
		}
	}

	public Integer total() {
		Integer totalPrice = new Integer(0);
		for (Item item : items.values()) {
			totalPrice = totalPrice + pricingEngine.calculatePrice(item);
		}
		return totalPrice;
	}

}
