package com.demo.UI;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.demo.model.Pizza;
import com.demo.service.PizzaService;
import com.demo.service.PizzaServiceImpl;

public class OurServices {
public static void main(String[] args) {
	PizzaService service = new PizzaServiceImpl();
	while (true) {
		System.out.println("****Pizza Services****");
		System.out.println("1.Add Your Order");
		System.out.println("2.Update Your Order");
		System.out.println("3.Get Your Order Details");
		System.out.println("4.Delete Your Order");
		System.out.println("5.Get All Your Order");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("***Add your Order***");
			System.out.println("Enter Pizza Name:");
			String pname = sc.next();
			System.out.println("Enter Pizza Price:");
			int pprice = sc.nextInt();
			System.out.println("Enter Pizza Type:");
			String ptype = sc.next();
			System.out.println("Enter Pizza Delivery Location:");
			String ploca = sc.next();
			Pizza obj = new Pizza(pname, pprice, ptype, ploca);
			int order = service.addPizzaOrder(obj);
			System.out.println("Successfully placed your at: "+ order);
			break;
		case 2:
			System.out.println("***Update Your Order***");
			System.out.println("Enter your order number:");
			int o1 = sc.nextInt();
			System.out.println("Enter UpdatedPizza Name:");
			String pname1 = sc.next();
			System.out.println("Enter UpdatedPizza Price:");
			int pprice1 = sc.nextInt();
			System.out.println("Enter UpdatedPizza Type:");
			String ptype1 = sc.next();
			System.out.println("Enter UpdatedPizza Delivery Location:");
			String ploca1 = sc.next();
			Pizza obj1 = new Pizza(pname1, pprice1, ptype1, ploca1);
			Pizza entry = service.updateOrder(o1, obj1);
			System.out.println("Successfully Updated your order in: "+ o1);
			break;
		case 3:
			System.out.println("***Get Your Order Details***");
			System.out.println("Enter your Order number:");
			int o2 = sc.nextInt();
			Pizza entry1 = service.getOrderDetails(o2);
			System.out.println(entry1);
			break;
		case 4:
			System.out.println("***Delete Your Order***");
			System.out.println("Enter your Order number:");
			int o3 = sc.nextInt();
			service.deleteOrder(o3);
			System.out.println("Successfully deleted your order in: "+ o3);
			break;
		case 5:
			System.out.println("***All Orders Taken***");
			Set<Entry<Integer, Pizza>> itr = service.getAllOrders();
			Iterator<Entry<Integer, Pizza>> finl = itr.iterator();
			while (finl.hasNext()) {
				Entry<Integer, Pizza> result= finl.next();
				System.out.println(result.getKey() + " "+ result.getValue());
			}
			break;

		default:
			System.out.println("OOPS!!!!!!!!!!!!  Enter Valid input in between 1 to 5");
			break;
		}
	}
}
}
