package com.demo.dao;

import java.util.Set;
import java.util.Map.Entry;

import com.demo.model.Pizza;

public interface PizzaDao {
	int addPizzaOrder(Pizza obj);
	Pizza updateOrder(int order, Pizza obj);
	Pizza getOrderDetails(int order);
	void deleteOrder(int order);
	Set<Entry<Integer, Pizza>> getAllOrders();
}
