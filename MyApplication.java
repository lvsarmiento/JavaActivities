package M2_Activity6;

public class MyApplication {
	
	public static void main(String[] args) {
		
		Car car = new Car(4, "Toyota");
		Truck truck = new Truck(18, "Truckz");
		
		car.startEngine();
		car.refuel();
		
		truck.startEngine();
		truck.refuel();
		
		destroyVehicle(car);
		//destroyVehicle(truck);

	}
	
    public static void destroyVehicle(Vehicle v) {
        v.destroy();
	}

}
