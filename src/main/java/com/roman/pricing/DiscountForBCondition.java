package com.roman.pricing;

import org.jeasy.rules.api.Condition;
import org.jeasy.rules.api.Facts;

public class DiscountForBCondition implements Condition {

	static DiscountForBCondition itIsDiscountForB() {
		return new DiscountForBCondition();
	}

	@Override
	public boolean evaluate(Facts facts) {
		Item item = facts.get("item");
		return (item.getValue().equals("B") && item.getQuantity() / 2 >= 1);
	}

}
