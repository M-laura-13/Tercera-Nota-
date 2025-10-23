package unidad2.ejerciciosClase.Tarea;


// ═══════════════════════════════════════════════════════════
//                      MAIN CLASS
// ═══════════════════════════════════════════════════════════
public class TechStoreInventorySystem {
    
    public static void main(String[] args) {
        // Print header
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║           TECH STORE INVENTORY MANAGEMENT SYSTEM               ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
        
        // Create inventory system
        Inventory inventory = new Inventory();
        
        // ───────────────────────────────────────────────────────
        // STEP 1: Add products to inventory
        // ───────────────────────────────────────────────────────
        System.out.println("📦 STEP 1: Adding products to inventory\n");
        
        Product p1 = new Product("LAPTOP-001", "MacBook Pro 16\" M3", 2499.99);
        Product p2 = new Product("PHONE-001", "iPhone 15 Pro Max", 1199.99);
        Product p3 = new Product("TABLET-001", "iPad Pro 12.9\"", 1099.99);
        Product p4 = new Product("WATCH-001", "Apple Watch Series 9", 399.99);
        Product p5 = new Product("HEADPHONE-001", "AirPods Pro 2nd Gen", 249.99);
        Product p6 = new Product("MONITOR-001", "LG UltraWide 34\" 5K", 899.99);
        Product p7 = new Product("KEYBOARD-001", "Logitech MX Keys", 99.99);
        
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);
        inventory.addProduct(p4);
        inventory.addProduct(p5);
        inventory.addProduct(p6);
        inventory.addProduct(p7);
        
        // ───────────────────────────────────────────────────────
        // STEP 2: Show all products
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 2: Displaying all products");
        inventory.showProducts();
        
        // ───────────────────────────────────────────────────────
        // STEP 3: Search for products by code
        // ───────────────────────────────────────────────────────
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    STEP 3: PRODUCT SEARCH                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        // Search existing product
        Product found1 = inventory.searchProduct("PHONE-001");
        
        // Search another existing product
        Product found2 = inventory.searchProduct("LAPTOP-001");
        
        // Search non-existing product
        Product notFound = inventory.searchProduct("CAMERA-001");
        
        // ───────────────────────────────────────────────────────
        // BONUS: Safe search with TRY-CATCH
        // ───────────────────────────────────────────────────────
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              BONUS: SAFE SEARCH WITH TRY-CATCH                 ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        // Test 1: Search existing product with exception handling
        Product safe1 = inventory.searchProductSafe("TABLET-001");
        
        // Test 2: Search non-existing product with exception handling
        Product safe2 = inventory.searchProductSafe("DRONE-001");
        
        // Test 3: Search another non-existing product
        Product safe3 = inventory.searchProductSafe("GAMING-999");
        
        // ───────────────────────────────────────────────────────
        // STEP 4: Update product price
        // ───────────────────────────────────────────────────────
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                  STEP 4: UPDATE PRODUCT PRICE                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
        
        inventory.updatePrice("HEADPHONE-001", 229.99);
        inventory.updatePrice("NONEXISTENT-001", 99.99);
        
        // ───────────────────────────────────────────────────────
        // STEP 5: Show catalog (HashMap view)
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 5: Displaying catalog (HashMap view)");
        inventory.showCatalog();
        
        // ───────────────────────────────────────────────────────
        // STEP 6: Show inventory statistics
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 6: Inventory statistics");
        inventory.showStatistics();
        
        // ───────────────────────────────────────────────────────
        // STEP 7: Remove a product
        // ───────────────────────────────────────────────────────
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   STEP 7: REMOVE PRODUCT                       ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
        
        inventory.removeProduct("KEYBOARD-001");
        inventory.removeProduct("INVALID-001");
        
        // ───────────────────────────────────────────────────────
        // STEP 8: Final inventory display
        // ───────────────────────────────────────────────────────
        System.out.println(" STEP 8: Final inventory");
        inventory.showProducts();
        
        // ───────────────────────────────────────────────────────
        // DEMONSTRATION: Why use both ArrayList and HashMap?
        // ───────────────────────────────────────────────────────
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║           WHY USE BOTH ARRAYLIST AND HASHMAP?                  ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("  ArrayList Benefits:");
        System.out.println("  • Maintains insertion order");
        System.out.println("  • Easy to iterate through all products");
        System.out.println("  • Great for displaying lists");
        System.out.println("  • Search complexity: O(n) - slower for lookups");
        System.out.println();
        System.out.println("  HashMap Benefits:");
        System.out.println("  • INSTANT lookup by code: O(1) complexity");
        System.out.println("  • Perfect for searching by unique identifier");
        System.out.println("  • Much faster than ArrayList for searches");
        System.out.println("  • Ideal for frequent lookups");
        System.out.println();
        System.out.println("  Using BOTH gives us:");
        System.out.println("  ✓ Fast iteration (ArrayList)");
        System.out.println("  ✓ Fast searching (HashMap)");
        System.out.println("  ✓ Best of both worlds!");
        System.out.println();
        
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║              SYSTEM DEMONSTRATION COMPLETE                     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }
}