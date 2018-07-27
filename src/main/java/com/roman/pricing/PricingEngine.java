package com.roman.pricing;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;


public class PricingEngine {

	private Rules rules;
	
	public PricingEngine() {
		super();
		rules = new Rules();
	}

	public Rules initialize(Rules rules) {
		this.rules = rules;
        return rules;
	}

	public Integer calculatePrice(Item item) {
		
        //create a default rules engine and fire rules on known facts
        RulesEngine rulesEngine = new DefaultRulesEngine();
        Facts facts = new Facts();
        
        facts.put("item", item);
        rulesEngine.fire(rules, facts);
        
        return item.getPrice();
	}

}
