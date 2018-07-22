package com.roman.pricing;

import org.jeasy.rules.api.Action;
import org.jeasy.rules.api.Facts;

public class DiscountForAAction implements Action {

	static DiscountForAAction calculateDiscountForA() {
        return new DiscountForAAction();
    }
	
	@Override
	public void execute(Facts facts) throws Exception {
        Item item = facts.get("item");
        int quotient = item.getQuantity() / 3;
        item.setPrice(item.getPrice() - quotient * 20);
        facts.put("item", item);
	}

}
