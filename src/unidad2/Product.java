package unidad2;

import java.util.ArrayList;
import java.util.List;


// ═══════════════════════════════════════════════════════════
//                      PRODUCT CLASS
// ═══════════════════════════════════════════════════════════
class Product {
    private String name;
    private double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getInfo() {
        return String.format("Product: %s | Price: $%.2f", name, price);
    }
}

// ═══════════════════════════════════════════════════════════
//                      CATEGORY CLASS
//              (AGGREGATION with Product)
// ═══════════════════════════════════════════════════════════
class Category {
    private String name;
    private String description;
    private List<Product> products;
    
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
        this.products = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    // AGGREGATION: Products can exist independently
    public void addProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
            System.out.println("✓ Product '" + product.getName() + "' added to category '" + name + "'");
        }
    }
    
    public void removeProduct(Product product) {
        if (products.remove(product)) {
            System.out.println("✓ Product '" + product.getName() + "' removed from category '" + name + "'");
        }
    }
    
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
    
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("╔══════════════════════════════════════════╗\n");
        info.append(String.format("║ Category: %-30s ║\n", name));
        info.append(String.format("║ Description: %-26s ║\n", description));
        info.append(String.format("║ Total Products: %-23d ║\n", products.size()));
        info.append("╚══════════════════════════════════════════╝");
        return info.toString();
    }
}

// ═══════════════════════════════════════════════════════════
//                   ORDER ITEM CLASS
//          (Part of COMPOSITION relationship)
// ═══════════════════════════════════════════════════════════
class OrderItem {
    private Product product;
    private int quantity;
    
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getSubtotal() {
        return product.getPrice() * quantity;
    }
    
    public String getInfo() {
        return String.format("  • %s (x%d) - $%.2f", 
            product.getName(), quantity, getSubtotal());
    }
}

// ═══════════════════════════════════════════════════════════
//                      ORDER CLASS
//           (COMPOSITION with OrderItem)
// ═══════════════════════════════════════════════════════════
class Order {
    private String orderDate;
    private double total;
    private List<OrderItem> items;
    
    public Order(String orderDate) {
        this.orderDate = orderDate;
        this.total = 0.0;
        this.items = new ArrayList<>();
    }
    
    // COMPOSITION: OrderItems cannot exist without Order
    public void addProduct(Product product, int quantity) {
        OrderItem item = new OrderItem(product, quantity);
        items.add(item);
        calculateTotal();
        System.out.println("✓ Added to order: " + product.getName() + " (x" + quantity + ")");
    }
    
    public void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
        calculateTotal();
        System.out.println("✓ Removed from order: " + product.getName());
    }
    
    public double calculateTotal() {
        total = items.stream()
                    .mapToDouble(OrderItem::getSubtotal)
                    .sum();
        return total;
    }
    
    public String getOrderDate() {
        return orderDate;
    }
    
    public double getTotal() {
        return total;
    }
    
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("╔══════════════════════════════════════════╗\n");
        info.append(String.format("║ Order Date: %-28s ║\n", orderDate));
        info.append("╠══════════════════════════════════════════╣\n");
        info.append("║ Items:                                   ║\n");
        
        for (OrderItem item : items) {
            info.append(String.format("║ %-40s ║\n", item.getInfo()));
        }
        
        info.append("╠══════════════════════════════════════════╣\n");
        info.append(String.format("║ TOTAL: $%-32.2f ║\n", total));
        info.append("╚══════════════════════════════════════════╝");
        return info.toString();
    }
}

// ═══════════════════════════════════════════════════════════
//                    CUSTOMER CLASS
//            (ASSOCIATION with Order)
// ═══════════════════════════════════════════════════════════
class Customer {
    private String name;
    private String email;
    private List<Order> orders;
    
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    // ASSOCIATION: Customer and Order are independent
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("✓ Order placed successfully for " + name);
    }
    
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
    
    public String getInfo() {
        double totalSpent = orders.stream()
                                  .mapToDouble(Order::getTotal)
                                  .sum();
        
        StringBuilder info = new StringBuilder();
        info.append("╔══════════════════════════════════════════╗\n");
        info.append(String.format("║ Customer: %-30s ║\n", name));
        info.append(String.format("║ Email: %-33s ║\n", email));
        info.append(String.format("║ Total Orders: %-26d ║\n", orders.size()));
        info.append(String.format("║ Total Spent: $%-25.2f ║\n", totalSpent));
        info.append("╚══════════════════════════════════════════╝");
        return info.toString();
    }
}
