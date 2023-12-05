package com.demo.service;

import java.util.Map.Entry;
import java.util.Set;

import com.demo.model.Pizza;

public interface PizzaService {
	int addPizzaOrder(Pizza obj);
	Pizza updateOrder(int order, Pizza obj);
	Pizza getOrderDetails(int order);
	void deleteOrder(int order);
	Set<Entry<Integer, Pizza>> getAllOrders();
}
