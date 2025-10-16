public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        
        // Adding products
        System.out.println("=== Adding Products ===");
        Product p1 = new Product("L001", "Gaming Laptop", 1299.99);
        Product p2 = new Product("M002", "Wireless Mouse", 29.99);
        Product p3 = new Product("K003", "Mechanical Keyboard", 89.99);
        Product p4 = new Product("H004", "USB-C Headphones", 49.99);
        
        inventory.addProduct(p1);
        inventory.addProduct(p2);
        inventory.addProduct(p3);
        inventory.addProduct(p4);
        
        // Show all products
        inventory.showProducts();
        
        // Search for products
        System.out.println("=== Searching Products ===");
        String searchCode1 = "M002";
        Product found1 = inventory.searchProduct(searchCode1);
        if (found1 != null) {
            System.out.println("Found: " + found1);
        } else {
            System.out.println("Product with code " + searchCode1 + " not found.");
        }
        
        String searchCode2 = "K003";
        Product found2 = inventory.searchProduct(searchCode2);
        if (found2 != null) {
            System.out.println("Found: " + found2);
        } else {
            System.out.println("Product with code " + searchCode2 + " not found.");
        }
        
        String searchCode3 = "X999";
        Product found3 = inventory.searchProduct(searchCode3);
        if (found3 != null) {
            System.out.println("Found: " + found3);
        } else {
            System.out.println("Product with code " + searchCode3 + " not found.");
        }
    }
}