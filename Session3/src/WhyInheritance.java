/*
class Shoe{
	
	int pid;
	String name;
	int price;
	String color;
	String brand;
	int size;
	
	public Shoe() {
		
	}

	public Shoe(int pid, String name, int price, String color, String brand, int size) {
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.color = color;
		this.brand = brand;
		this.size = size;
	}
	
	public void setShoeDetails(int pid, String name, int price, String color, String brand, int size) {
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.color = color;
		this.brand = brand;
		this.size = size;
	}
	
	void showShoeDetails() {
		System.out.println(">> Shoe "+pid+" | "+name+" | "+price);
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
		
	
	
	
}

class MobilePhone{
	
	int pid;
	String name;
	int price;
	String color;
	String brand;
	int screenSize;
	int memory;
	int ram;
	String os;
	
}

class LEDTv{
	
	int pid;
	String name;
	int price;
	String color;
	String brand;
	int screenSize;
	String technology;
	
}
*/

class Product{
	int pid;
	String name;
	int price;
	String color;
	String brand;
}

class Shoe extends Product{
	int size;
}

class MobilePhone extends Product{
	int screenSize;
	int memory;
	int ram;
	String os;
	
}

class LEDTv extends Product{
	int screenSize;
	String technology;
	
}



// Challenge : We are writing same code again and again
// Solution  : Use Inheritance an re-use the code again and again instead of writing again and again

public class WhyInheritance {

	public static void main(String[] args) {
		

	}

}
