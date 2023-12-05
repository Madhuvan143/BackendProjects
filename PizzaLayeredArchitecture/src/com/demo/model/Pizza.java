package com.demo.model;

public class Pizza {
	private String pizzaName;
	private int pizzaAmount;
	private String pizzaType;
	private String pizzaLocation;
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public int getPizzaAmount() {
		return pizzaAmount;
	}
	public void setPizzaAmount(int pizzaAmount) {
		this.pizzaAmount = pizzaAmount;
	}
	public String getPizzaType() {
		return pizzaType;
	}
	public void setPizzaType(String pizzaType) {
		this.pizzaType = pizzaType;
	}
	public String getPizzaLocation() {
		return pizzaLocation;
	}
	public void setPizzaLocation(String pizzaLocation) {
		this.pizzaLocation = pizzaLocation;
	}
	public Pizza() {
		// TODO Auto-generated constructor stub
	}
	public Pizza(String pizzaName, int pizzaAmount, String pizzaType, String pizzaLocation) {
		super();
		this.pizzaName = pizzaName;
		this.pizzaAmount = pizzaAmount;
		this.pizzaType = pizzaType;
		this.pizzaLocation = pizzaLocation;
	}
	@Override
	public String toString() {
		return "Pizza [pizzaName=" + pizzaName + ", pizzaAmount=" + pizzaAmount + ", pizzaType=" + pizzaType
				+ ", pizzaLocation=" + pizzaLocation + "]";
	}
	
}
