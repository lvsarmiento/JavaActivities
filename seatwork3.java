package M2_Activity3;

public class seatwork3 {

	//Public class with main method to run the demo

	 public static void main(String[] args) {
	     // 6) Instantiate two cars

	     // a) No-Args Constructor, then assign values using setters
	     car car1 = new car();
	     car1.setBrand("Toyota");
	     car1.setModel("Vios");
	     car1.setYear(2018);
	     car1.setFuelLevel(5.0);

	     // b) Parameterized Constructor (values provided directly)
	     car car2 = new car("Honda", "Civic", 2022, 12.0);

	     // Print initial stats
	     System.out.println("Initial cars stats:");
	     System.out.println(car1);
	     System.out.println(car2);

	     // 7) Call the method (drive) on both cars
	     System.out.println("\nTEST 1: Driving for 30km and 150km, respectively at 10km per Liter fuel efficiency...");
	     car1.drive(30); // should consume 3.0 L (10 km/L)
	     car2.drive(150); // should consume 15.0 L, but check fuel

	     // Print final states
	     System.out.println("\nFinal cars stats after Test1:");
	     System.out.println(car1);
	     System.out.println(car2);
	 }
}
