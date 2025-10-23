package unidad2;

public class PackageDeliverySystem {
    
    // BONUS: Method to change weight (demonstrates pass by reference)
    public static void changeWeight(Package p, double newWeight) {
        System.out.println("\n🔧 Changing weight through method...");
        p.setWeight(newWeight);
        System.out.println("✓ Weight updated to: " + newWeight + " kg");
    }
    
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("    PACKAGE DELIVERY SYSTEM - REFERENCE TEST");
        System.out.println("═══════════════════════════════════════════════════════\n");
        
        // 1. Create Package object p1
        System.out.println("📦 Step 1: Creating package p1");
        Package p1 = new Package("PKG-2025-001", 5.5);
        System.out.println("\nPackage p1 created:");
        p1.showPackage();
        
        // 2. Create another reference p2 that points to p1
        System.out.println("\n📦 Step 2: Creating reference p2 = p1");
        Package p2 = p1;
        System.out.println("✓ Reference p2 now points to the same object as p1");
        
        // 3. Change weight using p2
        System.out.println("\n📦 Step 3: Changing weight using p2.setWeight(8.7)");
        p2.setWeight(8.7);
        
        // 4. Display both references
        System.out.println("\n📦 Step 4: Displaying both references\n");
        System.out.println("Displaying p1:");
        p1.showPackage();
        
        System.out.println("\nDisplaying p2:");
        p2.showPackage();
        
        // EXPLANATION
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("                    EXPLANATION");
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("Why do both references show the same data?");
        System.out.println();
        System.out.println("• In Java, objects are passed by REFERENCE");
        System.out.println("• When we do: Package p2 = p1;");
        System.out.println("  - We DON'T create a new Package object");
        System.out.println("  - We create a new reference pointing to the SAME object");
        System.out.println();
        System.out.println("• Both p1 and p2 point to the same memory location");
        System.out.println("• Changes through p2 affect the object that p1 also points to");
        System.out.println("• Think of it like two remote controls for the same TV");
        System.out.println("═══════════════════════════════════════════════════════\n");
        
        // BONUS: Demonstrating method parameter passing
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("              BONUS: METHOD PARAMETER TEST");
        System.out.println("═══════════════════════════════════════════════════════");
        
        System.out.println("\n📦 Creating a new package p3");
        Package p3 = new Package("PKG-2025-002", 3.2);
        System.out.println("\nBefore calling changeWeight() method:");
        p3.showPackage();
        
        // Call method to change weight
        changeWeight(p3, 10.5);
        
        System.out.println("\n📦 After calling changeWeight() method:");
        p3.showPackage();
        
        System.out.println("\n═══════════════════════════════════════════════════════");
        System.out.println("         BONUS EXPLANATION");
        System.out.println("═══════════════════════════════════════════════════════");
        System.out.println("When we pass an object to a method:");
        System.out.println("• The method receives a COPY of the reference");
        System.out.println("• But both references point to the SAME object");
        System.out.println("• Changes made inside the method affect the original object");
        System.out.println("• This proves Java passes object references by value");
        System.out.println("═══════════════════════════════════════════════════════");
    }
}