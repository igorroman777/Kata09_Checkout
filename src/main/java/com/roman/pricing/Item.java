package com.roman.pricing;

public class Item {
	
    private String value;
    private Integer quantity;
    private Integer price;
    
    
	public Item(String value) {
		super();
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
    
    

}
