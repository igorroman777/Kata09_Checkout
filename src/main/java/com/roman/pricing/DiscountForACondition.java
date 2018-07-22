package com.roman.pricing;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;

public class DiscountForACondition implements Condition {

	static DiscountForACondition itIsDiscountForA() {
		return new DiscountForACondition();
	}

	@Override
	public boolean evaluate(Facts facts) {
		Item item = facts.get("item");
		return (item.getValue().equals("A") && item.getQuantity() / 3 >= 1);
	}

}
