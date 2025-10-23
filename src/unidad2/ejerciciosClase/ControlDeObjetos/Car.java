package unidad2.ejerciciosClase.ControlDeObjetos;

import java.util.ArrayList;

// ═══════════════════════════════════════════════════════════
//                        CAR CLASS
// ═══════════════════════════════════════════════════════════
class Car {
    private String model;
    private double pricePerDay;
    private boolean available;
    
    // Constructor
    public Car(String model, double pricePerDay, boolean available) {
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.available = available;
    }
    
    // Getters and Setters
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public double getPricePerDay() {
        return pricePerDay;
    }
    
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    // Method to display car information
    public String getInfo() {
        String status = available ? "✓ Available" : "✗ Rented";
        return String.format("%-25s | $%-8.2f/day | %s", 
                            model, pricePerDay, status);
    }
}

// ═══════════════════════════════════════════════════════════
//                    CAR RENTAL CLASS
// ═══════════════════════════════════════════════════════════
class CarRental {
    private ArrayList<Car> cars;
    
    // Constructor
    public CarRental() {
        this.cars = new ArrayList<>();
    }
    
    // Method to add a car to the system
    public void addCar(Car c) {
        cars.add(c);
        System.out.println("✓ Car added: " + c.getModel());
    }
    
    // Method to show all cars in the system
    public void showAllCars() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                    ALL CARS IN SYSTEM                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        
        // Using FOR loop with index
        if (cars.isEmpty()) {
            System.out.println("  No cars in the system.");
        } else {
            for (int i = 0; i < cars.size(); i++) {
                System.out.printf("  %2d. %s%n", (i + 1), cars.get(i).getInfo());
            }
        }
        System.out.println();
    }
    
    // Method to show only available cars
    public void showAvailableCars() {
        System.out.println("\n╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                    AVAILABLE CARS                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        
        int count = 0;
        
        // Using FOR-EACH loop
        for (Car car : cars) {
            // IF statement to check availability
            if (car.isAvailable()) {
                count++;
                System.out.printf("  %2d. %s%n", count, car.getInfo());
            }
        }
        
        // IF statement to check if no cars are available
        if (count == 0) {
            System.out.println("  ⚠ No cars available at the moment.");
        } else {
            System.out.println("\n  Total available: " + count + " car(s)");
        }
        System.out.println();
    }
    
    // Method to calculate rental cost
    public double calculateTotal(Car c, int days) {
        // IF statement to check if car is available
        if (c.isAvailable()) {
            double total = c.getPricePerDay() * days;
            System.out.println("\n╔════════════════════════════════════════════════════════════╗");
            System.out.println("║                   RENTAL CALCULATION                       ║");
            System.out.println("╚════════════════════════════════════════════════════════════╝");
            System.out.printf("  Car Model:      %s%n", c.getModel());
            System.out.printf("  Price per day:  $%.2f%n", c.getPricePerDay());
            System.out.printf("  Rental days:    %d%n", days);
            System.out.println("  ────────────────────────────────────");
            System.out.printf("  TOTAL COST:     $%.2f%n", total);
            System.out.println();
            
            return total;
        } else {
            System.out.println("\n⚠ ERROR: Car '" + c.getModel() + "' is not available!");
            System.out.println("  Please choose another car.\n");
            return 0.0;
        }
    }
    
    // Method to rent a car (mark as unavailable)
    public boolean rentCar(Car c, int days) {
        // IF statement to check availability before renting
        if (c.isAvailable()) {
            double total = calculateTotal(c, days);
            c.setAvailable(false);  // Mark car as rented
            System.out.println("✓ SUCCESS: Car '" + c.getModel() + "' has been rented!");
            System.out.println("  Rental period: " + days + " day(s)");
            System.out.println("  Total paid: $" + String.format("%.2f", total));
            System.out.println();
            return true;
        } else {
            System.out.println("\n✗ FAILED: Car '" + c.getModel() + "' is already rented.");
            System.out.println("  Please select an available car.\n");
            return false;
        }
    }
    
    // Method to return a car (mark as available)
    public void returnCar(Car c) {
        // IF-ELSE statement
        if (!c.isAvailable()) {
            c.setAvailable(true);
            System.out.println("✓ Car '" + c.getModel() + "' has been returned and is now available.\n");
        } else {
            System.out.println("⚠ Car '" + c.getModel() + "' was not rented.\n");
        }
    }
    
    // BONUS: Method to search for a car by model
    public Car searchCar(String model) {
        System.out.println("\n Searching for: " + model);
        
        // Using FOR-EACH loop to search
        for (Car car : cars) {
            // IF statement to compare models (case-insensitive)
            if (car.getModel().equalsIgnoreCase(model)) {
                System.out.println("✓ Car found!");
                System.out.println("  " + car.getInfo());
                System.out.println();
                return car;
            }
        }
        
        // If not found
        System.out.println("✗ Car not found.");
        System.out.println("  Model '" + model + "' does not exist in our system.\n");
        return null;
    }
    
    // BONUS: Method to search with partial match
    public void searchCarPartial(String keyword) {
        System.out.println("\n Searching cars containing: '" + keyword + "'");
        
        int found = 0;
        // Using FOR loop with index
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            // IF statement to check if model contains keyword
            if (car.getModel().toLowerCase().contains(keyword.toLowerCase())) {
                found++;
                System.out.printf("  %d. %s%n", found, car.getInfo());
            }
        }
        
        // IF-ELSE to display results
        if (found == 0) {
            System.out.println("  No cars found matching '" + keyword + "'");
        } else {
            System.out.println("\n  Found " + found + " car(s) matching your search.");
        }
        System.out.println();
    }
}