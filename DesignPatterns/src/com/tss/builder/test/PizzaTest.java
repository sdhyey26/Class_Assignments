package com.tss.builder.test;

import com.tss.builder.model.Pizza;
import com.tss.builder.model.Pizza.PizzaBuilder;

public class PizzaTest {

	public static void main(String[] args) {
		
		PizzaBuilder pizzaBuilder = new PizzaBuilder();
		
		pizzaBuilder.setDough("Cheesy Crust");
		pizzaBuilder.setSauce("Barbecue");
		pizzaBuilder.setTopping("panner & Olives");
		pizzaBuilder.build();
		
		Pizza pizza = new Pizza(pizzaBuilder);


		System.out.println(pizza);

		System.out.println("Dough   : " + pizza.getDough());
		System.out.println("Sauce   : " + pizza.getSauce());
		System.out.println("Topping : " + pizza.getTopping());
	}
}
