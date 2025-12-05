package M2_Activity3;

public class car {

		 private String brand;
		 private String model;
		 private int year;
		 private double fuelLevel; // in liters

		 // 2) No-Args Constructor
		 public car() {
		     // Set defaults
		     this.brand = "Unknown";
		     this.model = "Unknown";
		     this.year = 0;
		     this.fuelLevel = 0.0;
		 }

		 // 3) Parameterized Constructor
		 public car(String brand, String model, int year, double fuelLevel) {
		     this.brand = brand;
		     this.model = model;
		     this.year = year;
		     this.fuelLevel = fuelLevel;
		 }

		 // 4) A method (behavior) — drive reduces fuel and prints status
		 public void drive(double kilometers) {
		     // Simple assumption: 10 km per liter
		     double fuelNeeded = kilometers / 10.0;

		     if (fuelNeeded <= fuelLevel) {
		         fuelLevel -= fuelNeeded;
		         System.out.printf(
		             "%s %s drove %.1f km. Fuel used: %.2f L. Remaining fuel: %.2f L.%n",
		             brand, model, kilometers, fuelNeeded, fuelLevel
		         );
		     } else {
		         System.out.printf(
		             "Not enough fuel to drive %.1f km! %s %s has only %.2f L. DO NOT DRIVE!%n",
		             kilometers, brand, model, fuelLevel
		         );
		     }
		 }

		 // 5) Additional helpful methods (getters/setters and toString)
		 public String getBrand() { 
			 return brand; 
			 }
		 public void setBrand(String brand) { 
			 this.brand = brand; 
			 }

		 public String getModel() { 
			 return model; }
		 public void setModel(String model) { this.model = model; 
		 }

		 public int getYear() { 
			 return year; 
			 }
		 public void setYear(int year) { 
			 this.year = year; 
			 }

		 public double getFuelLevel() { 
			 return fuelLevel; 
			 }
		 public void setFuelLevel(double fuelLevel) { 
			 this.fuelLevel = fuelLevel; 
			 }

		 @Override
		 public String toString() {
		     return String.format("Car brand = '%s', model = '%s', year = %d, fuel = %.2f L",
		                          brand, model, year, fuelLevel);
		 }

}
