package unidad2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProductMain {
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║         ONLINE STORE MANAGEMENT SYSTEM                 ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        // ─────────────────────────────────────────────────────
        // 1. CREATE PRODUCTS
        // ─────────────────────────────────────────────────────
        System.out.println("📦 STEP 1: Creating Products\n");
        Product laptop = new Product("Gaming Laptop", 1299.99);
        Product mouse = new Product("Wireless Mouse", 29.99);
        Product keyboard = new Product("Mechanical Keyboard", 89.99);
        Product monitor = new Product("4K Monitor", 399.99);
        Product headphones = new Product("Noise-Cancelling Headphones", 199.99);
        
        System.out.println(laptop.getInfo());
        System.out.println(mouse.getInfo());
        System.out.println(keyboard.getInfo());
        System.out.println(monitor.getInfo());
        System.out.println(headphones.getInfo());
        
        // ─────────────────────────────────────────────────────
        // 2. CREATE CATEGORIES AND ADD PRODUCTS (AGGREGATION)
        // ─────────────────────────────────────────────────────
        System.out.println("\n\n📂 STEP 2: Creating Categories (AGGREGATION)\n");
        Category electronics = new Category("Electronics", "Electronic devices and gadgets");
        Category accessories = new Category("Accessories", "Computer accessories");
        
        electronics.addProduct(laptop);
        electronics.addProduct(monitor);
        accessories.addProduct(mouse);
        accessories.addProduct(keyboard);
        accessories.addProduct(headphones);
        
        System.out.println("\n" + electronics.getInfo());
        System.out.println("\n" + accessories.getInfo());
        
        // ─────────────────────────────────────────────────────
        // 3. CREATE CUSTOMER
        // ─────────────────────────────────────────────────────
        System.out.println("\n\n👤 STEP 3: Creating Customer\n");
        Customer customer = new Customer("Ana García", "ana.garcia@email.com");
        System.out.println(customer.getInfo());
        
        // ─────────────────────────────────────────────────────
        // 4. CREATE ORDER AND ADD PRODUCTS (COMPOSITION)
        // ─────────────────────────────────────────────────────
        System.out.println("\n\n🛒 STEP 4: Creating Order (COMPOSITION)\n");
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Order order1 = new Order(today);
        
        order1.addProduct(laptop, 1);
        order1.addProduct(mouse, 2);
        order1.addProduct(keyboard, 1);
        
        System.out.println("\n" + order1.getInfo());
        
        // ─────────────────────────────────────────────────────
        // 5. CUSTOMER PLACES ORDER (ASSOCIATION)
        // ─────────────────────────────────────────────────────
        System.out.println("\n\n📋 STEP 5: Customer Places Order (ASSOCIATION)\n");
        customer.placeOrder(order1);
        
        // ─────────────────────────────────────────────────────
        // 6. CREATE SECOND ORDER
        // ─────────────────────────────────────────────────────
        System.out.println("\n\n🛒 STEP 6: Creating Second Order\n");
        Order order2 = new Order(today);
        order2.addProduct(monitor, 1);
        order2.addProduct(headphones, 1);
        
        System.out.println("\n" + order2.getInfo());
        customer.placeOrder(order2);
        
        // ─────────────────────────────────────────────────────
        // 7. DISPLAY FINAL CUSTOMER INFO
        // ─────────────────────────────────────────────────────
        System.out.println("\n\n📊 FINAL CUSTOMER SUMMARY\n");
        System.out.println(customer.getInfo());
        
        // ─────────────────────────────────────────────────────
        // 8. DEMONSTRATE RELATIONSHIP TYPES
        // ─────────────────────────────────────────────────────
        System.out.println("\n\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              RELATIONSHIP DEMONSTRATIONS               ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");
        
        System.out.println("🔹 AGGREGATION (Category-Product):");
        System.out.println("   • Products can exist without categories");
        System.out.println("   • Removing from category doesn't delete product");
        electronics.removeProduct(laptop);
        System.out.println("   • Laptop still exists: " + laptop.getInfo());
        
        System.out.println("\n🔺 COMPOSITION (Order-OrderItem):");
        System.out.println("   • OrderItems cannot exist without Order");
        System.out.println("   • When Order is deleted, items are deleted too");
        System.out.println("   • Items have no meaning outside their order");
        
        System.out.println("\n🔸 ASSOCIATION (Customer-Order):");
        System.out.println("   • Customer and Order are independent entities");
        System.out.println("   • Order can exist without being assigned to customer");
        System.out.println("   • Customer can exist without orders");
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                  SYSTEM TEST COMPLETE                  ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}