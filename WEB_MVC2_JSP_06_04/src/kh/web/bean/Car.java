package kh.web.bean;

public class Car {
	private int price;
	private String brand;
	private String carName;
	
	public Car() {
		super();
	}
	
	public Car(int price, String brand, String carName) {
		this.price = price;
		this.brand = brand;
		this.carName = carName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	
	
}
