package com.roman.pricing;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rule;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RuleBuilder;
import org.jeasy.rules.mvel.MVELRule;

import static com.roman.pricing.DiscountForAAction.calculateDiscountForA;
import static com.roman.pricing.DiscountForACondition.itIsDiscountForA;
import static com.roman.pricing.DiscountForBAction.calculateDiscountForB;
import static com.roman.pricing.DiscountForBCondition.itIsDiscountForB;


public class PricingEngine {

	public PricingEngine() {
		super();
	}
	
	// Item   Unit    Special      Discount
    // Price          Price
	// ------------------------------------
	// A     50       3 for 130      20
	// B     30       2 for 45       15
	// C     20
	// D     15

	private Rules initialize() {
		
		Rules rules;
		MVELRule priceForARule;
		MVELRule priceForBRule;
		MVELRule priceForCRule;
		MVELRule priceForDRule;
		
		Rule specialPriceForARule;
		Rule specialPriceForBRule;
		
		priceForARule = new MVELRule()
	        .name("Item A for 50")
	        .priority(1)
	        .when("item.value == 'A'")
	        .then("item.setPrice(item.quantity * 50);");
		
		priceForBRule = new MVELRule()
	        .name("Item B for 30")
	        .priority(1)
	        .when("item.value == 'B'")
	        .then("item.setPrice(item.quantity * 30);");
		
		priceForCRule = new MVELRule()
	        .name("Item C for 20")
	        .priority(1)
	        .when("item.value == 'C'")
	        .then("item.setPrice(item.quantity * 20);");
		
		priceForDRule = new MVELRule()
	        .name("Item D for 15")
	        .priority(1)
	        .when("item.value == 'D'")
	        .then("item.setPrice(item.quantity * 15);");
		
		specialPriceForARule = new RuleBuilder()
	        .name("Item A: 3 for 130")
	        .description("buy three ‘A’s and they’ll cost you $130")
	        .priority(2)
	        .when(itIsDiscountForA())
	        .then(calculateDiscountForA())
	        .build();
		
		specialPriceForBRule = new RuleBuilder()
	        .name("Item B: 2 for 45")
	        .description("buy two ‘B’s and they’ll cost you $45")
	        .priority(2)
	        .when(itIsDiscountForB())
	        .then(calculateDiscountForB())
	        .build();
		
        // create a rule set
		rules = new Rules();
		rules.register(priceForARule);
		rules.register(priceForBRule);
		rules.register(priceForCRule);
		rules.register(priceForDRule);
		
        rules.register(specialPriceForARule);
        rules.register(specialPriceForBRule);
        return rules;
        
	}

	public Item calculatePrice(Item item) {
		Rules rules = initialize();
		
        //create a default rules engine and fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        Facts facts = new Facts();
        
        facts.put("item", item);
        rulesEngine.fire(rules, facts);
        
        return item;
	}

}
