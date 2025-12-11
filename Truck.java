
package M2_Activity6;

public class Truck extends Vehicle implements Refuelable {
	
	public Truck(int numberOfWheels, String brand) {
			super(numberOfWheels, brand);
		}
	
    @Override
    public void startEngine() {
    	System.out.println("Starting Car...");
        System.out.println(this.brand + " with " + numberOfWheels + " wheels engine started!");
    }
    
    @Override
    public void refuel() {
    	System.out.println("Refueling Car...");
    	System.out.println(this.brand + " with " + numberOfWheels + " wheels refueled!");
    }

}
