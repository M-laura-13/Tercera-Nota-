package unidad2.ejerciciosClase.Tarea;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Product {
    private String code;
    private String name;
    private double price;
    
    // Constructor
    public Product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    
    // Getters and Setters
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    // Method to display product information
    public String getInfo() {
        return String.format("[%s] %-35s $%,10.2f", code, name, price);
    }
    
    @Override
    public String toString() {
        return getInfo();
    }
}

// ═══════════════════════════════════════════════════════════
//                    INVENTORY CLASS
//         Using ArrayList AND HashMap for efficiency
// ═══════════════════════════════════════════════════════════
class Inventory {
    // ArrayList for sequential access and iteration
    private ArrayList<Product> products;
    
    // HashMap for fast lookups by code (O(1) complexity)
    private HashMap<String, Product> catalog;
    
    // Constructor
    public Inventory() {
        this.products = new ArrayList<>();
        this.catalog = new HashMap<>();
    }
    
    // Method to add a product to both ArrayList and HashMap
    public void addProduct(Product p) {
        // Check if product code already exists
        if (catalog.containsKey(p.getCode())) {
            System.out.println("⚠ WARNING: Product with code '" + p.getCode() + "' already exists!");
            System.out.println("  Existing product will be updated.\n");
            
            // Remove old product from ArrayList
            products.removeIf(product -> product.getCode().equals(p.getCode()));
        }
        
        // Add to both collections
        products.add(p);              // Add to ArrayList
        catalog.put(p.getCode(), p);  // Add to HashMap (code as key)
        
        System.out.println("✓ Product added successfully:");
        System.out.println("  " + p.getInfo());
        System.out.println();
    }
    
    // Method to show all products using FOR-EACH
    public void showProducts() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    INVENTORY - ALL PRODUCTS                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        if (products.isEmpty()) {
            System.out.println("  ⚠ Inventory is empty. No products to display.\n");
            return;
        }
        
        System.out.println("  Code      Product Name                        Price");
        System.out.println("  ────────  ──────────────────────────────────  ─────────────");
        
        int count = 0;
        double totalValue = 0.0;
        
        // Using FOR-EACH to iterate through ArrayList
        for (Product product : products) {
            count++;
            System.out.printf("  %2d. %s%n", count, product.getInfo());
            totalValue += product.getPrice();
        }
        
        System.out.println("  ────────────────────────────────────────────────────────────");
        System.out.printf("  Total Products: %-3d                    Total Value: $%,.2f%n", 
                         count, totalValue);
        System.out.println();
    }
    
    // Method to search product by code using HashMap (fast O(1) lookup)
    public Product searchProduct(String code) {
        System.out.println("\n🔍 Searching for product with code: " + code);
        
        // Using HashMap.get() for instant retrieval
        Product product = catalog.get(code);
        
        if (product != null) {
            System.out.println("✓ Product found!");
            System.out.println("  " + product.getInfo());
            System.out.println();
            return product;
        } else {
            System.out.println("✗ Product not found!");
            System.out.println("  No product exists with code '" + code + "'");
            System.out.println();
            return null;
        }
    }
    
    // BONUS: Method with TRY-CATCH for safe product retrieval
    public Product searchProductSafe(String code) {
        System.out.println("\n🔍 [SAFE SEARCH] Looking for product: " + code);
        
        try {
            // Check if code exists in catalog
            if (!catalog.containsKey(code)) {
                throw new ProductNotFoundException("Product with code '" + code + "' not found in catalog");
            }
            
            Product product = catalog.get(code);
            
            // Additional validation
            if (product == null) {
                throw new NullPointerException("Product object is null");
            }
            
            System.out.println("✓ Product found successfully!");
            System.out.println("  " + product.getInfo());
            System.out.println();
            return product;
            
        } catch (ProductNotFoundException e) {
            System.out.println("✗ ERROR: " + e.getMessage());
            System.out.println("  Please verify the product code and try again.");
            System.out.println();
            return null;
            
        } catch (NullPointerException e) {
            System.out.println("✗ ERROR: Unexpected null value");
            System.out.println("  " + e.getMessage());
            System.out.println();
            return null;
            
        } catch (Exception e) {
            System.out.println("✗ ERROR: Unexpected error occurred");
            System.out.println("  " + e.getMessage());
            System.out.println();
            return null;
        }
    }
    
    // Additional useful methods
    
    // Remove product by code
    public boolean removeProduct(String code) {
        try {
            if (!catalog.containsKey(code)) {
                throw new ProductNotFoundException("Cannot remove: Product '" + code + "' not found");
            }
            
            Product removed = catalog.remove(code);
            products.removeIf(p -> p.getCode().equals(code));
            
            System.out.println("✓ Product removed: " + removed.getName());
            System.out.println();
            return true;
            
        } catch (ProductNotFoundException e) {
            System.out.println("✗ " + e.getMessage());
            System.out.println();
            return false;
        }
    }
    
    // Update product price
    public void updatePrice(String code, double newPrice) {
        try {
            Product product = catalog.get(code);
            
            if (product == null) {
                throw new ProductNotFoundException("Product '" + code + "' not found");
            }
            
            double oldPrice = product.getPrice();
            product.setPrice(newPrice);
            
            System.out.println("✓ Price updated for: " + product.getName());
            System.out.printf("  Old price: $%.2f → New price: $%.2f%n", oldPrice, newPrice);
            System.out.println();
            
        } catch (ProductNotFoundException e) {
            System.out.println("✗ ERROR: " + e.getMessage());
            System.out.println();
        }
    }
    
    // Get inventory statistics
    public void showStatistics() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    INVENTORY STATISTICS                        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        if (products.isEmpty()) {
            System.out.println("  No products in inventory.\n");
            return;
        }
        
        double total = 0.0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        Product mostExpensive = null;
        Product cheapest = null;
        
        for (Product p : products) {
            double price = p.getPrice();
            total += price;
            
            if (price > max) {
                max = price;
                mostExpensive = p;
            }
            
            if (price < min) {
                min = price;
                cheapest = p;
            }
        }
        
        double average = total / products.size();
        
        System.out.println("  Total products:      " + products.size());
        System.out.printf("  Total value:         $%,.2f%n", total);
        System.out.printf("  Average price:       $%,.2f%n", average);
        System.out.println();
        System.out.println("  Most expensive:      " + (mostExpensive != null ? mostExpensive.getInfo() : "N/A"));
        System.out.println("  Cheapest:            " + (cheapest != null ? cheapest.getInfo() : "N/A"));
        System.out.println();
    }
    
    // Show all products in HashMap (alternative view)
    public void showCatalog() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    CATALOG (HashMap View)                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        if (catalog.isEmpty()) {
            System.out.println("  Catalog is empty.\n");
            return;
        }
        
        System.out.println("  Code → Product Details");
        System.out.println("  ────────────────────────────────────────────────────────────");
        
        // Using FOR-EACH with Map.Entry
        for (Map.Entry<String, Product> entry : catalog.entrySet()) {
            System.out.println("  " + entry.getKey() + " → " + entry.getValue().getInfo());
        }
        System.out.println();
    }
}

// ═══════════════════════════════════════════════════════════
//           CUSTOM EXCEPTION CLASS (BONUS)
// ═══════════════════════════════════════════════════════════
class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

public class  P {
    
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