package com.demo.dao;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

import com.demo.model.Pizza;

public class PizzaDaoImpl implements PizzaDao{
	HashMap<Integer, Pizza> data = new HashMap<Integer, Pizza>();
	int order = 0;
	@Override
	public int addPizzaOrder(Pizza obj) {
		data.put(++order, obj);
		return order;
	}

	@Override
	public Pizza updateOrder(int order, Pizza obj) {
		data.put(order, obj);
		return data.get(order);
	}

	@Override
	public Pizza getOrderDetails(int order) {
		return data.get(order);
	}

	@Override
	public void deleteOrder(int order) {
		data.remove(order);
	}

	@Override
	public Set<Entry<Integer, Pizza>> getAllOrders() {
		Set<Entry<Integer, Pizza>> ob= data.entrySet();
		return ob;
	}

}
