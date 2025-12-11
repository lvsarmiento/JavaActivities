package M2_Activity6;

public abstract class Vehicle implements Refuelable {
	
	public int numberOfWheels;
	public String brand;
	
	public Vehicle() {
	}
	
	public Vehicle(int numberOfWheels, String brand) {
		this.numberOfWheels = numberOfWheels;
		this.brand = brand;
	}
	
	public abstract void startEngine();
	
	public int getNumberOfWheels() {
		return numberOfWheels;
	}
	
	public void setNumberOfWheels() {
		this.numberOfWheels = numberOfWheels;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand() {
		this.brand = brand;
	}
	
	public void destroy() {
		System.out.println("Vehicle " + brand + " with " + numberOfWheels + " wheels has been destroyed!");
	}

}
