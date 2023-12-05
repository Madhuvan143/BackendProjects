package com.demo.service;

import java.util.Map.Entry;
import java.util.Set;

import com.demo.dao.PizzaDao;
import com.demo.dao.PizzaDaoImpl;
import com.demo.model.Pizza;

public class PizzaServiceImpl implements PizzaService{
	PizzaDao dao = new PizzaDaoImpl();
	@Override
	public int addPizzaOrder(Pizza obj) {
		return dao.addPizzaOrder(obj);
	}

	@Override
	public Pizza updateOrder(int order, Pizza obj) {
		return dao.updateOrder(order, obj);
	}

	@Override
	public Pizza getOrderDetails(int order) {
		return dao.getOrderDetails(order);
	}

	@Override
	public void deleteOrder(int order) {
		dao.deleteOrder(order);
	}

	@Override
	public Set<Entry<Integer, Pizza>> getAllOrders() {
		return dao.getAllOrders();
	}

}
