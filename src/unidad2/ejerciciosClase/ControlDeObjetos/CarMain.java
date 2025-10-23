package unidad2.ejerciciosClase.ControlDeObjetos;

public class CarMain {
    
    public static void main(String[] args) {
        // Print header
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║            CAR RENTAL MANAGEMENT SYSTEM                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝\n");
        
        // Create CarRental system
        CarRental rental = new CarRental();
        
        // ───────────────────────────────────────────────────────
        // STEP 1: Add cars to the system
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 1: Adding cars to the system\n");
        
        Car car1 = new Car("Toyota Camry 2024", 45.99, true);
        Car car2 = new Car("Honda Civic 2023", 39.99, true);
        Car car3 = new Car("BMW X5 2024", 89.99, true);
        Car car4 = new Car("Mercedes-Benz C-Class", 95.99, false);
        Car car5 = new Car("Tesla Model 3", 79.99, true);
        Car car6 = new Car("Ford Mustang 2024", 69.99, true);
        Car car7 = new Car("Chevrolet Malibu", 42.99, false);
        
        rental.addCar(car1);
        rental.addCar(car2);
        rental.addCar(car3);
        rental.addCar(car4);
        rental.addCar(car5);
        rental.addCar(car6);
        rental.addCar(car7);
        
        // ───────────────────────────────────────────────────────
        // STEP 2: Show all cars
        // ───────────────────────────────────────────────────────
        System.out.println("\n STEP 2: Displaying all cars");
        rental.showAllCars();
        
        // ───────────────────────────────────────────────────────
        // STEP 3: Show only available cars
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 3: Displaying available cars only");
        rental.showAvailableCars();
        
        // ───────────────────────────────────────────────────────
        // STEP 4: Calculate rental cost (without renting)
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 4: Calculate rental cost for 7 days");
        rental.calculateTotal(car1, 7);
        
        // ───────────────────────────────────────────────────────
        // STEP 5: Simulate car rental
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 5: Simulating car rentals\n");
        
        System.out.println(" Attempt to rent Toyota Camry for 5 days:");
        rental.rentCar(car1, 5);
        
        System.out.println(" Attempt to rent BMW X5 for 3 days:");
        rental.rentCar(car3, 3);
        
        System.out.println(" Attempt to rent Mercedes-Benz (already rented):");
        rental.rentCar(car4, 2);
        
        // ───────────────────────────────────────────────────────
        // STEP 6: Show available cars after rentals
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 6: Available cars after rentals");
        rental.showAvailableCars();
        
        // ───────────────────────────────────────────────────────
        // STEP 7: Return a car
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 7: Returning a car\n");
        System.out.println(" Returning Toyota Camry:");
        rental.returnCar(car1);
        
        System.out.println(" Available cars after return:");
        rental.showAvailableCars();
        
        // ───────────────────────────────────────────────────────
        // BONUS: Search for specific cars
        // ───────────────────────────────────────────────────────
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                    BONUS: CAR SEARCH                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        
        // Search by exact model
        Car foundCar = rental.searchCar("Tesla Model 3");
        
        // IF statement to demonstrate usage
        if (foundCar != null) {
            System.out.println(" Found car can be rented!");
            rental.calculateTotal(foundCar, 4);
        }
        
        // Search for non-existent car
        rental.searchCar("Lamborghini Aventador");
        
        // Partial search
        rental.searchCarPartial("BMW");
        rental.searchCarPartial("2024");
        
        // ───────────────────────────────────────────────────────
        // FINAL SUMMARY
        // ───────────────────────────────────────────────────────
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║                     FINAL SUMMARY                          ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        rental.showAllCars();
        
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║              SYSTEM DEMONSTRATION COMPLETE                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
    }
}