package com.amazon.designpatterns;

interface FoodItem{
	String getDescription();
	int getPrice();
}

class VeggieBurger implements FoodItem {

	@Override
	public String getDescription() {
		return "Veggie Burger loaded with Herbs and Spices";
	}

	@Override
	public int getPrice() {
		return 100;
	}
}

abstract class FoodDecorator implements FoodItem{
	
	FoodItem item;
	
	FoodDecorator(FoodItem item) {
		this.item = item;
	}
	
	@Override
	public String getDescription() {
		return item.getDescription();
	}

	@Override
	public int getPrice() {
		return item.getPrice();
	}
}

// VeggieBurgerMeal is a FoodDecorator
class VeggieBurgerMeal extends FoodDecorator{

	VeggieBurgerMeal(FoodItem item) {
		super(item);
	}
	
	@Override
	public String getDescription() {
		return item.getDescription()+" Upgraded to Meal with Coke and Fries !!";
	}

	@Override
	public int getPrice() {
		return item.getPrice() + 80; // Additional 80 for making Burger as a Meal !!
	}
	
}

public class DecoratorPattern {

	public static void main(String[] args) {
	
		FoodItem burger = new VeggieBurger();
		
		System.out.println(">> Description: "+burger.getDescription());
		System.out.println(">> Price: "+burger.getPrice());
		
		System.out.println();
		System.out.println(">> Converting Burger to a Meal");
		
		FoodDecorator meal = new VeggieBurgerMeal(burger);
		
		System.out.println(">> Description: "+meal.getDescription());
		System.out.println(">> Price: "+meal.getPrice());
		
	}

}

// PS: https://www.javatpoint.com/composite-pattern
