package com.roman.pricing;

import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Facts;

public class DiscountForBAction implements Action {

	static DiscountForBAction calculateDiscountForB() {
        return new DiscountForBAction();
    }
	
	@Override
	public void execute(Facts facts) throws Exception {
        Item item = facts.get("item");
        int quotient = item.getQuantity() / 2;
        item.setPrice(item.getPrice() - quotient * 15);
        facts.put("item", item);
	}

}
